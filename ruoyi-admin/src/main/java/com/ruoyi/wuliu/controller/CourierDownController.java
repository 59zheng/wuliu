package com.ruoyi.wuliu.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.http.HttpUtil;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.cundian.domain.VillagePoint;
import com.ruoyi.cundian.service.IVillagePointService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysDictData;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysDictDataService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.wuliu.domain.*;
import com.ruoyi.wuliu.service.*;
import com.ruoyi.wuliu.utils.RandomTimeUtils;
import org.apache.http.util.EntityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;


@Controller
@RequestMapping("/wuliu/courierDown")
public class CourierDownController extends BaseController {

    /**
     * 快递单管理Controller
     *
     * @author zheng
     * @date 2019-11-12
     */

    private String prefix = "wuliu/courierDown";

    @Autowired
    private ICourierService courierService;
    @Autowired
    private ISysDictDataService dictDataService;


    @Autowired
    private IWuliuDriverService wuliuDriverService;

    @Autowired
    private IVillagePointService pointService;


    @Autowired
    private IWuliuSchedulingService schedulingService;

    @Autowired
    private IWuliuTaskService taskService;

    @Autowired
    private IWuliuDelegateService delegateService;

    @Autowired
    private ISysUserService userService;

    @RequiresPermissions("wuliu:courierDown:view")
    @GetMapping()
    public String courier() {
        return prefix + "/courier";
    }

    /**
     * 查询快递单管理列表
     */
    @RequiresPermissions("wuliu:courierDown:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Courier courier) {
        startPage();
        courier.setType("县到村 ");
        List<Courier> list = courierService.selectCourierList(courier);
        return getDataTable(list);
    }

    /**
     * 导出快递单管理列表
     */
    @RequiresPermissions("wuliu:courierDown:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Courier courier) {
        List<Courier> list = courierService.selectCourierList(courier);
        ExcelUtil<Courier> util = new ExcelUtil<Courier>(Courier.class);
        return util.exportExcel(list, "courier");
    }

    /**
     * 新增快递单管理
     */
    @GetMapping("/add")
    public String add() {

        return prefix + "/add";
    }

    /**
     * 新增保存快递单管理
     */
    @RequiresPermissions("wuliu:courierDown:add")
    @Log(title = "快递单管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Courier courier) {
        courier.setIsDelete("1");
        courier.setType("县到村");
        SysUser sysUser = ShiroUtils.getSysUser();
        String station = sysUser.getStation();
        courier.setVillageName(station);
        return toAjax(courierService.insertCourier(courier));
    }

    /**
     * 修改快递单管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        Courier courier = courierService.selectCourierById(id);
        mmap.put("courier", courier);
        return prefix + "/edit";
    }

    /**
     * 修改保存快递单管理
     */
    @RequiresPermissions("wuliu:courierDown:edit")
    @Log(title = "快递单管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Courier courier) {
        return toAjax(courierService.updateCourier(courier));
    }

    /**
     * 删除快递单管理
     */
    @RequiresPermissions("wuliu:courierDown:remove")
    @Log(title = "快递单管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(courierService.deleteCourierByIds(ids));
    }


    /**
     * 下载模板
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() {
        ExcelUtil<CourierExmel> util = new ExcelUtil<CourierExmel>(CourierExmel.class);
        return util.importTemplateExcel("用户数据");
    }

    @PostMapping("/httpclient")
    @ResponseBody
    public String httpclient(String tasknum) {
        String host = "https://wuliu.market.alicloudapi.com";
        String path = "/kdi";
        String method = "GET";
        //System.out.println("请先替换成自己的AppCode");
        String appcode = "a4172a0c685b4858a4aa2d4311dfeb05";  // !!!替换填写自己的AppCode 在买家中心查看
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appcode); //格式为:Authorization:APPCODE 83359fd73fe11248385f570e3c139xxx
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("no", tasknum);// !!! 请求参数
        //querys.put("type", "zto");// !!! 请求参数
        try {

            org.apache.http.HttpResponse response = (org.apache.http.HttpResponse) HttpUtil.doGet(host, path, method, headers, querys);
            //状态码: 200 正常；400 URL无效；401 appCode错误； 403 次数用完； 500 API网管错误
            //获取response的body
            String s = EntityUtils.toString(response.getEntity());
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ("异常");
    }

    /**
     * 导入数据
     */
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<CourierExmel> util = new ExcelUtil<CourierExmel>(CourierExmel.class);
        List<CourierExmel> userList = util.importExcel(file.getInputStream());
        String message = importUser(userList, updateSupport);
        return AjaxResult.success(message);
    }

    /**
     * 导入用户数据
     *
     * @param userList        用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @return 结果
     */
    public String importUser(List<CourierExmel> userList, Boolean isUpdateSupport) {
        if (StringUtils.isNull(userList) || userList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (CourierExmel user : userList) {
            try {
                int num = 0;
                ArrayList<String> selectvillage = selectvillage();
                for (String s : selectvillage) {
//                    判断发件人是否包含指定村点
                    if (user.getDowndress().contains(s)) {
//                        包含的话添加呗
                        insertAll(user, s);
                        num++;
                        break;
                    } else {

                    }
                }
                //不包含的话只添加快递单号
                int insertinto = insertinto(user);
                successNum = successNum + num;
            } catch (Exception e) {
                e.printStackTrace();
                failureNum++;
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    //添加快递单号返回是否成功
    private int insertinto(CourierExmel user) {
        Courier courier = new Courier();
        courier.setType("县到村");
        SysUser sysUser = ShiroUtils.getSysUser();
        String station = sysUser.getStation();
        courier.setVillageName(station);
        courier.setCratetime(new Date());
        courier.setIsDelete("1");
        courier.setCouriercompany(user.getCouriercompany());
        courier.setDowndress(user.getDowndress());
        courier.setDownName(user.getDownName());
        courier.setDownPhone(user.getDownPhone());
        courier.setSheng(user.getSheng());
        courier.setSenderAddress(user.getSnderAddress());
        courier.setShi(user.getShi());
        courier.setXian(user.getXian());
        courier.setTasknum(user.getTasknum());
        courier.setCreatename(user.getCreatename());
        courier.setCreatePhone(user.getCreatePhone());
        return courierService.insertCourier(courier);
    }

    //获取所有的村点名称
    private ArrayList<String> selectvillage() {
        VillagePoint villagePoint = new VillagePoint();
        ArrayList<String> strings = new ArrayList<>();
        List<VillagePoint> list = pointService.selectVillagePointList(villagePoint);
        list.forEach(ite -> {
            strings.add(ite.getVillageName());
        });
        return strings;
    }

    //添加一系类表
    private void insertAll(CourierExmel user, String ite) {
        RandomTimeUtils randomTimeUtils = new RandomTimeUtils();
//    获取订单创建时间
        Date date = randomTimeUtils.httpclientTime(user.getTasknum());
//添加调度单
        WuliuScheduling wuliuScheduling = new WuliuScheduling();
        wuliuScheduling.setSchedulingId(randomenum() + "");
        wuliuScheduling.setTaskId("S" + randomenum());
        wuliuScheduling.setSchedulingType("已完成");
        wuliuScheduling.setCreateTime(date);
        Date date1 = datautils(date, 2);
        wuliuScheduling.setProcessingTime(randomTimeUtils.randomDate(date, date1));
        wuliuScheduling.setProcessingName(getusername(ite));
        wuliuScheduling.setDelegateName(dictionary("couriercompany", 2));
        wuliuScheduling.setDelegateId("W" + randomenum());
        wuliuScheduling.setTasknum(user.getTasknum());
        wuliuScheduling.setVillageName(ite);
        schedulingService.insertWuliuScheduling(wuliuScheduling);
//        添加task
        WuliuTask task = new WuliuTask();
        task.setCreateTime(date1);
        Date datautils1 = datautils(date1, 5);
//       获取一小时内的随机
        Date date2 = randomTimeUtils.randomDate(date, datautils1);
        task.setEndTime(date2);
//配送车辆随机
        String drivernum = dictionary("drivernum", 1);
        task.setDriverNum(drivernum);
        WuliuDriver getdrivers = getdrivers(drivernum);
        task.setDriverName(getdrivers.getName());
        task.setAssignedName(getusername(ite));
        task.setPhone(getdrivers.getPhone());
        task.setTaskId(wuliuScheduling.getTaskId());
        task.setIsReturn("已完成");
//        预计所需时间
        task.setEstimatedTime(randomnum1(10) + "小时");
        taskService.insertWuliuTask(task);
//添加委派单
        WuliuDelegate wuliuDelegate = new WuliuDelegate();
        wuliuDelegate.setSchedulingId(wuliuScheduling.getSchedulingId());
        wuliuDelegate.setVillageName(ite);
        wuliuDelegate.setVillageType("已完成");
        wuliuDelegate.setEstimatedTime(randomnum1(10) + "小时");
        wuliuDelegate.setDeliveryTime(randomTimeUtils.randomDate(date, datautils(date, 10)));
        delegateService.insertWuliuDelegate(wuliuDelegate);
    }

    //获取指定时间的几小时后的指定时间
    private Date datautils(Date data, int i) {
        long time = data.getTime();
        long time2 = time + 60 * 60 * 100 * i;
        Date date1 = new Date(time2);
        return date1;
    }

    //    随机数
    private int randomnum1(int i) {
        Random random = new Random();
        int i1 = random.nextInt(i);
        return i1;
    }

    //根据村点名称获取用户名
    private String getusername(String name) {
        SysUser sysUser = new SysUser();
        sysUser.setStation(name);
        List<SysUser> sysUsers = userService.selectUserList(sysUser);
        return sysUsers.get(0).getUserName();
    }

    private int randomenum() {
        int randomNum = (int) ((Math.random() * 9 + 1) * 100000); // 随机数 6 位
        return randomNum;
    }

    //    字典随机
    public String dictionary(String type, int i) {
        SysDictData sysDictData = new SysDictData();
        sysDictData.setDictType(type);
        List<SysDictData> sysDictTypes = dictDataService.selectDictDataList(sysDictData);
        ArrayList<String> strings = new ArrayList<>();
        sysDictTypes.forEach(itm -> {
            strings.add(itm.getDictValue());
        });
        Random random = new Random();
        int i1 = random.nextInt(i);
        return strings.get(i1);
    }

    //    根据车牌获取司机
    public WuliuDriver getdrivers(String drivernum) {
        WuliuDriver wuliuDriver = new WuliuDriver();
        wuliuDriver.setVehicleNum(drivernum);
        List<WuliuDriver> wuliuDrivers = wuliuDriverService.selectWuliuDriverList(wuliuDriver);
        return wuliuDrivers.get(0);
    }


}



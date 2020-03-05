package com.ruoyi.wuliu.controller;

import java.util.*;

import com.ruoyi.cundian.domain.VillagePoint;
import com.ruoyi.cundian.service.IVillagePointService;
import com.ruoyi.system.domain.SysDictData;
import com.ruoyi.system.service.ISysDictDataService;
import com.ruoyi.wuliu.domain.WuliuDriver;
import com.ruoyi.wuliu.domain.WuliuSrartRecordingVo;
import com.ruoyi.wuliu.domain.WuliuVehicleRoute;
import com.ruoyi.wuliu.service.IWuliuDriverService;
import com.ruoyi.wuliu.service.IWuliuVehicleRouteService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.wuliu.domain.WuliuStartRecording;
import com.ruoyi.wuliu.service.IWuliuStartRecordingService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;


/**
 * 发车记录Controller
 *
 * @author zheng
 * @date 2019-12-23
 */
@Controller
@RequestMapping("/wuliu/recording")
public class WuliuStartRecordingController extends BaseController {
    private String prefix = "wuliu/recording";

    @Autowired
    private IWuliuStartRecordingService wuliuStartRecordingService;


    @Autowired
    private IWuliuDriverService wuliuDriverService;

    @Autowired
    private IWuliuVehicleRouteService wuliuVehicleRouteService;

    @Autowired
    private IVillagePointService pointService;


    @Autowired
    private ISysDictDataService dictDataService;


    @RequiresPermissions("wuliu:recording:view")
    @GetMapping()
    public String recording() {
        return prefix + "/recording";
    }

    /**
     * 查询发车记录列表
     */
    @RequiresPermissions("wuliu:recording:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WuliuStartRecording wuliuStartRecording) {
        startPage();
        List<WuliuStartRecording> list = wuliuStartRecordingService.selectWuliuStartRecordingList(wuliuStartRecording);
        return getDataTable(list);
    }

    /**
     * 导出发车记录列表
     */
    @RequiresPermissions("wuliu:recording:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WuliuStartRecording wuliuStartRecording) {
        List<WuliuStartRecording> list = wuliuStartRecordingService.selectWuliuStartRecordingList(wuliuStartRecording);
        ExcelUtil<WuliuStartRecording> util = new ExcelUtil<WuliuStartRecording>(WuliuStartRecording.class);
        return util.exportExcel(list, "recording");
    }

    /**
     * 新增发车记录
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存发车记录
     */
    @RequiresPermissions("wuliu:recording:add")
    @Log(title = "发车记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WuliuStartRecording wuliuStartRecording) {
        return toAjax(wuliuStartRecordingService.insertWuliuStartRecording(wuliuStartRecording));
    }

    /**
     * 修改发车记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        WuliuStartRecording wuliuStartRecording = wuliuStartRecordingService.selectWuliuStartRecordingById(id);
        mmap.put("wuliuStartRecording", wuliuStartRecording);
        return prefix + "/edit";
    }

    /**
     * 修改保存发车记录
     */
    @RequiresPermissions("wuliu:recording:edit")
    @Log(title = "发车记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WuliuStartRecording wuliuStartRecording) {
        return toAjax(wuliuStartRecordingService.updateWuliuStartRecording(wuliuStartRecording));
    }

    /**
     * 删除发车记录
     */
    @RequiresPermissions("wuliu:recording:remove")
    @Log(title = "发车记录", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(wuliuStartRecordingService.deleteWuliuStartRecordingByIds(ids));
    }

/*
*根据id查询查询路径，根据路径获取途径点的经纬度
* */

    /**
     * 发车路径
     */
    @GetMapping("/path")
    @ResponseBody
    public List<WuliuSrartRecordingVo> path(Long id) {
        WuliuStartRecording wuliuStartRecording = wuliuStartRecordingService.selectWuliuStartRecordingById(id);
        String route = wuliuStartRecording.getRoute();
        List<WuliuSrartRecordingVo> wuliuSrartRecordingVos = new ArrayList<>();
        for (String s : route.split("-")) {
//获取到每个途经点的服务站名
            VillagePoint villagePoint = new VillagePoint();
            villagePoint.setVillageName(s);
            List<VillagePoint> list = pointService.selectVillagePointList(villagePoint);
            VillagePoint villagePoint1 = list.get(0);
            WuliuSrartRecordingVo wuliuSrartRecordingVo = new WuliuSrartRecordingVo();
            wuliuSrartRecordingVo.setLongitude(villagePoint1.getLongitude());
            wuliuSrartRecordingVo.setLatitude(villagePoint1.getLatitude());
            wuliuSrartRecordingVos.add(wuliuSrartRecordingVo);
        }
        return wuliuSrartRecordingVos;
    }




    /**
     * 定时保存发车记录
     */
    public void storage() {
        for (int i = 0; i <4 ; i++) {
        WuliuStartRecording wuliuStartRecording = new WuliuStartRecording();

//        添加随机路线
        WuliuVehicleRoute wuliuVehicleRoute = new WuliuVehicleRoute();
        List<WuliuVehicleRoute> wuliuVehicleRoutes = wuliuVehicleRouteService.selectWuliuVehicleRouteList(wuliuVehicleRoute);
        Random random = new Random();
        int d = random.nextInt(3);
        WuliuVehicleRoute wuliuVehicleRoute1 = wuliuVehicleRoutes.get(d);
        wuliuStartRecording.setRoute(wuliuVehicleRoute1.getSerialNumber());
//        添加随机车牌号
        String drivernum = random("drivernum", 1);
        wuliuStartRecording.setDriveNum(drivernum);
//添加司机
        WuliuDriver wuliuDriver = new WuliuDriver();
        wuliuDriver.setVehicleNum(drivernum);
        List<WuliuDriver> wuliuDrivers = wuliuDriverService.selectWuliuDriverList(wuliuDriver);
        wuliuStartRecording.setDirectorName(wuliuDrivers.get(0).getName());
//        添加发起时间
        Date date = randomDate(new Date(), getDate1(9));

        wuliuStartRecording.setDepartureTime(date);
//        添加结束时间
        Date date1 = randomDate(getDate1(18), getDate1(19));
        wuliuStartRecording.setReturnCarTime(date1);
//添加状态
        wuliuStartRecording.setDrivingStart("正常");

        toAjax(wuliuStartRecordingService.insertWuliuStartRecording(wuliuStartRecording));
        }

    }


    public String random(String type, int i) {
        List<SysDictData> sysDictTypes = dictDataService.selectDictDataByType(type);
        ArrayList<String> strings = new ArrayList<>();
        sysDictTypes.forEach(itm -> {
            strings.add(itm.getDictValue());
        });
        Random random = new Random();
        int i1 = random.nextInt(i);
        return strings.get(i1);
    }

    //获取当天0点时间
    public static Date getDate1(int i) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, i);//控制时
        cal.set(Calendar.MINUTE, 0);//控制分
        cal.set(Calendar.SECOND, 0);//控制秒
        return cal.getTime();
    }

    //生成指定时间内的时间
    private static Date randomDate(Date start, Date end) {

        if (start.getTime() >= end.getTime()) {
            return null;
        }
        long date = random(start.getTime(), end.getTime());
        return new Date(date);
    }

    private static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }


}

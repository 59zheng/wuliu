package com.ruoyi.cundian.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.cundian.domain.*;
import com.ruoyi.cundian.service.IVillagePointService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.wuliu.domain.Couriercompany;
import com.ruoyi.wuliu.service.ICourierService;
import com.ruoyi.wuliu.service.ICouriercompanyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 村点Controller
 *
 * @author zheng
 * @date 2019-12-10
 */
@Controller
@RequestMapping("/cundian/point")
public class VillagePointController extends BaseController {
    private String prefix = "cundian/point";

    @Autowired
    private IVillagePointService villagePointService;

    @Autowired
    private ICourierService courierService;

    @Autowired
    private ICouriercompanyService couriercompanyService;

    @RequiresPermissions("cundian:point:view")
    @GetMapping()
    public String point() {
        return prefix + "/point";
    }

    /**
     * 查询村点树列表
     */
    @RequiresPermissions("cundian:point:list")
    @PostMapping("/list")
    @ResponseBody
    public List<VillagePoint> list(VillagePoint villagePoint) {
        // 获取当前的用户信息
        SysUser sysUser = ShiroUtils.getSysUser();
        SysDept dept = sysUser.getDept();
        String deptName = dept.getDeptName();
        List<VillagePoint> list1 = new ArrayList<>();
        if ("admin".equals(sysUser.getLoginName())) {
            list1 = villagePointService.selectVillagePointList(villagePoint);
        } else if (!"县级管理".equals(deptName) && deptName != null) {
            //获取到所属服务站名
            String station = sysUser.getStation();
            //查询指定服务站名的服务站以及子服务站
            list1 = villagePointService.selectbyvillageName(station);
        } else {
            list1 = villagePointService.selectVillagePointList(villagePoint);
        }
        return list1;
    }

    /**
     * 导出村点列表
     */
    @RequiresPermissions("cundian:point:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(VillagePoint villagePoint) {
        List<VillagePoint> list = villagePointService.selectVillagePointList(villagePoint);
        ExcelUtil<VillagePoint> util = new ExcelUtil<VillagePoint>(VillagePoint.class);
        return util.exportExcel(list, "point");
    }

    /**
     * 新增村点
     */
    @GetMapping(value = {"/add/{id}", "/add/"})
    public String add(@PathVariable(value = "id", required = false) Long id, ModelMap mmap) {
        if (StringUtils.isNotNull(id)) {
            mmap.put("villagePoint", villagePointService.selectVillagePointById(id));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存村点
     */
    @RequiresPermissions("cundian:point:add")
    @Log(title = "村点", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("file") MultipartFile picture, VillagePoint villagePoint, @RequestParam("checked") String[] arr) throws IOException {
        // 上传文件路径
        String filePath = Global.getUploadPath();
        // 上传并返回新文件名称
        String fileName = FileUploadUtils.upload(filePath, picture);
        villagePoint.setPicture(fileName);
        villagePoint.setIsEnable("0");
        int i = 0;
        try {
            i = villagePointService.insertVillagePoint(villagePoint);
        } catch (Exception e) {
//            return new AjaxResult("村点名称已经存在");
            return error("村点名称已经存在");
        }
        List<VillagePoint> list = villagePointService.selectVillagePointList(villagePoint);
        Long id = list.get(0).getId();
        for (String s : arr) {
            Couriercompany couriercompany = new Couriercompany();
            couriercompany.setCouriercompany(s);
            List<Couriercompany> couriercompanies = couriercompanyService.selectCouriercompanyList(couriercompany);
            Long id1 = couriercompanies.get(0).getId();
            villagePointService.setvillageCourierId(id, id1);
        }
        return toAjax(i);
    }

    /**
     * 修改村点
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        VillagePoint villagePoint = villagePointService.selectVillagePointById(id);
        Long[] arr = villagePointService.selectbycourierid(id);
        StringBuilder stringBuilder = new StringBuilder();
        for (Long aLong : arr) {
            Couriercompany couriercompany = couriercompanyService.selectCouriercompanyById(aLong);
            stringBuilder.append(couriercompany.getCouriercompany());
            stringBuilder.append(",");
        }
        VillagePointVo villagePointVo = new VillagePointVo();
       villagePointVo.setVillagePoint(villagePoint);
        String s = stringBuilder.toString();
        villagePointVo.setCourierCompanyIdS(s);
        mmap.put("villagePointVo", villagePointVo);
        return prefix + "/edit";
    }

    /**
//     * 修改保存村点
//     */
//    @RequiresPermissions("cundian:point:edit")
//    @Log(title = "村点", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    public AjaxResult editSave(VillagePointVo villagePointVo ,@RequestParam("file") MultipartFile picture) throws IOException {
//        VillagePoint villagePoint = villagePointVo.getVillagePoint();
//        String courierCompanyIdS = villagePointVo.getCourierCompanyIdS();
//        // 上传文件路径
//        String filePath = Global.getUploadPath();
//        // 上传并返回新文件名称
//        String fileName = FileUploadUtils.upload(filePath, picture);
//        villagePoint.setPicture(fileName);
//        String[] split = courierCompanyIdS.split(",");
//        Long id = villagePoint.getId();
//        villagePointService.deleteCourierByvilid(id);
//        for (String s : split) {
//            Couriercompany couriercompany = new Couriercompany();
//            couriercompany.setCouriercompany(s);
//            List<Couriercompany> couriercompanies = couriercompanyService.selectCouriercompanyList(couriercompany);
//            Long id1 = couriercompanies.get(0).getId();
//            villagePointService.setvillageCourierId(id, id1);
//        }
//        return toAjax(villagePointService.updateVillagePoint(villagePoint));
//    }

    /**
     * 修改保存村点
     */
    @RequiresPermissions("cundian:point:edit")
    @Log(title = "村点", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(VillagePointVo1 villagePointVo , @RequestParam("file") MultipartFile picture) throws IOException {
        VillagePoint villagePoint = new VillagePoint();
        villagePoint.setId(villagePointVo.getId());
        villagePoint.setVillageName(villagePointVo.getVillageName());
        villagePoint.setProvinces(villagePointVo.getProvinces());
        villagePoint.setCities(villagePointVo.getCities());
        villagePoint.setCounties(villagePointVo.getCounties());
        villagePoint.setAddress(villagePointVo.getAddress());
        villagePoint.setLongitude(villagePointVo.getLongitude());
        villagePoint.setLatitude(villagePointVo.getLatitude());
        villagePoint.setIsEnable("0");
        villagePoint.setHead(villagePointVo.getHead());
        villagePoint.setHeadPhone(villagePointVo.getHeadPhone());
        villagePoint.setExaminationName(villagePointVo.getExaminationName());
        villagePoint.setExaminationPhone(villagePointVo.getExaminationPhone());
        villagePoint.setExaminationTime(villagePointVo.getExaminationTime());
        villagePoint.setProductId(villagePointVo.getProductId());
        String courierCompanyIdS = villagePointVo.getCourierCompanyIdS();
        // 上传文件路径
        String filePath = Global.getUploadPath();
        // 上传并返回新文件名称
        String fileName = FileUploadUtils.upload(filePath, picture);
        villagePoint.setPicture(fileName);
        String[] split = courierCompanyIdS.split(",");
        Long id = villagePoint.getId();
        villagePointService.deleteCourierByvilid(id);
        for (String s : split) {
            Couriercompany couriercompany = new Couriercompany();
            couriercompany.setCouriercompany(s);
            List<Couriercompany> couriercompanies = couriercompanyService.selectCouriercompanyList(couriercompany);
            Long id1 = couriercompanies.get(0).getId();
            villagePointService.setvillageCourierId(id, id1);
        }
        return toAjax(villagePointService.updateVillagePoint(villagePoint));
    }
    /**
     * 删除
     */
    @RequiresPermissions("cundian:point:remove")
    @Log(title = "村点", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{id}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("id") Long id) {
        return toAjax(villagePointService.deleteVillagePointById(id));
    }

    /**
     * 选择村点树
     */
    @GetMapping(value = {"/selectPointTree/{id}", "/selectPointTree/"})
    public String selectPointTree(@PathVariable(value = "id", required = false) Long id, ModelMap mmap) {
        if (StringUtils.isNotNull(id)) {
            mmap.put("villagePoint", villagePointService.selectVillagePointById(id));
        }
        return prefix + "/tree";
    }

    /**
     * 加载村点树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData() {
        List<Ztree> ztrees = villagePointService.selectVillagePointTree();
        return ztrees;
    }

    /*
     *通过服务站名查询可支配的快递公司
     * */
    @GetMapping("/slectcourier")
    @ResponseBody
    public List<String> slectcourier(String villageName) {
        VillagePoint villagePoint = new VillagePoint();
        villagePoint.setVillageName(villageName);
        List<VillagePoint> list = villagePointService.selectVillagePointList(villagePoint);
        Long id = list.get(0).getId();
        Long[] selectbycourierid = villagePointService.selectbycourierid(id);
        List<String> strings = new ArrayList<>();
        for (Long aLong : selectbycourierid) {
            Couriercompany couriercompany = couriercompanyService.selectCouriercompanyById(aLong);
            strings.add(couriercompany.getCouriercompany());
        }
        return strings;
    }


    //    查询村点总数
    @GetMapping("/cundianNum")
    @ResponseBody
    public String cundianNum() {
        String num = villagePointService.cundianNum();
        return num;
    }

    //    查询服务站名称
    @GetMapping("/saveList")
    @ResponseBody
    public List<VillagePoint> saveList() {
        VillagePoint villagePoint = new VillagePoint();
        List<VillagePoint> list = villagePointService.selectVillagePointList(villagePoint);
        return list;

    }

    //    首页统计村点信息 一级页面
    @GetMapping("/statistcalIndex")
    @ResponseBody
    public List<VillageStatisticalVo> statistcalIndex() {

        List<VillageStatisticalVo> list = villagePointService.cundianSaveNum();
        ArrayList<VillageStatisticalVo> villageStatisticalVos = new ArrayList<>();
        for (VillageStatisticalVo villageStatisticalVo : list) {
            String name = villageStatisticalVo.getName();
            List<VillageStatisticalVo> list1= courierService.selectSend(name);
            for (VillageStatisticalVo statisticalVo : list1) {
                VillageStatisticalVo villageStatisticalVo1 = new VillageStatisticalVo();
                String a= statisticalVo.getName()+statisticalVo.getDrilldown();
                villageStatisticalVo1.setName(a);
                villageStatisticalVo1.setDrilldown(a);
                villageStatisticalVo1.setY(statisticalVo.getY());
                villageStatisticalVos.add(villageStatisticalVo1);
            }
        }
        return villageStatisticalVos;

    }
    //    首页统计村点信息 二级页面
    @GetMapping("/statistcalIndexTwo")
    @ResponseBody
    public Map<String, List<VillageTwoVo>> statistcalIndexTwo() {
//        拿出所有的父级name
      List<VillageTwoVo> villageTwoVos = new ArrayList<>();

        List<VillageStatisticalVo> list = villagePointService.cundianSaveNum();

        list.forEach(item->{
            String name = item.getName();

            List<VillageStatisticalVo> list1= courierService.selectSend(name);
            for (VillageStatisticalVo statisticalVo : list1) {
                VillageTwoVo villageTwoVo = new VillageTwoVo();
                String a= statisticalVo.getName()+statisticalVo.getDrilldown();
                villageTwoVo.setName(a);
                villageTwoVo.setId(a);
                VillagePoint villagePoint = new VillagePoint();
                villagePoint.setVillageName(statisticalVo.getName());
                List<VillagePoint> list3 = villagePointService.selectVillagePointList(villagePoint);
                List<VillageStatisticalVo> list4 = villagePointService.cundianSaveNumAll(list3.get(0).getId());
                    List<List> objects = new ArrayList<>();
                for (VillageStatisticalVo villageStatisticalVo : list4) {
                    List<VillageStatisticalVo> list2 = courierService.selectSendTwo(villageStatisticalVo.getName(),statisticalVo.getDrilldown());
//                拼接date
                    list2.forEach(item2 -> {
                        List<Object> objects1 = new ArrayList<>();
                        objects1.add(item2.getName() + item2.getDrilldown());
                        objects1.add(item2.getY());
                        objects.add(objects1);
                    });
                }
                    villageTwoVo.setData(objects);
                villageTwoVos.add(villageTwoVo);
            }
//
        });
        Map<String, List<VillageTwoVo>> stringvillageTwoVosMap = new HashMap<String, List<VillageTwoVo>>();
        stringvillageTwoVosMap.put("series",villageTwoVos);
        return stringvillageTwoVosMap;

    }

}

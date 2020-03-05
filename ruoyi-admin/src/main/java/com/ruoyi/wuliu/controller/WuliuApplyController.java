package com.ruoyi.wuliu.controller;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.cundian.domain.VillagePoint;
import com.ruoyi.cundian.service.IVillagePointService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.wuliu.domain.*;
import com.ruoyi.wuliu.service.IWuliuDriverService;
import com.ruoyi.wuliu.service.IWuliuInternalService;
import com.ruoyi.wuliu.service.IWuliuTaskService;
import org.apache.ibatis.annotations.Param;
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
import com.ruoyi.wuliu.service.IWuliuApplyService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

import javax.xml.crypto.Data;

/**
 * 申请Controller
 *
 * @author ruoyi
 * @date 2019-12-11
 */
@Controller
@RequestMapping("/wuliu/apply")
public class WuliuApplyController extends BaseController {
    private String prefix = "wuliu/apply";

    @Autowired
    private IWuliuApplyService wuliuApplyService;

    @Autowired
    private IWuliuTaskService wuliuTaskService;


    @Autowired
    private IVillagePointService villagePointService;

    @Autowired
    private IWuliuInternalService wuliuInternalService;


    @Autowired
    private IWuliuDriverService wuliuDriverService;


    @RequiresPermissions("wuliu:apply:view")
    @GetMapping()
    public String apply() {
        return prefix + "/apply";
    }

    /**
     * 查询申请列表
     */
    @RequiresPermissions("wuliu:apply:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WuliuApply wuliuApply) {
        startPage();
        List<WuliuApply> list = wuliuApplyService.selectWuliuApplyList(wuliuApply);
        return getDataTable(list);
    }

    /**
     * 导出申请列表
     */
    @RequiresPermissions("wuliu:apply:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WuliuApply wuliuApply) {
        List<WuliuApply> list = wuliuApplyService.selectWuliuApplyList(wuliuApply);
        ExcelUtil<WuliuApply> util = new ExcelUtil<WuliuApply>(WuliuApply.class);
        return util.exportExcel(list, "apply");
    }

    /**
     * 新增申请
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存申请
     */
    @RequiresPermissions("wuliu:apply:add")
    @Log(title = "申请", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WuliuApplyVO wuliuApply) {
        WuliuApply wuliuApply1 = new WuliuApply();
        String sender = wuliuApply.getSender();
        wuliuApply1.setInitiateName(sender);
        wuliuApply1.setIsDispose("待处理");
        wuliuApply1.setCreateTime(new Date());
        //生成内部订单号
        String courierName = wuliuApply.getCourierName();
        int randomNum = (int) ((Math.random() * 9 + 1) * 100000); // 随机数 6 位
        String s = ("D"+randomNum + "");
        wuliuApply1.setWuliuInternalId(s);
        wuliuApply1.setApplyid((long) randomNum);
        //存储内部订单表
        WuliuInternal wuliuInternal = new WuliuInternal();
        wuliuInternal.setCratetime(new Date());
        wuliuInternal.setCouriercompany(wuliuApply.getCourierName());
        wuliuInternal.setDowndress(wuliuApply.getConsigneeAddress());
        wuliuInternal.setSheng(wuliuApply.getProvince());
        wuliuInternal.setShi(wuliuApply.getCity());
        wuliuInternal.setXian(wuliuApply.getCounty());
        wuliuInternal.setDownName(wuliuApply.getSender());
        wuliuInternal.setDownPhone(wuliuApply.getSenderPhone());
        wuliuInternal.setCreatePhone(wuliuApply.getConsigneePhone());
        wuliuInternal.setVillagePointName(wuliuApply.getVillagePointName());
        wuliuInternal.setDirection("months");
        wuliuInternal.setIsDelete("0");
        wuliuInternal.setInternalNum(s);
        wuliuInternalService.insertWuliuInternal(wuliuInternal);
        return toAjax(wuliuApplyService.insertWuliuApply(wuliuApply1));
    }

    /**
     * 修改申请
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        WuliuApply wuliuApply = wuliuApplyService.selectWuliuApplyById(id);
        WuliuApplyEditVO wuliuApplyEditVO = new WuliuApplyEditVO();
        wuliuApplyEditVO.setApplyId(wuliuApply.getApplyid());
        wuliuApplyEditVO.setId(id);
        wuliuApplyEditVO.setInitiateName(wuliuApply.getInitiateName());
        wuliuApplyEditVO.setWuliuInternalId(wuliuApply.getWuliuInternalId());
        mmap.put("wuliuApplyEditVO", wuliuApplyEditVO);
        return prefix + "/edit";
    }

    /**
     * 修改保存申请
     */
    @RequiresPermissions("wuliu:apply:edit")
    @Log(title = "申请", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WuliuApplyEditVO wuliuApplyEditVO) {
        //生成任务单
        WuliuTask wuliuTask = new WuliuTask();
        wuliuTask.setCreateTime(new Date());
        wuliuTask.setEstimatedTime(wuliuApplyEditVO.getEstimatedTime());
        wuliuTask.setDriverNum(wuliuApplyEditVO.getDriverNum());
        //任务单号
        int randomNum = (int) ((Math.random() * 9 + 1) * 100000); // 随机数 6 位
        wuliuTask.setTaskId("S"+randomNum+"");
        //获取当前登录用户
        SysUser sysUser = ShiroUtils.getSysUser();
        //添加指派人
        wuliuTask.setAssignedName(sysUser.getUserName());
        wuliuTask.setIsReturn("未完成");
        WuliuDriver wuliuDriver = new WuliuDriver();
        wuliuDriver.setVehicleNum(wuliuApplyEditVO.getDriverNum());
        List<WuliuDriver> wuliuDrivers = wuliuDriverService.selectWuliuDriverList(wuliuDriver);
        String name = wuliuDrivers.get(0).getName();
        wuliuTask.setDriverName(name);
        String phone = wuliuDrivers.get(0).getPhone();
        wuliuTask.setPhone(phone);
        wuliuTask.setDriverName(wuliuApplyEditVO.getDriverNum());
        wuliuTaskService.insertWuliuTask(wuliuTask);
        //修改申请表状态信息
        WuliuApply wuliuApply = new WuliuApply();
        wuliuApply.setApplyid(wuliuApplyEditVO.getApplyId());
        wuliuApply.setInitiateName(wuliuApplyEditVO.getInitiateName());
        wuliuApply.setIsDispose("已指派");
        wuliuApply.setDisponseName(sysUser.getUserName());
        wuliuApply.setTaskId("S"+randomNum+"");
        wuliuApply.setCreateTime(wuliuApplyEditVO.getCreateTime());
        wuliuApply.setDisponseTime(new Date());
        wuliuApply.setWuliuInternalId(wuliuApplyEditVO.getWuliuInternalId());
        wuliuApply.setId(wuliuApplyEditVO.getId());
        return toAjax(wuliuApplyService.updateWuliuApply(wuliuApply));
    }

    /**
     * 删除申请
     */
    @RequiresPermissions("wuliu:apply:remove")
    @Log(title = "申请", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(wuliuApplyService.deleteWuliuApplyByIds(ids));
    }


    /**
     * 查询目的地定位
     */
    @GetMapping("/select")
    @ResponseBody
    public VillagePoint select(Long id) {
        WuliuApply wuliuApply = wuliuApplyService.selectWuliuApplyById(id);
        String wuliuInternalId = wuliuApply.getWuliuInternalId();
        WuliuInternal wuliuInternal=   wuliuInternalService.selectByInternalId(wuliuInternalId);
        String villagePointName = wuliuInternal.getVillagePointName();
        VillagePoint villagePoint1 = new VillagePoint();
        villagePoint1.setVillageName(villagePointName);
        List<VillagePoint> list = villagePointService.selectVillagePointList(villagePoint1);
        VillagePoint villagePoint = list.get(0);
        return villagePoint;
    }


     // 配送完成

    @PostMapping("/update")
    @ResponseBody
    public AjaxResult upadte(@Param("id") Long id,@Param("createname") String createname) {
        WuliuApply wuliuApply = wuliuApplyService.selectWuliuApplyById(id);
        wuliuApply.setIsDispose("已完成");
        wuliuApplyService.updateWuliuApply(wuliuApply);
        //修改内部订单号
        String wuliuInternalId = wuliuApply.getWuliuInternalId();
        WuliuInternal wuliuInternal=   wuliuInternalService.selectByInternalId(wuliuInternalId);
        wuliuInternal.setTasknum(createname);
        wuliuInternalService.updateWuliuInternal(wuliuInternal);
        //修改任务单号
        String teskId = wuliuApply.getTaskId();
         WuliuTask task= wuliuTaskService.selectByTeskId(teskId);
        task.setEndTime(new Date());
        task.setIsReturn("已完成");
        wuliuTaskService.updateWuliuTask(task);
        return AjaxResult.success(true);
    }

}

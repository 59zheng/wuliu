package com.ruoyi.wuliu.controller;

import java.util.Date;
import java.util.List;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.wuliu.domain.*;
import com.ruoyi.wuliu.service.IWuliuDelegateService;
import com.ruoyi.wuliu.service.IWuliuDriverService;
import com.ruoyi.wuliu.service.IWuliuTaskService;
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
import com.ruoyi.wuliu.service.IWuliuSchedulingService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 调度单号关联任务单和委派单Controller
 * 
 * @author zheng
 * @date 2019-12-13
 */
@Controller
@RequestMapping("/wuliu/scheduling")
public class WuliuSchedulingController extends BaseController
{
    private String prefix = "wuliu/scheduling";

    @Autowired
    private IWuliuSchedulingService wuliuSchedulingService;

    @Autowired
    private IWuliuDelegateService wuliuDelegateService;

    @Autowired
    private IWuliuTaskService wuliuTaskService;

    @Autowired
    private IWuliuDriverService wuliuDriverService;

    @RequiresPermissions("wuliu:scheduling:view")
    @GetMapping()
    public String scheduling()
    {
        return prefix + "/scheduling";
    }

    /**
     * 查询调度单号关联任务单和委派单列表
     */
    @RequiresPermissions("wuliu:scheduling:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WuliuScheduling wuliuScheduling)
    {
        startPage();
        List<WuliuScheduling> list = wuliuSchedulingService.selectWuliuSchedulingList(wuliuScheduling);
        return getDataTable(list);
    }

    /**
     * 导出调度单号关联任务单和委派单列表
     */
    @RequiresPermissions("wuliu:scheduling:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WuliuScheduling wuliuScheduling)
    {
        List<WuliuScheduling> list = wuliuSchedulingService.selectWuliuSchedulingList(wuliuScheduling);
        ExcelUtil<WuliuScheduling> util = new ExcelUtil<WuliuScheduling>(WuliuScheduling.class);
        return util.exportExcel(list, "scheduling");
    }

    /**
     * 新增调度单号关联任务单和委派单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存调度单号关联任务单和委派单
     */
    @RequiresPermissions("wuliu:scheduling:add")
    @Log(title = "调度单号关联任务单和委派单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WuliuScheduling wuliuScheduling)
    {
        wuliuScheduling.setCreateTime(new Date());
        int randomNum = (int) ((Math.random() * 9 + 1) * 100000); // 随机数 6 位
        wuliuScheduling.setSchedulingId(wuliuScheduling.getVillageName()+randomNum);
        wuliuScheduling.setSchedulingType("待处理");
        wuliuScheduling.setDelegateId(wuliuScheduling.getDelegateName()+randomNum);
        //添加委派单
        WuliuDelegate wuliuDelegate = new WuliuDelegate();
        wuliuDelegate.setSchedulingId(wuliuScheduling.getSchedulingId());
        wuliuDelegate.setVillageName(wuliuScheduling.getVillageName());
        wuliuDelegate.setVillageType("待处理");
        wuliuDelegateService.insertWuliuDelegate(wuliuDelegate);
        return toAjax(wuliuSchedulingService.insertWuliuScheduling(wuliuScheduling));
    }

    /**
     * 修改调度单号关联任务单和委派单
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WuliuScheduling wuliuScheduling = wuliuSchedulingService.selectWuliuSchedulingById(id);
        WuliuSchedulingVo wuliuSchedulingVo = new WuliuSchedulingVo();
        wuliuSchedulingVo.setDelegateId(wuliuScheduling.getDelegateId());
        wuliuSchedulingVo.setDelegateName(wuliuScheduling.getDelegateName());
        wuliuSchedulingVo.setId(wuliuScheduling.getId());
        wuliuSchedulingVo.setTasknum(wuliuScheduling.getTasknum());
        wuliuSchedulingVo.setVillageName(wuliuScheduling.getVillageName());
        wuliuSchedulingVo.setSchedulingId(wuliuScheduling.getSchedulingId());
        mmap.put("wuliuScheduling", wuliuSchedulingVo);
        return prefix + "/edit";
    }

    /**
     * 修改保存调度单号关联任务单和委派单
     */
    @RequiresPermissions("wuliu:scheduling:edit")
    @Log(title = "调度单号关联任务单和委派单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WuliuSchedulingVo wuliuSchedulingVo)
    {
        //添加调度表
        WuliuScheduling wuliuScheduling = new WuliuScheduling();
        wuliuScheduling.setId(wuliuSchedulingVo.getId());
        wuliuScheduling.setDelegateId(wuliuSchedulingVo.getDelegateId());
        wuliuScheduling.setSchedulingType("已指派");
        wuliuScheduling.setSchedulingId(wuliuSchedulingVo.getSchedulingId());
        wuliuScheduling.setDelegateName(wuliuScheduling.getDelegateName());
        wuliuScheduling.setTasknum(wuliuSchedulingVo.getTasknum());
        int randomNum = (int) ((Math.random() * 9 + 1) * 100000); // 随机数 6 位
        wuliuScheduling.setTaskId("D"+randomNum+"");
        //获取当前登录用户
        SysUser user = ShiroUtils.getSysUser();
        wuliuScheduling.setProcessingName(user.getUserName());
        wuliuScheduling.setProcessingTime(new Date());
        wuliuSchedulingService.updateWuliuScheduling(wuliuScheduling);
        //添加任务表
        //生成任务单
        WuliuTask wuliuTask = new WuliuTask();
        wuliuTask.setCreateTime(new Date());
        wuliuTask.setEstimatedTime(wuliuSchedulingVo.getEstimatedTime());
        wuliuTask.setDriverNum(wuliuSchedulingVo.getDriverNum());
        wuliuTask.setTaskId("D"+randomNum+"");
        //获取当前登录用户
        SysUser sysUser = ShiroUtils.getSysUser();
        //添加指派人
        wuliuTask.setAssignedName(sysUser.getUserName());
        wuliuTask.setIsReturn("未完成");
        WuliuDriver wuliuDriver = new WuliuDriver();
        wuliuDriver.setVehicleNum(wuliuSchedulingVo.getDriverNum());
        List<WuliuDriver> wuliuDrivers = wuliuDriverService.selectWuliuDriverList(wuliuDriver);
        String name = wuliuDrivers.get(0).getName();
        wuliuTask.setDriverName(name);
        String phone = wuliuDrivers.get(0).getPhone();
        wuliuTask.setPhone(phone);
        wuliuTaskService.insertWuliuTask(wuliuTask);

        //修改委派表
        WuliuDelegate wuliuDelegate = new WuliuDelegate();
        wuliuDelegate.setSchedulingId(wuliuSchedulingVo.getSchedulingId());
        List<WuliuDelegate> wuliuDelegates = wuliuDelegateService.selectWuliuDelegateList(wuliuDelegate);
        WuliuDelegate wuliuDelegate1 = wuliuDelegates.get(0);
        wuliuDelegate1.setEstimatedTime(wuliuSchedulingVo.getEstimatedTime());
        wuliuDelegate1.setVillageType("已指派");
        return toAjax(wuliuDelegateService.updateWuliuDelegate(wuliuDelegate1));
    }

    /**
     * 删除调度单号关联任务单和委派单
     */
    @RequiresPermissions("wuliu:scheduling:remove")
    @Log(title = "调度单号关联任务单和委派单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wuliuSchedulingService.deleteWuliuSchedulingByIds(ids));
    }

    /**
     * 删除调度单号关联任务单和委派单
     */
    @GetMapping( "/complete")
    @ResponseBody
    public AjaxResult complete(Long id)
    {
        WuliuScheduling wuliuScheduling = wuliuSchedulingService.selectWuliuSchedulingById(id);
        String schedulingId = wuliuScheduling.getSchedulingId();
        wuliuScheduling.setSchedulingType("已完成");
        wuliuSchedulingService.updateWuliuScheduling(wuliuScheduling);
        String taskId = wuliuScheduling.getTaskId();
        WuliuTask task = wuliuTaskService.selectByTeskId(taskId);
        task.setIsReturn("已完成");
        task.setEndTime(new Date());
        wuliuTaskService.updateWuliuTask(task);
        WuliuDelegate wuliuDelegate = new WuliuDelegate();
        wuliuDelegate.setSchedulingId(schedulingId);
        List<WuliuDelegate> wuliuDelegates = wuliuDelegateService.selectWuliuDelegateList(wuliuDelegate);
        WuliuDelegate wuliuDelegate1 = wuliuDelegates.get(0);
        wuliuDelegate1.setVillageType("已完成");
        wuliuDelegate1.setDeliveryTime(new Date());
        return toAjax(wuliuDelegateService.updateWuliuDelegate(wuliuDelegate1));
    }
}

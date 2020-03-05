package com.ruoyi.wuliu.controller;

import java.util.List;
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
import com.ruoyi.wuliu.domain.WuliuTask;
import com.ruoyi.wuliu.service.IWuliuTaskService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 任务单关联路径和车辆和内部运单Controller
 * 
 * @author zheng
 * @date 2019-12-23
 */
@Controller
@RequestMapping("/wuliu/task")
public class WuliuTaskController extends BaseController
{
    private String prefix = "wuliu/task";

    @Autowired
    private IWuliuTaskService wuliuTaskService;

    @RequiresPermissions("wuliu:task:view")
    @GetMapping()
    public String task()
    {
        return prefix + "/task";
    }

    /**
     * 查询任务单关联路径和车辆和内部运单列表
     */
    @RequiresPermissions("wuliu:task:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WuliuTask wuliuTask)
    {
        startPage();
        List<WuliuTask> list = wuliuTaskService.selectWuliuTaskList(wuliuTask);
        return getDataTable(list);
    }

    /**
     * 导出任务单关联路径和车辆和内部运单列表
     */
    @RequiresPermissions ("wuliu:task:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WuliuTask wuliuTask)
    {
        List<WuliuTask> list = wuliuTaskService.selectWuliuTaskList(wuliuTask);
        ExcelUtil<WuliuTask> util = new ExcelUtil<WuliuTask>(WuliuTask.class);
        return util.exportExcel(list, "task");
    }

    /**
     * 新增任务单关联路径和车辆和内部运单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存任务单关联路径和车辆和内部运单
     */
    @RequiresPermissions("wuliu:task:add")
    @Log(title = "任务单关联路径和车辆和内部运单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WuliuTask wuliuTask)
    {
        return toAjax(wuliuTaskService.insertWuliuTask(wuliuTask));
    }

    /**
     * 修改任务单关联路径和车辆和内部运单
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WuliuTask wuliuTask = wuliuTaskService.selectWuliuTaskById(id);
        mmap.put("wuliuTask", wuliuTask);
        return prefix + "/edit";
    }

    /**
     * 修改保存任务单关联路径和车辆和内部运单
     */
    @RequiresPermissions("wuliu:task:edit")
    @Log(title = "任务单关联路径和车辆和内部运单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WuliuTask wuliuTask)
    {
        return toAjax(wuliuTaskService.updateWuliuTask(wuliuTask));
    }

    /**
     * 删除任务单关联路径和车辆和内部运单
     */
    @RequiresPermissions ("wuliu:task:remove")
    @Log(title = "任务单关联路径和车辆和内部运单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wuliuTaskService.deleteWuliuTaskByIds(ids));
    }
}

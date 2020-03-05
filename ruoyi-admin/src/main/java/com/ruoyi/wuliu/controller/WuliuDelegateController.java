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
import com.ruoyi.wuliu.domain.WuliuDelegate;
import com.ruoyi.wuliu.service.IWuliuDelegateService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 委派单关联调度单Controller
 * 
 * @author zheng
 * @date 2019-12-13
 */
@Controller
@RequestMapping("/wuliu/delegate")
public class WuliuDelegateController extends BaseController
{
    private String prefix = "wuliu/delegate";

    @Autowired
    private IWuliuDelegateService wuliuDelegateService;

    @RequiresPermissions("wuliu:delegate:view")
    @GetMapping()
    public String delegate()
    {
        return prefix + "/delegate";
    }

    /**
     * 查询委派单关联调度单列表
     */
    @RequiresPermissions("wuliu:delegate:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WuliuDelegate wuliuDelegate)
    {
        startPage();
        List<WuliuDelegate> list = wuliuDelegateService.selectWuliuDelegateList(wuliuDelegate);
        return getDataTable(list);
    }

    /**
     * 导出委派单关联调度单列表
     */
    @RequiresPermissions("wuliu:delegate:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WuliuDelegate wuliuDelegate)
    {
        List<WuliuDelegate> list = wuliuDelegateService.selectWuliuDelegateList(wuliuDelegate);
        ExcelUtil<WuliuDelegate> util = new ExcelUtil<WuliuDelegate>(WuliuDelegate.class);
        return util.exportExcel(list, "delegate");
    }

    /**
     * 新增委派单关联调度单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存委派单关联调度单
     */
    @RequiresPermissions("wuliu:delegate:add")
    @Log(title = "委派单关联调度单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WuliuDelegate wuliuDelegate)
    {
        return toAjax(wuliuDelegateService.insertWuliuDelegate(wuliuDelegate));
    }

    /**
     * 修改委派单关联调度单
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WuliuDelegate wuliuDelegate = wuliuDelegateService.selectWuliuDelegateById(id);
        mmap.put("wuliuDelegate", wuliuDelegate);
        return prefix + "/edit";
    }

    /**
     * 修改保存委派单关联调度单
     */
    @RequiresPermissions("wuliu:delegate:edit")
    @Log(title = "委派单关联调度单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WuliuDelegate wuliuDelegate)
    {
        return toAjax(wuliuDelegateService.updateWuliuDelegate(wuliuDelegate));
    }

    /**
     * 删除委派单关联调度单
     */
    @RequiresPermissions("wuliu:delegate:remove")
    @Log(title = "委派单关联调度单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wuliuDelegateService.deleteWuliuDelegateByIds(ids));
    }
}

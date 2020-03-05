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
import com.ruoyi.wuliu.domain.WuliuInternal;
import com.ruoyi.wuliu.service.IWuliuInternalService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 内部订单（上下行）Controller
 * 
 * @author zheng
 * @date 2019-12-05
 */
@Controller
@RequestMapping("/wuliu/internal")
public class WuliuInternalController extends BaseController
{
    private String prefix = "wuliu/internal";

    @Autowired
    private IWuliuInternalService wuliuInternalService;

    @RequiresPermissions("wuliu:internal:view")
    @GetMapping()
    public String internal()
    {
        return prefix + "/internal";
    }

    /**
     * 查询内部订单（上下行）列表
     */
    @RequiresPermissions("wuliu:internal:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WuliuInternal wuliuInternal)
    {
        startPage();
        List<WuliuInternal> list = wuliuInternalService.selectWuliuInternalList(wuliuInternal);
        return getDataTable(list);
    }

    /**
     * 导出内部订单（上下行）列表
     */
    @RequiresPermissions("wuliu:internal:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WuliuInternal wuliuInternal)
    {
        List<WuliuInternal> list = wuliuInternalService.selectWuliuInternalList(wuliuInternal);
        ExcelUtil<WuliuInternal> util = new ExcelUtil<WuliuInternal>(WuliuInternal.class);
        return util.exportExcel(list, "internal");
    }

    /**
     * 新增内部订单（上下行）
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存内部订单（上下行）
     */
    @RequiresPermissions("wuliu:internal:add")
    @Log(title = "内部订单（上下行）", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WuliuInternal wuliuInternal)
    {
        return toAjax(wuliuInternalService.insertWuliuInternal(wuliuInternal));
    }

    /**
     * 修改内部订单（上下行）
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WuliuInternal wuliuInternal = wuliuInternalService.selectWuliuInternalById(id);
        mmap.put("wuliuInternal", wuliuInternal);
        return prefix + "/edit";
    }

    /**
     * 修改保存内部订单（上下行）
     */
    @RequiresPermissions("wuliu:internal:edit")
    @Log(title = "内部订单（上下行）", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WuliuInternal wuliuInternal)
    {
        return toAjax(wuliuInternalService.updateWuliuInternal(wuliuInternal));
    }

    /**
     * 删除内部订单（上下行）
     */
    @RequiresPermissions("wuliu:internal:remove")
    @Log(title = "内部订单（上下行）", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wuliuInternalService.deleteWuliuInternalByIds(ids));
    }
}

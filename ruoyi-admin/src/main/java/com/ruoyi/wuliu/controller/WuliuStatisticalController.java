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
import com.ruoyi.wuliu.domain.WuliuStatistical;
import com.ruoyi.wuliu.service.IWuliuStatisticalService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 统计服务站上下行Controller
 * 
 * @author zheng
 * @date 2019-12-05
 */
@Controller
@RequestMapping("/wuliu/statistical")
public class WuliuStatisticalController extends BaseController
{
    private String prefix = "wuliu/statistical";

    @Autowired
    private IWuliuStatisticalService wuliuStatisticalService;

    @RequiresPermissions("wuliu:statistical:view")
    @GetMapping()
    public String statistical()
    {
        return prefix + "/statistical";
    }

    /**
     * 查询统计服务站上下行列表
     */
    @RequiresPermissions("wuliu:statistical:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WuliuStatistical wuliuStatistical)
    {
        startPage();
        List<WuliuStatistical> list = wuliuStatisticalService.selectWuliuStatisticalList(wuliuStatistical);
        return getDataTable(list);
    }

    /**
     * 导出统计服务站上下行列表
     */
    @RequiresPermissions("wuliu:statistical:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WuliuStatistical wuliuStatistical)
    {
        List<WuliuStatistical> list = wuliuStatisticalService.selectWuliuStatisticalList(wuliuStatistical);
        ExcelUtil<WuliuStatistical> util = new ExcelUtil<WuliuStatistical>(WuliuStatistical.class);
        return util.exportExcel(list, "statistical");
    }

    /**
     * 新增统计服务站上下行
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存统计服务站上下行
     */
    @RequiresPermissions("wuliu:statistical:add")
    @Log(title = "统计服务站上下行", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WuliuStatistical wuliuStatistical)
    {
        return toAjax(wuliuStatisticalService.insertWuliuStatistical(wuliuStatistical));
    }

    /**
     * 修改统计服务站上下行
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WuliuStatistical wuliuStatistical = wuliuStatisticalService.selectWuliuStatisticalById(id);
        mmap.put("wuliuStatistical", wuliuStatistical);
        return prefix + "/edit";
    }

    /**
     * 修改保存统计服务站上下行
     */
    @RequiresPermissions("wuliu:statistical:edit")
    @Log(title = "统计服务站上下行", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WuliuStatistical wuliuStatistical)
    {
        return toAjax(wuliuStatisticalService.updateWuliuStatistical(wuliuStatistical));
    }

    /**
     * 删除统计服务站上下行
     */
    @RequiresPermissions("wuliu:statistical:remove")
    @Log(title = "统计服务站上下行", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wuliuStatisticalService.deleteWuliuStatisticalByIds(ids));
    }
}

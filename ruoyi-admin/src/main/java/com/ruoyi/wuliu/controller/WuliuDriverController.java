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
import com.ruoyi.wuliu.domain.WuliuDriver;
import com.ruoyi.wuliu.service.IWuliuDriverService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 司机Controller
 * 
 * @author 正
 * @date 2019-12-05
 */
@Controller
@RequestMapping("/wuliu/driver")
public class WuliuDriverController extends BaseController
{
    private String prefix = "wuliu/driver";

    @Autowired
    private IWuliuDriverService wuliuDriverService;

    @RequiresPermissions("wuliu:driver:view")
    @GetMapping()
    public String driver()
    {
        return prefix + "/driver";
    }

    /**
     * 查询司机列表
     */
    @RequiresPermissions("wuliu:driver:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WuliuDriver wuliuDriver)
    {
        startPage();
        List<WuliuDriver> list = wuliuDriverService.selectWuliuDriverList(wuliuDriver);
        return getDataTable(list);
    }
    /**
     * 查询司机列表
     */
    @RequiresPermissions("wuliu:driver:list")
    @PostMapping("/list2")
    @ResponseBody
    public List<WuliuDriver> list2(WuliuDriver wuliuDriver)
    {
        List<WuliuDriver> list = wuliuDriverService.selectWuliuDriverList(wuliuDriver);
        return list;
    }

    /**
     * 导出司机列表
     */
    @RequiresPermissions("wuliu:driver:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WuliuDriver wuliuDriver)
    {
        List<WuliuDriver> list = wuliuDriverService.selectWuliuDriverList(wuliuDriver);
        ExcelUtil<WuliuDriver> util = new ExcelUtil<WuliuDriver>(WuliuDriver.class);
        return util.exportExcel(list, "driver");
    }

    /**
     * 新增司机
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存司机
     */
    @RequiresPermissions("wuliu:driver:add")
    @Log(title = "司机", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WuliuDriver wuliuDriver)
    {
        return toAjax(wuliuDriverService.insertWuliuDriver(wuliuDriver));
    }

    /**
     * 修改司机
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WuliuDriver wuliuDriver = wuliuDriverService.selectWuliuDriverById(id);
        mmap.put("wuliuDriver", wuliuDriver);
        return prefix + "/edit";
    }

    /**
     * 修改保存司机
     */
    @RequiresPermissions("wuliu:driver:edit")
    @Log(title = "司机", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WuliuDriver wuliuDriver)
    {
        return toAjax(wuliuDriverService.updateWuliuDriver(wuliuDriver));
    }

    /**
     * 删除司机
     */
    @RequiresPermissions("wuliu:driver:remove")
    @Log(title = "司机", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wuliuDriverService.deleteWuliuDriverByIds(ids));
    }
}

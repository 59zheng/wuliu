package com.ruoyi.system.controller;

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
import com.ruoyi.system.domain.DbArea;
import com.ruoyi.system.service.IDbAreaService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 区县信息Controller
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
@Controller
@RequestMapping("/system/area")
public class DbAreaController extends BaseController
{
    private String prefix = "system/area";

    @Autowired
    private IDbAreaService dbAreaService;

    @GetMapping()
    public String area()
    {
        return prefix + "/area";
    }

    /**
     * 查询区县信息列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DbArea dbArea)
    {
        startPage();
        List<DbArea> list = dbAreaService.selectDbAreaList(dbArea);
        return getDataTable(list);
    }

    /**
     * 导出区县信息列表
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DbArea dbArea)
    {
        List<DbArea> list = dbAreaService.selectDbAreaList(dbArea);
        ExcelUtil<DbArea> util = new ExcelUtil<DbArea>(DbArea.class);
        return util.exportExcel(list, "area");
    }

    /**
     * 新增区县信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存区县信息
     */
    @Log(title = "区县信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DbArea dbArea)
    {
        return toAjax(dbAreaService.insertDbArea(dbArea));
    }

    /**
     * 修改区县信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DbArea dbArea = dbAreaService.selectDbAreaById(id);
        mmap.put("dbArea", dbArea);
        return prefix + "/edit";
    }

    /**
     * 修改保存区县信息
     */
    @Log(title = "区县信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DbArea dbArea)
    {
        return toAjax(dbAreaService.updateDbArea(dbArea));
    }

    /**
     * 删除区县信息
     */
    @Log(title = "区县信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dbAreaService.deleteDbAreaByIds(ids));
    }
}

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
import com.ruoyi.system.domain.DbCity;
import com.ruoyi.system.service.IDbCityService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 城市信息Controller
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
@Controller
@RequestMapping("/system/city")
public class DbCityController extends BaseController
{
    private String prefix = "system/city";

    @Autowired
    private IDbCityService dbCityService;

    @GetMapping()
    public String city()
    {
        return prefix + "/city";
    }

    /**
     * 查询城市信息列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DbCity dbCity)
    {
        startPage();
        List<DbCity> list = dbCityService.selectDbCityList(dbCity);
        return getDataTable(list);
    }

    /**
     * 导出城市信息列表
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DbCity dbCity)
    {
        List<DbCity> list = dbCityService.selectDbCityList(dbCity);
        ExcelUtil<DbCity> util = new ExcelUtil<DbCity>(DbCity.class);
        return util.exportExcel(list, "city");
    }

    /**
     * 新增城市信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存城市信息
     */
    @Log(title = "城市信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DbCity dbCity)
    {
        return toAjax(dbCityService.insertDbCity(dbCity));
    }

    /**
     * 修改城市信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DbCity dbCity = dbCityService.selectDbCityById(id);
        mmap.put("dbCity", dbCity);
        return prefix + "/edit";
    }

    /**
     * 修改保存城市信息
     */
    @Log(title = "城市信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DbCity dbCity)
    {
        return toAjax(dbCityService.updateDbCity(dbCity));
    }

    /**
     * 删除城市信息
     */
    @Log(title = "城市信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dbCityService.deleteDbCityByIds(ids));
    }
}

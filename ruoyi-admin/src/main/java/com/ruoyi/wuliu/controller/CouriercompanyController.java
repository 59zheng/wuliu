package com.ruoyi.wuliu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.ruoyi.common.json.JSON;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.wuliu.domain.Couriercompany;
import com.ruoyi.wuliu.service.ICouriercompanyService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 快递公司Controller
 *
 * @author ruoyi
 * @date 2019-11-12
 */
@Controller
@RequestMapping("/wuliu/couriercompany")
public class CouriercompanyController extends BaseController {
    private String prefix = "wuliu/couriercompany";

    @Autowired
    private ICouriercompanyService couriercompanyService;

    @RequiresPermissions("wuliu:couriercompany:view")
    @GetMapping()
    public String couriercompany() {
        return prefix + "/couriercompany";
    }

    /**
     * 查询快递公司列表
     */
    @RequiresPermissions("wuliu:couriercompany:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Couriercompany couriercompany) {
        startPage();
        List<Couriercompany> list = couriercompanyService.selectCouriercompanyList(couriercompany);
        return getDataTable(list);
    }

    /**
     * 查询快递公司列表
     */
    @CrossOrigin
    @GetMapping("/dropdown")
    @ResponseBody
    public HashMap<String, ArrayList<HashMap<String, String>>> dropdown() {
        Couriercompany couriercompany = new Couriercompany();
        List<Couriercompany> list = couriercompanyService.selectCouriercompanyList(couriercompany);
        HashMap<String, ArrayList<HashMap<String, String>>> stringArrayListHashMap = new HashMap<>();
        ArrayList<HashMap<String, String>> hashMaps = new ArrayList<>();
        list.forEach(itm -> {
            HashMap<String, String> stringStringHashMap = new HashMap<>();
            stringStringHashMap.put("couier", itm.getCouriercompany());
            hashMaps.add(stringStringHashMap);
        });
        stringArrayListHashMap.put("name", hashMaps);
        return stringArrayListHashMap;
    }

    /**
     * 导出快递公司列表
     */
    @RequiresPermissions("wuliu:couriercompany:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Couriercompany couriercompany) {
        List<Couriercompany> list = couriercompanyService.selectCouriercompanyList(couriercompany);
        ExcelUtil<Couriercompany> util = new ExcelUtil<Couriercompany>(Couriercompany.class);
        return util.exportExcel(list, "couriercompany");
    }

    /**
     * 新增快递公司
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存快递公司
     */
    @RequiresPermissions("wuliu:couriercompany:add")
    @Log(title = "快递公司", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Couriercompany couriercompany) {
        couriercompany.setUpdatetime(new Date());
        return toAjax(couriercompanyService.insertCouriercompany(couriercompany));
    }

    /**
     * 修改快递公司
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        Couriercompany couriercompany = couriercompanyService.selectCouriercompanyById(id);
        mmap.put("couriercompany", couriercompany);
        return prefix + "/edit";
    }

    /**
     * 修改保存快递公司
     */
    @RequiresPermissions("wuliu:couriercompany:edit")
    @Log(title = "快递公司", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Couriercompany couriercompany) {
        return toAjax(couriercompanyService.updateCouriercompany(couriercompany));
    }

    /**
     * 删除快递公司
     */
    @RequiresPermissions("wuliu:couriercompany:remove")
    @Log(title = "快递公司", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(couriercompanyService.deleteCouriercompanyByIds(ids));
    }
}

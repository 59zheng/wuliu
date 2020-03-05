package com.ruoyi.system.controller;

import java.awt.geom.Area;
import java.util.List;

import com.ruoyi.system.domain.DbArea;
import com.ruoyi.system.domain.DbCity;
import com.ruoyi.system.service.IDbAreaService;
import com.ruoyi.system.service.IDbCityService;
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
import com.ruoyi.system.domain.DbProvince;
import com.ruoyi.system.service.IDbProvinceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 省市县三级下拉Controller
 * 
 * @author zheng
 * @date 2019-12-11
 */
@Controller
@RequestMapping("/system/province")
public class DbProvinceController extends BaseController
{
    private String prefix = "system/province";

    @Autowired
    private IDbProvinceService dbProvinceService;

    @Autowired
    private IDbCityService dbCityService;

    @Autowired
    private IDbAreaService dbAreaService;

    @GetMapping()
    public String province()
    {
        return prefix + "/province";
    }

    /**
     * 查询省三级下拉列表
     */
    @GetMapping("/provincelist")
    @ResponseBody
    public List<DbProvince> list(DbProvince dbProvince)
    {
        List<DbProvince> list = dbProvinceService.selectDbProvinceList(dbProvince);
        return list;
    }
    /**
     * 查询市三级下拉列表
     */
    @GetMapping("/citylist")
    @ResponseBody
    public List<DbCity> citylist(int dbProvinceid)
    {
        List<DbCity> list = dbCityService.selectprovinceid(dbProvinceid);
        return list;
    }
    /**
     * 查询县三级下拉列表
     */
    @GetMapping("/arealist")
    @ResponseBody
    public List<DbArea>  list(String cityid )
    {
        List<DbArea> list = dbAreaService.selectcityid(cityid);
        return list;
    }

}

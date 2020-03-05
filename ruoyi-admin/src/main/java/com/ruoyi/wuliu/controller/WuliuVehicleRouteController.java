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
import com.ruoyi.wuliu.domain.WuliuVehicleRoute;
import com.ruoyi.wuliu.service.IWuliuVehicleRouteService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 车辆路线Controller
 * 
 * @author zheng
 * @date 2020-01-09
 */
@Controller
@RequestMapping("/wuliu/route")
public class WuliuVehicleRouteController extends BaseController
{
    private String prefix = "wuliu/route";

    @Autowired
    private IWuliuVehicleRouteService wuliuVehicleRouteService;

    @RequiresPermissions("wuliu:route:view")
    @GetMapping()
    public String route()
    {
        return prefix + "/route";
    }

    /**
     * 查询车辆路线列表
     */
    @RequiresPermissions("wuliu:route:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WuliuVehicleRoute wuliuVehicleRoute)
    {
        startPage();
        List<WuliuVehicleRoute> list = wuliuVehicleRouteService.selectWuliuVehicleRouteList(wuliuVehicleRoute);
        return getDataTable(list);
    }

    /**
     * 导出车辆路线列表
     */
    @RequiresPermissions("wuliu:route:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WuliuVehicleRoute wuliuVehicleRoute)
    {
        List<WuliuVehicleRoute> list = wuliuVehicleRouteService.selectWuliuVehicleRouteList(wuliuVehicleRoute);
        ExcelUtil<WuliuVehicleRoute> util = new ExcelUtil<WuliuVehicleRoute>(WuliuVehicleRoute.class);
        return util.exportExcel(list, "route");
    }

    /**
     * 新增车辆路线
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存车辆路线
     */
    @RequiresPermissions("wuliu:route:add")
    @Log(title = "车辆路线", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WuliuVehicleRoute wuliuVehicleRoute)
    {
        return toAjax(wuliuVehicleRouteService.insertWuliuVehicleRoute(wuliuVehicleRoute));
    }

    /**
     * 修改车辆路线
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WuliuVehicleRoute wuliuVehicleRoute = wuliuVehicleRouteService.selectWuliuVehicleRouteById(id);
        mmap.put("wuliuVehicleRoute", wuliuVehicleRoute);
        return prefix + "/edit";
    }

    /**
     * 修改保存车辆路线
     */
    @RequiresPermissions("wuliu:route:edit")
    @Log(title = "车辆路线", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WuliuVehicleRoute wuliuVehicleRoute)
    {
        return toAjax(wuliuVehicleRouteService.updateWuliuVehicleRoute(wuliuVehicleRoute));
    }

    /**
     * 删除车辆路线
     */
    @RequiresPermissions("wuliu:route:remove")
    @Log(title = "车辆路线", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wuliuVehicleRouteService.deleteWuliuVehicleRouteByIds(ids));
    }
}

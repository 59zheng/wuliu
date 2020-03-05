package com.ruoyi.system.controller;

import java.io.IOException;
import java.util.List;

import com.ruoyi.common.config.Global;
import com.ruoyi.common.utils.file.FileUploadUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysFileInfo;
import com.ruoyi.system.service.ISysFileInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件信息Controller
 * 
 * @author ruoyi
 * @date 2019-11-26
 */
@Controller
@RequestMapping("/system/info")
public class SysFileInfoController extends BaseController
{
    private String prefix = "system/info";

    @Autowired
    private ISysFileInfoService sysFileInfoService;

    @RequiresPermissions("system:info:view")
    @GetMapping()
    public String info()
    {
        return prefix + "/info";
    }

    /**
     * 查询文件信息列表
     */
    @RequiresPermissions("system:info:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysFileInfo sysFileInfo)
    {
        startPage();
        List<SysFileInfo> list = sysFileInfoService.selectSysFileInfoList(sysFileInfo);
        return getDataTable(list);
    }

    /**
     * 导出文件信息列表
     */
    @RequiresPermissions("system:info:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysFileInfo sysFileInfo)
    {
        List<SysFileInfo> list = sysFileInfoService.selectSysFileInfoList(sysFileInfo);
        ExcelUtil<SysFileInfo> util = new ExcelUtil<SysFileInfo>(SysFileInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 新增文件信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }



    /**
     * 修改文件信息
     */
    @GetMapping("/edit/{fileId}")
    public String edit(@PathVariable("fileId") Long fileId, ModelMap mmap)
    {
        SysFileInfo sysFileInfo = sysFileInfoService.selectSysFileInfoById(fileId);
        mmap.put("sysFileInfo", sysFileInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存文件信息
     */
    @RequiresPermissions("system:info:edit")
    @Log(title = "文件信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysFileInfo sysFileInfo)
    {
        return toAjax(sysFileInfoService.updateSysFileInfo(sysFileInfo));
    }

    /**
     * 删除文件信息
     */
    @RequiresPermissions("system:info:remove")
    @Log(title = "文件信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysFileInfoService.deleteSysFileInfoByIds(ids));
    }

    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("file") MultipartFile file,SysFileInfo fileInfo) throws IOException
    {
        // 上传文件路径
        String filePath = Global.getUploadPath();
        // 上传并返回新文件名称
        String fileName = FileUploadUtils.upload(filePath, file);
        fileInfo.setFilePath(fileName);
        return toAjax(sysFileInfoService.insertSysFileInfo(fileInfo));
    }
}

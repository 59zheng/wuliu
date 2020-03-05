package com.ruoyi.cundian.controller;

import com.ruoyi.cundian.domain.VillagePoint;
import com.ruoyi.cundian.service.IVillagePointService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
@RequestMapping("/cundian/distribution")
public class Distribution {
    private String prefix = "cundian/distribution";

        @Autowired
        private IVillagePointService villagePointService;

    @RequiresPermissions("cundian:distribution:view")
    @GetMapping()
    public String VillagePoint() {
        return "cundian/point/distribution";
    }

    /**
     * 查询村点列表
     */
    @RequiresPermissions("cundian:point:list")
    @PostMapping("/list")
    @ResponseBody
    public List<VillagePoint> list(VillagePoint villagePoint) {
        List<VillagePoint> list = villagePointService.selectVillagePointList(villagePoint);
        return list;
    }


}

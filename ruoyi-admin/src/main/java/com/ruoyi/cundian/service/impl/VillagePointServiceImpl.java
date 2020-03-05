package com.ruoyi.cundian.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.cundian.domain.VillageStatisticalVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.cundian.mapper.VillagePointMapper;
import com.ruoyi.cundian.domain.VillagePoint;
import com.ruoyi.cundian.service.IVillagePointService;
import com.ruoyi.common.core.text.Convert;

/**
 * 村点Service业务层处理
 *
 * @author zheng
 * @date 2019-12-10
 */
@Service
public class VillagePointServiceImpl implements IVillagePointService
{
    @Autowired
    private VillagePointMapper villagePointMapper;

    /**
     * 查询村点
     *
     * @param id 村点ID
     * @return 村点
     */
    @Override
    public VillagePoint selectVillagePointById(Long id)
    {
        return villagePointMapper.selectVillagePointById(id);
    }

    /**
     * 查询村点列表
     *
     * @param villagePoint 村点
     * @return 村点
     */
    @Override
    public List<VillagePoint> selectVillagePointList(VillagePoint villagePoint)
    {
        return villagePointMapper.selectVillagePointList(villagePoint);
    }

    /**
     * 新增村点
     *
     * @param villagePoint 村点
     * @return 结果
     */
    @Override
    public int insertVillagePoint(VillagePoint villagePoint)
    {
        villagePoint.setCreateTime(DateUtils.getNowDate());
        return villagePointMapper.insertVillagePoint(villagePoint);
    }

    /**
     * 修改村点
     *
     * @param villagePoint 村点
     * @return 结果
     */
    @Override
    public int updateVillagePoint(VillagePoint villagePoint)
    {
        villagePoint.setUpdateTime(DateUtils.getNowDate());
        return villagePointMapper.updateVillagePoint(villagePoint);
    }

    /**
     * 删除村点对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteVillagePointByIds(String ids)
    {
        return villagePointMapper.deleteVillagePointByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除村点信息
     *
     * @param id 村点ID
     * @return 结果
     */
    @Override
    public int deleteVillagePointById(Long id)
    {
        return villagePointMapper.deleteVillagePointById(id);
    }

    @Override
    public List<VillagePoint> selectbyvillageName(String station) {
        //获取指定的服务站并且返回id
      VillagePoint villagePoint=  villagePointMapper.selectbyvillageName(station);
        Long id = villagePoint.getId();
        List<VillagePoint> list=villagePointMapper.selectbyid(id);

        return list;
    }

    @Override
    public void setvillageCourierId(Long id, Long id1) {
            villagePointMapper.setvillageCourierId(id,id1);
    }


    @Override
    public void deleteCourierByvilid(Long id) {
         villagePointMapper.deleteCourierByvilid(id);
    }

    @Override
    public Long[] selectbycourierid(Long id) {
        return villagePointMapper.selectbycourierid(id);
    }

    @Override
    public List<VillageStatisticalVo> cundianSaveNum() {
      return   villagePointMapper.cundianSaveNum();
    }

    @Override
    public String cundianNum() {
        return villagePointMapper.cundianNum();
    }

    @Override
    public List<VillageStatisticalVo> cundianSaveNumAll(Long id) {
        return villagePointMapper.cundianSaveNumAll(id);
    }

    /**
     * 查询村点树列表
     *
     * @return 所有村点信息
     */
    @Override
    public List<Ztree> selectVillagePointTree()
    {
        List<VillagePoint> villagePointList = villagePointMapper.selectVillagePointList(new VillagePoint());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (VillagePoint villagePoint : villagePointList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(villagePoint.getId());
            ztree.setpId(villagePoint.getProductId());
            ztree.setName(villagePoint.getVillageName());
            ztree.setTitle(villagePoint.getVillageName());
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
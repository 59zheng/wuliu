package com.ruoyi.cundian.service;

import com.ruoyi.cundian.domain.VillagePoint;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.cundian.domain.VillageStatisticalVo;

/**
 * 村点Service接口
 *
 * @author zheng
 * @date 2019-12-10
 */
public interface IVillagePointService
{
    /**
     * 查询村点
     *
     * @param id 村点ID
     * @return 村点
     */
    public VillagePoint selectVillagePointById(Long id);

    /**
     * 查询村点列表
     *
     * @param villagePoint 村点
     * @return 村点集合
     */
    public List<VillagePoint> selectVillagePointList(VillagePoint villagePoint);

    /**
     * 新增村点
     *
     * @param villagePoint 村点
     * @return 结果
     */
    public int insertVillagePoint(VillagePoint villagePoint);

    /**
     * 修改村点
     *
     * @param villagePoint 村点
     * @return 结果
     */
    public int updateVillagePoint(VillagePoint villagePoint);

    /**
     * 批量删除村点
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVillagePointByIds(String ids);

    /**
     * 删除村点信息
     *
     * @param id 村点ID
     * @return 结果
     */
    public int deleteVillagePointById(Long id);

    /**
     * 查询村点树列表
     *
     * @return 所有村点信息
     */
    public List<Ztree> selectVillagePointTree();

    List<VillagePoint> selectbyvillageName(String station);

    void setvillageCourierId(Long id, Long courierCompanyIdS);

    Long[] selectbycourierid(Long id);

    void deleteCourierByvilid(Long id);

    String cundianNum();

    List<VillageStatisticalVo> cundianSaveNum();

    List<VillageStatisticalVo> cundianSaveNumAll(Long id);
}
package com.ruoyi.cundian.mapper;

import com.ruoyi.cundian.domain.VillagePoint;
import com.ruoyi.cundian.domain.VillageStatisticalVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 村点Mapper接口
 *
 * @author zheng
 * @date 2019-12-10
 */
public interface VillagePointMapper
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
     * 删除村点
     *
     * @param id 村点ID
     * @return 结果
     */
    public int deleteVillagePointById(Long id);

    /**
     * 批量删除村点
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVillagePointByIds(String[] ids);

    VillagePoint selectbyvillageName(String station);

    List<VillagePoint> selectbyid(Long id);


    @Insert("insert into vilage_couriercompan (vilage_id, couriercompany_id) VALUES (#{id}, #{s})")
    void setvillageCourierId(@Param("id") Long id, @Param("s") Long s);

    @Select("select c.couriercompany_id from  vilage_couriercompan c where c.vilage_id=#{id}")
    Long[] selectbycourierid(Long id);

    @Delete("delete from vilage_couriercompan WHERE vilage_id = #{id}")
    void deleteCourierByvilid(Long id);

    @Select("select  COUNT(id) from village_point")
    String cundianNum();

    @Select("select  v.village_name as name  from village_point v  where product_id IS NULL group by v.village_name ")
    List<VillageStatisticalVo> cundianSaveNum();

    @Select("select  v.village_name as name ,COUNT(id) as  y from village_point v  where product_id =#{id} group by v.village_name ")
    List<VillageStatisticalVo> cundianSaveNumAll(Long id);
}
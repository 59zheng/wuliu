package com.ruoyi.wuliu.mapper;

import com.ruoyi.cundian.domain.VillageStatisticalVo;
import com.ruoyi.wuliu.domain.Courier;
import com.ruoyi.wuliu.domain.CourierVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 快递单管理Mapper接口
 *
 * @author zheng
 * @date 2019-11-12
 */
public interface CourierMapper {
    /**
     * 查询快递单管理
     *
     * @param id 快递单管理ID
     * @return 快递单管理
     */
    public Courier selectCourierById(Long id);

    /**
     * 查询快递单管理列表
     *
     * @param courier 快递单管理
     * @return 快递单管理集合
     */
    public List<Courier> selectCourierList(Courier courier);

    /**
     * 新增快递单管理
     *
     * @param courier 快递单管理
     * @return 结果
     */
    public int insertCourier(Courier courier);

    /**
     * 修改快递单管理
     *
     * @param courier 快递单管理
     * @return 结果
     */
    public int updateCourier(Courier courier);

    /**
     * 删除快递单管理
     *
     * @param id 快递单管理ID
     * @return 结果
     */
    public int deleteCourierById(Long id);

    /**
     * 批量删除快递单管理
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCourierByIds(String[] ids);


    @Select("SELECT DATE_FORMAT(cratetime,'%Y%m') months,c.sheng as province,COUNT(id) as num  FROM wuliu_courier c GROUP BY months,c.sheng")
    List<CourierVo> saveStatistical();


    @Select("select  COUNT(id) from wuliu_courier")
    String censusAll();

    @Select("select  COUNT(id) from wuliu_courier where type='村到县'")
    String censusupAll();

    @Select("select  COUNT(id) from wuliu_courier where type='县到村'")
    String censusdownAll();

    @Select("select  * from wuliu_courier order by cratetime DESC limit 10;")
    List<Courier> recentlyNum();

    @Select("SELECT COUNT(id) FROM wuliu_courier where DATE_SUB(CURDATE(), INTERVAL 30 DAY) <= date(cratetime)")
    String censusMonth();

    @Select("SELECT COUNT(id) FROM wuliu_courier where DATE_SUB(CURDATE(), INTERVAL 30 DAY) <= date(cratetime) and type='村到县'")
    String censusupMonth();

    @Select("SELECT COUNT(id) FROM wuliu_courier where DATE_SUB(CURDATE(), INTERVAL 30 DAY) <= date(cratetime) and type='县到村'")
    String censusdownMonth();

    @Select("select  v.village_name  as name ,COUNT(id) as y,v.type AS drilldown from wuliu_courier v where v.is_delete ='1'  and v.village_name=#{name} group by v.type")
    List<VillageStatisticalVo> selectSend( String name);

    @Select("select  v.village_name  as name ,COUNT(id) as y,v.type AS drilldown from wuliu_courier v where v.is_delete ='1' and v.village_name=#{name} and v.type=#{drilldown}")
    List<VillageStatisticalVo> selectSendTwo(@Param("name")String name,@Param("drilldown") String drilldown);
}

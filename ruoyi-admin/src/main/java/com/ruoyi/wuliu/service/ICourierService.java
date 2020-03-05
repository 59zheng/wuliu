package com.ruoyi.wuliu.service;

import com.ruoyi.cundian.domain.VillageStatisticalVo;
import com.ruoyi.wuliu.domain.Courier;
import com.ruoyi.wuliu.domain.CourierVo;

import java.util.List;
import java.util.Map;

/**
 * 快递单管理Service接口
 * 
 * @author zheng
 * @date 2019-11-12
 */
public interface ICourierService 
{
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
     * 批量删除快递单管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCourierByIds(String ids);

    /**
     * 删除快递单管理信息
     * 
     * @param id 快递单管理ID
     * @return 结果
     */
    public int deleteCourierById(Long id);

    List<CourierVo>  saveStatistical();

    String censusAll();

    String censusupAll();

    String censusdownAll();

    List<Courier> recentlyNum();

    String censusMonth();

    String censusupMonth();

    String censusdownMonth();

    List<VillageStatisticalVo> selectSend(String name);

    List<VillageStatisticalVo> selectSendTwo(String name, String drilldown);
}

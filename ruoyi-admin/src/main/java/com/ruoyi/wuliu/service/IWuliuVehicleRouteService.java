package com.ruoyi.wuliu.service;

import com.ruoyi.wuliu.domain.WuliuVehicleRoute;
import java.util.List;

/**
 * 车辆路线Service接口
 * 
 * @author zheng
 * @date 2020-01-09
 */
public interface IWuliuVehicleRouteService 
{
    /**
     * 查询车辆路线
     * 
     * @param id 车辆路线ID
     * @return 车辆路线
     */
    public WuliuVehicleRoute selectWuliuVehicleRouteById(Long id);

    /**
     * 查询车辆路线列表
     * 
     * @param wuliuVehicleRoute 车辆路线
     * @return 车辆路线集合
     */
    public List<WuliuVehicleRoute> selectWuliuVehicleRouteList(WuliuVehicleRoute wuliuVehicleRoute);

    /**
     * 新增车辆路线
     * 
     * @param wuliuVehicleRoute 车辆路线
     * @return 结果
     */
    public int insertWuliuVehicleRoute(WuliuVehicleRoute wuliuVehicleRoute);

    /**
     * 修改车辆路线
     * 
     * @param wuliuVehicleRoute 车辆路线
     * @return 结果
     */
    public int updateWuliuVehicleRoute(WuliuVehicleRoute wuliuVehicleRoute);

    /**
     * 批量删除车辆路线
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWuliuVehicleRouteByIds(String ids);

    /**
     * 删除车辆路线信息
     * 
     * @param id 车辆路线ID
     * @return 结果
     */
    public int deleteWuliuVehicleRouteById(Long id);
}

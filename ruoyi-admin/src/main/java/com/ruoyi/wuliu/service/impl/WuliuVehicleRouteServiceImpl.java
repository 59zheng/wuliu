package com.ruoyi.wuliu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wuliu.mapper.WuliuVehicleRouteMapper;
import com.ruoyi.wuliu.domain.WuliuVehicleRoute;
import com.ruoyi.wuliu.service.IWuliuVehicleRouteService;
import com.ruoyi.common.core.text.Convert;

/**
 * 车辆路线Service业务层处理
 * 
 * @author zheng
 * @date 2020-01-09
 */
@Service
public class WuliuVehicleRouteServiceImpl implements IWuliuVehicleRouteService 
{
    @Autowired
    private WuliuVehicleRouteMapper wuliuVehicleRouteMapper;

    /**
     * 查询车辆路线
     * 
     * @param id 车辆路线ID
     * @return 车辆路线
     */
    @Override
    public WuliuVehicleRoute selectWuliuVehicleRouteById(Long id)
    {
        return wuliuVehicleRouteMapper.selectWuliuVehicleRouteById(id);
    }

    /**
     * 查询车辆路线列表
     * 
     * @param wuliuVehicleRoute 车辆路线
     * @return 车辆路线
     */
    @Override
    public List<WuliuVehicleRoute> selectWuliuVehicleRouteList(WuliuVehicleRoute wuliuVehicleRoute)
    {
        return wuliuVehicleRouteMapper.selectWuliuVehicleRouteList(wuliuVehicleRoute);
    }

    /**
     * 新增车辆路线
     * 
     * @param wuliuVehicleRoute 车辆路线
     * @return 结果
     */
    @Override
    public int insertWuliuVehicleRoute(WuliuVehicleRoute wuliuVehicleRoute)
    {
        return wuliuVehicleRouteMapper.insertWuliuVehicleRoute(wuliuVehicleRoute);
    }

    /**
     * 修改车辆路线
     * 
     * @param wuliuVehicleRoute 车辆路线
     * @return 结果
     */
    @Override
    public int updateWuliuVehicleRoute(WuliuVehicleRoute wuliuVehicleRoute)
    {
        return wuliuVehicleRouteMapper.updateWuliuVehicleRoute(wuliuVehicleRoute);
    }

    /**
     * 删除车辆路线对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWuliuVehicleRouteByIds(String ids)
    {
        return wuliuVehicleRouteMapper.deleteWuliuVehicleRouteByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除车辆路线信息
     * 
     * @param id 车辆路线ID
     * @return 结果
     */
    @Override
    public int deleteWuliuVehicleRouteById(Long id)
    {
        return wuliuVehicleRouteMapper.deleteWuliuVehicleRouteById(id);
    }
}

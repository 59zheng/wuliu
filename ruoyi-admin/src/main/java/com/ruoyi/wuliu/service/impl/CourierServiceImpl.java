package com.ruoyi.wuliu.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.cundian.domain.VillageStatisticalVo;
import com.ruoyi.wuliu.domain.CourierVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wuliu.mapper.CourierMapper;
import com.ruoyi.wuliu.domain.Courier;
import com.ruoyi.wuliu.service.ICourierService;
import com.ruoyi.common.core.text.Convert;

/**
 * 快递单管理Service业务层处理
 * 
 * @author zheng
 * @date 2019-11-12
 */
@Service
public class CourierServiceImpl implements ICourierService 
{
    @Autowired
    private CourierMapper courierMapper;

    /**
     * 查询快递单管理
     * 
     * @param id 快递单管理ID
     * @return 快递单管理
     */
    @Override
    public Courier selectCourierById(Long id)
    {
        return courierMapper.selectCourierById(id);
    }

    /**
     * 查询快递单管理列表
     * 
     * @param courier 快递单管理
     * @return 快递单管理
     */
    @Override
    public List<Courier> selectCourierList(Courier courier)
    {
        return courierMapper.selectCourierList(courier);
    }

    /**
     * 新增快递单管理
     * 
     * @param courier 快递单管理
     * @return 结果
     */
    @Override
    public int insertCourier(Courier courier)
    {
        return courierMapper.insertCourier(courier);
    }

    /**
     * 修改快递单管理
     * 
     * @param courier 快递单管理
     * @return 结果
     */
    @Override
    public int updateCourier(Courier courier)
    {
        return courierMapper.updateCourier(courier);
    }

    /**
     * 删除快递单管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCourierByIds(String ids)
    {
        return courierMapper.deleteCourierByIds(Convert.toStrArray(ids));
    }

    @Override
    public String censusupAll() {
        return courierMapper.censusupAll();
    }

    @Override
    public String censusdownAll() {
        return courierMapper.censusdownAll();
    }

    @Override
    public String censusAll() {
        return courierMapper.censusAll();
    }

    @Override
    public List<CourierVo>  saveStatistical() {
        return courierMapper.saveStatistical();
    }

    @Override
    public String censusMonth() {
        return courierMapper.censusMonth();
    }

    @Override
    public String censusupMonth() {
        return courierMapper.censusupMonth();
    }

    @Override
    public List<VillageStatisticalVo> selectSend(String name) {
            return courierMapper.selectSend(name);

    }

    @Override
    public String censusdownMonth() {
        return courierMapper.censusdownMonth();
    }

    @Override
    public List<VillageStatisticalVo> selectSendTwo(String name, String drilldown) {
        return courierMapper.selectSendTwo(name,drilldown);
    }

    @Override
    public List<Courier> recentlyNum() {

        return courierMapper.recentlyNum();
    }

    /**
     * 删除快递单管理信息
     * 
     * @param id 快递单管理ID
     * @return 结果
     */
    @Override
    public int deleteCourierById(Long id)
    {
        return courierMapper.deleteCourierById(id);
    }
}

package com.ruoyi.wuliu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wuliu.mapper.WuliuDriverMapper;
import com.ruoyi.wuliu.domain.WuliuDriver;
import com.ruoyi.wuliu.service.IWuliuDriverService;
import com.ruoyi.common.core.text.Convert;

/**
 * 司机Service业务层处理
 * 
 * @author 正
 * @date 2019-12-05
 */
@Service
public class WuliuDriverServiceImpl implements IWuliuDriverService 
{
    @Autowired
    private WuliuDriverMapper wuliuDriverMapper;

    /**
     * 查询司机
     * 
     * @param id 司机ID
     * @return 司机
     */
    @Override
    public WuliuDriver selectWuliuDriverById(Long id)
    {
        return wuliuDriverMapper.selectWuliuDriverById(id);
    }

    /**
     * 查询司机列表
     * 
     * @param wuliuDriver 司机
     * @return 司机
     */
    @Override
    public List<WuliuDriver> selectWuliuDriverList(WuliuDriver wuliuDriver)
    {
        return wuliuDriverMapper.selectWuliuDriverList(wuliuDriver);
    }

    /**
     * 新增司机
     * 
     * @param wuliuDriver 司机
     * @return 结果
     */
    @Override
    public int insertWuliuDriver(WuliuDriver wuliuDriver)
    {
        return wuliuDriverMapper.insertWuliuDriver(wuliuDriver);
    }

    /**
     * 修改司机
     * 
     * @param wuliuDriver 司机
     * @return 结果
     */
    @Override
    public int updateWuliuDriver(WuliuDriver wuliuDriver)
    {
        return wuliuDriverMapper.updateWuliuDriver(wuliuDriver);
    }

    /**
     * 删除司机对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWuliuDriverByIds(String ids)
    {
        return wuliuDriverMapper.deleteWuliuDriverByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除司机信息
     * 
     * @param id 司机ID
     * @return 结果
     */
    @Override
    public int deleteWuliuDriverById(Long id)
    {
        return wuliuDriverMapper.deleteWuliuDriverById(id);
    }
}

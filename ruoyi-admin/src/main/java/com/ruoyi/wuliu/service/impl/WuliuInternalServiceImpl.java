package com.ruoyi.wuliu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wuliu.mapper.WuliuInternalMapper;
import com.ruoyi.wuliu.domain.WuliuInternal;
import com.ruoyi.wuliu.service.IWuliuInternalService;
import com.ruoyi.common.core.text.Convert;

/**
 * 内部订单（上下行）Service业务层处理
 * 
 * @author zheng
 * @date 2019-12-05
 */
@Service
public class WuliuInternalServiceImpl implements IWuliuInternalService 
{
    @Autowired
    private WuliuInternalMapper wuliuInternalMapper;

    /**
     * 查询内部订单（上下行）
     * 
     * @param id 内部订单（上下行）ID
     * @return 内部订单（上下行）
     */
    @Override
    public WuliuInternal selectWuliuInternalById(Long id)
    {
        return wuliuInternalMapper.selectWuliuInternalById(id);
    }

    /**
     * 查询内部订单（上下行）列表
     * 
     * @param wuliuInternal 内部订单（上下行）
     * @return 内部订单（上下行）
     */
    @Override
    public List<WuliuInternal> selectWuliuInternalList(WuliuInternal wuliuInternal)
    {
        return wuliuInternalMapper.selectWuliuInternalList(wuliuInternal);
    }

    /**
     * 新增内部订单（上下行）
     * 
     * @param wuliuInternal 内部订单（上下行）
     * @return 结果
     */
    @Override
    public int insertWuliuInternal(WuliuInternal wuliuInternal)
    {
        return wuliuInternalMapper.insertWuliuInternal(wuliuInternal);
    }

    /**
     * 修改内部订单（上下行）
     * 
     * @param wuliuInternal 内部订单（上下行）
     * @return 结果
     */
    @Override
    public int updateWuliuInternal(WuliuInternal wuliuInternal)
    {
        return wuliuInternalMapper.updateWuliuInternal(wuliuInternal);
    }

    /**
     * 删除内部订单（上下行）对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWuliuInternalByIds(String ids)
    {
        return wuliuInternalMapper.deleteWuliuInternalByIds(Convert.toStrArray(ids));
    }

    @Override
    public WuliuInternal selectByInternalId(String wuliuInternalId) {
        return wuliuInternalMapper.selectByInternalId(wuliuInternalId);
    }

    /**
     * 删除内部订单（上下行）信息
     * 
     * @param id 内部订单（上下行）ID
     * @return 结果
     */
    @Override
    public int deleteWuliuInternalById(Long id)
    {
        return wuliuInternalMapper.deleteWuliuInternalById(id);
    }
}

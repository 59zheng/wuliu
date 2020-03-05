package com.ruoyi.wuliu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wuliu.mapper.WuliuDelegateMapper;
import com.ruoyi.wuliu.domain.WuliuDelegate;
import com.ruoyi.wuliu.service.IWuliuDelegateService;
import com.ruoyi.common.core.text.Convert;

/**
 * 委派单关联调度单Service业务层处理
 * 
 * @author zheng
 * @date 2019-12-13
 */
@Service
public class WuliuDelegateServiceImpl implements IWuliuDelegateService 
{
    @Autowired
    private WuliuDelegateMapper wuliuDelegateMapper;

    /**
     * 查询委派单关联调度单
     * 
     * @param id 委派单关联调度单ID
     * @return 委派单关联调度单
     */
    @Override
    public WuliuDelegate selectWuliuDelegateById(Long id)
    {
        return wuliuDelegateMapper.selectWuliuDelegateById(id);
    }

    /**
     * 查询委派单关联调度单列表
     * 
     * @param wuliuDelegate 委派单关联调度单
     * @return 委派单关联调度单
     */
    @Override
    public List<WuliuDelegate> selectWuliuDelegateList(WuliuDelegate wuliuDelegate)
    {
        return wuliuDelegateMapper.selectWuliuDelegateList(wuliuDelegate);
    }

    /**
     * 新增委派单关联调度单
     * 
     * @param wuliuDelegate 委派单关联调度单
     * @return 结果
     */
    @Override
    public int insertWuliuDelegate(WuliuDelegate wuliuDelegate)
    {
        return wuliuDelegateMapper.insertWuliuDelegate(wuliuDelegate);
    }

    /**
     * 修改委派单关联调度单
     * 
     * @param wuliuDelegate 委派单关联调度单
     * @return 结果
     */
    @Override
    public int updateWuliuDelegate(WuliuDelegate wuliuDelegate)
    {
        return wuliuDelegateMapper.updateWuliuDelegate(wuliuDelegate);
    }

    /**
     * 删除委派单关联调度单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWuliuDelegateByIds(String ids)
    {
        return wuliuDelegateMapper.deleteWuliuDelegateByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除委派单关联调度单信息
     * 
     * @param id 委派单关联调度单ID
     * @return 结果
     */
    @Override
    public int deleteWuliuDelegateById(Long id)
    {
        return wuliuDelegateMapper.deleteWuliuDelegateById(id);
    }
}

package com.ruoyi.wuliu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wuliu.mapper.WuliuStatisticalMapper;
import com.ruoyi.wuliu.domain.WuliuStatistical;
import com.ruoyi.wuliu.service.IWuliuStatisticalService;
import com.ruoyi.common.core.text.Convert;

/**
 * 统计服务站上下行Service业务层处理
 * 
 * @author zheng
 * @date 2019-12-05
 */
@Service
public class WuliuStatisticalServiceImpl implements IWuliuStatisticalService 
{
    @Autowired
    private WuliuStatisticalMapper wuliuStatisticalMapper;

    /**
     * 查询统计服务站上下行
     * 
     * @param id 统计服务站上下行ID
     * @return 统计服务站上下行
     */
    @Override
    public WuliuStatistical selectWuliuStatisticalById(Long id)
    {
        return wuliuStatisticalMapper.selectWuliuStatisticalById(id);
    }

    /**
     * 查询统计服务站上下行列表
     * 
     * @param wuliuStatistical 统计服务站上下行
     * @return 统计服务站上下行
     */
    @Override
    public List<WuliuStatistical> selectWuliuStatisticalList(WuliuStatistical wuliuStatistical)
    {
        return wuliuStatisticalMapper.selectWuliuStatisticalList(wuliuStatistical);
    }

    /**
     * 新增统计服务站上下行
     * 
     * @param wuliuStatistical 统计服务站上下行
     * @return 结果
     */
    @Override
    public int insertWuliuStatistical(WuliuStatistical wuliuStatistical)
    {
        return wuliuStatisticalMapper.insertWuliuStatistical(wuliuStatistical);
    }

    /**
     * 修改统计服务站上下行
     * 
     * @param wuliuStatistical 统计服务站上下行
     * @return 结果
     */
    @Override
    public int updateWuliuStatistical(WuliuStatistical wuliuStatistical)
    {
        return wuliuStatisticalMapper.updateWuliuStatistical(wuliuStatistical);
    }

    /**
     * 删除统计服务站上下行对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWuliuStatisticalByIds(String ids)
    {
        return wuliuStatisticalMapper.deleteWuliuStatisticalByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除统计服务站上下行信息
     * 
     * @param id 统计服务站上下行ID
     * @return 结果
     */
    @Override
    public int deleteWuliuStatisticalById(Long id)
    {
        return wuliuStatisticalMapper.deleteWuliuStatisticalById(id);
    }
}

package com.ruoyi.wuliu.service;

import com.ruoyi.wuliu.domain.WuliuStatistical;
import java.util.List;

/**
 * 统计服务站上下行Service接口
 * 
 * @author zheng
 * @date 2019-12-05
 */
public interface IWuliuStatisticalService 
{
    /**
     * 查询统计服务站上下行
     * 
     * @param id 统计服务站上下行ID
     * @return 统计服务站上下行
     */
    public WuliuStatistical selectWuliuStatisticalById(Long id);

    /**
     * 查询统计服务站上下行列表
     * 
     * @param wuliuStatistical 统计服务站上下行
     * @return 统计服务站上下行集合
     */
    public List<WuliuStatistical> selectWuliuStatisticalList(WuliuStatistical wuliuStatistical);

    /**
     * 新增统计服务站上下行
     * 
     * @param wuliuStatistical 统计服务站上下行
     * @return 结果
     */
    public int insertWuliuStatistical(WuliuStatistical wuliuStatistical);

    /**
     * 修改统计服务站上下行
     * 
     * @param wuliuStatistical 统计服务站上下行
     * @return 结果
     */
    public int updateWuliuStatistical(WuliuStatistical wuliuStatistical);

    /**
     * 批量删除统计服务站上下行
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWuliuStatisticalByIds(String ids);

    /**
     * 删除统计服务站上下行信息
     * 
     * @param id 统计服务站上下行ID
     * @return 结果
     */
    public int deleteWuliuStatisticalById(Long id);
}

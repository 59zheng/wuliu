package com.ruoyi.wuliu.mapper;

import com.ruoyi.wuliu.domain.WuliuScheduling;
import java.util.List;

/**
 * 调度单号关联任务单和委派单Mapper接口
 * 
 * @author zheng
 * @date 2019-12-13
 */
public interface WuliuSchedulingMapper 
{
    /**
     * 查询调度单号关联任务单和委派单
     * 
     * @param id 调度单号关联任务单和委派单ID
     * @return 调度单号关联任务单和委派单
     */
    public WuliuScheduling selectWuliuSchedulingById(Long id);

    /**
     * 查询调度单号关联任务单和委派单列表
     * 
     * @param wuliuScheduling 调度单号关联任务单和委派单
     * @return 调度单号关联任务单和委派单集合
     */
    public List<WuliuScheduling> selectWuliuSchedulingList(WuliuScheduling wuliuScheduling);

    /**
     * 新增调度单号关联任务单和委派单
     * 
     * @param wuliuScheduling 调度单号关联任务单和委派单
     * @return 结果
     */
    public int insertWuliuScheduling(WuliuScheduling wuliuScheduling);

    /**
     * 修改调度单号关联任务单和委派单
     * 
     * @param wuliuScheduling 调度单号关联任务单和委派单
     * @return 结果
     */
    public int updateWuliuScheduling(WuliuScheduling wuliuScheduling);

    /**
     * 删除调度单号关联任务单和委派单
     * 
     * @param id 调度单号关联任务单和委派单ID
     * @return 结果
     */
    public int deleteWuliuSchedulingById(Long id);

    /**
     * 批量删除调度单号关联任务单和委派单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWuliuSchedulingByIds(String[] ids);
}

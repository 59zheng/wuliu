package com.ruoyi.wuliu.mapper;

import com.ruoyi.wuliu.domain.WuliuTask;
import java.util.List;

/**
 * 任务单关联路径和车辆和内部运单Mapper接口
 * 
 * @author zheng
 * @date 2019-12-23
 */
public interface WuliuTaskMapper 
{
    /**
     * 查询任务单关联路径和车辆和内部运单
     * 
     * @param id 任务单关联路径和车辆和内部运单ID
     * @return 任务单关联路径和车辆和内部运单
     */
    public WuliuTask selectWuliuTaskById(Long id);

    /**
     * 查询任务单关联路径和车辆和内部运单列表
     * 
     * @param wuliuTask 任务单关联路径和车辆和内部运单
     * @return 任务单关联路径和车辆和内部运单集合
     */
    public List<WuliuTask> selectWuliuTaskList(WuliuTask wuliuTask);

    /**
     * 新增任务单关联路径和车辆和内部运单
     * 
     * @param wuliuTask 任务单关联路径和车辆和内部运单
     * @return 结果
     */
    public int insertWuliuTask(WuliuTask wuliuTask);

    /**
     * 修改任务单关联路径和车辆和内部运单
     * 
     * @param wuliuTask 任务单关联路径和车辆和内部运单
     * @return 结果
     */
    public int updateWuliuTask(WuliuTask wuliuTask);

    /**
     * 删除任务单关联路径和车辆和内部运单
     * 
     * @param id 任务单关联路径和车辆和内部运单ID
     * @return 结果
     */
    public int deleteWuliuTaskById(Long id);

    /**
     * 批量删除任务单关联路径和车辆和内部运单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWuliuTaskByIds(String[] ids);

    WuliuTask selectByTeskId(String teskId);
}

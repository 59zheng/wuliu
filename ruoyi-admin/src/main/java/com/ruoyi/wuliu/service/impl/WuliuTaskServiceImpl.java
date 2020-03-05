package com.ruoyi.wuliu.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wuliu.mapper.WuliuTaskMapper;
import com.ruoyi.wuliu.domain.WuliuTask;
import com.ruoyi.wuliu.service.IWuliuTaskService;
import com.ruoyi.common.core.text.Convert;

/**
 * 任务单关联路径和车辆和内部运单Service业务层处理
 * 
 * @author zheng
 * @date 2019-12-23
 */
@Service
public class WuliuTaskServiceImpl implements IWuliuTaskService 
{
    @Autowired
    private WuliuTaskMapper wuliuTaskMapper;

    /**
     * 查询任务单关联路径和车辆和内部运单
     * 
     * @param id 任务单关联路径和车辆和内部运单ID
     * @return 任务单关联路径和车辆和内部运单
     */
    @Override
    public WuliuTask selectWuliuTaskById(Long id)
    {
        return wuliuTaskMapper.selectWuliuTaskById(id);
    }

    /**
     * 查询任务单关联路径和车辆和内部运单列表
     * 
     * @param wuliuTask 任务单关联路径和车辆和内部运单
     * @return 任务单关联路径和车辆和内部运单
     */
    @Override
    public List<WuliuTask> selectWuliuTaskList(WuliuTask wuliuTask)
    {
        return wuliuTaskMapper.selectWuliuTaskList(wuliuTask);
    }

    /**
     * 新增任务单关联路径和车辆和内部运单
     * 
     * @param wuliuTask 任务单关联路径和车辆和内部运单
     * @return 结果
     */
    @Override
    public int insertWuliuTask(WuliuTask wuliuTask)
    {
        wuliuTask.setCreateTime(DateUtils.getNowDate());
        return wuliuTaskMapper.insertWuliuTask(wuliuTask);
    }

    /**
     * 修改任务单关联路径和车辆和内部运单
     * 
     * @param wuliuTask 任务单关联路径和车辆和内部运单
     * @return 结果
     */
    @Override
    public int updateWuliuTask(WuliuTask wuliuTask)
    {
        wuliuTask.setUpdateTime(DateUtils.getNowDate());
        return wuliuTaskMapper.updateWuliuTask(wuliuTask);
    }

    /**
     * 删除任务单关联路径和车辆和内部运单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWuliuTaskByIds(String ids)
    {
        return wuliuTaskMapper.deleteWuliuTaskByIds(Convert.toStrArray(ids));
    }

    @Override
    public WuliuTask selectByTeskId(String teskId) {
        return wuliuTaskMapper.selectByTeskId(teskId);
    }

    /**
     * 删除任务单关联路径和车辆和内部运单信息
     * 
     * @param id 任务单关联路径和车辆和内部运单ID
     * @return 结果
     */
    @Override
    public int deleteWuliuTaskById(Long id)
    {
        return wuliuTaskMapper.deleteWuliuTaskById(id);
    }
}


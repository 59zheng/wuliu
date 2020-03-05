package com.ruoyi.wuliu.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wuliu.mapper.WuliuSchedulingMapper;
import com.ruoyi.wuliu.domain.WuliuScheduling;
import com.ruoyi.wuliu.service.IWuliuSchedulingService;
import com.ruoyi.common.core.text.Convert;

/**
 * 调度单号关联任务单和委派单Service业务层处理
 * 
 * @author zheng
 * @date 2019-12-13
 */
@Service
public class WuliuSchedulingServiceImpl implements IWuliuSchedulingService 
{
    @Autowired
    private WuliuSchedulingMapper wuliuSchedulingMapper;

    /**
     * 查询调度单号关联任务单和委派单
     * 
     * @param id 调度单号关联任务单和委派单ID
     * @return 调度单号关联任务单和委派单
     */
    @Override
    public WuliuScheduling selectWuliuSchedulingById(Long id)
    {
        return wuliuSchedulingMapper.selectWuliuSchedulingById(id);
    }

    /**
     * 查询调度单号关联任务单和委派单列表
     * 
     * @param wuliuScheduling 调度单号关联任务单和委派单
     * @return 调度单号关联任务单和委派单
     */
    @Override
    public List<WuliuScheduling> selectWuliuSchedulingList(WuliuScheduling wuliuScheduling)
    {
        return wuliuSchedulingMapper.selectWuliuSchedulingList(wuliuScheduling);
    }

    /**
     * 新增调度单号关联任务单和委派单
     * 
     * @param wuliuScheduling 调度单号关联任务单和委派单
     * @return 结果
     */
    @Override
    public int insertWuliuScheduling(WuliuScheduling wuliuScheduling)
    {
        wuliuScheduling.setCreateTime(DateUtils.getNowDate());
        return wuliuSchedulingMapper.insertWuliuScheduling(wuliuScheduling);
    }

    /**
     * 修改调度单号关联任务单和委派单
     * 
     * @param wuliuScheduling 调度单号关联任务单和委派单
     * @return 结果
     */
    @Override
    public int updateWuliuScheduling(WuliuScheduling wuliuScheduling)
    {
        wuliuScheduling.setUpdateTime(DateUtils.getNowDate());
        return wuliuSchedulingMapper.updateWuliuScheduling(wuliuScheduling);
    }

    /**
     * 删除调度单号关联任务单和委派单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWuliuSchedulingByIds(String ids)
    {
        return wuliuSchedulingMapper.deleteWuliuSchedulingByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除调度单号关联任务单和委派单信息
     * 
     * @param id 调度单号关联任务单和委派单ID
     * @return 结果
     */
    @Override
    public int deleteWuliuSchedulingById(Long id)
    {
        return wuliuSchedulingMapper.deleteWuliuSchedulingById(id);
    }
}

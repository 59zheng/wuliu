package com.ruoyi.wuliu.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wuliu.mapper.WuliuApplyMapper;
import com.ruoyi.wuliu.domain.WuliuApply;
import com.ruoyi.wuliu.service.IWuliuApplyService;
import com.ruoyi.common.core.text.Convert;

/**
 * 申请Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
@Service
public class WuliuApplyServiceImpl implements IWuliuApplyService 
{
    @Autowired
    private WuliuApplyMapper wuliuApplyMapper;

    /**
     * 查询申请
     * 
     * @param id 申请ID
     * @return 申请
     */
    @Override
    public WuliuApply selectWuliuApplyById(Long id)
    {
        return wuliuApplyMapper.selectWuliuApplyById(id);
    }

    /**
     * 查询申请列表
     * 
     * @param wuliuApply 申请
     * @return 申请
     */
    @Override
    public List<WuliuApply> selectWuliuApplyList(WuliuApply wuliuApply)
    {
        return wuliuApplyMapper.selectWuliuApplyList(wuliuApply);
    }

    /**
     * 新增申请
     * 
     * @param wuliuApply 申请
     * @return 结果
     */
    @Override
    public int insertWuliuApply(WuliuApply wuliuApply)
    {
        wuliuApply.setCreateTime(DateUtils.getNowDate());
        return wuliuApplyMapper.insertWuliuApply(wuliuApply);
    }

    /**
     * 修改申请
     * 
     * @param wuliuApply 申请
     * @return 结果
     */
    @Override
    public int updateWuliuApply(WuliuApply wuliuApply)
    {
        wuliuApply.setUpdateTime(DateUtils.getNowDate());
        return wuliuApplyMapper.updateWuliuApply(wuliuApply);
    }

    /**
     * 删除申请对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWuliuApplyByIds(String ids)
    {
        return wuliuApplyMapper.deleteWuliuApplyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除申请信息
     * 
     * @param id 申请ID
     * @return 结果
     */
    @Override
    public int deleteWuliuApplyById(Long id)
    {
        return wuliuApplyMapper.deleteWuliuApplyById(id);
    }
}

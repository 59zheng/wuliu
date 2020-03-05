package com.ruoyi.wuliu.mapper;

import com.ruoyi.wuliu.domain.WuliuApply;
import java.util.List;

/**
 * 申请Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public interface WuliuApplyMapper 
{
    /**
     * 查询申请
     * 
     * @param id 申请ID
     * @return 申请
     */
    public WuliuApply selectWuliuApplyById(Long id);

    /**
     * 查询申请列表
     * 
     * @param wuliuApply 申请
     * @return 申请集合
     */
    public List<WuliuApply> selectWuliuApplyList(WuliuApply wuliuApply);

    /**
     * 新增申请
     * 
     * @param wuliuApply 申请
     * @return 结果
     */
    public int insertWuliuApply(WuliuApply wuliuApply);

    /**
     * 修改申请
     * 
     * @param wuliuApply 申请
     * @return 结果
     */
    public int updateWuliuApply(WuliuApply wuliuApply);

    /**
     * 删除申请
     * 
     * @param id 申请ID
     * @return 结果
     */
    public int deleteWuliuApplyById(Long id);

    /**
     * 批量删除申请
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWuliuApplyByIds(String[] ids);
}

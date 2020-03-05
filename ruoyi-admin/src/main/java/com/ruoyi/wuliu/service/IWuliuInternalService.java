package com.ruoyi.wuliu.service;

import com.ruoyi.wuliu.domain.WuliuInternal;
import java.util.List;

/**
 * 内部订单（上下行）Service接口
 * 
 * @author zheng
 * @date 2019-12-05
 */
public interface IWuliuInternalService 
{
    /**
     * 查询内部订单（上下行）
     * 
     * @param id 内部订单（上下行）ID
     * @return 内部订单（上下行）
     */
    public WuliuInternal selectWuliuInternalById(Long id);

    /**
     * 查询内部订单（上下行）列表
     * 
     * @param wuliuInternal 内部订单（上下行）
     * @return 内部订单（上下行）集合
     */
    public List<WuliuInternal> selectWuliuInternalList(WuliuInternal wuliuInternal);

    /**
     * 新增内部订单（上下行）
     * 
     * @param wuliuInternal 内部订单（上下行）
     * @return 结果
     */
    public int insertWuliuInternal(WuliuInternal wuliuInternal);

    /**
     * 修改内部订单（上下行）
     * 
     * @param wuliuInternal 内部订单（上下行）
     * @return 结果
     */
    public int updateWuliuInternal(WuliuInternal wuliuInternal);

    /**
     * 批量删除内部订单（上下行）
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWuliuInternalByIds(String ids);

    /**
     * 删除内部订单（上下行）信息
     * 
     * @param id 内部订单（上下行）ID
     * @return 结果
     */
    public int deleteWuliuInternalById(Long id);

    WuliuInternal selectByInternalId(String wuliuInternalId);
}

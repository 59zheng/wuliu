package com.ruoyi.wuliu.service;

import com.ruoyi.wuliu.domain.WuliuDriver;
import java.util.List;

/**
 * 司机Service接口
 * 
 * @author 正
 * @date 2019-12-05
 */
public interface IWuliuDriverService 
{
    /**
     * 查询司机
     * 
     * @param id 司机ID
     * @return 司机
     */
    public WuliuDriver selectWuliuDriverById(Long id);

    /**
     * 查询司机列表
     * 
     * @param wuliuDriver 司机
     * @return 司机集合
     */
    public List<WuliuDriver> selectWuliuDriverList(WuliuDriver wuliuDriver);

    /**
     * 新增司机
     * 
     * @param wuliuDriver 司机
     * @return 结果
     */
    public int insertWuliuDriver(WuliuDriver wuliuDriver);

    /**
     * 修改司机
     * 
     * @param wuliuDriver 司机
     * @return 结果
     */
    public int updateWuliuDriver(WuliuDriver wuliuDriver);

    /**
     * 批量删除司机
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWuliuDriverByIds(String ids);

    /**
     * 删除司机信息
     * 
     * @param id 司机ID
     * @return 结果
     */
    public int deleteWuliuDriverById(Long id);
}

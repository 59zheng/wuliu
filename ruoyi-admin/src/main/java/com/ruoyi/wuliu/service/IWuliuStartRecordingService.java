package com.ruoyi.wuliu.service;

import com.ruoyi.wuliu.domain.WuliuStartRecording;
import java.util.List;

/**
 * 发车记录Service接口
 * 
 * @author zheng
 * @date 2019-12-23
 */
public interface IWuliuStartRecordingService 
{
    /**
     * 查询发车记录
     * 
     * @param id 发车记录ID
     * @return 发车记录
     */
    public WuliuStartRecording selectWuliuStartRecordingById(Long id);

    /**
     * 查询发车记录列表
     * 
     * @param wuliuStartRecording 发车记录
     * @return 发车记录集合
     */
    public List<WuliuStartRecording> selectWuliuStartRecordingList(WuliuStartRecording wuliuStartRecording);

    /**
     * 新增发车记录
     * 
     * @param wuliuStartRecording 发车记录
     * @return 结果
     */
    public int insertWuliuStartRecording(WuliuStartRecording wuliuStartRecording);

    /**
     * 修改发车记录
     * 
     * @param wuliuStartRecording 发车记录
     * @return 结果
     */
    public int updateWuliuStartRecording(WuliuStartRecording wuliuStartRecording);

    /**
     * 批量删除发车记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWuliuStartRecordingByIds(String ids);

    /**
     * 删除发车记录信息
     * 
     * @param id 发车记录ID
     * @return 结果
     */
    public int deleteWuliuStartRecordingById(Long id);
}

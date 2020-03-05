package com.ruoyi.wuliu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wuliu.mapper.WuliuStartRecordingMapper;
import com.ruoyi.wuliu.domain.WuliuStartRecording;
import com.ruoyi.wuliu.service.IWuliuStartRecordingService;
import com.ruoyi.common.core.text.Convert;

/**
 * 发车记录Service业务层处理
 * 
 * @author zheng
 * @date 2019-12-23
 */
@Service
public class WuliuStartRecordingServiceImpl implements IWuliuStartRecordingService 
{
    @Autowired
    private WuliuStartRecordingMapper wuliuStartRecordingMapper;

    /**
     * 查询发车记录
     * 
     * @param id 发车记录ID
     * @return 发车记录
     */
    @Override
    public WuliuStartRecording selectWuliuStartRecordingById(Long id)
    {
        return wuliuStartRecordingMapper.selectWuliuStartRecordingById(id);
    }

    /**
     * 查询发车记录列表
     * 
     * @param wuliuStartRecording 发车记录
     * @return 发车记录
     */
    @Override
    public List<WuliuStartRecording> selectWuliuStartRecordingList(WuliuStartRecording wuliuStartRecording)
    {
        return wuliuStartRecordingMapper.selectWuliuStartRecordingList(wuliuStartRecording);
    }

    /**
     * 新增发车记录
     * 
     * @param wuliuStartRecording 发车记录
     * @return 结果
     */
    @Override
    public int insertWuliuStartRecording(WuliuStartRecording wuliuStartRecording)
    {
        return wuliuStartRecordingMapper.insertWuliuStartRecording(wuliuStartRecording);
    }


    /**
     * 修改发车记录
     * 
     * @param wuliuStartRecording 发车记录
     * @return 结果
     */
    @Override
    public int updateWuliuStartRecording(WuliuStartRecording wuliuStartRecording)
    {
        return wuliuStartRecordingMapper.updateWuliuStartRecording(wuliuStartRecording);
    }

    /**
     * 删除发车记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWuliuStartRecordingByIds(String ids)
    {
        return wuliuStartRecordingMapper.deleteWuliuStartRecordingByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除发车记录信息
     * 
     * @param id 发车记录ID
     * @return 结果
     */
    @Override
    public int deleteWuliuStartRecordingById(Long id)
    {
        return wuliuStartRecordingMapper.deleteWuliuStartRecordingById(id);
    }
}

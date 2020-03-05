package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DbAreaMapper;
import com.ruoyi.system.domain.DbArea;
import com.ruoyi.system.service.IDbAreaService;
import com.ruoyi.common.core.text.Convert;

/**
 * 区县信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
@Service
public class DbAreaServiceImpl implements IDbAreaService 
{
    @Autowired
    private DbAreaMapper dbAreaMapper;

    /**
     * 查询区县信息
     * 
     * @param id 区县信息ID
     * @return 区县信息
     */
    @Override
    public DbArea selectDbAreaById(Long id)
    {
        return dbAreaMapper.selectDbAreaById(id);
    }

    /**
     * 查询区县信息列表
     * 
     * @param dbArea 区县信息
     * @return 区县信息
     */
    @Override
    public List<DbArea> selectDbAreaList(DbArea dbArea)
    {
        return dbAreaMapper.selectDbAreaList(dbArea);
    }

    /**
     * 新增区县信息
     * 
     * @param dbArea 区县信息
     * @return 结果
     */
    @Override
    public int insertDbArea(DbArea dbArea)
    {
        return dbAreaMapper.insertDbArea(dbArea);
    }

    /**
     * 修改区县信息
     * 
     * @param dbArea 区县信息
     * @return 结果
     */
    @Override
    public int updateDbArea(DbArea dbArea)
    {
        return dbAreaMapper.updateDbArea(dbArea);
    }

    /**
     * 删除区县信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDbAreaByIds(String ids)
    {
        return dbAreaMapper.deleteDbAreaByIds(Convert.toStrArray(ids));
    }

    @Override
    public List<DbArea> selectcityid(String cityid) {
        return dbAreaMapper.selectcityid(cityid);
    }

    /**
     * 删除区县信息信息
     * 
     * @param id 区县信息ID
     * @return 结果
     */
    @Override
    public int deleteDbAreaById(Long id)
    {
        return dbAreaMapper.deleteDbAreaById(id);
    }
}

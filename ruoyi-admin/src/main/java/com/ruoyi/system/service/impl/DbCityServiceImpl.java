package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DbCityMapper;
import com.ruoyi.system.domain.DbCity;
import com.ruoyi.system.service.IDbCityService;
import com.ruoyi.common.core.text.Convert;

/**
 * 城市信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
@Service
public class DbCityServiceImpl implements IDbCityService 
{
    @Autowired
    private DbCityMapper dbCityMapper;

    /**
     * 查询城市信息
     * 
     * @param id 城市信息ID
     * @return 城市信息
     */
    @Override
    public DbCity selectDbCityById(Long id)
    {
        return dbCityMapper.selectDbCityById(id);
    }

    /**
     * 查询城市信息列表
     * 
     * @param dbCity 城市信息
     * @return 城市信息
     */
    @Override
    public List<DbCity> selectDbCityList(DbCity dbCity)
    {
        return dbCityMapper.selectDbCityList(dbCity);
    }

    /**
     * 新增城市信息
     * 
     * @param dbCity 城市信息
     * @return 结果
     */
    @Override
    public int insertDbCity(DbCity dbCity)
    {
        return dbCityMapper.insertDbCity(dbCity);
    }

    /**
     * 修改城市信息
     * 
     * @param dbCity 城市信息
     * @return 结果
     */
    @Override
    public int updateDbCity(DbCity dbCity)
    {
        return dbCityMapper.updateDbCity(dbCity);
    }

    /**
     * 删除城市信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDbCityByIds(String ids)
    {
        return dbCityMapper.deleteDbCityByIds(Convert.toStrArray(ids));
    }

    @Override
    public List<DbCity> selectprovinceid(int dbProvinceid) {
        String s = dbProvinceid + "";
        return dbCityMapper.selectprovinceid(s);
    }

    /**
     * 删除城市信息信息
     * 
     * @param id 城市信息ID
     * @return 结果
     */
    @Override
    public int deleteDbCityById(Long id)
    {
        return dbCityMapper.deleteDbCityById(id);
    }
}

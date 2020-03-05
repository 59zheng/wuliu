package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.DbCity;
import java.util.List;

/**
 * 城市信息Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public interface DbCityMapper 
{
    /**
     * 查询城市信息
     * 
     * @param id 城市信息ID
     * @return 城市信息
     */
    public DbCity selectDbCityById(Long id);

    /**
     * 查询城市信息列表
     * 
     * @param dbCity 城市信息
     * @return 城市信息集合
     */
    public List<DbCity> selectDbCityList(DbCity dbCity);

    /**
     * 新增城市信息
     * 
     * @param dbCity 城市信息
     * @return 结果
     */
    public int insertDbCity(DbCity dbCity);

    /**
     * 修改城市信息
     * 
     * @param dbCity 城市信息
     * @return 结果
     */
    public int updateDbCity(DbCity dbCity);

    /**
     * 删除城市信息
     * 
     * @param id 城市信息ID
     * @return 结果
     */
    public int deleteDbCityById(Long id);

    /**
     * 批量删除城市信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDbCityByIds(String[] ids);

    List<DbCity> selectprovinceid(String dbProvinceid);
}

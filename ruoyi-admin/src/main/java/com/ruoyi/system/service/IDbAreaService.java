package com.ruoyi.system.service;

import com.ruoyi.system.domain.DbArea;
import java.util.List;

/**
 * 区县信息Service接口
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public interface IDbAreaService 
{
    /**
     * 查询区县信息
     * 
     * @param id 区县信息ID
     * @return 区县信息
     */
    public DbArea selectDbAreaById(Long id);

    /**
     * 查询区县信息列表
     * 
     * @param dbArea 区县信息
     * @return 区县信息集合
     */
    public List<DbArea> selectDbAreaList(DbArea dbArea);

    /**
     * 新增区县信息
     * 
     * @param dbArea 区县信息
     * @return 结果
     */
    public int insertDbArea(DbArea dbArea);

    /**
     * 修改区县信息
     * 
     * @param dbArea 区县信息
     * @return 结果
     */
    public int updateDbArea(DbArea dbArea);

    /**
     * 批量删除区县信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDbAreaByIds(String ids);

    /**
     * 删除区县信息信息
     * 
     * @param id 区县信息ID
     * @return 结果
     */
    public int deleteDbAreaById(Long id);

    List<DbArea> selectcityid(String cityid);
}

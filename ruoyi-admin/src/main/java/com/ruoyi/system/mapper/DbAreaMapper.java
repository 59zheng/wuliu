package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.DbArea;
import java.util.List;

/**
 * 区县信息Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public interface DbAreaMapper 
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
     * 删除区县信息
     * 
     * @param id 区县信息ID
     * @return 结果
     */
    public int deleteDbAreaById(Long id);

    /**
     * 批量删除区县信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDbAreaByIds(String[] ids);

    List<DbArea> selectcityid(String cityid);
}

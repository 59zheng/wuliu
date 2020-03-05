package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.DbProvince;
import java.util.List;

/**
 * 省市县三级下拉Mapper接口
 * 
 * @author zheng
 * @date 2019-12-11
 */
public interface DbProvinceMapper 
{
    /**
     * 查询省市县三级下拉
     * 
     * @param id 省市县三级下拉ID
     * @return 省市县三级下拉
     */
    public DbProvince selectDbProvinceById(Long id);

    /**
     * 查询省市县三级下拉列表
     * 
     * @param dbProvince 省市县三级下拉
     * @return 省市县三级下拉集合
     */
    public List<DbProvince> selectDbProvinceList(DbProvince dbProvince);

    /**
     * 新增省市县三级下拉
     * 
     * @param dbProvince 省市县三级下拉
     * @return 结果
     */
    public int insertDbProvince(DbProvince dbProvince);

    /**
     * 修改省市县三级下拉
     * 
     * @param dbProvince 省市县三级下拉
     * @return 结果
     */
    public int updateDbProvince(DbProvince dbProvince);

    /**
     * 删除省市县三级下拉
     * 
     * @param id 省市县三级下拉ID
     * @return 结果
     */
    public int deleteDbProvinceById(Long id);

    /**
     * 批量删除省市县三级下拉
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDbProvinceByIds(String[] ids);
}

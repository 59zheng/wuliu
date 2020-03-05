package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DbProvinceMapper;
import com.ruoyi.system.domain.DbProvince;
import com.ruoyi.system.service.IDbProvinceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 省市县三级下拉Service业务层处理
 * 
 * @author zheng
 * @date 2019-12-11
 */
@Service
public class DbProvinceServiceImpl implements IDbProvinceService 
{
    @Autowired
    private DbProvinceMapper dbProvinceMapper;

    /**
     * 查询省市县三级下拉
     * 
     * @param id 省市县三级下拉ID
     * @return 省市县三级下拉
     */
    @Override
    public DbProvince selectDbProvinceById(Long id)
    {
        return dbProvinceMapper.selectDbProvinceById(id);
    }

    /**
     * 查询省市县三级下拉列表
     * 
     * @param dbProvince 省市县三级下拉
     * @return 省市县三级下拉
     */
    @Override
    public List<DbProvince> selectDbProvinceList(DbProvince dbProvince)
    {
        return dbProvinceMapper.selectDbProvinceList(dbProvince);
    }

    /**
     * 新增省市县三级下拉
     * 
     * @param dbProvince 省市县三级下拉
     * @return 结果
     */
    @Override
    public int insertDbProvince(DbProvince dbProvince)
    {
        return dbProvinceMapper.insertDbProvince(dbProvince);
    }

    /**
     * 修改省市县三级下拉
     * 
     * @param dbProvince 省市县三级下拉
     * @return 结果
     */
    @Override
    public int updateDbProvince(DbProvince dbProvince)
    {
        return dbProvinceMapper.updateDbProvince(dbProvince);
    }

    /**
     * 删除省市县三级下拉对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDbProvinceByIds(String ids)
    {
        return dbProvinceMapper.deleteDbProvinceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除省市县三级下拉信息
     * 
     * @param id 省市县三级下拉ID
     * @return 结果
     */
    @Override
    public int deleteDbProvinceById(Long id)
    {
        return dbProvinceMapper.deleteDbProvinceById(id);
    }
}

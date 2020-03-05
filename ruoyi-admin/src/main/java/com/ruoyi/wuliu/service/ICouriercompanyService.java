package com.ruoyi.wuliu.service;

import com.ruoyi.wuliu.domain.Couriercompany;
import java.util.List;

/**
 * 快递公司Service接口
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
public interface ICouriercompanyService 
{
    /**
     * 查询快递公司
     * 
     * @param id 快递公司ID
     * @return 快递公司
     */
    public Couriercompany selectCouriercompanyById(Long id);

    /**
     * 查询快递公司列表
     * 
     * @param couriercompany 快递公司
     * @return 快递公司集合
     */
    public List<Couriercompany> selectCouriercompanyList(Couriercompany couriercompany);

    /**
     * 新增快递公司
     * 
     * @param couriercompany 快递公司
     * @return 结果
     */
    public int insertCouriercompany(Couriercompany couriercompany);

    /**
     * 修改快递公司
     * 
     * @param couriercompany 快递公司
     * @return 结果
     */
    public int updateCouriercompany(Couriercompany couriercompany);

    /**
     * 批量删除快递公司
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCouriercompanyByIds(String ids);

    /**
     * 删除快递公司信息
     * 
     * @param id 快递公司ID
     * @return 结果
     */
    public int deleteCouriercompanyById(Long id);
}

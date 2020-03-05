package com.ruoyi.wuliu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wuliu.mapper.CouriercompanyMapper;
import com.ruoyi.wuliu.domain.Couriercompany;
import com.ruoyi.wuliu.service.ICouriercompanyService;
import com.ruoyi.common.core.text.Convert;

/**
 * 快递公司Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
@Service
public class CouriercompanyServiceImpl implements ICouriercompanyService 
{
    @Autowired
    private CouriercompanyMapper couriercompanyMapper;

    /**
     * 查询快递公司
     * 
     * @param id 快递公司ID
     * @return 快递公司
     */
    @Override
    public Couriercompany selectCouriercompanyById(Long id)
    {
        return couriercompanyMapper.selectCouriercompanyById(id);
    }

    /**
     * 查询快递公司列表
     * 
     * @param couriercompany 快递公司
     * @return 快递公司
     */
    @Override
    public List<Couriercompany> selectCouriercompanyList(Couriercompany couriercompany)
    {
        return couriercompanyMapper.selectCouriercompanyList(couriercompany);
    }

    /**
     * 新增快递公司
     * 
     * @param couriercompany 快递公司
     * @return 结果
     */
    @Override
    public int insertCouriercompany(Couriercompany couriercompany)
    {
        return couriercompanyMapper.insertCouriercompany(couriercompany);
    }

    /**
     * 修改快递公司
     * 
     * @param couriercompany 快递公司
     * @return 结果
     */
    @Override
    public int updateCouriercompany(Couriercompany couriercompany)
    {
        return couriercompanyMapper.updateCouriercompany(couriercompany);
    }

    /**
     * 删除快递公司对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCouriercompanyByIds(String ids)
    {
        return couriercompanyMapper.deleteCouriercompanyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除快递公司信息
     * 
     * @param id 快递公司ID
     * @return 结果
     */
    @Override
    public int deleteCouriercompanyById(Long id)
    {
        return couriercompanyMapper.deleteCouriercompanyById(id);
    }
}

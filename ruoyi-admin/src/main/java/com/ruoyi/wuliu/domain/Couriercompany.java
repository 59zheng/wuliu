package com.ruoyi.wuliu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 快递公司对象 couriercompany
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
public class Couriercompany extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 首重 */
    @Excel(name = "首重")
    private Double fwegiht;

    /** 首价 */
    @Excel(name = "首价")
    private Double fprice;

    /** 阶梯重量 */
    @Excel(name = "阶梯重量")
    private Double ladderwegiht;

    /** 阶梯价格 */
    @Excel(name = "阶梯价格")
    private Double ladderprice;

    /** 最后修改人 */
    @Excel(name = "最后修改人")
    private String updatep;

    /** 快递公司名字 */
    @Excel(name = "快递公司名字")
    private String couriercompany;

    /** 主键 */
    private Long id;

    private Date updatetime;

    public void setFwegiht(Double fwegiht) 
    {
        this.fwegiht = fwegiht;
    }

    public Double getFwegiht() 
    {
        return fwegiht;
    }
    public void setFprice(Double fprice) 
    {
        this.fprice = fprice;
    }

    public Double getFprice() 
    {
        return fprice;
    }
    public void setLadderwegiht(Double ladderwegiht) 
    {
        this.ladderwegiht = ladderwegiht;
    }

    public Double getLadderwegiht() 
    {
        return ladderwegiht;
    }
    public void setLadderprice(Double ladderprice) 
    {
        this.ladderprice = ladderprice;
    }

    public Double getLadderprice() 
    {
        return ladderprice;
    }
    public void setUpdatep(String updatep) 
    {
        this.updatep = updatep;
    }

    public String getUpdatep() 
    {
        return updatep;
    }
    public void setCouriercompany(String couriercompany) 
    {
        this.couriercompany = couriercompany;
    }

    public String getCouriercompany() 
    {
        return couriercompany;
    }
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("fwegiht", getFwegiht())
                .append("fprice", getFprice())
                .append("ladderwegiht", getLadderwegiht())
                .append("ladderprice", getLadderprice())
                .append("updatetime", getUpdatetime())
                .append("updatep", getUpdatep())
                .append("couriercompany", getCouriercompany())
                .append("id", getId())
                .toString();
    }


    public Date getUpdatetime() {
        return updatetime;
    }
    public Date setUpdatetime(Date date) {
        return updatetime;
    }
}

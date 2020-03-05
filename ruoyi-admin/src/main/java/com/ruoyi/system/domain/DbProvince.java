package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 省市县三级下拉对象 db_province
 * 
 * @author zheng
 * @date 2019-12-11
 */
public class DbProvince extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 省ID */
    @Excel(name = "省ID")
    private Long provinceid;

    /** 省份 */
    @Excel(name = "省份")
    private String province;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProvinceid(Long provinceid) 
    {
        this.provinceid = provinceid;
    }

    public Long getProvinceid() 
    {
        return provinceid;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("provinceid", getProvinceid())
            .append("province", getProvince())
            .toString();
    }
}

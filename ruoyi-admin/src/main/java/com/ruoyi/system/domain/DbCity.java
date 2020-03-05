package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 城市信息对象 db_city
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public class DbCity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 城市编码 */
    @Excel(name = "城市编码")
    private String cityid;

    /** 城市名称 */
    @Excel(name = "城市名称")
    private String city;

    /** 所属省份编码 */
    @Excel(name = "所属省份编码")
    private String provinceid;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCityid(String cityid) 
    {
        this.cityid = cityid;
    }

    public String getCityid() 
    {
        return cityid;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setProvinceid(String provinceid) 
    {
        this.provinceid = provinceid;
    }

    public String getProvinceid() 
    {
        return provinceid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("cityid", getCityid())
            .append("city", getCity())
            .append("provinceid", getProvinceid())
            .toString();
    }
}

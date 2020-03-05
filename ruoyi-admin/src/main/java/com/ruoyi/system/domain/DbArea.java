package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 区县信息对象 db_area
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public class DbArea extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 区县编码 */
    @Excel(name = "区县编码")
    private String areaid;

    /** 区县名称 */
    @Excel(name = "区县名称")
    private String area;

    /** 所属城市编码 */
    @Excel(name = "所属城市编码")
    private String cityid;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAreaid(String areaid) 
    {
        this.areaid = areaid;
    }

    public String getAreaid() 
    {
        return areaid;
    }
    public void setArea(String area) 
    {
        this.area = area;
    }

    public String getArea() 
    {
        return area;
    }
    public void setCityid(String cityid) 
    {
        this.cityid = cityid;
    }

    public String getCityid() 
    {
        return cityid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("areaid", getAreaid())
            .append("area", getArea())
            .append("cityid", getCityid())
            .toString();
    }
}

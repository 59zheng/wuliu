package com.ruoyi.wuliu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 车辆路线对象 wuliu_vehicle_route
 * 
 * @author zheng
 * @date 2020-01-09
 */
public class WuliuVehicleRoute extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 编号 */
    @Excel(name = "编号")
    private String serialNumber;

    /** 路径 */
    @Excel(name = "路径")
    private String path;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSerialNumber(String serialNumber) 
    {
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() 
    {
        return serialNumber;
    }
    public void setPath(String path) 
    {
        this.path = path;
    }

    public String getPath() 
    {
        return path;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("serialNumber", getSerialNumber())
            .append("path", getPath())
            .toString();
    }
}

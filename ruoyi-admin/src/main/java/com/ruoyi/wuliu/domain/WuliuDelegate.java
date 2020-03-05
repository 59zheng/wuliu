package com.ruoyi.wuliu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 委派单关联调度单对象 wuliu_delegate
 * 
 * @author zheng
 * @date 2019-12-13
 */
public class WuliuDelegate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 调度单号 */
    @Excel(name = "调度单号")
    private String schedulingId;

    /** 委派服务站 */
    @Excel(name = "委派服务站")
    private String villageName;

    /** 委派状态 */
    @Excel(name = "委派状态")
    private String villageType;

    /** 预计所需时间 */
    @Excel(name = "预计所需时间")
    private String estimatedTime;

    /** 送达时间 */
    @Excel(name = "送达时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deliveryTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSchedulingId(String schedulingId) 
    {
        this.schedulingId = schedulingId;
    }

    public String getSchedulingId() 
    {
        return schedulingId;
    }
    public void setVillageName(String villageName) 
    {
        this.villageName = villageName;
    }

    public String getVillageName() 
    {
        return villageName;
    }
    public void setVillageType(String villageType) 
    {
        this.villageType = villageType;
    }

    public String getVillageType() 
    {
        return villageType;
    }
    public void setEstimatedTime(String estimatedTime) 
    {
        this.estimatedTime = estimatedTime;
    }

    public String getEstimatedTime() 
    {
        return estimatedTime;
    }
    public void setDeliveryTime(Date deliveryTime) 
    {
        this.deliveryTime = deliveryTime;
    }

    public Date getDeliveryTime() 
    {
        return deliveryTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("schedulingId", getSchedulingId())
            .append("villageName", getVillageName())
            .append("villageType", getVillageType())
            .append("estimatedTime", getEstimatedTime())
            .append("deliveryTime", getDeliveryTime())
            .toString();
    }
}

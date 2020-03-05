package com.ruoyi.wuliu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 调度单号关联任务单和委派单对象 wuliu_scheduling
 * 
 * @author zheng
 * @date 2019-12-13
 */
public class WuliuScheduling extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 调度单号 */
    @Excel(name = "调度单号")
    private String schedulingId;

    /** 任务单号 */
    @Excel(name = "任务单号")
    private String taskId;

    /** 状态 */
    @Excel(name = "状态")
    private String schedulingType;

    /** 处理时间 */
    @Excel(name = "处理时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date processingTime;

    /** 处理人 */
    @Excel(name = "处理人")
    private String processingName;

    /** 委派快递公司 */
    @Excel(name = "委派快递公司")
    private String delegateName;

    /** 委派单号 */
    @Excel(name = "委派单号")
    private String delegateId;

    /** 需调度的快递单号 */
    @Excel(name = "需调度的快递单号")
    private String tasknum;

    /** 委派服务站 */
    @Excel(name = "委派服务站")
    private String villageName;

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
    public void setTaskId(String taskId) 
    {
        this.taskId = taskId;
    }

    public String getTaskId() 
    {
        return taskId;
    }
    public void setSchedulingType(String schedulingType) 
    {
        this.schedulingType = schedulingType;
    }

    public String getSchedulingType() 
    {
        return schedulingType;
    }
    public void setProcessingTime(Date processingTime) 
    {
        this.processingTime = processingTime;
    }

    public Date getProcessingTime() 
    {
        return processingTime;
    }
    public void setProcessingName(String processingName) 
    {
        this.processingName = processingName;
    }

    public String getProcessingName() 
    {
        return processingName;
    }
    public void setDelegateName(String delegateName) 
    {
        this.delegateName = delegateName;
    }

    public String getDelegateName() 
    {
        return delegateName;
    }
    public void setDelegateId(String delegateId) 
    {
        this.delegateId = delegateId;
    }

    public String getDelegateId() 
    {
        return delegateId;
    }
    public void setTasknum(String tasknum) 
    {
        this.tasknum = tasknum;
    }

    public String getTasknum() 
    {
        return tasknum;
    }
    public void setVillageName(String villageName) 
    {
        this.villageName = villageName;
    }

    public String getVillageName() 
    {
        return villageName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("schedulingId", getSchedulingId())
            .append("taskId", getTaskId())
            .append("schedulingType", getSchedulingType())
            .append("createTime", getCreateTime())
            .append("processingTime", getProcessingTime())
            .append("processingName", getProcessingName())
            .append("delegateName", getDelegateName())
            .append("delegateId", getDelegateId())
            .append("tasknum", getTasknum())
            .append("villageName", getVillageName())
            .toString();
    }
}

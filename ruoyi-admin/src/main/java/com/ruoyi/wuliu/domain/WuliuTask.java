package com.ruoyi.wuliu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 任务单关联路径和车辆和内部运单对象 wuliu_task
 * 
 * @author zheng
 * @date 2019-12-23
 */
public class WuliuTask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 预计所需时间 */
    @Excel(name = "预计所需时间")
    private String estimatedTime;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String driverNum;

    /** 任务编号 */
    @Excel(name = "任务编号")
    private String taskId;

    /** 指派人 */
    @Excel(name = "指派人")
    private String assignedName;

    /** 是否完成 */
    @Excel(name = "是否完成")
    private String isReturn;

    /** 结束时间 */
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 配送司机名字 */
    @Excel(name = "配送司机名字")
    private String driverName;

    /** 配送司机联系方式 */
    @Excel(name = "配送司机联系方式")
    private String phone;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setEstimatedTime(String estimatedTime) 
    {
        this.estimatedTime = estimatedTime;
    }

    public String getEstimatedTime() 
    {
        return estimatedTime;
    }
    public void setDriverNum(String driverNum) 
    {
        this.driverNum = driverNum;
    }

    public String getDriverNum() 
    {
        return driverNum;
    }
    public void setTaskId(String taskId) 
    {
        this.taskId = taskId;
    }

    public String getTaskId() 
    {
        return taskId;
    }
    public void setAssignedName(String assignedName) 
    {
        this.assignedName = assignedName;
    }

    public String getAssignedName() 
    {
        return assignedName;
    }
    public void setIsReturn(String isReturn) 
    {
        this.isReturn = isReturn;
    }

    public String getIsReturn() 
    {
        return isReturn;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setDriverName(String driverName) 
    {
        this.driverName = driverName;
    }

    public String getDriverName() 
    {
        return driverName;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createTime", getCreateTime())
            .append("estimatedTime", getEstimatedTime())
            .append("driverNum", getDriverNum())
            .append("taskId", getTaskId())
            .append("assignedName", getAssignedName())
            .append("isReturn", getIsReturn())
            .append("endTime", getEndTime())
            .append("driverName", getDriverName())
            .append("phone", getPhone())
            .toString();
    }
}

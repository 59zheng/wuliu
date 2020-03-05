package com.ruoyi.wuliu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 申请对象 wuliu_apply
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public class WuliuApply extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 申请单号 */
    @Excel(name = "申请单号")
    private Long applyid;

    /** 发起人 */
    @Excel(name = "发起人")
    private String initiateName;

    /** 状态 */
    @Excel(name = "状态")
    private String isDispose;

    /** 处理人 */
    @Excel(name = "处理人")
    private String disponseName;

    /** 处理时间 */
    @Excel(name = "处理时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date disponseTime;

    /** 委派任务单号 */
    @Excel(name = "委派任务单号")
    private String taskId;

    /** 主键 */
    private Long id;

    /** 关联的内部订单表 */
    @Excel(name = "关联的内部订单表")
    private String wuliuInternalId;

    public void setApplyid(Long applyid) 
    {
        this.applyid = applyid;
    }

    public Long getApplyid() 
    {
        return applyid;
    }
    public void setInitiateName(String initiateName) 
    {
        this.initiateName = initiateName;
    }

    public String getInitiateName() 
    {
        return initiateName;
    }
    public void setIsDispose(String isDispose) 
    {
        this.isDispose = isDispose;
    }

    public String getIsDispose() 
    {
        return isDispose;
    }
    public void setDisponseName(String disponseName) 
    {
        this.disponseName = disponseName;
    }

    public String getDisponseName() 
    {
        return disponseName;
    }
    public void setDisponseTime(Date disponseTime) 
    {
        this.disponseTime = disponseTime;
    }

    public Date getDisponseTime() 
    {
        return disponseTime;
    }
    public void setTaskId(String taskId)
    {
        this.taskId = taskId;
    }

    public String getTaskId()
    {
        return taskId;
    }
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setWuliuInternalId(String wuliuInternalId) 
    {
        this.wuliuInternalId = wuliuInternalId;
    }

    public String getWuliuInternalId() 
    {
        return wuliuInternalId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("applyid", getApplyid())
            .append("initiateName", getInitiateName())
            .append("isDispose", getIsDispose())
            .append("disponseName", getDisponseName())
            .append("createTime", getCreateTime())
            .append("disponseTime", getDisponseTime())
            .append("taskId", getTaskId())
            .append("id", getId())
            .append("wuliuInternalId", getWuliuInternalId())
            .toString();
    }
}

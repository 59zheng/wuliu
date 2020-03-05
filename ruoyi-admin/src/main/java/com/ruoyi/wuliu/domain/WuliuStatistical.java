package com.ruoyi.wuliu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 统计服务站上下行对象 wuliu_statistical
 * 
 * @author zheng
 * @date 2019-12-05
 */
public class WuliuStatistical extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 上行数量 */
    @Excel(name = "上行数量")
    private String up;

    /** 服务站名称 */
    @Excel(name = "服务站名称")
    private String villagePointName;

    /** 统计日期 */
    @Excel(name = "统计日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 下行数量 */
    @Excel(name = "下行数量")
    private String down;

    /** 状态（快递单，内部单） */
    @Excel(name = "状态", readConverterExp = "快=递单，内部单")
    private String type;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUp(String up) 
    {
        this.up = up;
    }

    public String getUp() 
    {
        return up;
    }
    public void setVillagePointName(String villagePointName) 
    {
        this.villagePointName = villagePointName;
    }

    public String getVillagePointName() 
    {
        return villagePointName;
    }
    public void setDate(Date date) 
    {
        this.date = date;
    }

    public Date getDate() 
    {
        return date;
    }
    public void setDown(String down) 
    {
        this.down = down;
    }

    public String getDown() 
    {
        return down;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("up", getUp())
            .append("villagePointName", getVillagePointName())
            .append("date", getDate())
            .append("down", getDown())
            .append("type", getType())
            .toString();
    }
}

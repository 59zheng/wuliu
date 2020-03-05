package com.ruoyi.wuliu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 发车记录对象 wuliu_start_recording
 * 
 * @author zheng
 * @date 2019-12-23
 */
public class WuliuStartRecording extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 发车时间 */
    @Excel(name = "发车时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date departureTime;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String driveNum;

    /** 行驶路线 */
    @Excel(name = "行驶路线")
    private String route;

    /** 行驶前检查情况 */
    @Excel(name = "行驶前检查情况")
    private String drivingStart;

    /** 归车时间 */
    @Excel(name = "归车时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date returnCarTime;

    /** 主管名字 */
    @Excel(name = "主管名字")
    private String directorName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDepartureTime(Date departureTime) 
    {
        this.departureTime = departureTime;
    }

    public Date getDepartureTime() 
    {
        return departureTime;
    }
    public void setDriveNum(String driveNum) 
    {
        this.driveNum = driveNum;
    }

    public String getDriveNum() 
    {
        return driveNum;
    }
    public void setRoute(String route) 
    {
        this.route = route;
    }

    public String getRoute() 
    {
        return route;
    }
    public void setDrivingStart(String drivingStart) 
    {
        this.drivingStart = drivingStart;
    }

    public String getDrivingStart() 
    {
        return drivingStart;
    }
    public void setReturnCarTime(Date returnCarTime) 
    {
        this.returnCarTime = returnCarTime;
    }

    public Date getReturnCarTime() 
    {
        return returnCarTime;
    }
    public void setDirectorName(String directorName) 
    {
        this.directorName = directorName;
    }

    public String getDirectorName() 
    {
        return directorName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("departureTime", getDepartureTime())
            .append("driveNum", getDriveNum())
            .append("route", getRoute())
            .append("drivingStart", getDrivingStart())
            .append("returnCarTime", getReturnCarTime())
            .append("directorName", getDirectorName())
            .toString();
    }
}

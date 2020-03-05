package com.ruoyi.wuliu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 司机对象 wuliu_driver
 * 
 * @author 正
 * @date 2019-12-05
 */
public class WuliuDriver extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 准驾车型 */
    @Excel(name = "准驾车型")
    private String license;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    /** 生日 */
    @Excel(name = "生日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /** 紧急联系人 */
    @Excel(name = "紧急联系人")
    private String emergencyName;

    /** 紧急联系人电话 */
    @Excel(name = "紧急联系人电话")
    private String emergencyPhone;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String vehicleNum;

    /** 车载设备imei（用于GPS定位） */
    @Excel(name = "车载设备imei", readConverterExp = "用=于GPS定位")
    private String gps;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setLicense(String license) 
    {
        this.license = license;
    }

    public String getLicense() 
    {
        return license;
    }
    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }
    public void setBirthday(Date birthday) 
    {
        this.birthday = birthday;
    }

    public Date getBirthday() 
    {
        return birthday;
    }
    public void setEmergencyName(String emergencyName) 
    {
        this.emergencyName = emergencyName;
    }

    public String getEmergencyName() 
    {
        return emergencyName;
    }
    public void setEmergencyPhone(String emergencyPhone) 
    {
        this.emergencyPhone = emergencyPhone;
    }

    public String getEmergencyPhone() 
    {
        return emergencyPhone;
    }
    public void setVehicleNum(String vehicleNum) 
    {
        this.vehicleNum = vehicleNum;
    }

    public String getVehicleNum() 
    {
        return vehicleNum;
    }
    public void setGps(String gps) 
    {
        this.gps = gps;
    }

    public String getGps() 
    {
        return gps;
    }
    public void setNote(String note) 
    {
        this.note = note;
    }

    public String getNote() 
    {
        return note;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("phone", getPhone())
            .append("license", getLicense())
            .append("gender", getGender())
            .append("birthday", getBirthday())
            .append("emergencyName", getEmergencyName())
            .append("emergencyPhone", getEmergencyPhone())
            .append("vehicleNum", getVehicleNum())
            .append("gps", getGps())
            .append("note", getNote())
            .toString();
    }
}

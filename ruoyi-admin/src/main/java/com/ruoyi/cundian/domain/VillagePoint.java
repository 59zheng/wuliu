package com.ruoyi.cundian.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.TreeEntity;
import java.util.Date;

/**
 * 村点对象 village_point
 *
 * @author zheng
 * @date 2019-12-10
 */
public class VillagePoint extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 村点名称 */
    @Excel(name = "村点名称")
    private String villageName;

    /** 省 */
    @Excel(name = "省")
    private String provinces;

    /** 市 */
    @Excel(name = "市")
    private String cities;

    /** 县 */
    @Excel(name = "县")
    private String counties;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** 经度 */
    @Excel(name = "经度")
    private String longitude;

    /** 纬度 */
    @Excel(name = "纬度")
    private String latitude;

    /** 是否启用(0启用，1未启用) */
    @Excel(name = "是否启用(0启用，1未启用)")
    private String isEnable;

    /** 负责人 */
    @Excel(name = "负责人")
    private String head;

    /** 负责人电话 */
    @Excel(name = "负责人电话")
    private String headPhone;

    /** 审批人姓名 */
    @Excel(name = "审批人姓名")
    private String examinationName;

    /** 审批人电话 */
    @Excel(name = "负责人身份证号")
    private String examinationPhone;

    /** 审批时间 */
    @Excel(name = "审批时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date examinationTime;

    /** 图片信息 */
    @Excel(name = "图片信息")
    private String picture;

    /** 父级id */
    @Excel(name = "父级id")
    private Long productId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setVillageName(String villageName)
    {
        this.villageName = villageName;
    }

    public String getVillageName()
    {
        return villageName;
    }
    public void setProvinces(String provinces)
    {
        this.provinces = provinces;
    }

    public String getProvinces()
    {
        return provinces;
    }
    public void setCities(String cities)
    {
        this.cities = cities;
    }

    public String getCities()
    {
        return cities;
    }
    public void setCounties(String counties)
    {
        this.counties = counties;
    }

    public String getCounties()
    {
        return counties;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setLongitude(String longitude)
    {
        this.longitude = longitude;
    }

    public String getLongitude()
    {
        return longitude;
    }
    public void setLatitude(String latitude)
    {
        this.latitude = latitude;
    }

    public String getLatitude()
    {
        return latitude;
    }
    public void setIsEnable(String isEnable)
    {
        this.isEnable = isEnable;
    }

    public String getIsEnable()
    {
        return isEnable;
    }
    public void setHead(String head)
    {
        this.head = head;
    }

    public String getHead()
    {
        return head;
    }
    public void setHeadPhone(String headPhone)
    {
        this.headPhone = headPhone;
    }

    public String getHeadPhone()
    {
        return headPhone;
    }
    public void setExaminationName(String examinationName)
    {
        this.examinationName = examinationName;
    }

    public String getExaminationName()
    {
        return examinationName;
    }
    public void setExaminationPhone(String examinationPhone)
    {
        this.examinationPhone = examinationPhone;
    }

    public String getExaminationPhone()
    {
        return examinationPhone;
    }
    public void setExaminationTime(Date examinationTime)
    {
        this.examinationTime = examinationTime;
    }

    public Date getExaminationTime()
    {
        return examinationTime;
    }
    public void setPicture(String picture)
    {
        this.picture = picture;
    }

    public String getPicture()
    {
        return picture;
    }
    public void setProductId(Long productId)
    {
        this.productId = productId;
    }

    public Long getProductId()
    {
        return productId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("villageName", getVillageName())
                .append("provinces", getProvinces())
                .append("cities", getCities())
                .append("counties", getCounties())
                .append("address", getAddress())
                .append("longitude", getLongitude())
                .append("latitude", getLatitude())
                .append("isEnable", getIsEnable())
                .append("head", getHead())
                .append("createTime", getCreateTime())
                .append("headPhone", getHeadPhone())
                .append("examinationName", getExaminationName())
                .append("examinationPhone", getExaminationPhone())
                .append("examinationTime", getExaminationTime())
                .append("picture", getPicture())
                .append("productId", getProductId())
                .toString();
    }
}
package com.ruoyi.wuliu.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 内部订单（上下行）对象 wuliu_internal
 * 
 * @author zheng
 * @date 2019-12-05
 */
@Data
public class WuliuInternal extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 创建时间 */
    private Date cratetime;

    /** 快递公司名字 */
    @Excel(name = "快递公司名字")
    private String couriercompany;

    /** 收件人详细地址 */
    @Excel(name = "收件人详细地址")
    private String downdress;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String tasknum;

    /** 是否删除 */
    private String isDelete;

    /** 省份 */
    @Excel(name = "省份")
    private String sheng;

    /** 市 */
    @Excel(name = "市")
    private String shi;

    /** 县 */
    @Excel(name = "县")
    private String xian;

    /** 收件人姓名 */
    @Excel(name = "收件人姓名")
    private String downName;

    /** 收件人手机号 */
    @Excel(name = "收件人手机号")
    private String downPhone;

    /** 发件人手机号 */
    @Excel(name = "发件人手机号")
    private String createPhone;

    /** 内部运单号 */
    @Excel(name = "内部运单号")
    private String internalNum;

    /** 主键 */
    private Long id;


    /** 上下行 */
    @Excel(name = "上下行")
    private String direction;

    /** 服务站名称 */
    @Excel(name = "服务站名称")
    private String villagePointName;


}

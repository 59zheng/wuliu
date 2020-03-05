package com.ruoyi.wuliu.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 快递单管理对象 courier
 *
 * @author zheng
 * @date 2019-11-12
 */
@Data
public class Courier extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 发件人
     */
    @Excel(name = "发件人")
    private String createname;

    /**
     * 发件人详细地址
     */
    @Excel(name = "发件人详细地址")
    private String senderAddress;

    /**
     * 运单状态
     */
    @Excel(name = "运单状态")
    private String type;


    /**
     * 服务站名称
     */
    @Excel(name = "运单状态")
    private String villageName;

    /**
     * 创建时间
     */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date cratetime;

    /**
     * 快递公司名字
     */
    @Excel(name = "快递公司名字")
    private String couriercompany;

    /**
     * 收件人详细地址
     */
    @Excel(name = "收件人详细地址")
    private String downdress;

    /**
     * 订单编号
     */
    @Excel(name = "订单编号")
    private String tasknum;

    /**
     * 是否删除
     */
    private String isDelete;

    /**
     * 省份
     */
    @Excel(name = "省份")
    private String sheng;

    /**
     * 市
     */
    @Excel(name = "市")
    private String shi;

    /**
     * 县
     */
    @Excel(name = "县")
    private String xian;

    /**
     * 收件人姓名
     */
    @Excel(name = "收件人姓名")
    private String downName;

    /**
     * 收件人手机号
     */
    @Excel(name = "收件人手机号")
    private String downPhone;

    /**
     * 发件人手机号
     */
    @Excel(name = "发件人手机号")
    private String createPhone;


}

package com.ruoyi.wuliu.domain;

import lombok.Data;

@Data
public class WuliuApplyVO {

    private String consignee;
    private String sender;
    private String consigneeAddress;
    private String senderAddress;
    private String courierName;
    private String villagePointName;
    private String note;
    private String consigneePhone;
    private String senderPhone;
    private String province;
    private String city;
    private String county;

}

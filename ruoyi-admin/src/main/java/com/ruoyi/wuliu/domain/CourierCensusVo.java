package com.ruoyi.wuliu.domain;

import lombok.Data;


//物流统计页面返回的对象
@Data
public class CourierCensusVo {
    //上行总量
    private String upNumAll;
    //    上行量
    private String upNum;
    //    下行量
    private String downNum;
    //    下行总量
    private String downNumAll;
    ;
    //    订单总量
    private String courierNumAll;
    //    订单量
    private String courierNum;


}

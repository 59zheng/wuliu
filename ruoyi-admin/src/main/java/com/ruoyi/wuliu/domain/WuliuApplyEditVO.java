package com.ruoyi.wuliu.domain;


import lombok.Data;

import java.util.Date;

@Data
public class WuliuApplyEditVO {

        private  Long applyId;
        private  Long id;
        private String  initiateName;
        private  String wuliuInternalId;
        private  String estimatedTime;
        private  String driverNum;
        private  String taskId;
        private  String assignedName;
        private  String isReturn;
        private Date createTime;




}

package com.ruoyi.wuliu.domain;


import com.ruoyi.common.annotation.Excel;
import lombok.Data;

@Data
public class WuliuSchedulingVo {

    /** 主键 */
    private Long id;


    /** 委派快递公司 */
    private String delegateName;

    /** 委派单号 */
    private String delegateId;

    /** 需调度的快递单号 */
    private String tasknum;

    /** 委派服务站 */
    private String villageName;

    /*委派车辆*/
    private  String driverNum;

    /*委派车辆*/
    private  String estimatedTime;

    private  String schedulingId;

}

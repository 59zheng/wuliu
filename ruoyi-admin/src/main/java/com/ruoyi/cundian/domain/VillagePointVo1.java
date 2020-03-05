package com.ruoyi.cundian.domain;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

import java.util.Date;

@Data
public class VillagePointVo1 {

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


        /** 负责人 */
        private String head;

        /** 负责人电话 */
        private String headPhone;

        /** 审批人姓名 */
        private String examinationName;

        /** 审批人电话 */
        private String examinationPhone;

        /** 审批时间 */
        private Date examinationTime;

        /** 图片信息 */
        private String picture;

        /** 父级id */
        private Long productId;


        private String courierCompanyIdS;



}

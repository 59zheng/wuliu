package com.ruoyi.wuliu.domain;

import java.util.List;

public class RandomVo {


    /**
     * status : 0
     * msg : ok
     * result : {"number":"70335000365144","type":"HTKY","list":[{"time":"2019-11-10 19:42:50","status":"北京市【北京朝阳区十部】，李景清 已签收"},{"time":"2019-11-08 07:49:17","status":"北京市【北京朝阳区十部】，【狄长恒/18511873219】正在派件"},{"time":"2019-11-08 07:48:17","status":"到北京市【北京朝阳区十部】"},{"time":"2019-11-07 15:30:47","status":"北京市【北京转运中心】，正发往【北京朝阳区十部】"},{"time":"2019-11-07 15:00:16","status":"到北京市【北京转运中心】"},{"time":"2019-11-07 00:12:41","status":"太原市【太原转运中心】，正发往【北京转运中心】"},{"time":"2019-11-07 00:08:21","status":"到太原市【太原转运中心】"},{"time":"2019-11-06 02:32:30","status":"临汾市【侯马转运中心】，正发往【太原转运中心】"},{"time":"2019-11-06 02:31:13","status":"到临汾市【侯马转运中心】"},{"time":"2019-11-05 16:21:00","status":"运城市【运城盐湖区一部集货点】，正发往【侯马转运中心】"},{"time":"2019-11-05 16:20:59","status":"到运城市【运城盐湖区一部集货点】"},{"time":"2019-11-05 12:13:09","status":"运城市【运城平陆县】，【卢奇/15534802521】已揽收"}],"deliverystatus":"3","issign":"1","expName":"百世快递","expSite":"www.htky365.com ","expPhone":"95320","logo":"http://img3.fegine.com/express/htky.jpg","courier":"","courierPhone":"","updateTime":"2019-11-10 19:42:50","takeTime":"5天7小时29分"}
     */

    private String status;
    private String msg;
    private ResultBean result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * number : 70335000365144
         * type : HTKY
         * list : [{"time":"2019-11-10 19:42:50","status":"北京市【北京朝阳区十部】，李景清 已签收"},{"time":"2019-11-08 07:49:17","status":"北京市【北京朝阳区十部】，【狄长恒/18511873219】正在派件"},{"time":"2019-11-08 07:48:17","status":"到北京市【北京朝阳区十部】"},{"time":"2019-11-07 15:30:47","status":"北京市【北京转运中心】，正发往【北京朝阳区十部】"},{"time":"2019-11-07 15:00:16","status":"到北京市【北京转运中心】"},{"time":"2019-11-07 00:12:41","status":"太原市【太原转运中心】，正发往【北京转运中心】"},{"time":"2019-11-07 00:08:21","status":"到太原市【太原转运中心】"},{"time":"2019-11-06 02:32:30","status":"临汾市【侯马转运中心】，正发往【太原转运中心】"},{"time":"2019-11-06 02:31:13","status":"到临汾市【侯马转运中心】"},{"time":"2019-11-05 16:21:00","status":"运城市【运城盐湖区一部集货点】，正发往【侯马转运中心】"},{"time":"2019-11-05 16:20:59","status":"到运城市【运城盐湖区一部集货点】"},{"time":"2019-11-05 12:13:09","status":"运城市【运城平陆县】，【卢奇/15534802521】已揽收"}]
         * deliverystatus : 3
         * issign : 1
         * expName : 百世快递
         * expSite : www.htky365.com
         * expPhone : 95320
         * logo : http://img3.fegine.com/express/htky.jpg
         * courier :
         * courierPhone :
         * updateTime : 2019-11-10 19:42:50
         * takeTime : 5天7小时29分
         */

        private String number;
        private String type;
        private String deliverystatus;
        private String issign;
        private String expName;
        private String expSite;
        private String expPhone;
        private String logo;
        private String courier;
        private String courierPhone;
        private String updateTime;
        private String takeTime;
        private List<ListBean> list;

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDeliverystatus() {
            return deliverystatus;
        }

        public void setDeliverystatus(String deliverystatus) {
            this.deliverystatus = deliverystatus;
        }

        public String getIssign() {
            return issign;
        }

        public void setIssign(String issign) {
            this.issign = issign;
        }

        public String getExpName() {
            return expName;
        }

        public void setExpName(String expName) {
            this.expName = expName;
        }

        public String getExpSite() {
            return expSite;
        }

        public void setExpSite(String expSite) {
            this.expSite = expSite;
        }

        public String getExpPhone() {
            return expPhone;
        }

        public void setExpPhone(String expPhone) {
            this.expPhone = expPhone;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getCourier() {
            return courier;
        }

        public void setCourier(String courier) {
            this.courier = courier;
        }

        public String getCourierPhone() {
            return courierPhone;
        }

        public void setCourierPhone(String courierPhone) {
            this.courierPhone = courierPhone;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getTakeTime() {
            return takeTime;
        }

        public void setTakeTime(String takeTime) {
            this.takeTime = takeTime;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * time : 2019-11-10 19:42:50
             * status : 北京市【北京朝阳区十部】，李景清 已签收
             */

            private String time;
            private String status;

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }
        }
    }
}

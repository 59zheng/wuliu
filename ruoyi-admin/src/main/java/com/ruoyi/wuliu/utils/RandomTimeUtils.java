package com.ruoyi.wuliu.utils;

import com.ruoyi.common.utils.http.HttpUtil;
import com.ruoyi.system.domain.SysDictData;
import com.ruoyi.system.service.ISysDictDataService;
import com.ruoyi.wuliu.domain.RandomVo;
import com.ruoyi.wuliu.domain.WuliuDriver;
import com.ruoyi.wuliu.service.IWuliuDriverService;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class RandomTimeUtils {




    //获取当天某点的点时间
    public  Date getDate1(int i) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, i);//控制时
        cal.set(Calendar.MINUTE, 0);//控制分
        cal.set(Calendar.SECOND, 0);//控制秒
        return cal.getTime();
    }

    //生成指定时间内的时间
    public   Date randomDate(Date start, Date end) {

        if (start.getTime() >= end.getTime()) {
            return null;
        }
        long date = random(start.getTime(), end.getTime());
        return new Date(date);
    }
    private static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }

    //根据快递单号获取时间
    public  Date  httpclientTime(String tasknum) {
        String host = "https://wuliu.market.alicloudapi.com";
        String path = "/kdi";
        String method = "GET";
        //System.out.println("请先替换成自己的AppCode");
        String appcode = "a4172a0c685b4858a4aa2d4311dfeb05";  // !!!替换填写自己的AppCode 在买家中心查看
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appcode); //格式为:Authorization:APPCODE 83359fd73fe11248385f570e3c139xxx
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("no",tasknum);// !!! 请求参数
        //querys.put("type", "zto");// !!! 请求参数
        try {

            org.apache.http.HttpResponse response = (org.apache.http.HttpResponse) HttpUtil.doGet(host, path, method, headers, querys);
            //状态码: 200 正常；400 URL无效；401 appCode错误； 403 次数用完； 500 API网管错误
            //获取response的body
            String s = EntityUtils.toString(response.getEntity());
            RandomVo randomVo = com.alibaba.fastjson.JSONObject.parseObject(s, RandomVo.class);
            String updateTime = randomVo.getResult().getUpdateTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date parse = sdf.parse(updateTime);
            return parse;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (null);
    }

//    public static void main(String[] args) throws ParseException {
//        Date date = httpclientTime("70335007365145");
//        System.out.println(date);
//    }
}





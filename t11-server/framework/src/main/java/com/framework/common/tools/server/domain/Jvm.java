/**
 */
package com.framework.common.tools.server.domain;

import lombok.Data;

import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * Date:2021/6/26
 * Title: JVM相关信息
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
@Data
public class Jvm {
    /**
     * 当前JVM占用的内存总数
     */
    private String total;

    /**
     * JVM最大可用内存总数
     */
    private String max;

    /**
     * JVM空闲内存
     */
    private String free;

    /**
     * JDK版本
     */
    private String version;

    /**
     * JDK路径
     */
    private String home;


    /**
     * 获取JDK名称
     */
    public String getName() {
        return ManagementFactory.getRuntimeMXBean().getVmName();
    }


    /**
     * 获取服务器启动时间
     */
    public  Date getServerStartDate() {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }



    /**
     * JDK启动时间
     */
    public String getStartTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(getServerStartDate());
    }

    /**
     * JDK运行时间
     */
    public String getRunTime() {
        return getDatePoor(new Date(), getServerStartDate());
    }


    /**
     * 计算两个时间差
     */
    private  String getDatePoor(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟";
    }
}

/**
 */
package com.framework.common.tools.server.domain;

import lombok.Data;

/***
 * Date:2021/6/26
 * Title: CPU相关信息
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
@Data
public class Cpu {
    /**
     * 核心数
     */
    private int cpuNum;

    /**
     * CPU总的使用率
     */
    private double total;

    /**
     * CPU系统使用率
     */
    private double sys;

    /**
     * CPU用户使用率
     */
    private double used;

    /**
     * CPU当前等待率
     */
    private double wait;

    /**
     * CPU当前空闲率
     */
    private double free;

}

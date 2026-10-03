/**
 */
package com.framework.common.tools.server.domain;

import lombok.Data;

/***
 * Date:2021/6/26
 * Title: 內存相关信息
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
@Data
public class Mem {
    /**
     * 内存总量
     */
    private String total;

    /**
     * 已用内存
     */
    private String used;

    /**
     * 剩余内存
     */
    private String free;

}

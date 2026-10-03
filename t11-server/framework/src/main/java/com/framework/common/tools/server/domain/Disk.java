/**
 */
package com.framework.common.tools.server.domain;

import lombok.Data;

/***
 * Date:2021/6/26
 * Title: 磁盘信息
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
@Data
public class Disk {
    /**
     * 盘符路径
     */
    private String dirName;

    /**
     * 盘符类型
     */
    private String sysTypeName;

    /**
     * 文件类型
     */
    private String typeName;

    /**
     * 总大小
     */
    private String total;

    /**
     * 剩余大小
     */
    private String free;

    /**
     * 已经使用量
     */
    private String used;

    /**
     * 资源的使用率
     */
    private String useDescribe;

}

/**
 */
package com.framework.common.tools.server.domain;

import lombok.Data;

/***
 * Date:2021/6/26
 * Title: 系统相关信息
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
@Data
public class Sys {
    /**
     * 服务器名称
     */
    private String computerName;

    /**
     * 服务器Ip
     */
    private String computerIp;

    /**
     * 项目路径
     */
    private String userDir;

    /**
     * 操作系统
     */
    private String osName;

    /**
     * 系统架构
     */
    private String osArch;

}

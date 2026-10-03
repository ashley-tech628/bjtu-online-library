/**
 */
package com.foundation.springcontext.configure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/***
 * Date:2021/6/26
 * Title:项目配置
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
@Data
@Component
@ConfigurationProperties(prefix = "apollo")
public class PlatformConfig {

    /**
     * 项目名称
     */
    private String name;

    /**
     * 版本
     */
    private String version;

    /**
     * 版权信息
     */
    private String copyright;

    /**
     * 是否开启记录操作日志
     */
    private boolean logoperation;

    /**
     * 是否开启记录异常日志
     */
    private boolean logexception;

}

/**
 * 
 */
package com.foundation.springsecurity.configure;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

/***
 * 
 * Title:文件所属模块（必须填写）
 * 
 */
@Data
@Configuration
public class PcTokenBeanConfig {

    private String accessToken;

    private String userTicket;

    /** token有效时长 */
    private int tokenExpiresIn;

    /** ticket有效时长 */
    private int ticketExpiresIn;

    private String state;

    private String code;
}


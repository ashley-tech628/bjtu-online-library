/**
 */
package com.foundation.springsecurity.secure.uutoken;

import com.foundation.springsecurity.secure.services.SecureUser;
import lombok.Data;

import java.time.LocalDateTime;

/***
 * Date:2021/6/26
 * Title:用户 Token 封装实体
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
@Data
public class SecureUserToken {

    /**
     * 1表示PC端；2表示APP端
     */
    private String source;

    /**
     * Token
     */
    private String token;

    /**
     * tokenKey
     */
    private String tokenKey;

    /**
     * 基本信息
     */
    private SecureUser secureUser;

    /**
     * 创建时间
     */
    private LocalDateTime createTime = LocalDateTime.now();

}

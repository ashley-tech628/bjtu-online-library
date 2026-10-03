/**
 */
package com.framework.web.exception.auth.token;

import org.springframework.security.core.AuthenticationException;

/***
 * Date:2021/6/26
 * Title: Token异常基类
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public class TokenException extends AuthenticationException {

    public TokenException(String message) {
        super(message);
    }
}
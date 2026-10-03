/**
 */
package com.framework.web.exception.auth.captcha;

import org.springframework.security.core.AuthenticationException;

/***
 * Date:2021/6/26
 * Title: 验证码异常类
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public class CaptchaException extends AuthenticationException {

    public CaptchaException(String message) {
        super(message);
    }

}

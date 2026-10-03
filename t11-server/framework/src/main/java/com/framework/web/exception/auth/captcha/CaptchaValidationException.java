/**
 */
package com.framework.web.exception.auth.captcha;

/***
 * Date:2021/6/26
 * Title: 验证码失效异常类
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public class CaptchaValidationException extends CaptchaException {

    public CaptchaValidationException(String message) {
        super(message);
    }
}

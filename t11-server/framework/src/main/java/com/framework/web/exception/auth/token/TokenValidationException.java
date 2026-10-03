/**
 */
package com.framework.web.exception.auth.token;

/***
 * Date:2021/6/26
 * Title: Token验证异常类
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public class TokenValidationException extends TokenException {

    public TokenValidationException(String message) {
        super(message);
    }
}

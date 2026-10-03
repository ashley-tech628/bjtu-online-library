/**
 */
package com.foundation.springsecurity.constant;

/***
 */
public class SecurityConstant {

    /**
     * 不需要认证的静态资源
     */
    public static final String SUPER_ADMIN = "superAdmin";
    /**
     * 不需要认证的静态资源
     */
    public static final String WEB_ACT_MATCHERS = "/favicon.ico";

    /**
     * 默认的登录接口
     */
    public static final String LOGIN_URL = "/api/login";

    /**
     * 登录接口方式
     */
    public static final String LOGIN_METHOD = "POST";

    /**
     * 默认的注销接口
     */
    public static final String LOGOUT_URL = "/api/logout";

    /**
     * 是否开启验证码
     */
    public static final Boolean IS_CAPTCHA_VERIFICATION = true;

    /**
     * Captcha过期时间
     */
    public static final long CAPTCHA_EXPIRATION = 1000 * 60 * 5;

    /**
     * Token过期时间
     */
//    public static final long TOKEN_EXPIRATION = 1000 * 60 * 30;
    public static final long TOKEN_EXPIRATION = 1000 * 60 * 60 * 24 * 365;

}

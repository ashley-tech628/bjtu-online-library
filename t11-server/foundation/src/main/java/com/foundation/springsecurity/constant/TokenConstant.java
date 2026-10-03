/**
 */
package com.foundation.springsecurity.constant;

/***
 * Date:2021/6/26
 * Title:jwt静态配置
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public class TokenConstant {

    /**
     * Access Token密钥
     */
    public static final String SECRET = requiredSecret();

    private static String requiredSecret() {
        String value = System.getenv("JWT_SECRET");
        if (value == null || value.getBytes(java.nio.charset.StandardCharsets.UTF_8).length < 64) {
            throw new IllegalStateException("JWT_SECRET must contain at least 64 UTF-8 bytes");
        }
        return value;
    }

    /**
     * Access Token前缀
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * Access Token发布者
     */
    public static final String ISSUER = "library-demo";

    /**
     * Http Header Token请求头
     */
    public static final String TOKEN_HEADER = "Authorization";

    /**
     * Http Header Token Key
     */
    public static final String TOKEN_HEADER_KEY = "AuthorizationKey";

}

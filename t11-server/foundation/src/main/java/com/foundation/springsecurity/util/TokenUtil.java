/**
 */
package com.foundation.springsecurity.util;

import com.foundation.springsecurity.constant.TokenConstant;
import com.framework.web.exception.auth.token.TokenValidationException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/***
 * Date:2021/6/26
 * Title: Jwt工具类
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public class TokenUtil {

    /**
     * 创建 Token
     */
    public static String create(String userId, String username) {
        return Jwts.builder()
                .setId(userId)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setIssuer(TokenConstant.ISSUER)
                .signWith(SignatureAlgorithm.HS256, TokenConstant.SECRET)
                .compact();
    }

    /**
     * 解析 Token
     */
    public static void parse(String token) {
        try {
            Jwts.parser().setSigningKey(TokenConstant.SECRET).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            throw new TokenValidationException("token validation failure");
        }
    }

}

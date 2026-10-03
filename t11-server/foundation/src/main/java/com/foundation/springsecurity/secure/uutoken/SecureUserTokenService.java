/**
 */
package com.foundation.springsecurity.secure.uutoken;

import com.foundation.springsecurity.secure.services.SecureUser;
import com.foundation.springsecurity.util.TokenUtil;
import com.foundation.springcontext.bean.CaffeineCache;
import com.framework.common.constant.CacheNameConstant;
import com.framework.web.exception.auth.token.TokenException;
import com.framework.web.exception.auth.token.TokenValidationException;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

import java.util.UUID;

/***
 * Date:2021/6/26
 * Title:Security User Token 操作服务
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
@Component
public class SecureUserTokenService {
    @Resource
    private CaffeineCache caffeineCache;

    /**
     * Function:创建Token
     * Author: Admin
     * Date:2021/6/26
      * @param secureUser
     * @return com.bjtuwh.common.secure.uutoken.SecureUserToken
     * @throws Exception
     */
    public SecureUserToken createToken(SecureUser secureUser) {
        SecureUserToken userToken = new SecureUserToken();
        userToken.setToken(TokenUtil.create(secureUser.getId(), secureUser.getUsername()));
        userToken.setSecureUser(secureUser);
        return userToken;
    }

    /**
     * Function:存储Token
     * Author: Admin
     * Date:2021/6/26
      * @param userToken
     * @return java.lang.String
     * @throws Exception
     */
    public String saveToken(SecureUserToken userToken) {
        if(null == userToken)return null;
        String key = String.valueOf(UUID.randomUUID());
        userToken.setTokenKey(key);
        caffeineCache.setToken(CacheNameConstant.TOKEN_NAME_PREFIX + key, userToken);
//        redisTemplate.opsForValue().set(CacheNameConstant.TOKEN_NAME_PREFIX + key, userToken, SecurityConstant.TOKEN_EXPIRATION, TimeUnit.MILLISECONDS);
        return key;
    }

    /**
     * Function:验证Token
     * Author: Admin
     * Date:2021/6/26
      * @param key
     * @return com.bjtuwh.common.secure.uutoken.SecureUserToken
     * @throws Exception
     */
    public SecureUserToken verifyToken(String key) throws TokenException {
        SecureUserToken secureUserToken = taskToken(key);
        if (secureUserToken == null){
            throw new TokenValidationException("token expired");
        }
        TokenUtil.parse(secureUserToken.getToken());
        return secureUserToken;
    }

    /**
     * Function: 重置过期时间
     * Author: DSH
     * Date: 2021/8/4
     * @param key
     * @return: void
     */
    public void expire(String key) {
        caffeineCache.resetToken(key);
//        redisTemplate.expire(CacheNameConstant.TOKEN_NAME_PREFIX + key, SecurityConstant.TOKEN_EXPIRATION, TimeUnit.MILLISECONDS);
    }

    /**
     * Function:获取Token
     * Author: Admin
     * Date:2021/6/26
      * @param key
     * @return com.bjtuwh.common.secure.uutoken.SecureUserToken
     * @throws Exception
     */
    public SecureUserToken taskToken(String key) {
//        SecureUserToken secureUserToken = redisTemplate.opsForValue().get(CacheNameConstant.TOKEN_NAME_PREFIX + key);
        SecureUserToken secureUserToken = (SecureUserToken) caffeineCache.getToken(CacheNameConstant.TOKEN_NAME_PREFIX + key);
        return secureUserToken;
    }

    /**
     * Function:销毁Token
     * Author: Admin
     * Date:2021/6/26
      * @param key
     * @return void
     * @throws Exception
     */
    public void destroyToken(String key) {
        caffeineCache.removeToken(key);
//        redisTemplate.delete(CacheNameConstant.TOKEN_NAME_PREFIX + key);
    }


}

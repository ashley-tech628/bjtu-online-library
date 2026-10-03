/**
 */
package com.foundation.springsecurity.secure.process;

import com.foundation.springcontext.bean.BeanContext;
import com.foundation.springsecurity.constant.TokenConstant;
import com.foundation.springsecurity.context.UserContext;
import com.foundation.springsecurity.secure.services.SecureUser;
import com.foundation.springsecurity.secure.uutoken.SecureUserToken;
import com.foundation.springsecurity.secure.uutoken.SecureUserTokenService;
import com.foundation.tools.ServletUtil;
import com.framework.web.domain.CommonResult;
import org.checkerframework.checker.units.qual.C;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/***
 * Date:2021/6/26
 * Title:Security 登陆成功处理类
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public class SecureLoginSuccessHandler implements AuthenticationSuccessHandler {
    public SecureLoginSuccessHandler(){
        customUserDetailsTokenService = BeanContext.getBean(SecureUserTokenService.class);
    }
    @Resource
    private SecureUserTokenService customUserDetailsTokenService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
        SecureUser secureUser = (SecureUser) authentication.getPrincipal();

        SecureUserToken userToken = customUserDetailsTokenService.createToken(secureUser);
        String tokenKey = customUserDetailsTokenService.saveToken(userToken);
        String tokenValue = userToken.getToken();

        // 组装返回结果
        Map<String,Object> map = new HashMap<String,Object>(20);
//        map.put("token",tokenValue);
        map.put("tokenKey",tokenKey);
        map.put("username",secureUser.getUsername());
        map.put("authorities", secureUser.getPerms());
//        map.put("secureUser", secureUser);
//        map.put("authorities", UserContext.getAuthorities());


//        Cookie cookie = new Cookie(TokenConstant.TOKEN_HEADER_KEY,tokenKey);
//        cookie.setPath("/");
//        httpServletResponse.addCookie(cookie);

        ServletUtil.writeJson(CommonResult.success(map));
    }
}

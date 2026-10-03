/**
 */
package com.foundation.springsecurity.secure.uutoken;

import com.foundation.springsecurity.constant.TokenConstant;
import com.foundation.springsecurity.secure.services.SecureUser;
import com.foundation.springcontext.configure.IgnoreUrlsConfig;
import com.foundation.springcontext.bean.BeanContext;
import com.foundation.tools.ServletUtil;
import com.framework.web.domain.CommonResult;
import com.framework.web.domain.ResultCode;
import com.framework.web.exception.auth.token.TokenExpiredException;
import com.framework.web.exception.auth.token.TokenValidationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * Date:2021/6/26
 * Title:Token Filter 主要增加 Token 的验证
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public class SecureUserTokenSupport extends OncePerRequestFilter {
    private SecureUserTokenService customUserDetailsTokenService;

    private IgnoreUrlsConfig ignoreUrlsConfig;

    private AntPathMatcher pathMatcher;

    public SecureUserTokenSupport() {
        this.customUserDetailsTokenService = BeanContext.getBean("secureUserTokenService", SecureUserTokenService.class);
        this.ignoreUrlsConfig = BeanContext.getBean(IgnoreUrlsConfig.class);
        this.pathMatcher = BeanContext.getBean(AntPathMatcher.class);
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String tokenKey = null;
        Cookie[] cookies = request.getCookies();
        if(null != cookies){
            for(Cookie cookie:cookies){
                String name = cookie.getName();
                if(TokenConstant.TOKEN_HEADER_KEY.equals(name)){
                    tokenKey = cookie.getValue();
                    break;
                }
            }
        }
        if(null == tokenKey){
            tokenKey = request.getHeader(TokenConstant.TOKEN_HEADER_KEY);
        }
        SecureUser secureUser;

//        SecureUserToken userToken = customUserDetailsTokenService.verifyToken(tokenKey);
//        secureUser = userToken.getSecureUser();
//        // Token校验成功后，重置Token失效时间
//        customUserDetailsTokenService.expire(tokenKey);
        try {
            SecureUserToken userToken = customUserDetailsTokenService.verifyToken(tokenKey);
            secureUser = userToken.getSecureUser();
            // Token校验成功后，重置Token失效时间
            customUserDetailsTokenService.expire(tokenKey);
        } catch (Exception e) {
            //no token: 501
            ServletUtil.writeJson(CommonResult.failure(ResultCode.TOKEN_INVALID));
            return;
        }
//        catch (TokenExpiredException e) {
//            ServletUtil.writeJson(CommonResult.failure(ResultCode.TOKEN_EXPIRED));
////            response.sendRedirect("/site/houseRoom/toLogin");
//            return;
//        }
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(secureUser, secureUser.getId(), secureUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        // 白名单请求直接放行
        return ignoreUrlsConfig.getUrls().stream()
                .anyMatch(path -> pathMatcher.match(path, request.getRequestURI()));
    }
}

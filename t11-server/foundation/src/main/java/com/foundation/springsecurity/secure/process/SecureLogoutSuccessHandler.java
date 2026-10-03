/**
 */
package com.foundation.springsecurity.secure.process;

import com.foundation.springsecurity.constant.TokenConstant;
import com.foundation.springsecurity.secure.uutoken.SecureUserTokenService;
import com.foundation.tools.ServletUtil;
import com.framework.web.domain.CommonResult;
import com.framework.web.domain.ResultCode;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * Date:2021/6/26
 * Title:Security 注销成功处理类
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public class SecureLogoutSuccessHandler implements LogoutSuccessHandler {
    @Resource
    private SecureUserTokenService customUserDetailsTokenService;

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
        String token = httpServletRequest.getHeader(TokenConstant.TOKEN_HEADER).replaceFirst(TokenConstant.TOKEN_PREFIX, "");
        customUserDetailsTokenService.destroyToken(token);

        ServletUtil.writeJson(CommonResult.success(ResultCode.LOGOUT_SUCCESS));
    }
}

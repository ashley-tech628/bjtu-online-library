/**
 */
package com.foundation.springsecurity.secure.process;

import com.foundation.tools.ServletUtil;
import com.framework.web.domain.CommonResult;
import com.framework.web.domain.ResultCode;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * Date:2021/6/26
 * Title:Security 登陆失败处理类
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public class SecureLoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        e.printStackTrace();

        if (e instanceof UsernameNotFoundException) {
            ServletUtil.writeJson(CommonResult.failure(ResultCode.USER_USERNAME_NOT_FOUND));
            return;
        }
        if (e instanceof LockedException) {
            ServletUtil.writeJson(CommonResult.failure(ResultCode.USER_LOCKED));
            return;
        }
        if (e instanceof BadCredentialsException) {
            ServletUtil.writeJson(CommonResult.failure(ResultCode.USER_BAD_CREDENTIALS));
            return;
        }
        if (e instanceof AccountExpiredException) {
            ServletUtil.writeJson(CommonResult.failure(ResultCode.USER_EXPIRED));
            return;
        }
        if (e instanceof DisabledException) {
            ServletUtil.writeJson(CommonResult.failure(ResultCode.USER_NOT_ENABLE));
            return;
        }


        ServletUtil.writeJson(CommonResult.failure(ResultCode.LOGIN_FAILURE));
    }
}

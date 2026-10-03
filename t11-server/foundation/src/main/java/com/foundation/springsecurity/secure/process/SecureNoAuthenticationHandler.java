/**
 */
package com.foundation.springsecurity.secure.process;

import com.foundation.tools.ServletUtil;
import com.framework.web.domain.CommonResult;
import com.framework.web.domain.ResultCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * Date:2021/6/26
 * Title:Security 用户未登陆处理类
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public class SecureNoAuthenticationHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        ServletUtil.writeJson(CommonResult.failure(ResultCode.NOT_LOGIN));
    }
}

/**
 */
package com.foundation.springsecurity.secure.process;

import com.foundation.tools.ServletUtil;
import com.framework.web.domain.CommonResult;
import com.framework.web.domain.ResultCode;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * Date:2021/6/26
 * Title:Security 用户暂无权限处理类
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public class SecureNoPermissionHandler implements AccessDeniedHandler{

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException {
        ServletUtil.writeJson(CommonResult.failure(ResultCode.NOT_PERMISSION));
    }
}

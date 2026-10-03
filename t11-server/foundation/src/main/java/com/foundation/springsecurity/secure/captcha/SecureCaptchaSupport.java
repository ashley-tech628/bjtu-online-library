/**
 */
package com.foundation.springsecurity.secure.captcha;

import com.foundation.springsecurity.constant.SecurityConstant;
import com.foundation.springcontext.bean.BeanContext;
import com.foundation.tools.ServletUtil;
import com.framework.web.domain.CommonResult;
import com.framework.web.domain.ResultCode;
import com.framework.web.exception.auth.captcha.CaptchaExpiredException;
import com.framework.web.exception.auth.captcha.CaptchaValidationException;
import org.apache.logging.log4j.util.Strings;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * Date:2021/6/26
 * Title:Captcha Filter 主要增加 Token 的验证
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public class SecureCaptchaSupport extends OncePerRequestFilter {
    public static final String CAPTCHA_KEY = "captchaKey";
    public static final String CAPTCHA_CODE = "captchaCode";

    private SecureCaptchaService customCaptchaService;

    public SecureCaptchaSupport() {
        this.customCaptchaService = BeanContext.getBean("secureCaptchaService", SecureCaptchaService.class);
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String captchaKey = ServletUtil.getParameter(CAPTCHA_KEY);
        String captchaCode = ServletUtil.getParameter(CAPTCHA_CODE);
        if (Strings.isBlank(captchaKey)) {
            ServletUtil.writeJson(CommonResult.failure(ResultCode.CAPTCHA_KEY_MISSION));
            return;
        }
        if (Strings.isBlank(captchaCode)) {
            ServletUtil.writeJson(CommonResult.failure(ResultCode.CAPTCHA_CODE_MISSION));
            return;
        }
        try {
//            customCaptchaService.verifyCaptcha(captchaKey, captchaCode);
        } catch (CaptchaExpiredException e) {
            ServletUtil.writeJson(CommonResult.failure(ResultCode.CAPTCHA_EXPIRED));
            return;
        } catch (CaptchaValidationException e) {
            ServletUtil.writeJson(CommonResult.failure(ResultCode.CAPTCHA_INVALID));
            return;
        }
//        customCaptchaService.destroyCaptcha(captchaKey);
        chain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        if (SecurityConstant.IS_CAPTCHA_VERIFICATION) {
            if (request.getRequestURI().equals(SecurityConstant.LOGIN_URL) && request.getMethod().equals(SecurityConstant.LOGIN_METHOD)) {
                return false;
            }
            return true;
        }
        return true;
    }
}

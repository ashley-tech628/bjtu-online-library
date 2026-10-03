/**
 */
package com.framework.web.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.framework.web.domain.CommonResult;
import com.framework.web.domain.ResultCode;
import com.framework.web.interceptor.annotation.Submission;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/***
 * Date:2021/6/26
 * Title: 重复提交拦截器
 * Description：对本文件的详细描述，原则上不能少于30字
 * @author Admin
 * @mender：（文件的修改者，文件创建者之外的人）
 * @version 1.0
 * Remark：认为有必要的其他信息
 */
@Component
public class SubmissionInterceptor implements HandlerInterceptor {

    /**
     * 参数
     */
    public final String REPEAT_PARAMS = "repeatParams";

    /**
     * 时间
     */
    public final String REPEAT_TIME = "repeatTime";

    /**
     * 数据
     */
    public final String SESSION_REPEAT_KEY = "repeatData";

    /**
     * 间隔时间，单位:秒 默认10秒
     * <p>
     * 两次相同参数的请求，如果间隔时间大于该参数，系统不会认定为重复提交的数据
     */
    private int intervalTime = 10;

    /**
     * 设置，间隔时间
     */
    public void setIntervalTime(int intervalTime) {
        this.intervalTime = intervalTime;
    }

//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        if (handler instanceof HandlerMethod) {
//            HandlerMethod handlerMethod = (HandlerMethod) handler;
//            Method method = handlerMethod.getMethod();
//            Submission annotation = method.getAnnotation(Submission.class);
//            if (annotation != null) {
//                if (this.isRepeatSubmit(request)) {
//                    ServletUtil.writeJson(CommonResult.failure(ResultCode.REPEAT_SUBMIT));
//                    return false;
//                }
//            }
//        }
//
//        return true;
//    }

    public boolean isRepeatSubmit(HttpServletRequest request) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String nowParams = objectMapper.writeValueAsString((request.getParameterMap()));
        Map<String, Object> nowDataMap = new HashMap<String, Object>(100);
        nowDataMap.put(REPEAT_PARAMS, nowParams);
        nowDataMap.put(REPEAT_TIME, System.currentTimeMillis());

        String url = request.getRequestURI();

        HttpSession session = request.getSession();
        Object sessionObj = session.getAttribute(SESSION_REPEAT_KEY);
        if (sessionObj != null) {
            Map<String, Object> sessionMap = (Map<String, Object>) sessionObj;
            if (sessionMap.containsKey(url)) {
                Map<String, Object> preDataMap = (Map<String, Object>) sessionMap.get(url);
                if (compareParams(nowDataMap, preDataMap) && compareTime(nowDataMap, preDataMap)) {
                    return true;
                }
            }
        }
        Map<String, Object> sessionMap = new HashMap<String, Object>(100);
        sessionMap.put(url, nowDataMap);
        session.setAttribute(SESSION_REPEAT_KEY, sessionMap);
        return false;
    }


    /**
     * 判断参数是否相同
     */
    private boolean compareParams(Map<String, Object> nowMap, Map<String, Object> preMap) {
        String nowParams = (String) nowMap.get(REPEAT_PARAMS);
        String preParams = (String) preMap.get(REPEAT_PARAMS);
        return nowParams.equals(preParams);
    }

    /**
     * 判断两次间隔时间
     */
    private boolean compareTime(Map<String, Object> nowMap, Map<String, Object> preMap) {
        int limit  = 1000;
        long time1 = (Long) nowMap.get(REPEAT_TIME);
        long time2 = (Long) preMap.get(REPEAT_TIME);
        if ((time1 - time2) < (this.intervalTime * limit)) {
            return true;
        }
        return false;
    }
}

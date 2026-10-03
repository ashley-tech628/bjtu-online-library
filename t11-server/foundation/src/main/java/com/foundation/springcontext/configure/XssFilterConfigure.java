/**
 */
package com.foundation.springcontext.configure;

import com.framework.common.xss.XssFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.HashMap;
import java.util.Map;
import jakarta.servlet.Filter;
/*** 
 * 创建日期:2021/7/5
 * Title: xss过滤拦截器配置文件
 * 
 */
@Configuration
public class XssFilterConfigure {

    /**
     * xss过滤拦截器
     */
    @Bean
    public FilterRegistrationBean xssFilterRegistrationBean() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        Filter filter = new XssFilter();
        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.setOrder(Integer.MAX_VALUE-1);
        filterRegistrationBean.setEnabled(true);
        filterRegistrationBean.addUrlPatterns("/*");
        Map<String, String> initParameters = new HashMap<>(20);
        //excludes用于配置不需要参数过滤的请求url
        initParameters.put("excludes", "/favicon.ico,/img/*,/js/*,/css/*");
        //isIncludeRichText主要用于设置富文本内容是否需要过滤
        initParameters.put("isIncludeRichText", "true");
        filterRegistrationBean.setInitParameters(initParameters);
        return filterRegistrationBean;
    }
}


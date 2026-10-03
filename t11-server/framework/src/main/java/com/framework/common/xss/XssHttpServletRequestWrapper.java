/**
 */
package com.framework.common.xss;

import org.apache.commons.lang3.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

/*** 
 * 创建日期:2021/7/5
 * Title: 重写请求参数处理函数
 * 
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

    HttpServletRequest orgRequest = null;

    private boolean isIncludeRichText = false;

    public XssHttpServletRequestWrapper(HttpServletRequest request, boolean isIncludeRichText) {
        super(request);
        orgRequest = request;
        this.isIncludeRichText = isIncludeRichText;
    }

    /**
     * 覆盖getParameter方法，将参数名和参数值都做xss过滤.
     * 如果需要获得原始的值，则通过super.getParameterValues(name)来获取
     * getParameterNames,getParameterValues和getParameterMap也可能需要覆盖
     */
    @Override
    public String getParameter(String name) {
        String content = "content";
        String withHtml = "WithHtml";
        boolean isResult = (content.equals(name) || name.endsWith(withHtml)) && !isIncludeRichText;
        if (isResult) {
            return super.getParameter(name);
        }
        name = XssUtil.clean(name);
        String value = super.getParameter(name);
        if (StringUtils.isNotBlank(value)) {
            value = XssUtil.clean(value);
        }
        return value;
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] arr = super.getParameterValues(name);
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = XssUtil.clean(arr[i]);
            }
        }
        return arr;
    }


    /**
     * 覆盖getHeader方法，将参数名和参数值都做xss过滤。<br/>
     * 如果需要获得原始的值，则通过super.getHeaders(name)来获取<br/>
     * getHeaderNames 也可能需要覆盖
     */
    @Override
    public String getHeader(String name) {
        name = XssUtil.clean(name);
        String value = super.getHeader(name);
        if (StringUtils.isNotBlank(value)) {
            value = XssUtil.clean(value);
        }
        return value;
    }

    /**
     * 获取最原始的request
     *
     * @return
     */
    public HttpServletRequest getOrgRequest() {
        return orgRequest;
    }

    /**
     * 获取最原始的request的静态方法
     *
     * @return
     */
    public static HttpServletRequest getOrgRequest(HttpServletRequest req) {
        if (req instanceof XssHttpServletRequestWrapper) {
            return ((XssHttpServletRequestWrapper) req).getOrgRequest();
        }
        return req;
    }

}


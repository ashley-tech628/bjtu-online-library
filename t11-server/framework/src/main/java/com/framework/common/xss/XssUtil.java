/**
 */
package com.framework.common.xss;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Safelist;

import java.util.HashSet;
import java.util.Set;

/***
 * 创建日期:2021/7/5
 * Title: XSS非法标签过滤
 * 
 */
@Slf4j
public class XssUtil {

    /** sql注入关键字 */
    private static final String SQLKEYS = "and|exec|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|;|or|+|$|..";
    /** sql注入关键字集合 */
    private static Set<String> notAllowedKeyWords = new HashSet<String>(0);
    private static final String REPLACEDSTRING = "INVALID";

    /**
     * 使用自带的basicWithImages 白名单
     * 允许的便签有a,b,blockquote,br,cite,code,dd,dl,dt,em,i,li,ol,p,pre,q,small,span,
     * strike,strong,sub,sup,u,ul,img
     * 以及a标签的href,img标签的src,align,alt,height,width,title属性
     */
    private static final Safelist WHITELIST = Safelist.basicWithImages();

    /** 配置过滤化参数,不对代码进行格式化 */
    private static final Document.OutputSettings OUTPUTSETTINGS = new Document.OutputSettings().prettyPrint(false);
    static {
        // 富文本编辑时一些样式是使用style来进行实现的
        // 比如红色字体 style="color:red;"
        // 所以需要给所有标签添加style属性
        WHITELIST.addAttributes(":all", "style");
        // 将sql关键字写入集合
        String[] keyStr = SQLKEYS.split("\\|");
        for (String str : keyStr) {
            notAllowedKeyWords.add(str);
        }
    }

    /** 清除sql关键字 */
    public static String cleanSqlKeyWords(String value) {
        String paramValue = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        paramValue = paramValue.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
        paramValue = paramValue.replaceAll("eval\\((.*)\\)", "");
        paramValue = paramValue.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
        paramValue = paramValue.replaceAll("script", "");

        for (String keyword : notAllowedKeyWords) {
            boolean isResult = paramValue.length() >= keyword.length() && (paramValue.trim().contains(keyword) || paramValue.trim().contains(keyword.toUpperCase()));
            if (isResult) {
                paramValue = StringUtils.replace(paramValue, keyword, REPLACEDSTRING);
                log.error("已被过滤，因为参数中包含不允许sql的关键词(" + keyword
                        + ")" + ";参数：" + value + ";过滤后的参数：" + paramValue);
            }
        }
        return paramValue;
    }

    public static String clean(String content) {
        //清除sql关键字
        // content = cleanSqlKeyWords(content);
        return Jsoup.clean(content, "", WHITELIST, OUTPUTSETTINGS);
    }
}


/**
 */
package com.framework.web.interceptor.annotation;

import java.lang.annotation.*;

/***
 * Date:2021/6/26
 * Title: 重复提交注解
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Submission {

}

/**
 */
package com.framework.common.aop.annotation;

import com.framework.common.aop.enums.Action;

import java.lang.annotation.*;

/***
 * Date:2021/6/26
 * Title:行为日志注解
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Log {

    /**
     * Title 日志标题
     */
    String title() default "暂无标题";

    /**
     * Describe 日志描述
     */
    String describe() default "暂无描述";

    /**
     * Action 操作类型（默认查询操作）
     */
    Action action() default Action.QUERY;

}

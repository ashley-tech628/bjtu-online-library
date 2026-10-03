/**
 */
package com.framework.web.interceptor.enums;

/***
 * Date:2021/6/26
 * Title: 接口权限限制
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public enum Scope {

    /**
     * 全部
     */
    ALL,

    /**
     * 自己
     */
    SELF,

    /**
     * 部门
     */
    DEPT,

    /**
     * 部门 及其 子部门
     */
    DEPT_CHILD,

    /**
     * 自动
     */
    AUTO,

    /**
     * 自定义
     */
    CUSTOM

}

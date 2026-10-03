/**
 */
package com.framework.web.interceptor.annotation;

import com.framework.web.interceptor.enums.Scope;

/***
 * Date:2021/6/26
 * Title: 数据权限注解
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public @interface DataScope {

    /**
     * 自动模式
     * Auto模式下根据用户角色定义规则过滤数据
     * 非 Auto 模式下, 采用强制数据权限过滤，即用户角色定义的规则失效
     */
    Scope scope() default Scope.AUTO;
}

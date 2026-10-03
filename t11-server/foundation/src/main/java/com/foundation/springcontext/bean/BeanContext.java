/**
 */
package com.foundation.springcontext.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/***
 * Date:2021/6/26
 * Title:Bean相关上下文
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public class BeanContext implements ApplicationContextAware {

    /**
     * Spring Ioc上下文
     */
    public static ApplicationContext applicationContext;

    /**
     * 设置Spring上下文
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanContext.applicationContext = applicationContext;
    }

    /**
     * 获取Bean实体
     */
    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    /**
     * 获取Bean实例
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return applicationContext.getBean(name, clazz);
    }

    /**
     * 获取Bean实例
     */
    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    /**
     * Bean是否存在
     */
    public static boolean containsBean(String name) {
        return applicationContext.containsBean(name);
    }

    /**
     * Bean是否为单例
     */
    public static boolean isSingleton(String name) {
        return applicationContext.isSingleton(name);
    }

    /**
     * 获取Bean类型
     */
    public static Class<? extends Object> getType(String name) {
        return applicationContext.getType(name);
    }

}

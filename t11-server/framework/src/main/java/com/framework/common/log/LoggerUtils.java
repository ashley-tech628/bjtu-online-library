/**
 */
package com.framework.common.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * Date:2021/7/24
 * Title:日志工具类
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public class LoggerUtils {

    /**
     * Function:
     * Author: Admin
     * Date:2021/7/24
      * @param clazz
     * @return org.slf4j.Logger
     * @throws Exception
     */
    public static <T> Logger logger(Class<T> clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    /**
     * Function:打印到指定的文件下
     * Author: Admin
     * Date:2021/7/24
      * @param desc
     * @return org.slf4j.Logger
     * @throws Exception
     */
    public static Logger logger(LogFileName desc) {
        return LoggerFactory.getLogger(desc.getLogFileName());
    }

}

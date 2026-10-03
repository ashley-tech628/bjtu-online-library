/**
 */
package com.framework.web.exception.base;

/***
 * Date:2021/6/26
 * Title: 业务异常类
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}
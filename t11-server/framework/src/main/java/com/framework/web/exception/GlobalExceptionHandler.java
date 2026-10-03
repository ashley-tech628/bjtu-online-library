/**
 */
package com.framework.web.exception;

import com.framework.web.domain.CommonResult;
import com.framework.web.exception.base.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/***
 * Date:2021/6/26
 * Title: 公共全局异常类
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 不支持的请求类型
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public CommonResult handleException(HttpRequestMethodNotSupportedException e) {
        return CommonResult.failure("不支持" + e.getMethod() + "请求");
    }

    /**
     * 未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public CommonResult notFount(RuntimeException e) {
        e.printStackTrace();
        return CommonResult.failure("运行时异常：" + e.getMessage());
    }

    /**
     * 未知的运行时异常
     */
    @ExceptionHandler(SQLSyntaxErrorException.class)
    public CommonResult notColumn(RuntimeException e) {
        e.printStackTrace();
        return CommonResult.failure("列不存在：" + e.getMessage());
    }

    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public CommonResult handleException(Exception e) {
        e.printStackTrace();
        return CommonResult.failure("服务器错误，请联系管理员");
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public CommonResult businessException(HttpServletRequest request, BusinessException e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return CommonResult.failure(e.getMessage());
    }

    // FIXME 将绑定参数异常合并 2021-11-06 bxy

    /**
     * 处理formdata方式调用接口校验失败抛出的异常
     */
    @ExceptionHandler(BindException.class)
    public CommonResult bindExceptionHandler(BindException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<String> collect = fieldErrors.stream().map(o -> o.getDefaultMessage()).collect(Collectors.toList());
        return CommonResult.result(400, collect, "Bad Request");
    }

    /**
     * 处理json请求体调用接口校验失败抛出的异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<String> collect = fieldErrors.stream().map(o -> o.getDefaultMessage()).collect(Collectors.toList());
        return CommonResult.result(400, collect, "Bad Request");
    }

    /**
     * 处理单个参数校验失败抛出的异常
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public CommonResult constraintViolationExceptionHandler(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        List<String> collect = constraintViolations.stream().map(o -> o.getMessage()).collect(Collectors.toList());
        return CommonResult.result(400, collect, "Bad Request");
    }
}

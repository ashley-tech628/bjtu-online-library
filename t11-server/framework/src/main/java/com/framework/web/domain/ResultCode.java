/**
 */
package com.framework.web.domain;

/***
 * Date:2021/6/26
 * Title: Rest状态码
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public enum ResultCode {
    /**
     * 成功
     */
    SUCCESS(0, "成功"),
    /**
     * 失败
     */
    FAILURE(-1, "失败"),
    /**
     * 登录成功
     */
    LOGIN_SUCCESS(200, "登录成功"),
    /**
     * 注销成功
     */
    LOGOUT_SUCCESS(200, "注销成功"),
    /**
     * 未登录
     */
    NOT_LOGIN(401, "未登录"),
    /**
     * 未授权
     */
    NOT_PERMISSION(403, "未授权"),
    /**
     * 登录失败
     */
    LOGIN_FAILURE(500, "登录失败"),
    /**
     * 验证码过期
     */
    CAPTCHA_EXPIRED(500, "验证码过期"),
    /**
     * 验证码无效
     */
    CAPTCHA_INVALID(500, "验证码无效"),
    /**
     * 验证码 KEY 缺失
     */
    CAPTCHA_KEY_MISSION(500, "验证码KEY缺失"),
    /**
     * 验证码 CODE 缺失
     */
    CAPTCHA_CODE_MISSION(500, "验证码CODE缺失"),
    /**
     * Token无效
     */
    TOKEN_INVALID(501, "Token无效"),
    /**
     * Token过期
     */
    TOKEN_EXPIRED(502, "Token过期"),
    /**
     * Token缺失
     */
    TOKEN_MISSION(503, "Token缺失"),
    /**
     * 用户锁定
     */
    USER_LOCKED(601, "用户锁定"),
    /**
     * 用户不存在
     */
    USER_USERNAME_NOT_FOUND(602, "用户不存在"),
    /**
     * 密码不正确
     */
    USER_BAD_CREDENTIALS(603, "密码不正确"),
    /**
     * 账户过期
     */
    USER_EXPIRED(604, "账户过期"),
    /**
     * 用户未启用
     */
    USER_NOT_ENABLE(605, "用户未启用"),

    /**
     * 不允许重复提交，请稍后再试
     */
    REPEAT_SUBMIT(701, "不允许重复提交，请稍后再试"),

    /***
     * 企业微信网页授权登录 - 获取访问用户身份参数异常
     */
    WECHAT_GETUSERINFO_PARAMS_ERRORS(1001, "获取访问用户身份参数异常")

    ;

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


    public ResultCode build(String msg, Object... param) {
        this.msg = String.format(msg, param);
        return this;
    }

    public ResultCode param(Object... param) {
        msg = String.format(msg, param);
        return this;
    }


    /**
     * 功能:获取异常码对象，默认返回SYSTEM_BUSY
     * 作者: Admin
     * 创建日期:2020/3/19
     * 参数:[code]
     * 返回:com.bjtuwh.platform.exception.code.ExceptionCode
     */
    public static ResultCode getExceptionCodeByDefaultError(int code){
        for (ResultCode exCode:values()
        ) {
            if(exCode.getCode() == code){
                return exCode;
            }
        }
        return FAILURE;
    }

}

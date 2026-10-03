/**
 */
package com.framework.common.aop.enums;

/***
 * Date:2021/6/26
 * Title:日志分类
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public enum Action {

    /**
     * 新增
     */
    ADD("新增"),

    /**
     * 删除
     */
    REMOVE("删除"),

    /**
     * 修改
     */
    EDIT("修改"),

    /**
     * 查询
     */
    QUERY("查询"),

    /**
     * 导入
     */
    IMPORT("导入"),

    /**
     * 导出
     */
    REPORT("导出"),

    /**
     * 上传
     */
    UPLOAD("上传"),

    /**
     * 登录认证
     */
    AUTH("登录认证"),

    /**
     * 报文解析
     */
    ANALYSIS("报文解析"),

    /**
     * 启用
     */
    ACTIVATE("启用"),

    /**
     * 禁用
     */
    DISABLE("禁用"),

    /**
     * 发布
     */
    RELEASE("发布"),

    ;


    private String value;

    private Action(String value){
        this.value = value;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

/**
 * 
 */
package com.framework.web.enums;

import org.apache.commons.lang3.StringUtils;

/***
 * Date:2021/6/26
 * Title:附件上传类型
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public enum FileFromTypeEnum {
    /**
     * 默认
     */
    DEFAULT("0", "", "默认", "other"),

    /////////////////////////////业务系统

    /**
     * 知识库文档
     */
    BUSINESS_DOCDOCUMENT("100", "docdocument", "知识库文档", "docdocument"),

    ;


    /** 调整异常数据 */
    private String type;
    /** 类型标识 */
    private String code;
    /** 类型名称 */
    private String text;
    /** 存储相对路径 */
    private String path;


    private FileFromTypeEnum(String type, String code, String text, String path) {
        this.type = type;
        this.code = code;
        this.text = text;
        this.path = path;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    public static FileFromTypeEnum getEnumByType(String type) {
        for (FileFromTypeEnum obj : values()) {
            if (StringUtils.equals(obj.getType(), type)) {
                return obj;
            }
        }
        return DEFAULT;
    }


}

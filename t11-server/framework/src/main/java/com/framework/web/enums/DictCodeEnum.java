package com.framework.web.enums;

/**
 * DictCodeEnum 字典编码枚举(只存根节点编码枚举)
 * @author bxy
 * @description TODO
 * @date 2021-12-15 11:13:00
 */
public enum DictCodeEnum {

    /** 默认code为空 */
    DEFAULT(""),

    /** 是否有效字典code */
    isValid("is_valid_status"),

    /** 性别字典code */
    gender("gender"),

    /** 身份标识字典code */
    Identity("identification"),

    ;

    DictCodeEnum(String code) {
        this.code = code;
    }

    private String code;

    public String code() {
        return code;
    }

}

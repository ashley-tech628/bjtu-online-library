package com.framework.web.enums;

/**
 * YesAndNoEnum
 * @author bxy
 * @description TODO
 * @date 2021-11-17 18:31:00
 */
public enum YesAndNoEnum {

    /** 0:否 */
    NO("0", "否"),

    /** 1:是 */
    YES("1", "是");

    private String code;

    private String name;

    YesAndNoEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    /**
     * 获取是或否字符串
     */
    public static String getName(String code) {
        YesAndNoEnum yesAndNoEnum = getYesAndNoEnum(code);
        return yesAndNoEnum != null ? yesAndNoEnum.name : "";
    }

    /**
     * 获取是否对应的枚举
     */
    public static YesAndNoEnum getYesAndNoEnum(String code) {
        for (YesAndNoEnum type : YesAndNoEnum.values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        return null;
    }
}

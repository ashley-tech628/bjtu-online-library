/**
 * 
 */
package com.framework.web.enums;

/***
 * Date:2021/6/26
 * Title:是否启用（0表示禁用；1表示启用）
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public enum IsValidEnum {
    /** 0:禁用 */
    VALID_0(0, "禁用", "is_valid_status.invalid"),

    /** 1:启用 */
    VALID_1(1, "启用", "is_valid_status.valid");

    private Integer code;

    private String name;

    private String dictCode;

    IsValidEnum(Integer code, String name, String dictCode) {
        this.code = code;
        this.name = name;
        this.dictCode = dictCode;
    }

    /**
     * Function:根据code来获取对应的name
     * Author: Admin
     * Date:2021/6/26
     * @param code
     * @return java.lang.String
     * @throws Exception
     */
    public static String getName(Integer code) {
        for (IsValidEnum type : IsValidEnum.values()) {
            if (type.code.equals(code)) {
                return type.name;
            }
        }
        return "";
    }

    /**
     * Function:根据code来获取对应的枚举常量
     * Author: Admin
     * Date:2021/6/26
     * @param code
     * @return com.bjtuwh.web.enums.IsValid
     * @throws Exception
     */
    public static IsValidEnum getIsValid(Integer code) {
        for (IsValidEnum type : IsValidEnum.values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        return null;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

/**
 * 
 */
package com.framework.web.enums;

/***
 * Date:2021/6/26
 * Title:性别枚举
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public enum GenderEnum{

    /** 1:男 */
    SEX_M("1", "男","gender.male"),

    /** 2:女 */
    SEX_W("2", "女","gender.female");

    private String code;

    private String name;

    private String dictCode;

    GenderEnum(String code, String name,String dictCode) {
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
    public static String getName(String code) {
        for (GenderEnum type : GenderEnum.values()) {
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
     * @param name
     * @return com.bjtuwh.web.enums.Sex
     * @throws Exception
     */
    public static String getCode(String name) {
        for (GenderEnum type : GenderEnum.values()) {
            if (type.name.equals(name)) {
                return type.code;
            }
        }
        return "";
    }


    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

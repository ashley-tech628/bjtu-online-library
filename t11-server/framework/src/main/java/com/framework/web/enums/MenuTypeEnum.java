/**
 * 
 */
package com.framework.web.enums;

/*** 
 * 创建日期:2021/7/8
 * Title: 菜单类型枚举类
 * 
 */
public enum MenuTypeEnum {

    /** 类型 - 0 目录 */
    TYPE_0(0, "目录"),

    /** 类型 - 1 菜单 */
    TYPE_1(1, "菜单"),

    /** 类型 - 2 按钮 */
    TYPE_2(2, "按钮");

    private Integer code;

    private String name;

    MenuTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * Function: 根据key来获取对应的value
     * Author: chenlei
     * Date:2021/7/8
     * @param code
     * @return java.lang.String
     * @throws Exception
     */
    public static String getMenuTypeName(Integer code) {
        for (MenuTypeEnum type : MenuTypeEnum.values()) {
            if (type.code.equals(code)) {
                return type.name;
            }
        }
        return "";
    }

    /**
     * Function: 根据key来获取对应的枚举常量
     * Author: chenlei
     * Date:2021/7/8
     * @param code
     * @return com.bjtuwh.web.enums.MenuEnum
     * @throws Exception
     */
    public static MenuTypeEnum getMenuType(String code) {
        for (MenuTypeEnum type : MenuTypeEnum.values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        return null;
    }


    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}

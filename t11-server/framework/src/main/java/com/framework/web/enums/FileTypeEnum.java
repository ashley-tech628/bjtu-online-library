package com.framework.web.enums;

/**
 * FileTypeEnum 文件类型枚举
 * 文件类型(1、图片；2、word；3、EXCEL；4、PDF；5、视频)
 * @author bxy
 * @description TODO
 * @date 2021-11-15 23:38:00
 */
public enum FileTypeEnum {

    /** 未知类型 */
    UNKNOWN("0", "未知"),

    /** 图片类型 */
    IMAGE("1", "图片"),

    /** word类型 */
    WORD("2", "word"),

    /** excel类型 */
    EXCEL("3", "EXCEL"),

    /** PDF类型 */
    PDF("4", "word"),

    /** 视频类型 */
    VIDEO("5", "视频"),
    ;

    private String code;

    private String name;

    FileTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }


    public String getName() {
        return name;
    }

}

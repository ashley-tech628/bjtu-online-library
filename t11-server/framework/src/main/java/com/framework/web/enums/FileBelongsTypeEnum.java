package com.framework.web.enums;

/**
 * FileBelongsTypeEnum
 * @author bxy
 * @description TODO
 * @date 2021-11-16 20:56:00
 */
public enum FileBelongsTypeEnum {

    /** 图片类型 */
    RESUME("0", "简历"),

    /** 派遣证明 */
    DISPATCH_CERTIFICATE("1", "派遣证明"),

    /** 协议 */
    EMLOYMENT("2", "协议"),

    /** 无犯罪证明 */
    NONCRIMINAL_RECORD("3", "无犯罪证明"),

    /** 学位证 */
    DEGREE_CERTIFICATE("4", "学位证"),

    /** 教学证书 */
    TEACHER_CERTIFICATE("5", "教学证书"),

    /** 同行家属护照 */
    FAMILY_PASSPORTS  ("6","同行家属护照") ,

    /** 家属身份证明 */
    FAMILY_IDENTIFICATION ("7","家属身份证明"),

    /** 护照信息页归属 */
    PASSPORT_PAGE("8", "护照信息页归属"),

    /** 护照签证页归属 */
    PASSPORT_VISA_PAGE("9", "护照签证页归属"),

    /** 入境章页归属 */
    ENTRY_STAMP_PAGE("10", "入境章页归属"),

    /** 上传可用签证 */
    AVAILABLE_VISA_PAGE("15", "上传可用签证"),



    ;

    private String code;

    private String name;

    FileBelongsTypeEnum(String code, String name) {
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
     * 按code获取区域名称
     * @param code 位置编码
     * @return 区域名称
     */
    public static String getName(String code) {
        FileBelongsTypeEnum fileBelongsTypeEnum = getFileBelongsTypeEnum(code);
        return fileBelongsTypeEnum != null ? fileBelongsTypeEnum.name : "";
    }

    /**
     * 按code获取区域名称
     * @param code 位置编码
     * @return 区域名称
     */
    public static FileBelongsTypeEnum getFileBelongsTypeEnum(String code) {
        for (FileBelongsTypeEnum type : FileBelongsTypeEnum.values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        return null;
    }
}

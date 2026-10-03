/**
 */
package com.framework.common.constant;

/***
 * Date:2021/6/26
 * Title:静态配置
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public class ControllerConstant {


    /**
     * 系统上传API根路径
     */
    public static final String PREFIX_FILE = "file/";


    /**
     * 基础API根路径 - PC后台
     */
    public static final String PREFIX = "api/";
    public static final String SITE = "site/";

    /**
     * 系统API根路径 - PC后台
     */
    public static final String PREFIX_SYS = PREFIX + "sys/";

    /**
     * 业务API根路径 - PC后台
     */
    public static final String PREFIX_BUSINESS = PREFIX + "business/";

    /**
     * 教师端请求前缀
     */
    public static final String PREFIX_TEACHER = PREFIX + "teacher/";


    /**
     * 基础API根路径 - APP端
     */
    public static final String WEBAPP_PREFIX = "webapi/";

    /**
     * 业务API根路径 - APP端
     */
    public static final String WEBAPP_PREFIX_BUSINESS = WEBAPP_PREFIX + "/business/";

    /**
     * 系统API根路径 - APP端
     */
    public static final String WEBAPP_PREFIX_SYS = WEBAPP_PREFIX + "/sys/";
}

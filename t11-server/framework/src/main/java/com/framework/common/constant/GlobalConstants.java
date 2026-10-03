/**
 * 
 */
package com.framework.common.constant;

/***
 * 创建日期:2020/2/20
 * Title:系统公有常量
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public class GlobalConstants {

    /** 编码 */
    public static final String UTF8 = "UTF-8";

    /** JSON 资源 */
    public static final String CONTENT_TYPE = "application/json; charset=utf-8";

    /** 选择控件参数名称 */
    public static final String MULTI_NAME = "multi";

    /**
     * 资源映射路径 前缀
     */
    public static final String RESOURCE_PREFIX = "/profile";

    /**
     * 默认头像id
     */
    public static final String DEFAULT_AVATAR_ID = "1";

    //-------------------------------------------

    /** 树虚拟根节点ID */
    public static final String TREE_ROOT_ID = "0";

    /** 树虚拟根节点PID */
    public static final String TREE_PARENT_ID = "-1";

    /** 组织架构根节点名称 */
    public static final String ORG_ROOT_NAME = "组织机构管理";


    //--------------------------------------------------

    /** 默认用户登陆密码 */
    public final static String DEFAULT_USER_PASSWORD = java.util.UUID.randomUUID().toString();

    /** 系统默认超级管理员账号id */
    public final static String USER_SYS_ADMIN_ID_DEFAULT = "1";

    /** 系统默认超级管理员账号 */
    public final static String USER_SYS_ADMIN_DEFAULT = "admin";


    /** 系统预约限制时间字典申请约车时间id */
    public final static String DICT_APPLY_TIME_ID = "03d7ce2f2a3211ec83d200ff0a651a65";

    /** 系统预约限制时间字典取消约车时间id */
    public final static String DICT_CANCEL_TIME_ID = "4bd035452a5011ec83d200ff0a651a65";


    /** 超级管理员的UserID */
    public final static String ADMIN_USER_ID = "a5e8c0a63e5111ecb7fd8c1645f0ec25";
}

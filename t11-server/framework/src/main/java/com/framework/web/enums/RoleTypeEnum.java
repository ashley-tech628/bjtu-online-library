/**
 * 
 */
package com.framework.web.enums;

/***
 * Date:2021/6/26
 * Title:角色类型
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public enum RoleTypeEnum {

	/** 类型 - 0 系统类型 */
	TYPE_SYSTEM("0", "系统类型"),

	/** 类型 - 1 业务类型 */
	TYPE_BUSINESS("1", "业务类型");

	private String code;

	private String name;

	private RoleTypeEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	/**
	 *
	 * 功能: 根据key来获取对应的value<br/>
	 * 作者: DSH<br/>
	 * 创建日期: 2016年11月5日<br/>
	 * @param code
	 * @return
	 */
	public static String getName(String code) {
		for (RoleTypeEnum type : RoleTypeEnum.values()) {
			if (type.code.equals(code)) {
				return type.name;
			}
		}
		return "";
	}

	/**
	 * 
	 * 功能: 根据key来获取对应的枚举常量<br/>
	 * 作者: DSH<br/>
	 * 创建日期: 2016年11月5日<br/>
	 * @param code
	 * @return
	 */
	public static RoleTypeEnum getRoleType(String code) {
		for (RoleTypeEnum type : RoleTypeEnum.values()) {
			if (type.code.equals(code)) {
				return type;
			}
		}
		return null;
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

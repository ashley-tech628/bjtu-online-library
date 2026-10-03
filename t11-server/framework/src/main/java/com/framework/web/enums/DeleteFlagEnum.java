/**
 * 
 */
package com.framework.web.enums;

/***
 * Date:2021/6/26
 * Title:删除标记位（0表示未删除；1表示已删除）
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public enum DeleteFlagEnum {
	/** 删除标记位 - 0:未删除 */
	FLAG_0("0", "未删除"),
	
	/** 删除标记位 - 1:已删除 */
	FLAG_1("1", "已删除");
	
	private String code;
	
	private String name;
	
	private DeleteFlagEnum(String code, String name) {
		this.code = code;
		this.name = name;
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
		for (DeleteFlagEnum type : DeleteFlagEnum.values()) {
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
	 * @return com.bjtuwh.web.enums.DeleteFlag
	 * @throws Exception
	 */
	public static DeleteFlagEnum getDeleteFlag(String code) {
		for (DeleteFlagEnum type : DeleteFlagEnum.values()) {
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

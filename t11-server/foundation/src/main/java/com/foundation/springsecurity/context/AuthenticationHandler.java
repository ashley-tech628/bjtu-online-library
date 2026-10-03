/**
 */
package com.foundation.springsecurity.context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/***
 * Date:2021/7/15
 * Title: 帐号认证工具类
 * Description：对本文件的详细描述，原则上不能少于30字
 * @author dyc
 * @mender：（文件的修改者，文件创建者之外的人）
 * @version 1.0
 * Remark：认为有必要的其他信息
 */
@Slf4j
public class AuthenticationHandler {

	/**
	 * Function:获取用户角色信息
	 * Author: dyc
	 * Date:2021/7/15
	 * @param
	 * @return java.util.List<java.lang.String>
	 * @throws Exception
	 */
	public static List<String> getRoles() {
		Authentication authentication = UserContext.getAuthentication();
		if(authentication!=null){
			Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
			List<String> roleIds = new ArrayList<>();
			authorities.stream()
					.forEach(granted -> {
						roleIds.add(granted.getAuthority());
					});
			return roleIds;
		}else{
			log.debug("未获取到登录信息.authentication is blank");
		}

		return new ArrayList<String>();
	}

	/**
	 * Function:是否包含某角色
	 * Author: dyc
	 * Date:2021/7/15
	 * @param roleCode
	 * @return boolean
	 * @throws Exception
	 */
	public static boolean hasRoles(String roleCode) {
		return getRoles().contains(roleCode);
	}

	/**
	 * Function:是否包含角色中的一个
	 * Author: dyc
	 * Date:2021/7/15
	 * @param roleCodes
	 * @return boolean
	 * @throws Exception
	 */
	public static boolean hasRoles(String[] roleCodes) {
		boolean has = false;
		if (roleCodes != null) {
			List<String> roleCodeList = getRoles();
			for (String roleCode : roleCodes) {
				if (roleCodeList.contains(roleCode)) {
					has = true;
					break;
				}
			}
		}
		return has;
	}

}

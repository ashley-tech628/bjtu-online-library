/**
 */
package com.foundation.springsecurity.context;

import com.framework.common.constant.GlobalConstants;
import com.foundation.springsecurity.secure.services.SecureUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

/***
 * Date:2021/6/26
 * Title:系统登录账号相关上下文
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
@Component
public class UserContext {

    /**
     * Function:Authentication认证对象
     * Author: Admin
     * Date:2021/8/25
     * @param
     * @return org.springframework.security.core.Authentication
     * @throws Exception
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * Function:获取SysUser当前用户
     * Author: Admin
     * Date:2021/8/25
     * @param
     * @return com.zhgzjg.common.secure.services.SecureUser
     * @throws Exception
     */
    public static SecureUser getPrincipal() {
        Authentication authentication = getAuthentication();
        Object principal = authentication.getPrincipal();
        try{
            SecureUser secureUser = (SecureUser) principal;
            return secureUser;
        }catch (Exception e){
        }
        return null;
    }

    /**
     * Function:获取用户名
     * Author: Admin
     * Date:2021/8/25
     * @param
     * @return java.lang.String
     * @throws Exception
     */
    public static String getUsername() {
        return getPrincipal().getUsername();
    }

    /**
     * Function:获取用户Id
     * Author: Admin
     * Date:2021/8/25
     * @param
     * @return java.lang.String
     * @throws Exception
     */
    public static String getUserId() {
        SecureUser principal = getPrincipal();
        if(null == principal)return null;
        return principal.getId();
    }

    /**
     * Function:获取机构Id
     * Author: Admin
     * Date:2021/8/25
     * @param
     * @return java.lang.String
     * @throws Exception
     */

    /**
     * 获取当前用户的权限列表
     * @return 权限集合
     */
    public static Set<String> getAuthorities() {
        return getPrincipal().getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());
    }

    /**
     * 是否是超级管理员（依据主键判断）
     * @return true：是，false：否
     */
    public static boolean isAdmin() {
        return GlobalConstants.ADMIN_USER_ID.equals(getUserId());
    }

    /**
     * 是否是超级管理员（依据用户表主键判断）
     * @param userId 用户id
     * @return true：是系统管理员，false：不是系统管理员
     */
    public static boolean isAdmin(String userId) {
        return GlobalConstants.ADMIN_USER_ID.equals(userId);
    }
}

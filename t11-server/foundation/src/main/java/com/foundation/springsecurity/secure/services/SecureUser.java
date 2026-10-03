/**
 * 
 */
package com.foundation.springsecurity.secure.services;

import com.foundation.springsecurity.context.UserContext;
import com.framework.web.base.entity.BaseEntity;
import com.framework.web.enums.IsValidEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/***
 * Date:2021/6/26
 * Title:UserInfo实体, 为安全验证提供支持的公共属性
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class SecureUser extends BaseEntity implements UserDetails, CredentialsContainer {
    /**
     * 角色编码集合 --- app端使用
     */
    private List<String> roles;
    /**
     * 主键
     */
    private String id;

    /**
     * 登录账号
     */
    private String username;
    private String password;



    /**
     * 姓名
     */
    private String realName;



    /**
     * 权限
     */
    private Set<? extends GrantedAuthority> authorities;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }
    public void setAuthorities(Set<? extends GrantedAuthority> authorities){
        this.authorities = authorities;
        this.perms = this.authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());

    }
    private Set<String> perms;


    /**
     * Function:是否上锁，false代表账号上锁（用户帐号已被锁定）
     * Author: Admin
     * Date:2021/6/27
     * @param
     * @return boolean
     * @throws Exception
     */
    @Override
    public boolean isAccountNonLocked() {
        //TODO: 不做上锁处理
        return true;
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public void eraseCredentials() {

    }
}

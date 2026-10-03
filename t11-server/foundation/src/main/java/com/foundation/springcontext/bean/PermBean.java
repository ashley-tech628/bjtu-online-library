package com.foundation.springcontext.bean;

import com.foundation.springsecurity.constant.SecurityConstant;
import org.checkerframework.checker.units.qual.N;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component("pb")
public class PermBean {
    public boolean  hasPerm(String ...perms){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            String authority = grantedAuthority.getAuthority();
            if(SecurityConstant.SUPER_ADMIN.equals(authority)){
                return true;
            }
            for (String perm : perms) {
                if(perm.equals(authority)){
                    return true;
                }
            }
        }
        return false;
    }
}

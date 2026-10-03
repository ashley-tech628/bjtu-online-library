package com.foundation.springsecurity.secure.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component("ex")
public class ExpressionRoot {
    public boolean hasAuthority(String authority){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(null == authentication)return false;
        SecureUser secureUser = (SecureUser) authentication.getPrincipal();
        if(null == secureUser)return false;
        List<String> roles = secureUser.getRoles();
        if(roles !=null && roles.contains("root"))return true;
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        if(authorities !=null && authorities.contains(authority))return true;
        return false;
    }
}

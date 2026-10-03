package com.t11.web.auth.service;

import com.foundation.springsecurity.secure.services.SecureUser;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.framework.web.base.page.PageResponse;
import com.t11.web.auth.entity.AuthUserRoleRelEntity;
import com.t11.web.auth.param.AuthUserRoleRelParam;
import com.framework.web.domain.CommonResult;
import java.util.*;

/***
*
*/
public interface AuthUserRoleRelService {
    SecureUser loadUserByUsername(String username) throws UsernameNotFoundException;

    Long count(AuthUserRoleRelParam authUserRoleRelParam);
    List<AuthUserRoleRelEntity> list(AuthUserRoleRelParam authUserRoleRelParam);
  
    Map<String,List> relateList();
    /**
    * 插入
    * @param authUserRoleRelEntity
    * @return
    */
    boolean create(AuthUserRoleRelEntity authUserRoleRelEntity);

    /**
    * 根据id更新
    */
    boolean update(AuthUserRoleRelEntity authUserRoleRelEntity);
    boolean delete(AuthUserRoleRelParam authUserRoleRelParam);
    /**
    * 根据id查找
    * @param id
    * @return 单条记录
    */
    AuthUserRoleRelEntity get(AuthUserRoleRelParam authUserRoleRelParam);
  

    /**
    *列表-分页
    */
    PageResponse<AuthUserRoleRelEntity> page(AuthUserRoleRelParam authUserRoleRelParam);
    CommonResult importAuthUserRoleRel(List<AuthUserRoleRelEntity> dataList, boolean isUpdateSupport);
    }
        

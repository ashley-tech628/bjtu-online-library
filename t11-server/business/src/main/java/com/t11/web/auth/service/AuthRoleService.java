package com.t11.web.auth.service;

import com.framework.web.base.page.PageResponse;
import com.t11.web.auth.entity.AuthRoleEntity;
import com.t11.web.auth.param.AuthRoleParam;
import com.framework.web.domain.CommonResult;
import java.util.*;

/***
*
*/
public interface AuthRoleService {

    Long count(AuthRoleParam authRoleParam);
    List<AuthRoleEntity> list(AuthRoleParam authRoleParam);
  
    Map<String,List> relateList();
    /**
    * 插入
    * @param authRoleEntity
    * @return
    */
    boolean create(AuthRoleEntity authRoleEntity);

    /**
    * 根据id更新
    */
    boolean update(AuthRoleEntity authRoleEntity);
    boolean delete(AuthRoleParam authRoleParam);
    /**
    * 根据id查找
    * @param id
    * @return 单条记录
    */
    AuthRoleEntity get(AuthRoleParam authRoleParam);
  

    /**
    *列表-分页
    */
    PageResponse<AuthRoleEntity> page(AuthRoleParam authRoleParam);
    CommonResult importAuthRole(List<AuthRoleEntity> dataList, boolean isUpdateSupport);
    }
        

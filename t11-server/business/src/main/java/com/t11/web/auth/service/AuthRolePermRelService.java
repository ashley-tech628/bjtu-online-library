package com.t11.web.auth.service;

import com.framework.web.base.page.PageResponse;
import com.t11.web.auth.entity.AuthRolePermRelEntity;
import com.t11.web.auth.param.AuthRolePermRelParam;
import com.framework.web.domain.CommonResult;
import java.util.*;

/***
*
*/
public interface AuthRolePermRelService {

    Long count(AuthRolePermRelParam authRolePermRelParam);
    List<AuthRolePermRelEntity> list(AuthRolePermRelParam authRolePermRelParam);
  
    Map<String,List> relateList();
    /**
    * 插入
    * @param authRolePermRelEntity
    * @return
    */
    boolean create(AuthRolePermRelEntity authRolePermRelEntity);

    /**
    * 根据id更新
    */
    boolean update(AuthRolePermRelEntity authRolePermRelEntity);
    boolean delete(AuthRolePermRelParam authRolePermRelParam);
    /**
    * 根据id查找
    * @param id
    * @return 单条记录
    */
    AuthRolePermRelEntity get(AuthRolePermRelParam authRolePermRelParam);
  

    /**
    *列表-分页
    */
    PageResponse<AuthRolePermRelEntity> page(AuthRolePermRelParam authRolePermRelParam);
    CommonResult importAuthRolePermRel(List<AuthRolePermRelEntity> dataList, boolean isUpdateSupport);
    }
        

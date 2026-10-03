package com.t11.web.auth.service;

import com.framework.web.base.page.PageResponse;
import com.t11.web.auth.entity.AuthUserEntity;
import com.t11.web.auth.param.AuthUserParam;
import com.framework.web.domain.CommonResult;
import java.util.*;

/***
*
*/
public interface AuthUserService {

    Long count(AuthUserParam authUserParam);
    Long count(AuthUserEntity authUserEntity);
    List<AuthUserEntity> list(AuthUserParam authUserParam);
  
    Map<String,List> relateList();
    /**
    * 插入
    * @param authUserEntity
    * @return
    */
    boolean create(AuthUserEntity authUserEntity);

    /**
    * 根据id更新
    */
    boolean update(AuthUserEntity authUserEntity);
    boolean delete(AuthUserParam authUserParam);
    /**
    * 根据id查找
    * @param id
    * @return 单条记录
    */
    AuthUserEntity get(AuthUserParam authUserParam);
  

    /**
    *列表-分页
    */
    PageResponse<AuthUserEntity> page(AuthUserParam authUserParam);
    CommonResult importAuthUser(List<AuthUserEntity> dataList, boolean isUpdateSupport);
    }
        

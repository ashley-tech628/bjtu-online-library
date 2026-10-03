package com.t11.web.auth.service;

import com.framework.web.base.page.PageResponse;
import com.t11.web.auth.entity.AuthPermEntity;
import com.t11.web.auth.param.AuthPermParam;
import com.framework.web.domain.CommonResult;
import java.util.*;

/***
*
*/
public interface AuthPermService {

    Long count(AuthPermParam authPermParam);
    List<AuthPermEntity> list(AuthPermParam authPermParam);
  
    Map<String,List> relateList();
    /**
    * 插入
    * @param authPermEntity
    * @return
    */
    boolean create(AuthPermEntity authPermEntity);

    /**
    * 根据id更新
    */
    boolean update(AuthPermEntity authPermEntity);
    boolean delete(AuthPermParam authPermParam);
    /**
    * 根据id查找
    * @param id
    * @return 单条记录
    */
    AuthPermEntity get(AuthPermParam authPermParam);
  

    /**
    *列表-分页
    */
    PageResponse<AuthPermEntity> page(AuthPermParam authPermParam);
    CommonResult importAuthPerm(List<AuthPermEntity> dataList, boolean isUpdateSupport);
    }
        

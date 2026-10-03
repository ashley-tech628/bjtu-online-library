package com.t11.web.userDetails.service;

import com.framework.web.base.page.PageResponse;
import com.framework.web.domain.CommonResult;
import com.t11.web.house.entity.HouseRegionEntity;
import com.t11.web.house.param.HouseRegionParam;
import com.t11.web.userDetails.entity.UserDetailsEntity;
import com.t11.web.userDetails.param.UserDetailsParam;

import java.util.List;
import java.util.Map;

public interface UserDetailsBooksService {

    List<UserDetailsEntity> list(UserDetailsParam userDetailsParam);

    Map<String,List> relateList();

    UserDetailsEntity get(UserDetailsParam userDetailsParam);

    /**
     * insert
     * @param userDetailsEntity
     * @return
     */
    boolean create(UserDetailsEntity userDetailsEntity);

    /**
     * update according to id
     */
    boolean update(UserDetailsEntity userDetailsEntity);
    boolean delete(UserDetailsParam userDetailsParam);
    PageResponse<UserDetailsEntity> page(UserDetailsParam userDetailsParam);


//    CommonResult importHouseRegion(List<UserDetailsEntity> dataList, boolean isUpdateSupport);


    Long count(UserDetailsParam userDetailsParam);

    CommonResult importUserDetails(List<UserDetailsEntity> list, boolean b);
}

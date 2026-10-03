package com.t11.web.userDetails.controller;

import com.foundation.springsecurity.context.UserContext;
import com.foundation.tools.ExcelUtil;
import com.t11.web.house.entity.HouseRegionEntity;
import com.t11.web.house.param.HouseRegionParam;
import com.t11.web.userDetails.entity.UserDetailsEntity;
import com.framework.common.constant.ControllerConstant;
import com.framework.web.base.controller.BaseController;
import com.framework.web.domain.CommonResult;
import com.t11.web.userDetails.param.UserDetailsParam;
import com.t11.web.userDetails.service.UserDetailsBooksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang3.StringUtils;

import jakarta.annotation.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/***
 *
 */
@Slf4j
@RestController
@RequestMapping(ControllerConstant.PREFIX + "userDetails")
public class UserDetailsController extends BaseController {
    @Resource
    private UserDetailsBooksService userDetailsService;

    @PostMapping("list")
    public CommonResult list(@RequestBody UserDetailsParam userDetailsParam){
        List<UserDetailsEntity> list = userDetailsService.list(userDetailsParam);
        return CommonResult.success(list);
    }
    @PostMapping("get")
    public CommonResult get(@RequestBody UserDetailsParam userDetailsParam) {
        UserDetailsEntity entity =  userDetailsService.get(userDetailsParam);
        return CommonResult.success(entity);
    }
    @PostMapping("relateList")
    public CommonResult relateList() {
        Map<String,List> map = userDetailsService.relateList();
        return CommonResult.success(map);
    }
    @PostMapping("create")
    public CommonResult create(@RequestBody UserDetailsEntity userDetailsEntity) {
        verifyEntity(userDetailsEntity);
        boolean result = userDetailsService.create(userDetailsEntity);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("insert failure");
        }
    }
    @PostMapping("update")
    public CommonResult update(@RequestBody UserDetailsEntity userDetailsEntity) {
        boolean result = userDetailsService.update(userDetailsEntity);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("update failure");
        }
    }

    @PostMapping("delete")
    public CommonResult delete(@RequestBody UserDetailsParam userDetailsParam) {
        String id = userDetailsParam.getUser_id();
        if(StringUtils.isEmpty(id)) {
            return null;
        }
        boolean result = userDetailsService.delete(userDetailsParam);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("delete failure");
        }
    }

    @PostMapping("page")
    public CommonResult page(@RequestBody UserDetailsParam userDetailsParam) {
        return CommonResult.success(userDetailsService.page(userDetailsParam));
    }
    @PostMapping("getID")
    public String getID()
    {
        return UserContext.getUserId();
    }

//    @PostMapping("getEntity")
//    public UserDetailsEntity getEntity(@RequestBody UserDetailsParam userDetailsParam) {
//        UserDetailsEntity entity =  userDetailsService.get(userDetailsParam);
//        return entity;
//    }
    private void verifyEntity(UserDetailsEntity userDetailsParam){

    }

    @PostMapping("importExcel")
    public CommonResult importExcel(MultipartFile file) throws Exception {
        ExcelUtil<UserDetailsEntity> excelUtil = new ExcelUtil<>(UserDetailsEntity.class);
        List<UserDetailsEntity> list = excelUtil.importExcel(file.getInputStream());
        return userDetailsService.importUserDetails(list, true);
    }
    @PostMapping("exportExcel")
    public CommonResult exportExcel(UserDetailsParam userDetailsParam) throws Exception {
        List<UserDetailsEntity> list = userDetailsService.list(userDetailsParam);
        ExcelUtil<UserDetailsEntity> excelUtil = new ExcelUtil<>(UserDetailsEntity.class);
        return excelUtil.exportExcel(list, "userDetails");
    }

    @PostMapping("count")
    public CommonResult count(@RequestBody UserDetailsParam userDetailsParam){
        Long count = userDetailsService.count(userDetailsParam);
        return CommonResult.success(count);
    }


}

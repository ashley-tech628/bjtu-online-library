package com.t11.web.auth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import com.foundation.springsecurity.secure.services.SecureUser;
import org.springframework.security.core.Authentication;
import com.framework.common.constant.ControllerConstant;
import com.framework.web.base.controller.BaseController;
import com.framework.web.domain.CommonResult;
import com.t11.web.auth.entity.AuthUserEntity;
import com.t11.web.auth.param.AuthUserParam;
import com.t11.web.auth.service.AuthUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import com.foundation.tools.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang3.StringUtils;

import jakarta.annotation.Resource;
import java.util.*;

/***
 * 
 */
@Slf4j
@RestController
@RequestMapping(ControllerConstant.PREFIX + "authUser/manager")
public class AuthUserManagerController extends BaseController {
    @Resource
    private AuthUserService authUserService;
    @PostMapping("getPerms")
    public CommonResult getPerms(String username){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(null == authentication)return null;
        SecureUser secureUser = (SecureUser) authentication.getPrincipal();
        return CommonResult.success(secureUser.getPerms());
    }
    @PostMapping("count")
    @PreAuthorize("@pb.hasPerm('authUser.read')")
    public CommonResult count(@RequestBody AuthUserParam authUserParam){
        Long count = authUserService.count(authUserParam);
        return CommonResult.success(count);
    }
    @PostMapping("list")
    @PreAuthorize("@pb.hasPerm('authUser.read')")
    public CommonResult list(@RequestBody AuthUserParam authUserParam){
        List<AuthUserEntity> list = authUserService.list(authUserParam);
        return CommonResult.success(list);
    }
    @PostMapping("get")
    @PreAuthorize("@pb.hasPerm('authUser.read')")
    public CommonResult get(@RequestBody AuthUserParam authUserParam) {
        AuthUserEntity entity =  authUserService.get(authUserParam);
        return CommonResult.success(entity);
    }
    @PostMapping("relateList")
    @PreAuthorize("@pb.hasPerm('authUser.read')")
    public CommonResult relateList() {
        Map<String,List> map = authUserService.relateList();
        return CommonResult.success(map);
    }
    @PostMapping("create")
    @PreAuthorize("@pb.hasPerm('authUser.write')")
    public CommonResult create(@RequestBody AuthUserEntity authUserEntity) {
        verifyEntity(authUserEntity);
        boolean result = authUserService.create(authUserEntity);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("插入失败");
        }
    }
    @PostMapping("update")
    @PreAuthorize("@pb.hasPerm('authUser.write')")
    public CommonResult update(@RequestBody AuthUserEntity authUserEntity) {
        boolean result = authUserService.update(authUserEntity);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("更新失败");
        }
    }

    @PostMapping("delete")
    @PreAuthorize("@pb.hasPerm('authUser.write')")
    public CommonResult delete(@RequestBody AuthUserParam authUserParam) {
        String id = authUserParam.getId();
        if(StringUtils.isEmpty(id))return null;
        boolean result = authUserService.delete(authUserParam);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("删除失败");
        }
    }

    @PostMapping("page")
    @PreAuthorize("@pb.hasPerm('authUser.read')")
    public CommonResult page(@RequestBody AuthUserParam authUserParam) {
        return CommonResult.success(authUserService.page(authUserParam));
    }
    private void verifyEntity(AuthUserEntity authUserEntity){
       
    }
    @PostMapping("importExcel")
    @PreAuthorize("@pb.hasPerm('authUser.write')")
    public CommonResult importExcel(MultipartFile file) throws Exception {
        ExcelUtil<AuthUserEntity> excelUtil = new ExcelUtil<>(AuthUserEntity.class);
        List<AuthUserEntity> list = excelUtil.importExcel(file.getInputStream());
        return authUserService.importAuthUser(list, true);
    }
    @PostMapping("exportExcel")
    @PreAuthorize("@pb.hasPerm('authUser.read')")
    public CommonResult exportExcel(AuthUserParam authUserParam) throws Exception {
        List<AuthUserEntity> list = authUserService.list(authUserParam);
        ExcelUtil<AuthUserEntity> excelUtil = new ExcelUtil<>(AuthUserEntity.class);
        return excelUtil.exportExcel(list, "authUser");
    }
}


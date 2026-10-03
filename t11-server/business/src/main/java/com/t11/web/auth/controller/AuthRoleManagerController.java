package com.t11.web.auth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import com.foundation.springsecurity.secure.services.SecureUser;
import org.springframework.security.core.Authentication;
import com.framework.common.constant.ControllerConstant;
import com.framework.web.base.controller.BaseController;
import com.framework.web.domain.CommonResult;
import com.t11.web.auth.entity.AuthRoleEntity;
import com.t11.web.auth.param.AuthRoleParam;
import com.t11.web.auth.service.AuthRoleService;
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
@RequestMapping(ControllerConstant.PREFIX + "authRole/manager")
public class AuthRoleManagerController extends BaseController {
    @Resource
    private AuthRoleService authRoleService;
    @PostMapping("count")
    @PreAuthorize("@pb.hasPerm('authRole.read')")
    public CommonResult count(@RequestBody AuthRoleParam authRoleParam){
        Long count = authRoleService.count(authRoleParam);
        return CommonResult.success(count);
    }
    @PostMapping("list")
    @PreAuthorize("@pb.hasPerm('authRole.read')")
    public CommonResult list(@RequestBody AuthRoleParam authRoleParam){
        List<AuthRoleEntity> list = authRoleService.list(authRoleParam);
        return CommonResult.success(list);
    }
    @PostMapping("get")
    @PreAuthorize("@pb.hasPerm('authRole.read')")
    public CommonResult get(@RequestBody AuthRoleParam authRoleParam) {
        AuthRoleEntity entity =  authRoleService.get(authRoleParam);
        return CommonResult.success(entity);
    }
    @PostMapping("relateList")
    @PreAuthorize("@pb.hasPerm('authRole.read')")
    public CommonResult relateList() {
        Map<String,List> map = authRoleService.relateList();
        return CommonResult.success(map);
    }
    @PostMapping("create")
    @PreAuthorize("@pb.hasPerm('authRole.write')")
    public CommonResult create(@RequestBody AuthRoleEntity authRoleEntity) {
        verifyEntity(authRoleEntity);
        boolean result = authRoleService.create(authRoleEntity);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("插入失败");
        }
    }
    @PostMapping("update")
    @PreAuthorize("@pb.hasPerm('authRole.write')")
    public CommonResult update(@RequestBody AuthRoleEntity authRoleEntity) {
        boolean result = authRoleService.update(authRoleEntity);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("更新失败");
        }
    }

    @PostMapping("delete")
    @PreAuthorize("@pb.hasPerm('authRole.write')")
    public CommonResult delete(@RequestBody AuthRoleParam authRoleParam) {
        String id = authRoleParam.getId();
        if(StringUtils.isEmpty(id))return null;
        boolean result = authRoleService.delete(authRoleParam);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("删除失败");
        }
    }

    @PostMapping("page")
    @PreAuthorize("@pb.hasPerm('authRole.read')")
    public CommonResult page(@RequestBody AuthRoleParam authRoleParam) {
        return CommonResult.success(authRoleService.page(authRoleParam));
    }
    private void verifyEntity(AuthRoleEntity authRoleEntity){
       
    }
    @PostMapping("importExcel")
    @PreAuthorize("@pb.hasPerm('authRole.write')")
    public CommonResult importExcel(MultipartFile file) throws Exception {
        ExcelUtil<AuthRoleEntity> excelUtil = new ExcelUtil<>(AuthRoleEntity.class);
        List<AuthRoleEntity> list = excelUtil.importExcel(file.getInputStream());
        return authRoleService.importAuthRole(list, true);
    }
    @PostMapping("exportExcel")
    @PreAuthorize("@pb.hasPerm('authRole.read')")
    public CommonResult exportExcel(AuthRoleParam authRoleParam) throws Exception {
        List<AuthRoleEntity> list = authRoleService.list(authRoleParam);
        ExcelUtil<AuthRoleEntity> excelUtil = new ExcelUtil<>(AuthRoleEntity.class);
        return excelUtil.exportExcel(list, "authRole");
    }
}


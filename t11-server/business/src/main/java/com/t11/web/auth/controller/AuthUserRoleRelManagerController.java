package com.t11.web.auth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import com.foundation.springsecurity.secure.services.SecureUser;
import org.springframework.security.core.Authentication;
import com.framework.common.constant.ControllerConstant;
import com.framework.web.base.controller.BaseController;
import com.framework.web.domain.CommonResult;
import com.t11.web.auth.entity.AuthUserRoleRelEntity;
import com.t11.web.auth.param.AuthUserRoleRelParam;
import com.t11.web.auth.service.AuthUserRoleRelService;
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
@RequestMapping(ControllerConstant.PREFIX + "authUserRoleRel/manager")
public class AuthUserRoleRelManagerController extends BaseController {
    @Resource
    private AuthUserRoleRelService authUserRoleRelService;
    @PostMapping("count")
    @PreAuthorize("@pb.hasPerm('authUserRoleRel.read')")
    public CommonResult count(@RequestBody AuthUserRoleRelParam authUserRoleRelParam){
        Long count = authUserRoleRelService.count(authUserRoleRelParam);
        return CommonResult.success(count);
    }
    @PostMapping("list")
    @PreAuthorize("@pb.hasPerm('authUserRoleRel.read')")
    public CommonResult list(@RequestBody AuthUserRoleRelParam authUserRoleRelParam){
        List<AuthUserRoleRelEntity> list = authUserRoleRelService.list(authUserRoleRelParam);
        return CommonResult.success(list);
    }
    @PostMapping("get")
    @PreAuthorize("@pb.hasPerm('authUserRoleRel.read')")
    public CommonResult get(@RequestBody AuthUserRoleRelParam authUserRoleRelParam) {
        AuthUserRoleRelEntity entity =  authUserRoleRelService.get(authUserRoleRelParam);
        return CommonResult.success(entity);
    }
    @PostMapping("relateList")
    @PreAuthorize("@pb.hasPerm('authUserRoleRel.read')")
    public CommonResult relateList() {
        Map<String,List> map = authUserRoleRelService.relateList();
        return CommonResult.success(map);
    }
    @PostMapping("create")
    @PreAuthorize("@pb.hasPerm('authUserRoleRel.write')")
    public CommonResult create(@RequestBody AuthUserRoleRelEntity authUserRoleRelEntity) {
        verifyEntity(authUserRoleRelEntity);
        boolean result = authUserRoleRelService.create(authUserRoleRelEntity);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("插入失败");
        }
    }
    @PostMapping("update")
    @PreAuthorize("@pb.hasPerm('authUserRoleRel.write')")
    public CommonResult update(@RequestBody AuthUserRoleRelEntity authUserRoleRelEntity) {
        boolean result = authUserRoleRelService.update(authUserRoleRelEntity);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("更新失败");
        }
    }

    @PostMapping("delete")
    @PreAuthorize("@pb.hasPerm('authUserRoleRel.write')")
    public CommonResult delete(@RequestBody AuthUserRoleRelParam authUserRoleRelParam) {
        String id = authUserRoleRelParam.getId();
        if(StringUtils.isEmpty(id))return null;
        boolean result = authUserRoleRelService.delete(authUserRoleRelParam);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("删除失败");
        }
    }

    @PostMapping("page")
    @PreAuthorize("@pb.hasPerm('authUserRoleRel.read')")
    public CommonResult page(@RequestBody AuthUserRoleRelParam authUserRoleRelParam) {
        return CommonResult.success(authUserRoleRelService.page(authUserRoleRelParam));
    }
    private void verifyEntity(AuthUserRoleRelEntity authUserRoleRelEntity){
       
    }
    @PostMapping("importExcel")
    @PreAuthorize("@pb.hasPerm('authUserRoleRel.write')")
    public CommonResult importExcel(MultipartFile file) throws Exception {
        ExcelUtil<AuthUserRoleRelEntity> excelUtil = new ExcelUtil<>(AuthUserRoleRelEntity.class);
        List<AuthUserRoleRelEntity> list = excelUtil.importExcel(file.getInputStream());
        return authUserRoleRelService.importAuthUserRoleRel(list, true);
    }
    @PostMapping("exportExcel")
    @PreAuthorize("@pb.hasPerm('authUserRoleRel.read')")
    public CommonResult exportExcel(AuthUserRoleRelParam authUserRoleRelParam) throws Exception {
        List<AuthUserRoleRelEntity> list = authUserRoleRelService.list(authUserRoleRelParam);
        ExcelUtil<AuthUserRoleRelEntity> excelUtil = new ExcelUtil<>(AuthUserRoleRelEntity.class);
        return excelUtil.exportExcel(list, "authUserRoleRel");
    }
}


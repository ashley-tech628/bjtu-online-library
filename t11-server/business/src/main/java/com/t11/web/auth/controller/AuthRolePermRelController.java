package com.t11.web.auth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import com.foundation.springsecurity.secure.services.SecureUser;
import org.springframework.security.core.Authentication;
import com.framework.common.constant.ControllerConstant;
import com.framework.web.base.controller.BaseController;
import com.framework.web.domain.CommonResult;
import com.t11.web.auth.entity.AuthRolePermRelEntity;
import com.t11.web.auth.param.AuthRolePermRelParam;
import com.t11.web.auth.service.AuthRolePermRelService;
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
@RequestMapping(ControllerConstant.PREFIX + "authRolePermRel")
public class AuthRolePermRelController extends BaseController {
    @Resource
    private AuthRolePermRelService authRolePermRelService;
    @PostMapping("count")
    @PreAuthorize("@pb.hasPerm('authRolePermRel.read')")
    public CommonResult count(@RequestBody AuthRolePermRelParam authRolePermRelParam){
        Long count = authRolePermRelService.count(authRolePermRelParam);
        return CommonResult.success(count);
    }
    @PostMapping("list")
    @PreAuthorize("@pb.hasPerm('authRolePermRel.read')")
    public CommonResult list(@RequestBody AuthRolePermRelParam authRolePermRelParam){
        List<AuthRolePermRelEntity> list = authRolePermRelService.list(authRolePermRelParam);
        return CommonResult.success(list);
    }
    @PostMapping("get")
    @PreAuthorize("@pb.hasPerm('authRolePermRel.read')")
    public CommonResult get(@RequestBody AuthRolePermRelParam authRolePermRelParam) {
        AuthRolePermRelEntity entity =  authRolePermRelService.get(authRolePermRelParam);
        return CommonResult.success(entity);
    }
    @PostMapping("relateList")
    @PreAuthorize("@pb.hasPerm('authRolePermRel.read')")
    public CommonResult relateList() {
        Map<String,List> map = authRolePermRelService.relateList();
        return CommonResult.success(map);
    }
    @PostMapping("create")
    @PreAuthorize("@pb.hasPerm('authRolePermRel.write')")
    public CommonResult create(@RequestBody AuthRolePermRelEntity authRolePermRelEntity) {
        verifyEntity(authRolePermRelEntity);
        boolean result = authRolePermRelService.create(authRolePermRelEntity);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("插入失败");
        }
    }
    @PostMapping("update")
    @PreAuthorize("@pb.hasPerm('authRolePermRel.write')")
    public CommonResult update(@RequestBody AuthRolePermRelEntity authRolePermRelEntity) {
        boolean result = authRolePermRelService.update(authRolePermRelEntity);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("更新失败");
        }
    }

    @PostMapping("delete")
    @PreAuthorize("@pb.hasPerm('authRolePermRel.write')")
    public CommonResult delete(@RequestBody AuthRolePermRelParam authRolePermRelParam) {
        String id = authRolePermRelParam.getId();
        if(StringUtils.isEmpty(id))return null;
        boolean result = authRolePermRelService.delete(authRolePermRelParam);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("删除失败");
        }
    }

    @PostMapping("page")
    @PreAuthorize("@pb.hasPerm('authRolePermRel.read')")
    public CommonResult page(@RequestBody AuthRolePermRelParam authRolePermRelParam) {
        return CommonResult.success(authRolePermRelService.page(authRolePermRelParam));
    }
    private void verifyEntity(AuthRolePermRelEntity authRolePermRelEntity){
       
    }
    @PostMapping("importExcel")
    @PreAuthorize("@pb.hasPerm('authRolePermRel.write')")
    public CommonResult importExcel(MultipartFile file) throws Exception {
        ExcelUtil<AuthRolePermRelEntity> excelUtil = new ExcelUtil<>(AuthRolePermRelEntity.class);
        List<AuthRolePermRelEntity> list = excelUtil.importExcel(file.getInputStream());
        return authRolePermRelService.importAuthRolePermRel(list, true);
    }
    @PostMapping("exportExcel")
    @PreAuthorize("@pb.hasPerm('authRolePermRel.read')")
    public CommonResult exportExcel(AuthRolePermRelParam authRolePermRelParam) throws Exception {
        List<AuthRolePermRelEntity> list = authRolePermRelService.list(authRolePermRelParam);
        ExcelUtil<AuthRolePermRelEntity> excelUtil = new ExcelUtil<>(AuthRolePermRelEntity.class);
        return excelUtil.exportExcel(list, "authRolePermRel");
    }
}


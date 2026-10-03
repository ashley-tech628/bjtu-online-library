package com.t11.web.auth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import com.foundation.springsecurity.secure.services.SecureUser;
import org.springframework.security.core.Authentication;
import com.framework.common.constant.ControllerConstant;
import com.framework.web.base.controller.BaseController;
import com.framework.web.domain.CommonResult;
import com.t11.web.auth.entity.AuthPermEntity;
import com.t11.web.auth.param.AuthPermParam;
import com.t11.web.auth.service.AuthPermService;
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
@RequestMapping(ControllerConstant.PREFIX + "authPerm/manager")
public class AuthPermManagerController extends BaseController {
    @Resource
    private AuthPermService authPermService;
    @PostMapping("count")
    @PreAuthorize("@pb.hasPerm('authPerm.read')")
    public CommonResult count(@RequestBody AuthPermParam authPermParam){
        Long count = authPermService.count(authPermParam);
        return CommonResult.success(count);
    }
    @PostMapping("list")
    @PreAuthorize("@pb.hasPerm('authPerm.read')")
    public CommonResult list(@RequestBody AuthPermParam authPermParam){
        List<AuthPermEntity> list = authPermService.list(authPermParam);
        return CommonResult.success(list);
    }
    @PostMapping("get")
    @PreAuthorize("@pb.hasPerm('authPerm.read')")
    public CommonResult get(@RequestBody AuthPermParam authPermParam) {
        AuthPermEntity entity =  authPermService.get(authPermParam);
        return CommonResult.success(entity);
    }
    @PostMapping("relateList")
    @PreAuthorize("@pb.hasPerm('authPerm.read')")
    public CommonResult relateList() {
        Map<String,List> map = authPermService.relateList();
        return CommonResult.success(map);
    }
    @PostMapping("create")
    @PreAuthorize("@pb.hasPerm('authPerm.write')")
    public CommonResult create(@RequestBody AuthPermEntity authPermEntity) {
        verifyEntity(authPermEntity);
        boolean result = authPermService.create(authPermEntity);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("插入失败");
        }
    }
    @PostMapping("update")
    @PreAuthorize("@pb.hasPerm('authPerm.write')")
    public CommonResult update(@RequestBody AuthPermEntity authPermEntity) {
        boolean result = authPermService.update(authPermEntity);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("更新失败");
        }
    }

    @PostMapping("delete")
    @PreAuthorize("@pb.hasPerm('authPerm.write')")
    public CommonResult delete(@RequestBody AuthPermParam authPermParam) {
        String id = authPermParam.getId();
        if(StringUtils.isEmpty(id))return null;
        boolean result = authPermService.delete(authPermParam);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("删除失败");
        }
    }

    @PostMapping("page")
    @PreAuthorize("@pb.hasPerm('authPerm.read')")
    public CommonResult page(@RequestBody AuthPermParam authPermParam) {
        return CommonResult.success(authPermService.page(authPermParam));
    }
    private void verifyEntity(AuthPermEntity authPermEntity){
       
    }
    @PostMapping("importExcel")
    @PreAuthorize("@pb.hasPerm('authPerm.write')")
    public CommonResult importExcel(MultipartFile file) throws Exception {
        ExcelUtil<AuthPermEntity> excelUtil = new ExcelUtil<>(AuthPermEntity.class);
        List<AuthPermEntity> list = excelUtil.importExcel(file.getInputStream());
        return authPermService.importAuthPerm(list, true);
    }
    @PostMapping("exportExcel")
    @PreAuthorize("@pb.hasPerm('authPerm.read')")
    public CommonResult exportExcel(AuthPermParam authPermParam) throws Exception {
        List<AuthPermEntity> list = authPermService.list(authPermParam);
        ExcelUtil<AuthPermEntity> excelUtil = new ExcelUtil<>(AuthPermEntity.class);
        return excelUtil.exportExcel(list, "authPerm");
    }
}


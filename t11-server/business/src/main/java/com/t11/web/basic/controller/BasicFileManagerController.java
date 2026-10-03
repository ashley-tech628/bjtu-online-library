package com.t11.web.basic.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import com.foundation.springsecurity.secure.services.SecureUser;
import org.springframework.security.core.Authentication;
import com.framework.common.constant.ControllerConstant;
import com.framework.web.base.controller.BaseController;
import com.framework.web.domain.CommonResult;
import com.t11.web.basic.entity.BasicFileEntity;
import com.t11.web.basic.param.BasicFileParam;
import com.t11.web.basic.service.BasicFileService;
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
@RequestMapping(ControllerConstant.PREFIX + "basicFile/manager")
public class BasicFileManagerController extends BaseController {
    @Resource
    private BasicFileService basicFileService;
    @PostMapping("count")
    @PreAuthorize("@pb.hasPerm('basicFile.read')")
    public CommonResult count(@RequestBody BasicFileParam basicFileParam){
        Long count = basicFileService.count(basicFileParam);
        return CommonResult.success(count);
    }
    @PostMapping("list")
    @PreAuthorize("@pb.hasPerm('basicFile.read')")
    public CommonResult list(@RequestBody BasicFileParam basicFileParam){
        List<BasicFileEntity> list = basicFileService.list(basicFileParam);
        return CommonResult.success(list);
    }
    @PostMapping("get")
    @PreAuthorize("@pb.hasPerm('basicFile.read')")
    public CommonResult get(@RequestBody BasicFileParam basicFileParam) {
        BasicFileEntity entity =  basicFileService.get(basicFileParam);
        return CommonResult.success(entity);
    }
    @PostMapping("relateList")
    @PreAuthorize("@pb.hasPerm('basicFile.read')")
    public CommonResult relateList() {
        Map<String,List> map = basicFileService.relateList();
        return CommonResult.success(map);
    }
    @PostMapping("create")
    @PreAuthorize("@pb.hasPerm('basicFile.write')")
    public CommonResult create(@RequestBody BasicFileEntity basicFileEntity) {
        verifyEntity(basicFileEntity);
        boolean result = basicFileService.create(basicFileEntity);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("插入失败");
        }
    }
    @PostMapping("update")
    @PreAuthorize("@pb.hasPerm('basicFile.write')")
    public CommonResult update(@RequestBody BasicFileEntity basicFileEntity) {
        boolean result = basicFileService.update(basicFileEntity);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("更新失败");
        }
    }

    @PostMapping("delete")
    @PreAuthorize("@pb.hasPerm('basicFile.write')")
    public CommonResult delete(@RequestBody BasicFileParam basicFileParam) {
        String id = basicFileParam.getId();
        if(StringUtils.isEmpty(id))return null;
        boolean result = basicFileService.delete(basicFileParam);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("删除失败");
        }
    }

    @PostMapping("page")
    @PreAuthorize("@pb.hasPerm('basicFile.read')")
    public CommonResult page(@RequestBody BasicFileParam basicFileParam) {
        return CommonResult.success(basicFileService.page(basicFileParam));
    }
    private void verifyEntity(BasicFileEntity basicFileEntity){
       
    }
    @PostMapping("importExcel")
    @PreAuthorize("@pb.hasPerm('basicFile.write')")
    public CommonResult importExcel(MultipartFile file) throws Exception {
        ExcelUtil<BasicFileEntity> excelUtil = new ExcelUtil<>(BasicFileEntity.class);
        List<BasicFileEntity> list = excelUtil.importExcel(file.getInputStream());
        return basicFileService.importBasicFile(list, true);
    }
    @PostMapping("exportExcel")
    @PreAuthorize("@pb.hasPerm('basicFile.read')")
    public CommonResult exportExcel(BasicFileParam basicFileParam) throws Exception {
        List<BasicFileEntity> list = basicFileService.list(basicFileParam);
        ExcelUtil<BasicFileEntity> excelUtil = new ExcelUtil<>(BasicFileEntity.class);
        return excelUtil.exportExcel(list, "basicFile");
    }
}


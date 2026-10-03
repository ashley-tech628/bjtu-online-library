package com.t11.web.basic.controller;
import com.framework.common.tools.uuid.IdUtils;
import com.framework.web.domain.FileInfoDomain;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
@RequestMapping(ControllerConstant.PREFIX + "basicFile")
public class BasicFileController extends BaseController {
    @Resource
    private BasicFileService basicFileService;
    @PostMapping("count")
    public CommonResult count(@RequestBody BasicFileParam basicFileParam){
        Long count = basicFileService.count(basicFileParam);
        return CommonResult.success(count);
    }
    @PostMapping("list")
    public CommonResult list(@RequestBody BasicFileParam basicFileParam){
        List<BasicFileEntity> list = basicFileService.list(basicFileParam);
        return CommonResult.success(list);
    }
    @PostMapping("get")
    public CommonResult get(@RequestBody BasicFileParam basicFileParam) {
        BasicFileEntity entity =  basicFileService.get(basicFileParam);
        return CommonResult.success(entity);
    }
    @PostMapping("relateList")
    public CommonResult relateList() {
        Map<String,List> map = basicFileService.relateList();
        return CommonResult.success(map);
    }
    @PostMapping("create")
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
    public CommonResult update(@RequestBody BasicFileEntity basicFileEntity) {
        boolean result = basicFileService.update(basicFileEntity);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("更新失败");
        }
    }

    @PostMapping("delete")
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
    public CommonResult page(@RequestBody BasicFileParam basicFileParam) {
        return CommonResult.success(basicFileService.page(basicFileParam));
    }
    private void verifyEntity(BasicFileEntity basicFileEntity){

    }
    @PostMapping("importExcel")
    public CommonResult importExcel(MultipartFile file) throws Exception {
        ExcelUtil<BasicFileEntity> excelUtil = new ExcelUtil<>(BasicFileEntity.class);
        List<BasicFileEntity> list = excelUtil.importExcel(file.getInputStream());
        return basicFileService.importBasicFile(list, true);
    }
    @PostMapping("exportExcel")
    public CommonResult exportExcel(BasicFileParam basicFileParam) throws Exception {
        List<BasicFileEntity> list = basicFileService.list(basicFileParam);
        ExcelUtil<BasicFileEntity> excelUtil = new ExcelUtil<>(BasicFileEntity.class);
        return excelUtil.exportExcel(list, "basicFile");
    }

    @PostMapping("/getNewGroupId")
    public Map<String, String> getNewGroupId() {
        String snowFlakeId = IdUtils.getSnowFlakeId();
        Map<String, String> mp = Map.of("groupId", snowFlakeId);
        return mp;
    }
    /**
     * Function:单附件上传，返回附件实体
     * Author: Admin
     * Date:2021/9/6
     * @param request
     * @return com.zhgzjg.web.domain.Res
     * @throws Exception
     */
    @PostMapping("/upload")
    public Map<String, String> upload(HttpServletRequest request) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        // 附件组ID
        String groupId = request.getParameter("groupId");
        //附件类型
        String fromType = request.getParameter("fromType");
        //附件
        MultipartFile file = multipartRequest.getFile("file");
        FileInfoDomain fileInfoDomain = basicFileService.create(groupId, fromType, file);
        String path = fileInfoDomain.getPath();
//        { location: '/uploaded/image/path/image.png' }
        Map<String, String> mp = Map.of("location", path);
        return mp;
    }

    /**
     * 用于tinymce上传文件
     */
    @PostMapping("/simpleUpload")
    public Map<String, String> simpleUpload(HttpServletRequest request) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("file");
        String urlPath   = basicFileService.simpleUpload(file);
        Map<String, String> mp = Map.of("location", urlPath);
        return mp;
    }
}


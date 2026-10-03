package com.t11.web.books.controller;

import com.t11.web.auth.entity.AuthRoleEntity;
import com.t11.web.auth.param.AuthRoleParam;
import com.t11.web.auth.service.AuthRoleService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import com.foundation.springsecurity.secure.services.SecureUser;
import org.springframework.security.core.Authentication;
import com.framework.common.constant.ControllerConstant;
import com.framework.web.base.controller.BaseController;
import com.framework.web.domain.CommonResult;


// my
import com.t11.web.books.entity.BookRecommendsEntity;
import com.t11.web.books.param.BookRecommendsParam;
import com.t11.web.books.service.BookRecommendsService;
//import com.t11.web.books.dao.BookRecommendsDao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import com.foundation.tools.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang3.StringUtils;

import jakarta.annotation.Resource;
import java.util.*;


@Slf4j
@RestController
@RequestMapping(ControllerConstant.PREFIX + "bookRecommends")
public class BookRecommendsController extends BaseController {

    @Resource
    private BookRecommendsService bookRecommendsService;
    @PostMapping("count")
    @PreAuthorize("@pb.hasPerm('bookRecommends.read')")
    public CommonResult count(@RequestBody BookRecommendsParam bookRecommendsParam){
        Long count = bookRecommendsService.count(bookRecommendsParam);
        return CommonResult.success(count);
    }
    @PostMapping("list")
    @PreAuthorize("@pb.hasPerm('bookRecommends.read')")
    public CommonResult list(@RequestBody BookRecommendsParam bookRecommendsParam){
        List<BookRecommendsEntity> list = bookRecommendsService.list(bookRecommendsParam);
        return CommonResult.success(list);
    }


    @PostMapping("get")
    @PreAuthorize("@pb.hasPerm('bookRecommends.read')")
    public CommonResult get(@RequestBody BookRecommendsParam bookRecommendsParam) {

        BookRecommendsEntity entity =  bookRecommendsService.get(bookRecommendsParam);
        return CommonResult.success(entity);

    }

    @PostMapping("relateList")
    @PreAuthorize("@pb.hasPerm('bookRecommends.read')")
    public CommonResult relateList() {
        Map<String,List> map = bookRecommendsService.relateList();
        return CommonResult.success(map);
    }
    @PostMapping("create")
    @PreAuthorize("@pb.hasPerm('bookRecommends.write')")
    public CommonResult create(@RequestBody BookRecommendsEntity bookRecommendsEntity) {
        verifyEntity(bookRecommendsEntity);
        boolean result = bookRecommendsService.create(bookRecommendsEntity);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("insert error");
        }
    }

    @PostMapping("page")
    @PreAuthorize("@pb.hasPerm('authRole.read')")
    public CommonResult page(@RequestBody BookRecommendsParam bookRecommendsParam) {
        return CommonResult.success(bookRecommendsService.page(bookRecommendsParam));
    }

    private void verifyEntity(BookRecommendsEntity bookRecommendsEntity){

    }

}

package com.t11.web.bookshelf.controller;

import com.framework.web.base.page.PageResponse;
import com.t11.web.bookshelf.entity.BookshelfEntity;
import com.t11.web.bookshelf.param.BookshelfParam;
import com.t11.web.bookshelf.service.BookshelfService;
import com.t11.web.house.entity.HouseRegionEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import com.framework.common.constant.ControllerConstant;
import com.framework.web.base.controller.BaseController;
import com.framework.web.domain.CommonResult;
import com.t11.web.house.param.HouseRegionParam;
import com.t11.web.house.service.HouseRegionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import com.foundation.tools.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang3.StringUtils;

import jakarta.annotation.Resource;
import java.util.*;

@Slf4j
@RestController
@RequestMapping(ControllerConstant.PREFIX + "bookshelf")
public class bookshelfController {

    @Resource
    private BookshelfService bookshelfService;

    @PostMapping("page")
    public CommonResult page(@RequestBody BookshelfParam bookshelfParam) {
        return CommonResult.success(bookshelfService.page(bookshelfParam));
    }

    @PostMapping("relateList")
    public CommonResult relateList() {
        Map<String, List> map = bookshelfService.relateList();
        return CommonResult.success(map);
    }

    @PostMapping("create")
    public CommonResult create(@RequestBody BookshelfEntity bookshelfEntity) {
        verifyEntity(bookshelfEntity);
        boolean result = bookshelfService.create(bookshelfEntity);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("����ʧ��");
        }
    }

    @PostMapping("update")
    public CommonResult update(@RequestBody BookshelfEntity bookshelfEntity) {
        boolean result = bookshelfService.update(bookshelfEntity);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("����ʧ��");
        }
    }

    private void verifyEntity(BookshelfEntity bookshelfEntity){

    }

}

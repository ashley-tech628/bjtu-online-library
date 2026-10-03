package com.t11.web.bookLibrary.controller;

import com.framework.common.constant.ControllerConstant;
import com.framework.web.base.controller.BaseController;
import com.framework.web.domain.CommonResult;
import com.t11.web.bookLibrary.entity.BookLibraryEntity;
import com.t11.web.bookLibrary.param.BookLibraryParam;
import com.t11.web.bookLibrary.service.BookLibraryService;
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
@RequestMapping(ControllerConstant.PREFIX + "bookLibrary")
public class BookLibraryController extends BaseController {
    @Resource
    private BookLibraryService bookLibraryService;
    @PostMapping("count")
//    @PreAuthorize("@pb.hasPerm('bookLibrary.read')")
    public CommonResult count(@RequestBody BookLibraryParam bookLibraryParam){
        Long count = bookLibraryService.count(bookLibraryParam);
        return CommonResult.success(count);
    }
    @PostMapping("list")
//    @PreAuthorize("@pb.hasPerm('bookLibrary.read')")
    public CommonResult list(@RequestBody BookLibraryParam bookLibraryParam){
        List<BookLibraryEntity> list = bookLibraryService.list(bookLibraryParam);
        return CommonResult.success(list);
    }
    @PostMapping("get")
//    @PreAuthorize("@pb.hasPerm('bookLibrary.read')")
    public CommonResult get(@RequestBody BookLibraryParam bookLibraryParam) {
        BookLibraryEntity entity =  bookLibraryService.get(bookLibraryParam);
        return CommonResult.success(entity);
    }
    @PostMapping("relateList")
//    @PreAuthorize("@pb.hasPerm('bookLibrary.read')")
    public CommonResult relateList() {
        Map<String,List> map = bookLibraryService.relateList();
        return CommonResult.success(map);
    }
    @PostMapping("create")
//    @PreAuthorize("@pb.hasPerm('bookLibrary.write')")
    public CommonResult create(@RequestBody BookLibraryEntity bookLibraryEntity) {
        verifyEntity(bookLibraryEntity);
        boolean result = bookLibraryService.create(bookLibraryEntity);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("插入失败");
        }
    }
    @PostMapping("update")
//    @PreAuthorize("@pb.hasPerm('bookLibrary.write')")
    public CommonResult update(@RequestBody BookLibraryEntity bookLibraryEntity) {
        boolean result = bookLibraryService.update(bookLibraryEntity);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("更新失败");
        }
    }

    @PostMapping("delete")
//    @PreAuthorize("@pb.hasPerm('bookLibrary.write')")
    public CommonResult delete(@RequestBody BookLibraryParam bookLibraryParam) {
        String id = bookLibraryParam.getId();
        if(StringUtils.isEmpty(id))return null;
        boolean result = bookLibraryService.delete(bookLibraryParam);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("删除失败");
        }
    }

    @PostMapping("page")
//    @PreAuthorize("@pb.hasPerm('bookLibrary.read')")
    public CommonResult page(@RequestBody BookLibraryParam bookLibraryParam) {
        return CommonResult.success(bookLibraryService.page(bookLibraryParam));
    }
    private void verifyEntity(BookLibraryEntity bookLibraryEntity){

    }
    @PostMapping("importExcel")
//    @PreAuthorize("@pb.hasPerm('bookLibrary.write')")
    public CommonResult importExcel(MultipartFile file) throws Exception {
        ExcelUtil<BookLibraryEntity> excelUtil = new ExcelUtil<>(BookLibraryEntity.class);
        List<BookLibraryEntity> list = excelUtil.importExcel(file.getInputStream());
        return bookLibraryService.importbookLibrary(list, true);
    }
    @PostMapping("exportExcel")
//    @PreAuthorize("@pb.hasPerm('bookLibrary.read')")
    public CommonResult exportExcel(BookLibraryParam bookLibraryParam) throws Exception {
        List<BookLibraryEntity> list = bookLibraryService.list(bookLibraryParam);
        ExcelUtil<BookLibraryEntity> excelUtil = new ExcelUtil<>(BookLibraryEntity.class);
        return excelUtil.exportExcel(list, "bookLibrary");
    }
}


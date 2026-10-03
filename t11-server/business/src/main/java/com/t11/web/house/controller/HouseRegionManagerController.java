package com.t11.web.house.controller;

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

/***
 * 
 */
@Slf4j
@RestController
@RequestMapping(ControllerConstant.PREFIX + "houseRegion/manager")
public class HouseRegionManagerController extends BaseController {
    @Resource
    private HouseRegionService houseRegionService;
    @PostMapping("count")
    @PreAuthorize("@pb.hasPerm('houseRegion.read')")
    public CommonResult count(@RequestBody HouseRegionParam houseRegionParam){
        Long count = houseRegionService.count(houseRegionParam);
        return CommonResult.success(count);
    }
    @PostMapping("list")
    @PreAuthorize("@pb.hasPerm('houseRegion.read')")
    public CommonResult list(@RequestBody HouseRegionParam houseRegionParam){
        List<HouseRegionEntity> list = houseRegionService.list(houseRegionParam);
        return CommonResult.success(list);
    }
    @PostMapping("get")
    @PreAuthorize("@pb.hasPerm('houseRegion.read')")
    public CommonResult get(@RequestBody HouseRegionParam houseRegionParam) {
        HouseRegionEntity entity =  houseRegionService.get(houseRegionParam);
        return CommonResult.success(entity);
    }
    @PostMapping("relateList")
    @PreAuthorize("@pb.hasPerm('houseRegion.read')")
    public CommonResult relateList() {
        Map<String,List> map = houseRegionService.relateList();
        return CommonResult.success(map);
    }
    @PostMapping("create")
    @PreAuthorize("@pb.hasPerm('houseRegion.write')")
    public CommonResult create(@RequestBody HouseRegionEntity houseRegionEntity) {
        verifyEntity(houseRegionEntity);
        boolean result = houseRegionService.create(houseRegionEntity);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("插入失败");
        }
    }
    @PostMapping("update")
    @PreAuthorize("@pb.hasPerm('houseRegion.write')")
    public CommonResult update(@RequestBody HouseRegionEntity houseRegionEntity) {
        boolean result = houseRegionService.update(houseRegionEntity);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("更新失败");
        }
    }

    @PostMapping("delete")
    @PreAuthorize("@pb.hasPerm('houseRegion.write')")
    public CommonResult delete(@RequestBody HouseRegionParam houseRegionParam) {
        String id = houseRegionParam.getId();
        if(StringUtils.isEmpty(id))return null;
        boolean result = houseRegionService.delete(houseRegionParam);
        if (result) {
            return CommonResult.success();
        }else {
            return CommonResult.failure("删除失败");
        }
    }

    @PostMapping("page")
    @PreAuthorize("@pb.hasPerm('houseRegion.read')")
    public CommonResult page(@RequestBody HouseRegionParam houseRegionParam) {
        return CommonResult.success(houseRegionService.page(houseRegionParam));
    }
    private void verifyEntity(HouseRegionEntity houseRegionEntity){
       
    }
    @PostMapping("importExcel")
    @PreAuthorize("@pb.hasPerm('houseRegion.write')")
    public CommonResult importExcel(MultipartFile file) throws Exception {
        ExcelUtil<HouseRegionEntity> excelUtil = new ExcelUtil<>(HouseRegionEntity.class);
        List<HouseRegionEntity> list = excelUtil.importExcel(file.getInputStream());
        return houseRegionService.importHouseRegion(list, true);
    }
    @PostMapping("exportExcel")
    @PreAuthorize("@pb.hasPerm('houseRegion.read')")
    public CommonResult exportExcel(HouseRegionParam houseRegionParam) throws Exception {
        List<HouseRegionEntity> list = houseRegionService.list(houseRegionParam);
        ExcelUtil<HouseRegionEntity> excelUtil = new ExcelUtil<>(HouseRegionEntity.class);
        return excelUtil.exportExcel(list, "houseRegion");
    }
}


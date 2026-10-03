package com.t11.web.basic.service;

import org.springframework.web.multipart.MultipartFile;
import com.framework.web.domain.FileInfoDomain;

import com.framework.web.base.page.PageResponse;
import com.t11.web.basic.entity.BasicFileEntity;
import com.t11.web.basic.param.BasicFileParam;
import com.framework.web.domain.CommonResult;
import java.util.*;
/***
*
*/
public interface BasicFileService {
    FileInfoDomain create(String groupId, String fromType, MultipartFile file);

    Long count(BasicFileParam basicFileParam);
    List<BasicFileEntity> list(BasicFileParam basicFileParam);
  
    Map<String,List> relateList();
    /**
    * 插入
    * @param basicFileEntity
    * @return
    */
    boolean create(BasicFileEntity basicFileEntity);

    /**
    * 根据id更新
    */
    boolean update(BasicFileEntity basicFileEntity);
    boolean delete(BasicFileParam basicFileParam);
    /**
    * 根据id查找
    * @param id
    * @return 单条记录
    */
    BasicFileEntity get(BasicFileParam basicFileParam);
  

    /**
    *列表-分页
    */
    PageResponse<BasicFileEntity> page(BasicFileParam basicFileParam);
    CommonResult importBasicFile(List<BasicFileEntity> dataList, boolean isUpdateSupport);
     String simpleUpload(MultipartFile file);
    }
        

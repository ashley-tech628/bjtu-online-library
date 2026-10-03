/**
 */
package com.t11.web.basic.service.impl;

import com.framework.common.tools.uuid.IdUtils;
import cn.hutool.core.date.DateUtil;
import com.foundation.springcontext.configure.FileConfig;
import com.framework.common.tools.Img2Base64Util;
import com.foundation.tools.file.FileUploadUtils;
import com.framework.common.tools.file.MimeTypeUtils;
import com.framework.common.tools.uuid.IdUtils;
import com.framework.web.domain.FileInfoDomain;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.framework.web.enums.FileFromTypeEnum;
import com.framework.web.enums.FileTypeEnum;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import java.io.File;
import java.io.IOException;

import com.foundation.springsecurity.context.UserContext;
import com.framework.web.base.page.PageResponse;
import com.framework.web.base.page.Pageable;
import com.t11.web.basic.entity.BasicFileEntity;
import com.t11.web.basic.param.BasicFileParam;
import com.t11.web.basic.dao.BasicFileDao;
import com.t11.web.basic.service.BasicFileService;
import lombok.extern.slf4j.Slf4j;
import com.framework.common.tools.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.collections.CollectionUtils;
import com.framework.web.domain.CommonResult;
import com.framework.web.exception.base.BusinessException;
import org.apache.commons.lang3.StringUtils;

import jakarta.annotation.Resource;
import java.util.*;




/***
 * Title: Service-BasicFileServiceImpl
 */
@Slf4j
@Service
public class BasicFileServiceImpl implements BasicFileService {

    @Resource
    private UserContext userContext;
    @Resource
    private BasicFileDao basicFileDao;

    @Override
    public Long count(BasicFileParam basicFileParam){
        //BeanUtils.setPropertiesNullIfEmpty(basicFileParam);
        try {
            Long count = basicFileDao.selectCount(basicFileParam);
            return count;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
    }
    @Override
    public List<BasicFileEntity> list(BasicFileParam basicFileParam){
        //BeanUtils.setPropertiesNullIfEmpty(basicFileParam);
        try {
            List<BasicFileEntity> res = basicFileDao.selectList(basicFileParam);
            return res;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
    }
    @Override
    public boolean create(BasicFileEntity basicFileEntity) {
        basicFileEntity.initCreateAttribute(UserContext.getUserId());
        String snowFlakeId = IdUtils.getSnowFlakeId();
        basicFileEntity.setId(snowFlakeId);
        //BeanUtils.setPropertiesNullIfEmpty(basicFileEntity);
        try{
            basicFileDao.insert(basicFileEntity);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
      public BasicFileEntity get(BasicFileParam basicFileParam){
          try{
              return basicFileDao.selectOne(basicFileParam);
          } catch (Exception e){
              e.printStackTrace();
          }
          return null;
      }

    @Override
    public boolean delete(BasicFileParam basicFileParam){
        try{
            //delete file first
            BasicFileEntity basicFileEntity = this.get(basicFileParam);
            String path = basicFileEntity.getPath();
            String realPath = FileUploadUtils.getRealPath(path);
            File file = new File(realPath);
            if(file.exists())file.delete();
            //delete from table
            basicFileDao.delete(basicFileParam);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

     @Override
     public boolean update(BasicFileEntity basicFileEntity) {
          try{
              String id = basicFileEntity.getId();
              BasicFileParam basicFileParam = new BasicFileParam();
              basicFileParam.setId(id);
              BasicFileEntity entity = get(basicFileParam);
              String[] ignoreProperties = {"id", "createUser", "createTime", "updateUser", "updateTime"};
              BeanUtils.copyProperties(basicFileEntity, entity, ignoreProperties);
              entity.initUpdateAttribute(UserContext.getUserId());
              basicFileDao.update(entity, basicFileParam);
              return true;
          } catch (Exception e){
              e.printStackTrace();
          }
          return false;
      }

    @Override
        public PageResponse<BasicFileEntity> page(BasicFileParam basicFileParam){
           try {
               List<BasicFileEntity> list = basicFileDao.selectList(basicFileParam);
               Long count = basicFileDao.selectCount(basicFileParam);
               return new PageResponse<>(basicFileParam.getPageNo(), basicFileParam.getPageSize(), count, list);
           } catch (Exception e){
               e.printStackTrace();
           } finally {
           }
           return null;
        }
     @Override
    public CommonResult importBasicFile(List<BasicFileEntity> dataList, boolean isUpdateSupport) {
        if (CollectionUtils.isEmpty(dataList)) {
            throw new BusinessException("导入信息不能为空！");
        }
        int successNum = 0;
        int failNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (BasicFileEntity basicFileEntity : dataList) {
            try {
                // 是否已经存在
                BasicFileEntity existBasicFileEntity = this.get(basicFileEntity);
                if (null == existBasicFileEntity) {
                    // 创建用户
                    this.create(basicFileEntity);
                    successNum++;
                    successMsg.append(String.format("<br/>%s导入成功",
                            successNum));
                } else if (isUpdateSupport) {
                    // 更新用户
                    basicFileEntity.setId(basicFileEntity.getId());
                    this.update(basicFileEntity);
                    successNum++;
                    successMsg.append(String.format("<br/>%s更新成功",
                            successNum));
                } else {
                    throw new BusinessException(String.format("已存在"));
                }
            } catch (Exception e) {
                log.error("导入数据错误：", e);
                failNum++;
                failureMsg.append(String.format("<br/>%s导入失败：%s",
                        failNum, e.getMessage()));
            }
        }
        // 返回信息
        return CommonResult.result(successNum, failNum, successMsg, failureMsg);
    }
    private BasicFileEntity get(BasicFileEntity basicFileEntity){
        return null;
    }

    public Map<String,List> relateList(){
        Map<String,List> map = new HashMap<>();

        return map;
    }
   @Override
    public FileInfoDomain create(String groupId, String fromType, MultipartFile file) {
          String realPath = FileConfig.getFileRootDirectory();
          log.info("realPath:"+realPath);
          // 获取文件来源路径
          FileFromTypeEnum fileFromTypeEnum = FileFromTypeEnum.getEnumByType(fromType);
          String fileFromPath = fileFromTypeEnum.getPath();
          //附件组Id

          // 文件类型
          String contentType = getUploadFileType(file);
          // 文件名称
          String originalFilename = file.getOriginalFilename().replaceAll(",", "，");
          // 文件大小
          Double size = (double) file.getSize();
          // 后缀名
          String ext = FilenameUtils.getExtension(originalFilename);
          // 自动生成主键id
          String fileId = IdUtils.getSnowFlakeId();
          String filePath = fileFromPath + File.separator +
                  DateUtil.formatDate(new Date()) + File.separator +
                  fileId + "." + ext;
          String savedPath = realPath + File.separator + filePath;

          try {
              //附件写磁盘
              FileUtils.writeByteArrayToFile(new File(savedPath), file.getBytes());
          } catch (IOException e) {
              e.printStackTrace();
          }

          //记录附件上传信息
          BasicFileEntity basicFileEntity = new BasicFileEntity();
          basicFileEntity.initCreateAttribute(UserContext.getUserId());
          String basicFileId = IdUtils.getSnowFlakeId();
          basicFileEntity.setId(basicFileId);
          basicFileEntity.setContentType(contentType);
          basicFileEntity.setExtName(ext);
          basicFileEntity.setName(originalFilename);
          basicFileEntity.setSize(size);
          basicFileEntity.setGroupId(groupId);
          basicFileEntity.setPath(filePath);
          basicFileEntity.setFromType(fileFromTypeEnum.getType());
          basicFileDao.insert(basicFileEntity);
          // 组装附件信息
          return fileInfoDomainBuild(basicFileEntity);
      }

      private FileInfoDomain fileInfoDomainBuild(BasicFileEntity basicFileEntity) {
          FileInfoDomain domain = new FileInfoDomain();
          domain.setGroupId(basicFileEntity.getGroupId());
          domain.setFileId(basicFileEntity.getId());
          domain.setContentType(basicFileEntity.getContentType());
          domain.setFileName(basicFileEntity.getName());
          domain.setExtName(basicFileEntity.getExtName());
          domain.setFileSize(basicFileEntity.getSize());
  //        domain.setFileData(Img2Base64Util.getImgStr(
  //                FileConfig.getFileRootDirectory() + File.separator + basicFileEntity.getPath())
  //        );
          String urlPath = FileUploadUtils.getUrlPath(basicFileEntity.getPath());
          domain.setPath(urlPath);
          return domain;
      }
      @Override
      public String simpleUpload(MultipartFile file) {
          String realPath = FileConfig.getFileRootDirectory();
          log.info("realPath:"+realPath);
          // 获取文件来源路径
          FileFromTypeEnum fileFromTypeEnum = FileFromTypeEnum.getEnumByType(null);
          String fileFromPath = fileFromTypeEnum.getPath();
          // 文件名称
          String originalFilename = file.getOriginalFilename().replaceAll(",", "，");
          // 文件大小
          // 后缀名
          String ext = FilenameUtils.getExtension(originalFilename);
          // 自动生成主键id
          String fileId = IdUtils.getSnowFlakeId();
          String filePath = fileFromPath + File.separator +
                  DateUtil.formatDate(new Date()) + File.separator +
                  fileId + "." + ext;
          String savedPath = realPath + File.separator + filePath;

          try {
              //附件写磁盘
              FileUtils.writeByteArrayToFile(new File(savedPath), file.getBytes());
          } catch (IOException e) {
              e.printStackTrace();
          }
          String urlPath = FileUploadUtils.getUrlPath(filePath);
          // 组装附件信息
          return urlPath;
      }
    /**
     * 判断上传文件类型，并返回对应的常量值
     * @param file 上传的文件
     * @return 文件类型：0 未知类型，1、图片；2、word；3、EXCEL；4、PDF；5、视频
     */
    public static String getUploadFileType(MultipartFile file) {
        // 获取后缀
        String extension = FileUploadUtils.getExtension(file);
        // 判断文件类型
        if (FileUploadUtils.isAllowedExtension(extension, MimeTypeUtils.IMAGE_EXTENSION)) {
            return FileTypeEnum.IMAGE.getCode();
        } else if (FileUploadUtils.isAllowedExtension(extension, MimeTypeUtils.WORD_EXTENSION)) {
            return FileTypeEnum.WORD.getCode();
        } else if (FileUploadUtils.isAllowedExtension(extension, MimeTypeUtils.EXCEL_EXTENSION)) {
            return FileTypeEnum.EXCEL.getCode();
        } else if (FileUploadUtils.isAllowedExtension(extension, MimeTypeUtils.PDF_EXTENSION)) {
            return FileTypeEnum.PDF.getCode();
        } else if (FileUploadUtils.isAllowedExtension(extension, MimeTypeUtils.VIDEO_EXTENSION)) {
            return FileTypeEnum.VIDEO.getCode();
        } else {
            return FileTypeEnum.UNKNOWN.getCode();
        }
    }
}
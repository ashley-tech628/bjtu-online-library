/**
 */
package com.t11.web.bookLibrary.service.impl;

import com.framework.common.tools.uuid.IdUtils;
import com.foundation.springsecurity.context.UserContext;
import com.framework.web.base.page.PageResponse;
import com.t11.web.bookLibrary.entity.BookLibraryEntity;
import com.t11.web.bookLibrary.param.BookLibraryParam;
import com.t11.web.bookLibrary.dao.BookLibraryDao;
import com.t11.web.bookLibrary.service.BookLibraryService;
import lombok.extern.slf4j.Slf4j;
import com.framework.common.tools.BeanUtils;
import org.springframework.stereotype.Service;
import org.apache.commons.collections.CollectionUtils;
import com.framework.web.domain.CommonResult;
import com.framework.web.exception.base.BusinessException;

import jakarta.annotation.Resource;
import java.util.*;



/***
 * Title: Service-bookLibraryServiceImpl
 */
@Slf4j
@Service
public class BookLibraryServiceImpl implements BookLibraryService {

    @Resource
    private UserContext userContext;
    @Resource
    private BookLibraryDao bookLibraryDao;

    @Override
    public Long count(BookLibraryParam bookLibraryParam){
        //BeanUtils.setPropertiesNullIfEmpty(bookLibraryParam);
        try {
            Long count = bookLibraryDao.selectCount(bookLibraryParam);
            return count;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
    }
    @Override
    public List<BookLibraryEntity> list(BookLibraryParam bookLibraryParam){
        //BeanUtils.setPropertiesNullIfEmpty(bookLibraryParam);
        try {
            List<BookLibraryEntity> res = bookLibraryDao.selectList(bookLibraryParam);
            return res;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
    }
    @Override
    public boolean create(BookLibraryEntity bookLibraryEntity) {
        bookLibraryEntity.initCreateAttribute(UserContext.getUserId());
        String snowFlakeId = IdUtils.getSnowFlakeId();
        bookLibraryEntity.setId(snowFlakeId);
        //BeanUtils.setPropertiesNullIfEmpty(bookLibraryEntity);
        try{
            bookLibraryDao.insert(bookLibraryEntity);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public BookLibraryEntity get(BookLibraryParam bookLibraryParam){
        try{
            return bookLibraryDao.selectOne(bookLibraryParam);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(BookLibraryParam bookLibraryParam){
        try{
            bookLibraryDao.delete(bookLibraryParam);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(BookLibraryEntity bookLibraryEntity) {
        try{
            String id = bookLibraryEntity.getId();
            BookLibraryParam bookLibraryParam = new BookLibraryParam();
            bookLibraryParam.setId(id);
            BookLibraryEntity entity = get(bookLibraryParam);
            String[] ignoreProperties = {"id", "createUser", "createTime", "updateUser", "updateTime"};
            BeanUtils.copyProperties(bookLibraryEntity, entity, ignoreProperties);
            entity.initUpdateAttribute(UserContext.getUserId());
            bookLibraryDao.update(entity, bookLibraryParam);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public PageResponse<BookLibraryEntity> page(BookLibraryParam bookLibraryParam){
        try {
            List<BookLibraryEntity> list = bookLibraryDao.selectList(bookLibraryParam);
            Long count = bookLibraryDao.selectCount(bookLibraryParam);
            return new PageResponse<>(bookLibraryParam.getPageNo(), bookLibraryParam.getPageSize(), count, list);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
    }
    @Override
    public CommonResult importbookLibrary(List<BookLibraryEntity> dataList, boolean isUpdateSupport) {
        if (CollectionUtils.isEmpty(dataList)) {
            throw new BusinessException("导入信息不能为空！");
        }
        int successNum = 0;
        int failNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (BookLibraryEntity bookLibraryEntity : dataList) {
            try {
                // 是否已经存在
                BookLibraryEntity existbookLibraryEntity = this.get(bookLibraryEntity);
                if (null == existbookLibraryEntity) {
                    // 创建用户
                    this.create(bookLibraryEntity);
                    successNum++;
                    successMsg.append(String.format("<br/>%s导入成功",
                            successNum));
                } else if (isUpdateSupport) {
                    // 更新用户
                    bookLibraryEntity.setId(bookLibraryEntity.getId());
                    this.update(bookLibraryEntity);
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
    private BookLibraryEntity get(BookLibraryEntity bookLibraryEntity){
        return null;
    }

    public Map<String,List> relateList(){
        Map<String,List> map = new HashMap<>();

        return map;
    }
}
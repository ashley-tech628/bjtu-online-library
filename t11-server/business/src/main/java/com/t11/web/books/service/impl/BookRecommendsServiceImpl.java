package com.t11.web.books.service.impl;

import com.foundation.springsecurity.context.UserContext;
import com.framework.common.tools.BeanUtils;
import com.framework.common.tools.uuid.IdUtils;
import com.framework.web.base.page.PageResponse;
import com.framework.web.domain.CommonResult;
import com.framework.web.exception.base.BusinessException;
import com.t11.web.auth.dao.AuthRoleDao;
import com.t11.web.auth.entity.AuthRoleEntity;
import com.t11.web.auth.param.AuthRoleParam;
import com.t11.web.books.dao.BookRecommendsDao;
import com.t11.web.books.entity.BookRecommendsEntity;
import com.t11.web.books.param.BookRecommendsParam;
import com.t11.web.books.service.BookRecommendsService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class BookRecommendsServiceImpl implements BookRecommendsService {

    //    @Resource
    private UserContext userContext = new UserContext();
    //    @Resource
    private BookRecommendsDao bookRecommendsDao = new BookRecommendsDao();

    @Override
    public Long count(BookRecommendsParam bookRecommendsParam){
        //BeanUtils.setPropertiesNullIfEmpty(authRoleParam);
        try {
            Long count = bookRecommendsDao.selectCount(bookRecommendsParam);
            return count;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
    }
    @Override
    public List<BookRecommendsEntity> list(BookRecommendsParam bookRecommendsParam){
        //BeanUtils.setPropertiesNullIfEmpty(authRoleParam);
        try {
            List<BookRecommendsEntity> res = bookRecommendsDao.selectList(bookRecommendsParam);
            return res;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
    }

    @Override
    public Map<String, List> relateList() {
        Map<String,List> map = new HashMap<>();

        return map;
    }

    @Override
    public BookRecommendsEntity get(BookRecommendsParam bookRecommendsParam){
        try{
            return bookRecommendsDao.selectOne(bookRecommendsParam);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private BookRecommendsEntity get(BookRecommendsEntity bookRecommendsEntity){
        return null;
    }
    @Override
    public CommonResult importBookRecommends(List<BookRecommendsEntity> dataList, boolean isUpdateSupport) {
        if (CollectionUtils.isEmpty(dataList)) {
            throw new BusinessException("Import data cannot be empty!");
        }
        int successNum = 0;
        int failNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (BookRecommendsEntity bookRecommendsEntity : dataList) {
            try {
                // Check if the entity already exists
                BookRecommendsEntity existBookRecommendEntity = this.get(bookRecommendsEntity);
                if (null == existBookRecommendEntity) {
                    // Create the entity
                    this.create(bookRecommendsEntity);
                    successNum++;
                    successMsg.append(String.format("<br/>%s imported successfully",
                            successNum));
                } else if (isUpdateSupport) {
                    // Update the entity
                    bookRecommendsEntity.setId(bookRecommendsEntity.getId());
                    this.update(bookRecommendsEntity);
                    successNum++;
                    successMsg.append(String.format("<br/>%s updated successfully",
                            successNum));
                } else {
                    throw new BusinessException(String.format("Already exists"));
                }
            } catch (Exception e) {
                log.error("Data import error:", e);
                failNum++;
                failureMsg.append(String.format("<br/>%s import failed: %s",
                        failNum, e.getMessage()));
            }
        }
        // Return information
        return CommonResult.result(successNum, failNum, successMsg, failureMsg);
    }

    public boolean create(BookRecommendsEntity bookRecommendsEntity) {
        bookRecommendsEntity.initCreateAttribute(UserContext.getUserId());
        String snowFlakeId = IdUtils.getSnowFlakeId();
        bookRecommendsEntity.setId(snowFlakeId);
        //BeanUtils.setPropertiesNullIfEmpty(authRoleEntity);
        try{
            bookRecommendsDao.insert(bookRecommendsEntity);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public PageResponse<BookRecommendsEntity> page(BookRecommendsParam bookRecommendsParam){
        try {
            List<BookRecommendsEntity> list = bookRecommendsDao.selectList(bookRecommendsParam);
            Long count = bookRecommendsDao.selectCount(bookRecommendsParam);
            return new PageResponse<>(bookRecommendsParam.getPageNo(), bookRecommendsParam.getPageSize(), count, list);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
    }

    public boolean update(BookRecommendsEntity bookRecommendsEntity) {
        try{
            String id = bookRecommendsEntity.getId();
            BookRecommendsParam bookRecommendsParam = new BookRecommendsParam();
//            AuthRoleParam authRoleParam = new AuthRoleParam();
            bookRecommendsParam.setId(id);
            BookRecommendsEntity entity = get(bookRecommendsParam);
            String[] ignoreProperties = {"id", "createUser", "createTime", "updateUser", "updateTime"};
            BeanUtils.copyProperties(bookRecommendsEntity, entity, ignoreProperties);
            entity.initUpdateAttribute(UserContext.getUserId());
            bookRecommendsDao.update(entity, bookRecommendsParam);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}

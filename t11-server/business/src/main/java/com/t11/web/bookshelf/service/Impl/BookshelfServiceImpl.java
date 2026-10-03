package com.t11.web.bookshelf.service.Impl;

import com.foundation.springsecurity.context.UserContext;
import com.framework.common.tools.BeanUtils;
import com.framework.common.tools.uuid.IdUtils;
import com.framework.web.base.page.PageResponse;
import com.t11.web.bookshelf.entity.BookshelfEntity;
import com.t11.web.bookshelf.param.BookshelfParam;
import com.t11.web.bookshelf.service.BookshelfService;
import com.t11.web.bookshelf.dao.BookshelfDao;


import com.t11.web.house.entity.HouseRegionEntity;
import com.t11.web.house.param.HouseRegionParam;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class BookshelfServiceImpl implements BookshelfService {
    @Resource
    private UserContext userContext;
    @Resource
    private BookshelfDao bookshelfDao;

    @Override
    public PageResponse<BookshelfEntity> page(BookshelfParam bookshelfParam){
        try {
            List<BookshelfEntity> list = bookshelfDao.selectList(bookshelfParam);
            Long count = bookshelfDao.selectCount(bookshelfParam);
            return new PageResponse<>(bookshelfParam.getPageNo(), bookshelfParam.getPageSize(), count, list);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
    }

    public Map<String,List> relateList(){
        Map<String,List> map = new HashMap<>();

        return map;
    }

    @Override
    public boolean create(BookshelfEntity bookshelfEntity) {
        bookshelfEntity.initCreateAttribute(UserContext.getUserId());
//        String snowFlakeId = IdUtils.getSnowFlakeId();
//        bookshelfEntity.setId(snowFlakeId);
        //BeanUtils.setPropertiesNullIfEmpty(houseRegionEntity);
        try{
            bookshelfDao.insert(bookshelfEntity);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean update(BookshelfEntity bookshelfEntity) {
        try{
            String id = bookshelfEntity.getId();
            BookshelfParam bookshelfParam = new BookshelfParam();
            bookshelfParam.setId(id);
            BookshelfEntity entity = get(bookshelfParam);
            String[] ignoreProperties = {"id"};
            BeanUtils.copyProperties(bookshelfEntity, entity, ignoreProperties);
            entity.initUpdateAttribute(UserContext.getUserId());
            bookshelfDao.update(entity, bookshelfParam);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public BookshelfEntity get(BookshelfParam bookshelfParam){
        try{
            return bookshelfDao.selectOne(bookshelfParam);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

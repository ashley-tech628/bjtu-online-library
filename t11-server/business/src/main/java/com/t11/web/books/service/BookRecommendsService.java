package com.t11.web.books.service;

import com.framework.web.base.page.PageResponse;
import com.framework.web.domain.CommonResult;
import com.t11.web.auth.entity.AuthRoleEntity;
import com.t11.web.auth.param.AuthRoleParam;
import com.t11.web.books.entity.BookRecommendsEntity;
import com.t11.web.books.param.BookRecommendsParam;
//import com.t11.web.books.param.BookRecommendsParam;

import java.util.List;
import java.util.*;
import java.util.Map;

public interface BookRecommendsService {

    Long count(BookRecommendsParam bookRecommendsParam);
    List<BookRecommendsEntity> list(BookRecommendsParam bookRecommendsParam);

    Map<String,List> relateList();
    /**
     * insert
     * @param bookRecommendsEntity
     * @return
     */
    boolean create(BookRecommendsEntity bookRecommendsEntity);

    PageResponse<BookRecommendsEntity> page(BookRecommendsParam bookRecommendsParam);


    /**
     * Update by ID
     */
//    boolean update(BookRecommendsEntity bookRecommendsEntity);
//    boolean delete(BookRecommendsParam bookRecommendsParam);
    BookRecommendsEntity get(BookRecommendsParam bookRecommendsParam);

    /**
     * List - Pagination
     */
//    PageResponse<BookRecommendsEntity> page(BookRecommendsParam bookRecommendsParam);
    CommonResult importBookRecommends(List<BookRecommendsEntity> dataList, boolean isUpdateSupport);
}

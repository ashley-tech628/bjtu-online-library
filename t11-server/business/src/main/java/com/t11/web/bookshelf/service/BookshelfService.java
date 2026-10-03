package com.t11.web.bookshelf.service;

import com.framework.web.base.page.PageResponse;
import com.t11.web.bookshelf.entity.BookshelfEntity;
import com.t11.web.bookshelf.param.BookshelfParam;

import com.framework.web.domain.CommonResult;

import java.util.*;


/**
 * @author Aug.OTS
 */
public interface BookshelfService {
    PageResponse<BookshelfEntity> page(BookshelfParam bookshelfParam);
    Map<String, List> relateList();
    public BookshelfEntity get(BookshelfParam bookshelfParam);

    boolean create(BookshelfEntity bookshelfEntity);

    boolean update(BookshelfEntity bookshelfEntity);
}

package com.t11.web.bookLibrary.service;

import com.framework.web.base.page.PageResponse;
import com.t11.web.bookLibrary.entity.BookLibraryEntity;
import com.t11.web.bookLibrary.param.BookLibraryParam;
import com.framework.web.domain.CommonResult;
import java.util.*;

/***
 *
 */
public interface BookLibraryService {

    Long count(BookLibraryParam bookLibraryParam);
    List<BookLibraryEntity> list(BookLibraryParam bookLibraryParam);

    Map<String,List> relateList();
    /**
     * 插入
     * @param bookLibraryEntity
     * @return
     */
    boolean create(BookLibraryEntity bookLibraryEntity);

    /**
     * 根据id更新
     */
    boolean update(BookLibraryEntity bookLibraryEntity);
    boolean delete(BookLibraryParam bookLibraryParam);
    /**
     * 根据id查找
     * @param
     * @return 单条记录
     */
    BookLibraryEntity get(BookLibraryParam bookLibraryParam);


    /**
     *列表-分页
     */
    PageResponse<BookLibraryEntity> page(BookLibraryParam bookLibraryParam);
    CommonResult importbookLibrary(List<BookLibraryEntity> dataList, boolean isUpdateSupport);
}
        

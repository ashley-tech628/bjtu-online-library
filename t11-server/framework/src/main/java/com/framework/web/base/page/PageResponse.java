/**
 */
package com.framework.web.base.page;

import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/***
 * Date:2021/6/26
 * Title:分页结果
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
@Data
@NoArgsConstructor
public class PageResponse<T> {

    /**
     * 当前页数
     */
    private long page = 1;

    /**
     * 每页数量
     */
    private long pageSize = 10;

    /**
     * 总页数
     */
    private long total;

    /**
     * 分页后的数据
     */
    private List<T> items;

    /**
     * 构建实体
     */
    public PageResponse(int page, int pageSize, long total, List<T> items) {
        this.page = page;
        this.pageSize = pageSize;
        this.total = total;
        this.items = items;
    }

    /**
     * 构建实体
     */
    public PageResponse(PageInfo pageInfo) {
        this.items = pageInfo.getList();
        this.page = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.total = pageInfo.getTotal();
    }


}

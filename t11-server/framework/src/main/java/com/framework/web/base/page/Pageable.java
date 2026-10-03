/**
 */
package com.framework.web.base.page;

import com.framework.web.base.param.BaseParam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/***
 * Date:2021/6/26
 * Title:分页工具
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public class Pageable {

    private Pageable() {
    }

    /**
     * 内存分页
     * @param records   待分页的数据
     * @param pageIndex 当前页码
     * @param pageSize  每页显示的条数
     * @return 分页数据 {@link PageResponse}
     */
    public static <T> List<T> of(List<T> records, int pageIndex, int pageSize) {
        if (records == null) {
            return Collections.emptyList();
        }
        int totalCount = records.size();
        int remainder = totalCount % pageSize;
        int pageCount = (remainder > 0) ? totalCount / pageSize + 1 : totalCount / pageSize;
        if (remainder == 0) {
            return records.stream().skip((pageIndex - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
        } else {
            if (pageIndex == pageCount) {
                return records.stream().skip((pageIndex - 1) * pageSize).limit(totalCount).collect(Collectors.toList());
            } else {
                return records.stream().skip((pageIndex - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
            }
        }
    }

    /**
     * 内存分页
     * @param baseParam 分页参数
     * @param records 待分页的数据
     * @return 分页数据 {@link PageResponse}
     */
    public static <T> PageResponse<T> of(BaseParam baseParam, List<T> records) {
        return new PageResponse<T>(baseParam.getPageNo(),baseParam.getPageSize(),records.size(),
                of(
                        records,
                        baseParam.getPageNo(),
                        baseParam.getPageSize()
                ));
    }

    /**
     * Function:物理分页
     * Author: Admin
     * Date:2021/6/26
      * @param baseParam
     * @param record
     * @return com.bjtuwh.web.base.page.PageResponse<T>
     * @throws Exception
     */
    public static <T> PageResponse<T> of(BaseParam baseParam, Record record) {
        PageHelper.startPage(baseParam.getPageNo(), baseParam.getPageSize());
        return new PageResponse<>(new PageInfo<>(record.invoke()));
    }

    /**
     * Function:内部类常用于分页数据的来源实现
     * Author: Admin
     * Date:2021/6/26
      * @param <T>
     * @return
     * @throws Exception
     */
    public interface Record<T> {
        @SuppressWarnings("AlibabaAbstractMethodOrInterfaceMethodMustUseJavadoc")
        List<T> invoke();
    }
}

package com.t11.web.books.param;

import com.framework.web.base.param.BaseParam;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class BookRecommendsParam extends BaseParam {
    private String id;
    private String code;
}


package com.t11.web.bookLibrary.param;

import com.framework.web.base.param.BaseParam;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class BookLibraryParam extends BaseParam {
    private String id;
    private String title;
}

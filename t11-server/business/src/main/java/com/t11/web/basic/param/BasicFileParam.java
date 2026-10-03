package com.t11.web.basic.param;

import com.framework.web.base.param.BaseParam;
import lombok.*;
import java.time.LocalDateTime;
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class BasicFileParam extends BaseParam {
    private String id;
    private String groupId;
}

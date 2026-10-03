package com.t11.web.auth.param;

import com.framework.web.base.param.BaseParam;
import lombok.*;
import java.time.LocalDateTime;
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class AuthPermParam extends BaseParam {
    private String id;
    private String code;
}

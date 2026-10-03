package com.t11.web.auth.param;

import com.framework.web.base.param.BaseParam;
import lombok.*;
import java.time.LocalDateTime;
import com.t11.web.auth.param.AuthPermParam;
import com.t11.web.auth.param.AuthRoleParam;
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class AuthRolePermRelParam extends BaseParam {
    private String id;
    private String roleId;
    private String permId;
    private AuthRoleParam roleParam = new AuthRoleParam();
    private AuthPermParam permParam = new AuthPermParam();
}

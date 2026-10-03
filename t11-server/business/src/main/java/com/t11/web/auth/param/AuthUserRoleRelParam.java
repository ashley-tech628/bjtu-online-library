package com.t11.web.auth.param;

import com.framework.web.base.param.BaseParam;
import lombok.*;
import java.time.LocalDateTime;
import com.t11.web.auth.param.AuthUserParam;
import com.t11.web.auth.param.AuthRoleParam;
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class AuthUserRoleRelParam extends BaseParam {
    private String id;
    private String userId;
    private String roleId;
    private AuthUserParam userParam = new AuthUserParam();
    private AuthRoleParam roleParam = new AuthRoleParam();
}

package com.t11.web.userDetails.param;

import com.framework.web.base.param.BaseParam;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class UserDetailsParam extends BaseParam {

    private String user_id;
    private String user_name;

    private String books;
}

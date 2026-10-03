package com.t11.web.house.param;

import com.framework.web.base.param.BaseParam;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class HouseRegionParam extends BaseParam {
    private String id;
    private String name;
}

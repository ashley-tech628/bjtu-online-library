package com.framework.web.base.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Set;

/**
 * BaseParam 教师分页查询入参
 * @author bxy
 * @description TODO
 * @date 2021-11-08 15:13:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class BaseParam{
    private int pageNo = 1;
    private int pageSize = 0;
}

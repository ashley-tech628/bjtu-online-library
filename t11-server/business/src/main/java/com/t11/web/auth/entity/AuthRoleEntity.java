package com.t11.web.auth.entity;

import com.framework.web.base.entity.BaseEntity;
import com.framework.web.base.entity.BaseTreeEntity;
import com.framework.common.aop.annotation.Excel;
import lombok.*;
import lombok.experimental.Accessors;
import java.util.Date;
import java.util.List;
import java.time.LocalDateTime;
import com.framework.web.base.entity.BaseTreeEntity;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AuthRoleEntity extends BaseEntity {
    @Excel(name = "主键")
    private String id;
    @Excel(name = "编号")
    private String code;
    @Excel(name = "名称")
    private String name;
    @Excel(name = "是否启用")
    private Integer isValid;
    @Excel(name = "排序号")
    private Integer sortNum;
}

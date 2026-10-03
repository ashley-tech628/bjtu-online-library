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
import com.t11.web.auth.entity.AuthUserEntity;
import com.t11.web.auth.entity.AuthRoleEntity;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AuthUserRoleRelEntity extends BaseEntity {
    @Excel(name = "主键")
    private String id;
    @Excel(name = "用户编号")
    private String userId;
    @Excel(name = "角色编号")
    private String roleId;
    @Excel(name = "是否启用")
    private Integer isValid;
    @Excel(name = "排序号")
    private Integer sortNum;
    private AuthUserEntity userEntity;
    private AuthRoleEntity roleEntity;
}

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
public class AuthUserEntity extends BaseEntity {
    @Excel(name = "主键")
    private String id;
    @Excel(name = "用户名")
    private String username;
    @Excel(name = "密码")
    private String password;
    @Excel(name = "姓名")
    private String realName;
    @Excel(name = "最后登录时间")
    private String lastLoginTime;
    @Excel(name = "头像")
    private String avatarGroupId;
    @Excel(name = "手机号")
    private String mobile;
    @Excel(name = "备注")
    private String remark;
    @Excel(name = "是否启用")
    private Integer isValid;
    @Excel(name = "排序号")
    private Integer sortNum;
}

package com.t11.web.userDetails.entity;

import com.framework.web.base.entity.BaseEntity;
import lombok.*;
import lombok.experimental.Accessors;

import com.framework.web.base.entity.BaseEntity;
import com.framework.common.aop.annotation.Excel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class UserDetailsEntity extends BaseEntity {

    @Excel(name = "user_id")
    private String user_id;

    @Excel(name = "user_name")
    private String user_name;

    @Excel(name = "books")
    private String books;
}

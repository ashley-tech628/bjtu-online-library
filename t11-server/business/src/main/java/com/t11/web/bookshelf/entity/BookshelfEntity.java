package com.t11.web.bookshelf.entity;

import com.framework.common.aop.annotation.Excel;
import com.framework.web.base.entity.BaseEntity;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class BookshelfEntity extends BaseEntity {
    @Excel(name = "id")
    private String id;
    @Excel(name = "name")
    private String name;

    @Excel(name = "allbooks")
    private String allbooks;
}

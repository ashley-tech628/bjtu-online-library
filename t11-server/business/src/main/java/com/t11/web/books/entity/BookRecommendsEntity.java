package com.t11.web.books.entity;

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
public class BookRecommendsEntity extends BaseEntity {
    @Excel(name = "����")
    private String id;
    @Excel(name = "���")
    private String code;
    @Excel(name = "ͼ������")
    private String name;
    @Excel(name = "�Ƿ�����")
    private Integer isValid;
    @Excel(name = "�����")
    private Integer sortNum;

}

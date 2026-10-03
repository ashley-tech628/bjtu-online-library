package com.t11.web.house.entity;

import com.framework.web.base.entity.BaseEntity;
import com.framework.common.aop.annotation.Excel;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class HouseRegionEntity extends BaseEntity {
    @Excel(name = "主键")
    private String id;
    @Excel(name = "编码")
    private String code;
    @Excel(name = "名称")
    private String name;
    @Excel(name = "校区简称")
    private String shortName;
    @Excel(name = "宗地面积")
    private Integer landArea;
    @Excel(name = "建筑面积")
    private Integer constructionArea;
    @Excel(name = "道路面积")
    private Integer roadArea;
    @Excel(name = "绿化面积")
    private Integer greenArea;
    @Excel(name = "建筑数量")
    private Integer constructionNum;
    @Excel(name = "产权情况")
    private String ownerStatus;
    @Excel(name = "不动产证")
    private String estateCardGroupId;
    @Excel(name = "排序号")
    private Integer sortNum;
}

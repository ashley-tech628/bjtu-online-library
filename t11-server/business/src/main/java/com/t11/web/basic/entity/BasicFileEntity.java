package com.t11.web.basic.entity;

import com.foundation.FoundationConstant;
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
public class BasicFileEntity extends BaseEntity {
    @Excel(name = "主键")
    private String id;
    @Excel(name = "来源表")
    private String fromType;
    @Excel(name = "附件组ID")
    private String groupId;
    @Excel(name = "附件名")
    private String name;
    @Excel(name = "附件拓展名")
    private String extName;
    @Excel(name = "文件类型")
    private String contentType;
    @Excel(name = "附件大小")
    private Double size;
    @Excel(name = "附件存储相对地址")
    private String path;
    @Excel(name = "是否启用")
    private Integer isValid;
    @Excel(name = "排序号")
    private Integer sortNum;
    private String uri;
    public BasicFileEntity setPath(String path){
        this.path = path;
        this.uri = FoundationConstant.RESOURCE_URL_PREFIX  + path;
        return this;
    }
}

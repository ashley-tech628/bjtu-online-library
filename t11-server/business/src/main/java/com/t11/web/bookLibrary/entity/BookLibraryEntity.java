package com.t11.web.bookLibrary.entity;

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
public class BookLibraryEntity extends BaseEntity {
    @Excel(name = "主键")
    private String id;
    @Excel(name = "书名")
    private String title;
    @Excel(name = "作者")
    private String author;
    @Excel(name = "类型")
    private String type;
    @Excel(name = "出版时间")
    private String publicationTime;
    @Excel(name = "封面")
    private String cover;
    @Excel(name = "简介")
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublicationTime() {
        return publicationTime;
    }

    public void setPublicationTime(String publicationTime) {
        this.publicationTime = publicationTime;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

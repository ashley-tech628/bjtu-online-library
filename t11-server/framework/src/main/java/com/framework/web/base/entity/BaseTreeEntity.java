/**
 */
package com.framework.web.base.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.experimental.Accessors;

/***
 * Date:2021/6/26
 * Title:实体树父类
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
@JsonIgnoreProperties(value = {"handler"})
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class BaseTreeEntity<T> extends BaseEntity {

    /**
     * 父id
     */
    protected String parentId;

    /**
     * 父节点名称
     */
    protected String parentName;

    /**
     * 子级集合
     */
    protected List<T> children = new ArrayList<>();

    /**
     * 排序号
     */
    private Integer sortNum = 0;

    /**
     * 是否有子集
     */
    private Boolean hasChild = false;

    /**
     * 集合转换为树状集合
     * @param list     集合
     * @param parentId 第一层父节点id
     * @param <T>      泛型
     * @return 树状集合
     */
    public static <T extends BaseTreeEntity<T>> List<T> toTree(List<T> list, String parentId) {
//        if (CollectionUtils.isNotEmpty(list)) {
//            return list.parallelStream().filter(s -> StringUtils.equals(s.getParentId(), parentId))
//                    .peek(s -> s.setChildren(toTree(list, s.getId())))
//                    .sorted(Comparator.comparingInt(BaseTreeEntity::getSortNum))
//                    .collect(Collectors.toList());
//        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T extends BaseTreeEntity> List<T> toList(T data) {
        List<T> result = new ArrayList<>();
        if (Objects.isNull(data)) {
            return result;
        }
        result.add(data);
        List<T> children = data.getChildren();
        children.forEach(s -> result.addAll(toList(s)));
        return result;
    }
}

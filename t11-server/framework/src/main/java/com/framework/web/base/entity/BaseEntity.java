/**
 */
package com.framework.web.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.framework.common.tools.DateUtils;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
/***
 */
@Data
@Accessors(chain = true)
public class BaseEntity<T>  implements Serializable {
    /** 创建人 */
    protected String createUser;

    /** 创建时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    protected String createTime;

    /** 最后修改人 */
    protected String updateUser;

    /** 最后修改时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    protected String updateTime;


    /**
     * Function:初始化新建实体属性
     * Author: Admin
     * Date:2021/6/26
     * @param userId
     * @return void
     * @throws Exception
     */
    public void initCreateAttribute(String userId){
        if(StringUtils.isBlank(userId)){
            userId = null;
        }
        LocalDateTime localDateTime = LocalDateTime.now();
        String localDateTimeStr = DateUtils.localDateTime2Str(localDateTime);
        this.setCreateTime(localDateTimeStr);
        this.setUpdateTime(localDateTimeStr);
        this.setCreateUser(userId);
        this.setUpdateUser(userId);
    }

    /**
     * Function:初始化更新实体属性
     * Author: Admin
     * Date:2021/6/26
     * @param userId
     * @return void
     * @throws Exception
     */
    public void initUpdateAttribute(String userId){
        if(userId == null || "".equals(userId)) {
            userId = null;
        }
        LocalDateTime localDateTime = LocalDateTime.now();
        String localDateTimeStr = DateUtils.localDateTime2Str(localDateTime);
        this.setUpdateTime(localDateTimeStr);
        this.setUpdateUser(userId);
    }


}

/**
 */
package com.t11.web.auth.service.impl;

import com.framework.common.tools.uuid.IdUtils;
import com.foundation.springsecurity.context.UserContext;
import com.framework.web.base.page.PageResponse;
import com.framework.web.base.page.Pageable;
import com.t11.web.auth.entity.AuthPermEntity;
import com.t11.web.auth.param.AuthPermParam;
import com.t11.web.auth.dao.AuthPermDao;
import com.t11.web.auth.service.AuthPermService;
import lombok.extern.slf4j.Slf4j;
import com.framework.common.tools.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.collections.CollectionUtils;
import com.framework.web.domain.CommonResult;
import com.framework.web.exception.base.BusinessException;
import org.apache.commons.lang3.StringUtils;

import jakarta.annotation.Resource;
import java.util.*;



/***
 * Title: Service-AuthPermServiceImpl
 */
@Slf4j
@Service
public class AuthPermServiceImpl implements AuthPermService {

    @Resource
    private UserContext userContext;
    @Resource
    private AuthPermDao authPermDao;

    @Override
    public Long count(AuthPermParam authPermParam){
        //BeanUtils.setPropertiesNullIfEmpty(authPermParam);
        try {
            Long count = authPermDao.selectCount(authPermParam);
            return count;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
    }
    @Override
    public List<AuthPermEntity> list(AuthPermParam authPermParam){
        //BeanUtils.setPropertiesNullIfEmpty(authPermParam);
        try {
            List<AuthPermEntity> res = authPermDao.selectList(authPermParam);
            return res;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
    }
    @Override
    public boolean create(AuthPermEntity authPermEntity) {
        authPermEntity.initCreateAttribute(UserContext.getUserId());
        String snowFlakeId = IdUtils.getSnowFlakeId();
        authPermEntity.setId(snowFlakeId);
        //BeanUtils.setPropertiesNullIfEmpty(authPermEntity);
        try{
            authPermDao.insert(authPermEntity);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public AuthPermEntity get(AuthPermParam authPermParam){
        try{
            return authPermDao.selectOne(authPermParam);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(AuthPermParam authPermParam){
        try{
            authPermDao.delete(authPermParam);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(AuthPermEntity authPermEntity) {
        try{
            String id = authPermEntity.getId();
            AuthPermParam authPermParam = new AuthPermParam();
            authPermParam.setId(id);
            AuthPermEntity entity = get(authPermParam);
            String[] ignoreProperties = {"id", "createUser", "createTime", "updateUser", "updateTime"};
            BeanUtils.copyProperties(authPermEntity, entity, ignoreProperties);
            entity.initUpdateAttribute(UserContext.getUserId());
            authPermDao.update(entity, authPermParam);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
     @Override
     public PageResponse<AuthPermEntity> page(AuthPermParam authPermParam){
        try {
            List<AuthPermEntity> list = authPermDao.selectList(authPermParam);
            Long count = authPermDao.selectCount(authPermParam);
            return new PageResponse<>(authPermParam.getPageNo(), authPermParam.getPageSize(), count, list);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
     }
     @Override
    public CommonResult importAuthPerm(List<AuthPermEntity> dataList, boolean isUpdateSupport) {
        if (CollectionUtils.isEmpty(dataList)) {
            throw new BusinessException("导入信息不能为空！");
        }
        int successNum = 0;
        int failNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (AuthPermEntity authPermEntity : dataList) {
            try {
                // 是否已经存在
                AuthPermEntity existAuthPermEntity = this.get(authPermEntity);
                if (null == existAuthPermEntity) {
                    // 创建用户
                    this.create(authPermEntity);
                    successNum++;
                    successMsg.append(String.format("<br/>%s导入成功",
                            successNum));
                } else if (isUpdateSupport) {
                    // 更新用户
                    authPermEntity.setId(authPermEntity.getId());
                    this.update(authPermEntity);
                    successNum++;
                    successMsg.append(String.format("<br/>%s更新成功",
                            successNum));
                } else {
                    throw new BusinessException(String.format("已存在"));
                }
            } catch (Exception e) {
                log.error("导入数据错误：", e);
                failNum++;
                failureMsg.append(String.format("<br/>%s导入失败：%s",
                        failNum, e.getMessage()));
            }
        }
        // 返回信息
        return CommonResult.result(successNum, failNum, successMsg, failureMsg);
    }
    private AuthPermEntity get(AuthPermEntity authPermEntity){
        return null;
    }

    public Map<String,List> relateList(){
        Map<String,List> map = new HashMap<>();

        return map;
    }
}
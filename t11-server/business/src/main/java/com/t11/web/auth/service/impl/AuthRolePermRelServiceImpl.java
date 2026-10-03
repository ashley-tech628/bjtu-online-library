/**
 */
package com.t11.web.auth.service.impl;

import com.framework.common.tools.uuid.IdUtils;
import com.foundation.springsecurity.context.UserContext;
import com.framework.web.base.page.PageResponse;
import com.framework.web.base.page.Pageable;
import com.t11.web.auth.entity.AuthRolePermRelEntity;
import com.t11.web.auth.param.AuthRolePermRelParam;
import com.t11.web.auth.dao.AuthRolePermRelDao;
import com.t11.web.auth.service.AuthRolePermRelService;
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

import com.t11.web.auth.param.AuthPermParam;
import com.t11.web.auth.entity.AuthPermEntity;
import com.t11.web.auth.service.AuthPermService;
import com.t11.web.auth.param.AuthRoleParam;
import com.t11.web.auth.entity.AuthRoleEntity;
import com.t11.web.auth.service.AuthRoleService;


/***
 * Title: Service-AuthRolePermRelServiceImpl
 */
@Slf4j
@Service
public class AuthRolePermRelServiceImpl implements AuthRolePermRelService {

    @Resource
    private UserContext userContext;
    @Resource
    private AuthRolePermRelDao authRolePermRelDao;
    @Resource
    private AuthPermService authPermService;
    @Resource
    private AuthRoleService authRoleService;

    @Override
    public Long count(AuthRolePermRelParam authRolePermRelParam){
        //BeanUtils.setPropertiesNullIfEmpty(authRolePermRelParam);
        try {
            Long count = authRolePermRelDao.selectCount(authRolePermRelParam);
            return count;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
    }
    @Override
    public List<AuthRolePermRelEntity> list(AuthRolePermRelParam authRolePermRelParam){
        //BeanUtils.setPropertiesNullIfEmpty(authRolePermRelParam);
        try {
            List<AuthRolePermRelEntity> res = authRolePermRelDao.selectList(authRolePermRelParam);
            return res;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
    }
    @Override
    public boolean create(AuthRolePermRelEntity authRolePermRelEntity) {
        authRolePermRelEntity.initCreateAttribute(UserContext.getUserId());
        String snowFlakeId = IdUtils.getSnowFlakeId();
        authRolePermRelEntity.setId(snowFlakeId);
        //BeanUtils.setPropertiesNullIfEmpty(authRolePermRelEntity);
        try{
            authRolePermRelDao.insert(authRolePermRelEntity);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public AuthRolePermRelEntity get(AuthRolePermRelParam authRolePermRelParam){
        try{
            return authRolePermRelDao.selectOne(authRolePermRelParam);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(AuthRolePermRelParam authRolePermRelParam){
        try{
            authRolePermRelDao.delete(authRolePermRelParam);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(AuthRolePermRelEntity authRolePermRelEntity) {
        try{
            String id = authRolePermRelEntity.getId();
            AuthRolePermRelParam authRolePermRelParam = new AuthRolePermRelParam();
            authRolePermRelParam.setId(id);
            AuthRolePermRelEntity entity = get(authRolePermRelParam);
            String[] ignoreProperties = {"id", "createUser", "createTime", "updateUser", "updateTime"};
            BeanUtils.copyProperties(authRolePermRelEntity, entity, ignoreProperties);
            entity.initUpdateAttribute(UserContext.getUserId());
            authRolePermRelDao.update(entity, authRolePermRelParam);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
     @Override
     public PageResponse<AuthRolePermRelEntity> page(AuthRolePermRelParam authRolePermRelParam){
        try {
            List<AuthRolePermRelEntity> list = authRolePermRelDao.selectList(authRolePermRelParam);
            Long count = authRolePermRelDao.selectCount(authRolePermRelParam);
            return new PageResponse<>(authRolePermRelParam.getPageNo(), authRolePermRelParam.getPageSize(), count, list);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
     }
     @Override
    public CommonResult importAuthRolePermRel(List<AuthRolePermRelEntity> dataList, boolean isUpdateSupport) {
        if (CollectionUtils.isEmpty(dataList)) {
            throw new BusinessException("导入信息不能为空！");
        }
        int successNum = 0;
        int failNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (AuthRolePermRelEntity authRolePermRelEntity : dataList) {
            try {
                // 是否已经存在
                AuthRolePermRelEntity existAuthRolePermRelEntity = this.get(authRolePermRelEntity);
                if (null == existAuthRolePermRelEntity) {
                    // 创建用户
                    this.create(authRolePermRelEntity);
                    successNum++;
                    successMsg.append(String.format("<br/>%s导入成功",
                            successNum));
                } else if (isUpdateSupport) {
                    // 更新用户
                    authRolePermRelEntity.setId(authRolePermRelEntity.getId());
                    this.update(authRolePermRelEntity);
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
    private AuthRolePermRelEntity get(AuthRolePermRelEntity authRolePermRelEntity){
        return null;
    }

    public Map<String,List> relateList(){
        Map<String,List> map = new HashMap<>();
        AuthRoleParam authRoleParam = new AuthRoleParam();
        PageResponse<AuthRoleEntity> authRoleEntityPage = authRoleService.page(authRoleParam);
        List<AuthRoleEntity> authRoleEntityList = authRoleEntityPage.getItems();
        map.put("roleEntityList", authRoleEntityList);
        AuthPermParam authPermParam = new AuthPermParam();
        PageResponse<AuthPermEntity> authPermEntityPage = authPermService.page(authPermParam);
        List<AuthPermEntity> authPermEntityList = authPermEntityPage.getItems();
        map.put("permEntityList", authPermEntityList);

        return map;
    }
}
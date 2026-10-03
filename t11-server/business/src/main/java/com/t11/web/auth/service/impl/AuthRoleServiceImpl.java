/**
 */
package com.t11.web.auth.service.impl;

import com.framework.common.tools.uuid.IdUtils;
import com.foundation.springsecurity.context.UserContext;
import com.framework.web.base.page.PageResponse;
import com.framework.web.base.page.Pageable;
import com.t11.web.auth.entity.AuthRoleEntity;
import com.t11.web.auth.param.AuthRoleParam;
import com.t11.web.auth.dao.AuthRoleDao;
import com.t11.web.auth.service.AuthRoleService;
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
 * Title: Service-AuthRoleServiceImpl
 */
@Slf4j
@Service
public class AuthRoleServiceImpl implements AuthRoleService {

    @Resource
    private UserContext userContext;
    @Resource
    private AuthRoleDao authRoleDao;

    @Override
    public Long count(AuthRoleParam authRoleParam){
        //BeanUtils.setPropertiesNullIfEmpty(authRoleParam);
        try {
            Long count = authRoleDao.selectCount(authRoleParam);
            return count;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
    }
    @Override
    public List<AuthRoleEntity> list(AuthRoleParam authRoleParam){
        //BeanUtils.setPropertiesNullIfEmpty(authRoleParam);
        try {
            List<AuthRoleEntity> res = authRoleDao.selectList(authRoleParam);
            return res;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
    }
    @Override
    public boolean create(AuthRoleEntity authRoleEntity) {
        authRoleEntity.initCreateAttribute(UserContext.getUserId());
        String snowFlakeId = IdUtils.getSnowFlakeId();
        authRoleEntity.setId(snowFlakeId);
        //BeanUtils.setPropertiesNullIfEmpty(authRoleEntity);
        try{
            authRoleDao.insert(authRoleEntity);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public AuthRoleEntity get(AuthRoleParam authRoleParam){
        try{
            return authRoleDao.selectOne(authRoleParam);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(AuthRoleParam authRoleParam){
        try{
            authRoleDao.delete(authRoleParam);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(AuthRoleEntity authRoleEntity) {
        try{
            String id = authRoleEntity.getId();
            AuthRoleParam authRoleParam = new AuthRoleParam();
            authRoleParam.setId(id);
            AuthRoleEntity entity = get(authRoleParam);
            String[] ignoreProperties = {"id", "createUser", "createTime", "updateUser", "updateTime"};
            BeanUtils.copyProperties(authRoleEntity, entity, ignoreProperties);
            entity.initUpdateAttribute(UserContext.getUserId());
            authRoleDao.update(entity, authRoleParam);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
     @Override
     public PageResponse<AuthRoleEntity> page(AuthRoleParam authRoleParam){
        try {
            List<AuthRoleEntity> list = authRoleDao.selectList(authRoleParam);
            Long count = authRoleDao.selectCount(authRoleParam);
            return new PageResponse<>(authRoleParam.getPageNo(), authRoleParam.getPageSize(), count, list);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
     }
     @Override
    public CommonResult importAuthRole(List<AuthRoleEntity> dataList, boolean isUpdateSupport) {
        if (CollectionUtils.isEmpty(dataList)) {
            throw new BusinessException("导入信息不能为空！");
        }
        int successNum = 0;
        int failNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (AuthRoleEntity authRoleEntity : dataList) {
            try {
                // 是否已经存在
                AuthRoleEntity existAuthRoleEntity = this.get(authRoleEntity);
                if (null == existAuthRoleEntity) {
                    // 创建用户
                    this.create(authRoleEntity);
                    successNum++;
                    successMsg.append(String.format("<br/>%s导入成功",
                            successNum));
                } else if (isUpdateSupport) {
                    // 更新用户
                    authRoleEntity.setId(authRoleEntity.getId());
                    this.update(authRoleEntity);
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
    private AuthRoleEntity get(AuthRoleEntity authRoleEntity){
        return null;
    }

    public Map<String,List> relateList(){
        Map<String,List> map = new HashMap<>();

        return map;
    }
}
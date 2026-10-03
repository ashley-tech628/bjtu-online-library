/**
 */
package com.t11.web.auth.service.impl;

import com.framework.common.tools.uuid.IdUtils;
import com.foundation.springsecurity.context.UserContext;
import com.framework.web.base.page.PageResponse;
import com.framework.web.base.page.Pageable;
import com.t11.web.auth.entity.AuthUserEntity;
import com.t11.web.auth.param.AuthUserParam;
import com.t11.web.auth.dao.AuthUserDao;
import com.t11.web.auth.service.AuthUserService;
import lombok.extern.slf4j.Slf4j;
import com.framework.common.tools.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.collections.CollectionUtils;
import com.framework.web.domain.CommonResult;
import com.framework.web.exception.base.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.annotation.Resource;
import java.util.*;



/***
 * Title: Service-AuthUserServiceImpl
 */
@Slf4j
@Service
public class AuthUserServiceImpl implements AuthUserService {

    @Resource
    private UserContext userContext;
    @Resource
    private AuthUserDao authUserDao;

    @Override
    public Long count(AuthUserParam authUserParam){
        //BeanUtils.setPropertiesNullIfEmpty(authUserParam);
        try {
            Long count = authUserDao.selectCount(authUserParam);
            return count;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
    }

    @Override
    public Long count(AuthUserEntity authUserEntity)
    {
        try {
            Long count = authUserDao.selectCount(authUserEntity);
            return count;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
    }

    @Override
    public List<AuthUserEntity> list(AuthUserParam authUserParam){
        //BeanUtils.setPropertiesNullIfEmpty(authUserParam);
        try {
            List<AuthUserEntity> res = authUserDao.selectList(authUserParam);
            return res;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
    }
    @Override
    public boolean create(AuthUserEntity authUserEntity) {
        authUserEntity.initCreateAttribute(UserContext.getUserId());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        authUserEntity.setPassword(bCryptPasswordEncoder.encode(authUserEntity.getPassword()));
//        String snowFlakeId = IdUtils.getSnowFlakeId();
//        authUserEntity.setId(snowFlakeId);
        //BeanUtils.setPropertiesNullIfEmpty(authUserEntity);
        try{
            authUserDao.insert(authUserEntity);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public AuthUserEntity get(AuthUserParam authUserParam){
        try{
            return authUserDao.selectOne(authUserParam);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(AuthUserParam authUserParam){
        try{
            authUserDao.delete(authUserParam);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(AuthUserEntity authUserEntity) {
        try{
            String id = authUserEntity.getId();
            AuthUserParam authUserParam = new AuthUserParam();
            authUserParam.setId(id);
            AuthUserEntity entity = get(authUserParam);
            String[] ignoreProperties = {"id", "createUser", "createTime", "updateUser", "updateTime"};
            BeanUtils.copyProperties(authUserEntity, entity, ignoreProperties);
            entity.initUpdateAttribute(UserContext.getUserId());
            authUserDao.update(entity, authUserParam);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
     @Override
     public PageResponse<AuthUserEntity> page(AuthUserParam authUserParam){
        try {
            List<AuthUserEntity> list = authUserDao.selectList(authUserParam);
            Long count = authUserDao.selectCount(authUserParam);
            return new PageResponse<>(authUserParam.getPageNo(), authUserParam.getPageSize(), count, list);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
     }
     @Override
    public CommonResult importAuthUser(List<AuthUserEntity> dataList, boolean isUpdateSupport) {
        if (CollectionUtils.isEmpty(dataList)) {
            throw new BusinessException("导入信息不能为空！");
        }
        int successNum = 0;
        int failNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (AuthUserEntity authUserEntity : dataList) {
            try {
                // 是否已经存在
                AuthUserEntity existAuthUserEntity = this.get(authUserEntity);
                if (null == existAuthUserEntity) {
                    // 创建用户
                    this.create(authUserEntity);
                    successNum++;
                    successMsg.append(String.format("<br/>%s导入成功",
                            successNum));
                } else if (isUpdateSupport) {
                    // 更新用户
                    authUserEntity.setId(authUserEntity.getId());
                    this.update(authUserEntity);
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
    private AuthUserEntity get(AuthUserEntity authUserEntity){
        return null;
    }

    public Map<String,List> relateList(){
        Map<String,List> map = new HashMap<>();

        return map;
    }
}
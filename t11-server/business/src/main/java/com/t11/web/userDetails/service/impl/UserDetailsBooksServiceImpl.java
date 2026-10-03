/**
 */
package com.t11.web.userDetails.service.impl;

import com.foundation.springsecurity.context.UserContext;
import com.framework.web.base.page.PageResponse;
import com.framework.web.domain.CommonResult;
import com.framework.web.exception.base.BusinessException;
import com.t11.web.userDetails.entity.UserDetailsEntity;
import com.t11.web.userDetails.param.UserDetailsParam;
import com.t11.web.userDetails.dao.UserDetailsDao;
import com.t11.web.userDetails.service.UserDetailsBooksService;
import lombok.extern.slf4j.Slf4j;
import com.framework.common.tools.BeanUtils;
import org.springframework.stereotype.Service;
import org.apache.commons.collections.CollectionUtils;


import jakarta.annotation.Resource;
import java.util.*;



/***
 * Title: Service-UserDetailsServiceImpl
 */
@Slf4j
@Service
public class UserDetailsBooksServiceImpl implements UserDetailsBooksService {

    @Resource
    private UserDetailsDao userDetailsDao;

    @Override
    public List<UserDetailsEntity> list(UserDetailsParam userDetailsParam){
        //BeanUtils.setPropertiesNullIfEmpty(userDetailsParam);
        try {
            List<UserDetailsEntity> res = userDetailsDao.selectList(userDetailsParam);
            return res;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
    }
    @Override
    public boolean create(UserDetailsEntity userDetailsEntity) {
        userDetailsEntity.initCreateAttribute(UserContext.getUserId());
//        String snowFlakeId = IdUtils.getSnowFlakeId();
//        userDetailsEntity.setUser_id(snowFlakeId);
        //BeanUtils.setPropertiesNullIfEmpty(userDetailsEntity);
        try{
            userDetailsDao.insert(userDetailsEntity);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public UserDetailsEntity get(UserDetailsParam userDetailsParam){
        try{
            return userDetailsDao.selectOne(userDetailsParam);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(UserDetailsParam userDetailsParam){
        try{
            userDetailsDao.delete(userDetailsParam);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(UserDetailsEntity userDetailsEntity) {
        try{
            String id = userDetailsEntity.getUser_id();
            UserDetailsParam userDetailsParam = new UserDetailsParam();
            userDetailsParam.setUser_id(id);
            UserDetailsEntity entity = get(userDetailsParam);
            String[] ignoreProperties = {"user_id", "user_name"};
            BeanUtils.copyProperties(userDetailsEntity, entity, ignoreProperties);
            entity.initUpdateAttribute(UserContext.getUserId());
            userDetailsDao.update(entity, userDetailsParam);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public PageResponse<UserDetailsEntity> page(UserDetailsParam userDetailsParam){
        try {
            List<UserDetailsEntity> list = userDetailsDao.selectList(userDetailsParam);
            Long count = userDetailsDao.selectCount(userDetailsParam);
            return new PageResponse<>(userDetailsParam.getPageNo(), userDetailsParam.getPageSize(), count, list);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
    }

    private UserDetailsEntity get(UserDetailsEntity userDetailsEntity){
        return null;
    }

    public Map<String,List> relateList(){
        Map<String,List> map = new HashMap<>();

        return map;
    }

    @Override
    public CommonResult importUserDetails(List<UserDetailsEntity> dataList, boolean isUpdateSupport) {
        if (CollectionUtils.isEmpty(dataList)) {
            throw new BusinessException("������Ϣ����Ϊ�գ�");
        }
        int successNum = 0;
        int failNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (UserDetailsEntity userDetailsEntity : dataList) {
            try {
                // �Ƿ��Ѿ�����
                UserDetailsEntity existUserDetailsEntity = this.get(userDetailsEntity);
                if (null == existUserDetailsEntity) {
                    // �����û�
                    this.create(userDetailsEntity);
                    successNum++;
                    successMsg.append(String.format("<br/>%s����ɹ�",
                            successNum));
                } else if (isUpdateSupport) {
                    // �����û�
                    userDetailsEntity.setUser_id(userDetailsEntity.getUser_id());
                    this.update(userDetailsEntity);
                    successNum++;
                    successMsg.append(String.format("<br/>%s���³ɹ�",
                            successNum));
                } else {
                    throw new BusinessException(String.format("�Ѵ���"));
                }
            } catch (Exception e) {
                log.error("�������ݴ���", e);
                failNum++;
                failureMsg.append(String.format("<br/>%s����ʧ�ܣ�%s",
                        failNum, e.getMessage()));
            }
        }
        // ������Ϣ
        return CommonResult.result(successNum, failNum, successMsg, failureMsg);
    }

    @Override
    public Long count(UserDetailsParam userDetailsParam){
        //BeanUtils.setPropertiesNullIfEmpty(userDetailsParam);
        try {
            Long count = userDetailsDao.selectCount(userDetailsParam);
            return count;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
    }



}

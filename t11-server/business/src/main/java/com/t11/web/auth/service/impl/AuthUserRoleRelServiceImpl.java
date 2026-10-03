/**
 */
package com.t11.web.auth.service.impl;

import com.framework.common.tools.uuid.IdUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.foundation.springsecurity.secure.services.SecureUser;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.t11.web.auth.service.AuthRolePermRelService;
import com.t11.web.auth.service.AuthUserRoleRelService;
import com.t11.web.auth.entity.AuthRolePermRelEntity;
import com.t11.web.auth.entity.AuthUserRoleRelEntity;
import com.t11.web.auth.param.AuthRolePermRelParam;
import com.t11.web.auth.param.AuthUserRoleRelParam;
import com.t11.web.auth.entity.AuthPermEntity;

import com.foundation.springsecurity.context.UserContext;
import com.framework.web.base.page.PageResponse;
import com.framework.web.base.page.Pageable;
import com.t11.web.auth.entity.AuthUserRoleRelEntity;
import com.t11.web.auth.param.AuthUserRoleRelParam;
import com.t11.web.auth.mapper.AuthUserRoleRelMapper;
import com.t11.web.auth.dao.AuthUserRoleRelDao;
import com.t11.web.auth.service.AuthUserRoleRelService;
import lombok.extern.slf4j.Slf4j;
import com.framework.common.tools.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.collections.CollectionUtils;
import com.framework.web.domain.CommonResult;
import com.framework.web.exception.base.BusinessException;
import org.apache.commons.lang3.StringUtils;

import jakarta.annotation.Resource;
import java.util.*;

import com.t11.web.auth.param.AuthUserParam;
import com.t11.web.auth.entity.AuthUserEntity;
import com.t11.web.auth.service.AuthUserService;
import com.t11.web.auth.param.AuthRoleParam;
import com.t11.web.auth.entity.AuthRoleEntity;
import com.t11.web.auth.service.AuthRoleService;


/***
 * Title: Service-AuthUserRoleRelServiceImpl
 */
@Slf4j
@Service
public class AuthUserRoleRelServiceImpl implements AuthUserRoleRelService,UserDetailsService {

    @Resource
    private UserContext userContext;
    @Resource
    private AuthUserRoleRelDao authUserRoleRelDao;
    @Resource
    private AuthRolePermRelService authRolePermRelService;
    @Resource
    private AuthUserService authUserService;
    @Resource
    private AuthRoleService authRoleService;

    @Override
    public Long count(AuthUserRoleRelParam authUserRoleRelParam){
        //BeanUtils.setPropertiesNullIfEmpty(authUserRoleRelParam);
        try {
            Long count = authUserRoleRelDao.selectCount(authUserRoleRelParam);
            return count;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
    }
    @Override
    public List<AuthUserRoleRelEntity> list(AuthUserRoleRelParam authUserRoleRelParam){
        //BeanUtils.setPropertiesNullIfEmpty(authUserRoleRelParam);
        try {
            List<AuthUserRoleRelEntity> res = authUserRoleRelDao.selectList(authUserRoleRelParam);
            return res;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
    }
    @Override
    public boolean create(AuthUserRoleRelEntity authUserRoleRelEntity) {
        authUserRoleRelEntity.initCreateAttribute(UserContext.getUserId());
        String snowFlakeId = IdUtils.getSnowFlakeId();
        authUserRoleRelEntity.setId(snowFlakeId);
        //BeanUtils.setPropertiesNullIfEmpty(authUserRoleRelEntity);
        try{
            authUserRoleRelDao.insert(authUserRoleRelEntity);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
     @Override
     public AuthUserRoleRelEntity get(AuthUserRoleRelParam authUserRoleRelParam){
       try{
           return authUserRoleRelDao.selectOne(authUserRoleRelParam);
       } catch (Exception e){
           e.printStackTrace();
       }
       return null;
    }
    @Override
    public boolean delete(AuthUserRoleRelParam authUserRoleRelParam){
        try{
            authUserRoleRelDao.delete(authUserRoleRelParam);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(AuthUserRoleRelEntity authUserRoleRelEntity) {
       try{
           String id = authUserRoleRelEntity.getId();
           AuthUserRoleRelParam authUserRoleRelParam = new AuthUserRoleRelParam();
           authUserRoleRelParam.setId(id);
           AuthUserRoleRelEntity entity = get(authUserRoleRelParam);
           String[] ignoreProperties = {"id", "createUser", "createTime", "updateUser", "updateTime"};
           BeanUtils.copyProperties(authUserRoleRelEntity, entity, ignoreProperties);
           entity.initUpdateAttribute(UserContext.getUserId());
           authUserRoleRelDao.update(entity, authUserRoleRelParam);
           return true;
       } catch (Exception e){
           e.printStackTrace();
       }
       return false;
   }

   @Override
       public PageResponse<AuthUserRoleRelEntity> page(AuthUserRoleRelParam authUserRoleRelParam){
          try {
              List<AuthUserRoleRelEntity> list = authUserRoleRelDao.selectList(authUserRoleRelParam);
              Long count = authUserRoleRelDao.selectCount(authUserRoleRelParam);
              return new PageResponse<>(authUserRoleRelParam.getPageNo(), authUserRoleRelParam.getPageSize(), count, list);
          } catch (Exception e){
              e.printStackTrace();
          } finally {
          }
          return null;
       }
     @Override
    public CommonResult importAuthUserRoleRel(List<AuthUserRoleRelEntity> dataList, boolean isUpdateSupport) {
        if (CollectionUtils.isEmpty(dataList)) {
            throw new BusinessException("导入信息不能为空！");
        }
        int successNum = 0;
        int failNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (AuthUserRoleRelEntity authUserRoleRelEntity : dataList) {
            try {
                // 是否已经存在
                AuthUserRoleRelEntity existAuthUserRoleRelEntity = this.get(authUserRoleRelEntity);
                if (null == existAuthUserRoleRelEntity) {
                    // 创建用户
                    this.create(authUserRoleRelEntity);
                    successNum++;
                    successMsg.append(String.format("<br/>%s导入成功",
                            successNum));
                } else if (isUpdateSupport) {
                    // 更新用户
                    authUserRoleRelEntity.setId(authUserRoleRelEntity.getId());
                    this.update(authUserRoleRelEntity);
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
    private AuthUserRoleRelEntity get(AuthUserRoleRelEntity authUserRoleRelEntity){
        return null;
    }

    public Map<String,List> relateList(){
        Map<String,List> map = new HashMap<>();
        AuthUserParam authUserParam = new AuthUserParam();
        PageResponse<AuthUserEntity> authUserEntityPage = authUserService.page(authUserParam);
        List<AuthUserEntity> authUserEntityList = authUserEntityPage.getItems();
        map.put("userEntityList", authUserEntityList);
        AuthRoleParam authRoleParam = new AuthRoleParam();
        PageResponse<AuthRoleEntity> authRoleEntityPage = authRoleService.page(authRoleParam);
        List<AuthRoleEntity> authRoleEntityList = authRoleEntityPage.getItems();
        map.put("roleEntityList", authRoleEntityList);
        return map;
    }
    /**
    * Function:加载用户信息
    * Author: Admin
    * Date:2021/6/27
    * @param username
    * @return com.bjtuwh.common.secure.services.SecureUser
    * @throws Exception
    */
   @Override
   public SecureUser loadUserByUsername(String username) throws UsernameNotFoundException {
       log.info("-------------------loadUserByUsername.用户登录账号:" + username);
       SecureUser userDetails = null;
       AuthUserParam authUserParam = new AuthUserParam();
       authUserParam.setUsername(username);
       AuthUserEntity sysUser = authUserService.get(authUserParam);
       if (sysUser == null) {
           log.info("-------------------loadUserByUsername.未获取到用户");
           throw new UsernameNotFoundException("USERNAME NOT SUPPORT");
       } else {
           log.info("----------loadUserByUsername.用户ID:" + sysUser.getId() + ",用户登陆账号:" + sysUser.getUsername() + ",用户姓名:" + sysUser.getRealName());
           userDetails = new SecureUser();
           userDetails.setId(sysUser.getId());
           userDetails.setUsername(sysUser.getUsername());
           userDetails.setRealName(sysUser.getRealName());
           //用于校验密码用的
           userDetails.setPassword(sysUser.getPassword());

           //权限
           Set<? extends GrantedAuthority> grantedAuthorities = loadAuthorities(userDetails.getId());
           userDetails.setAuthorities(grantedAuthorities);
       }

       return userDetails;
   }

   /**
    * Function:加载用户权限
    * Author: Admin
    * Date:2021/6/27
    * @return java.util.Set<? extends org.springframework.security.core.GrantedAuthority>
    */
   private Set<? extends GrantedAuthority> loadAuthorities(String userId) {
       // 设置用户角色
       AuthUserRoleRelParam authUserRoleRelParam = new AuthUserRoleRelParam();
       authUserRoleRelParam.setUserId(userId);
       List<AuthUserRoleRelEntity> authUserRoleRelEntityList = list(authUserRoleRelParam);
       Set<String> codeSet = new HashSet();
       Set<SimpleGrantedAuthority> simpleGrantedAuthoritySet = new HashSet();
       for(AuthUserRoleRelEntity authUserRoleRelEntity : authUserRoleRelEntityList){
           String roleId = authUserRoleRelEntity.getRoleId();
           AuthRolePermRelParam authRolePermRelParam = new AuthRolePermRelParam();
           authRolePermRelParam.setRoleId(roleId);
           List<AuthRolePermRelEntity> authRolePermRelEntityList = authRolePermRelService.list(authRolePermRelParam);
           for(AuthRolePermRelEntity authRolePermRelEntity : authRolePermRelEntityList){
               AuthPermEntity permEntity = authRolePermRelEntity.getPermEntity();
               String code = permEntity.getCode();
               codeSet.add(code);
           }
       }
       for(String code:codeSet){
           SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(code);
           simpleGrantedAuthoritySet.add(simpleGrantedAuthority);
       }
       return simpleGrantedAuthoritySet;
   }
}
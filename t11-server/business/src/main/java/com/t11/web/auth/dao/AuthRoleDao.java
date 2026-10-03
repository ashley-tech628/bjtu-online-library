package com.t11.web.auth.dao;

import com.foundation.sql.SqlUtil;
import com.foundation.sql.record.PrepareSqlRecord;
import com.foundation.sql.SimpleExecutor;
import com.foundation.sql.record.ProviderRecord;
import com.foundation.sql.ConnectionFactory;
import com.t11.web.auth.entity.AuthRoleEntity;
import com.t11.web.auth.param.AuthRoleParam;
import com.t11.web.auth.mapper.AuthRoleMapper;
import com.t11.web.auth.sql.AuthRoleSql;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.GeneralInsertStatementProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.List;

@Repository
public class AuthRoleDao{
   public  List<AuthRoleEntity> selectList(AuthRoleParam authRoleParam){
       Connection connection = ConnectionFactory.getDefaultConnection();
       AuthRoleSql authRoleSql = new AuthRoleSql();
       ProviderRecord providerRecord = authRoleSql.selectProvider(authRoleParam);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPageSql(providerRecord,authRoleParam.getPageNo(), authRoleParam.getPageSize());
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       List<AuthRoleEntity> authRoleEntityList = simpleExecutor.selectList(connection, prepareSqlRecord, AuthRoleEntity.class);
       return authRoleEntityList;
   }
   public Long selectCount(AuthRoleParam authRoleParam){
       Connection connection = ConnectionFactory.getDefaultConnection();
       AuthRoleSql authRoleSql = new AuthRoleSql();
       ProviderRecord providerRecord = authRoleSql.selectCountProvider(authRoleParam);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(providerRecord);
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       Long count = (Long) simpleExecutor.selectValue(connection, prepareSqlRecord);
       return count;
   }
   public  AuthRoleEntity selectOne(AuthRoleParam authRoleParam){
       List<AuthRoleEntity> authRoleEntityList = selectList(authRoleParam);
       if(null == authRoleEntityList || authRoleEntityList.size() == 0)return null;
       return authRoleEntityList.get(0);
   }
   public  int insert(AuthRoleEntity authRoleEntity) {
       Connection connection = ConnectionFactory.getDefaultConnection();
       AuthRoleSql authRoleSql = new AuthRoleSql();
       GeneralInsertStatementProvider insertProvider = authRoleSql.getInsertProvider(authRoleEntity);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(insertProvider.getInsertStatement(), insertProvider.getParameters());
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
       return result;
   }
   public  int update(AuthRoleEntity authRoleEntity, AuthRoleParam authRoleParam) {
       Connection connection = ConnectionFactory.getDefaultConnection();
       AuthRoleSql authRoleSql = new AuthRoleSql();
       UpdateStatementProvider updateProvider = authRoleSql.getUpdateProvider(authRoleEntity, authRoleParam);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(updateProvider.getUpdateStatement(), updateProvider.getParameters());
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
       return result;
   }
   public  int delete(AuthRoleParam authRoleParam) {
       Connection connection = ConnectionFactory.getDefaultConnection();
       AuthRoleSql authRoleSql = new AuthRoleSql();
       DeleteStatementProvider deleteProvider = authRoleSql.getDeleteProvider(authRoleParam);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(deleteProvider.getDeleteStatement(), deleteProvider.getParameters());
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
       return result;
   }
}
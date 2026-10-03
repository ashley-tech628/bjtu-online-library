package com.t11.web.auth.dao;

import com.foundation.sql.SqlUtil;
import com.foundation.sql.record.PrepareSqlRecord;
import com.foundation.sql.SimpleExecutor;
import com.foundation.sql.record.ProviderRecord;
import com.foundation.sql.ConnectionFactory;
import com.t11.web.auth.entity.AuthUserRoleRelEntity;
import com.t11.web.auth.param.AuthUserRoleRelParam;
import com.t11.web.auth.mapper.AuthUserRoleRelMapper;
import com.t11.web.auth.sql.AuthUserRoleRelSql;
import com.t11.web.auth.entity.AuthUserEntity;
import com.t11.web.auth.entity.AuthRoleEntity;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.GeneralInsertStatementProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.List;

@Repository
public class AuthUserRoleRelDao{
   public  List<AuthUserRoleRelEntity> selectList(AuthUserRoleRelParam authUserRoleRelParam){
       Connection connection = ConnectionFactory.getDefaultConnection();
       AuthUserRoleRelSql authUserRoleRelSql = new AuthUserRoleRelSql();
       ProviderRecord providerRecord = authUserRoleRelSql.selectProvider(authUserRoleRelParam);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPageSql(providerRecord,authUserRoleRelParam.getPageNo(), authUserRoleRelParam.getPageSize());
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       List<AuthUserRoleRelEntity> authUserRoleRelEntityList = simpleExecutor.selectList(connection, prepareSqlRecord, AuthUserRoleRelEntity.class);
       return authUserRoleRelEntityList;
   }
   public Long selectCount(AuthUserRoleRelParam authUserRoleRelParam){
       Connection connection = ConnectionFactory.getDefaultConnection();
       AuthUserRoleRelSql authUserRoleRelSql = new AuthUserRoleRelSql();
       ProviderRecord providerRecord = authUserRoleRelSql.selectCountProvider(authUserRoleRelParam);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(providerRecord);
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       Long count = (Long) simpleExecutor.selectValue(connection, prepareSqlRecord);
       return count;
   }
   public  AuthUserRoleRelEntity selectOne(AuthUserRoleRelParam authUserRoleRelParam){
       List<AuthUserRoleRelEntity> authUserRoleRelEntityList = selectList(authUserRoleRelParam);
       if(null == authUserRoleRelEntityList || authUserRoleRelEntityList.size() == 0)return null;
       return authUserRoleRelEntityList.get(0);
   }
   public  int insert(AuthUserRoleRelEntity authUserRoleRelEntity) {
       Connection connection = ConnectionFactory.getDefaultConnection();
       AuthUserRoleRelSql authUserRoleRelSql = new AuthUserRoleRelSql();
       GeneralInsertStatementProvider insertProvider = authUserRoleRelSql.getInsertProvider(authUserRoleRelEntity);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(insertProvider.getInsertStatement(), insertProvider.getParameters());
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
       return result;
   }
   public  int update(AuthUserRoleRelEntity authUserRoleRelEntity, AuthUserRoleRelParam authUserRoleRelParam) {
       Connection connection = ConnectionFactory.getDefaultConnection();
       AuthUserRoleRelSql authUserRoleRelSql = new AuthUserRoleRelSql();
       UpdateStatementProvider updateProvider = authUserRoleRelSql.getUpdateProvider(authUserRoleRelEntity, authUserRoleRelParam);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(updateProvider.getUpdateStatement(), updateProvider.getParameters());
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
       return result;
   }
   public  int delete(AuthUserRoleRelParam authUserRoleRelParam) {
       Connection connection = ConnectionFactory.getDefaultConnection();
       AuthUserRoleRelSql authUserRoleRelSql = new AuthUserRoleRelSql();
       DeleteStatementProvider deleteProvider = authUserRoleRelSql.getDeleteProvider(authUserRoleRelParam);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(deleteProvider.getDeleteStatement(), deleteProvider.getParameters());
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
       return result;
   }
}
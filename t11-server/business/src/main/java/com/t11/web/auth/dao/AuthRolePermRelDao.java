package com.t11.web.auth.dao;

import com.foundation.sql.SqlUtil;
import com.foundation.sql.record.PrepareSqlRecord;
import com.foundation.sql.SimpleExecutor;
import com.foundation.sql.record.ProviderRecord;
import com.foundation.sql.ConnectionFactory;
import com.t11.web.auth.entity.AuthRolePermRelEntity;
import com.t11.web.auth.param.AuthRolePermRelParam;
import com.t11.web.auth.mapper.AuthRolePermRelMapper;
import com.t11.web.auth.sql.AuthRolePermRelSql;
import com.t11.web.auth.entity.AuthPermEntity;
import com.t11.web.auth.entity.AuthRoleEntity;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.GeneralInsertStatementProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.List;

@Repository
public class AuthRolePermRelDao{
   public  List<AuthRolePermRelEntity> selectList(AuthRolePermRelParam authRolePermRelParam){
       Connection connection = ConnectionFactory.getDefaultConnection();
       AuthRolePermRelSql authRolePermRelSql = new AuthRolePermRelSql();
       ProviderRecord providerRecord = authRolePermRelSql.selectProvider(authRolePermRelParam);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPageSql(providerRecord,authRolePermRelParam.getPageNo(), authRolePermRelParam.getPageSize());
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       List<AuthRolePermRelEntity> authRolePermRelEntityList = simpleExecutor.selectList(connection, prepareSqlRecord, AuthRolePermRelEntity.class);
       return authRolePermRelEntityList;
   }
   public Long selectCount(AuthRolePermRelParam authRolePermRelParam){
       Connection connection = ConnectionFactory.getDefaultConnection();
       AuthRolePermRelSql authRolePermRelSql = new AuthRolePermRelSql();
       ProviderRecord providerRecord = authRolePermRelSql.selectCountProvider(authRolePermRelParam);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(providerRecord);
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       Long count = (Long) simpleExecutor.selectValue(connection, prepareSqlRecord);
       return count;
   }
   public  AuthRolePermRelEntity selectOne(AuthRolePermRelParam authRolePermRelParam){
       List<AuthRolePermRelEntity> authRolePermRelEntityList = selectList(authRolePermRelParam);
       if(null == authRolePermRelEntityList || authRolePermRelEntityList.size() == 0)return null;
       return authRolePermRelEntityList.get(0);
   }
   public  int insert(AuthRolePermRelEntity authRolePermRelEntity) {
       Connection connection = ConnectionFactory.getDefaultConnection();
       AuthRolePermRelSql authRolePermRelSql = new AuthRolePermRelSql();
       GeneralInsertStatementProvider insertProvider = authRolePermRelSql.getInsertProvider(authRolePermRelEntity);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(insertProvider.getInsertStatement(), insertProvider.getParameters());
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
       return result;
   }
   public  int update(AuthRolePermRelEntity authRolePermRelEntity, AuthRolePermRelParam authRolePermRelParam) {
       Connection connection = ConnectionFactory.getDefaultConnection();
       AuthRolePermRelSql authRolePermRelSql = new AuthRolePermRelSql();
       UpdateStatementProvider updateProvider = authRolePermRelSql.getUpdateProvider(authRolePermRelEntity, authRolePermRelParam);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(updateProvider.getUpdateStatement(), updateProvider.getParameters());
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
       return result;
   }
   public  int delete(AuthRolePermRelParam authRolePermRelParam) {
       Connection connection = ConnectionFactory.getDefaultConnection();
       AuthRolePermRelSql authRolePermRelSql = new AuthRolePermRelSql();
       DeleteStatementProvider deleteProvider = authRolePermRelSql.getDeleteProvider(authRolePermRelParam);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(deleteProvider.getDeleteStatement(), deleteProvider.getParameters());
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
       return result;
   }
}
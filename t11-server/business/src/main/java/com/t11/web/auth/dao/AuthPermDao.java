package com.t11.web.auth.dao;

import com.foundation.sql.SqlUtil;
import com.foundation.sql.record.PrepareSqlRecord;
import com.foundation.sql.SimpleExecutor;
import com.foundation.sql.record.ProviderRecord;
import com.foundation.sql.ConnectionFactory;
import com.t11.web.auth.entity.AuthPermEntity;
import com.t11.web.auth.param.AuthPermParam;
import com.t11.web.auth.mapper.AuthPermMapper;
import com.t11.web.auth.sql.AuthPermSql;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.GeneralInsertStatementProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.List;

@Repository
public class AuthPermDao{
   public  List<AuthPermEntity> selectList(AuthPermParam authPermParam){
       Connection connection = ConnectionFactory.getDefaultConnection();
       AuthPermSql authPermSql = new AuthPermSql();
       ProviderRecord providerRecord = authPermSql.selectProvider(authPermParam);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPageSql(providerRecord,authPermParam.getPageNo(), authPermParam.getPageSize());
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       List<AuthPermEntity> authPermEntityList = simpleExecutor.selectList(connection, prepareSqlRecord, AuthPermEntity.class);
       return authPermEntityList;
   }
   public Long selectCount(AuthPermParam authPermParam){
       Connection connection = ConnectionFactory.getDefaultConnection();
       AuthPermSql authPermSql = new AuthPermSql();
       ProviderRecord providerRecord = authPermSql.selectCountProvider(authPermParam);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(providerRecord);
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       Long count = (Long) simpleExecutor.selectValue(connection, prepareSqlRecord);
       return count;
   }
   public  AuthPermEntity selectOne(AuthPermParam authPermParam){
       List<AuthPermEntity> authPermEntityList = selectList(authPermParam);
       if(null == authPermEntityList || authPermEntityList.size() == 0)return null;
       return authPermEntityList.get(0);
   }
   public  int insert(AuthPermEntity authPermEntity) {
       Connection connection = ConnectionFactory.getDefaultConnection();
       AuthPermSql authPermSql = new AuthPermSql();
       GeneralInsertStatementProvider insertProvider = authPermSql.getInsertProvider(authPermEntity);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(insertProvider.getInsertStatement(), insertProvider.getParameters());
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
       return result;
   }
   public  int update(AuthPermEntity authPermEntity, AuthPermParam authPermParam) {
       Connection connection = ConnectionFactory.getDefaultConnection();
       AuthPermSql authPermSql = new AuthPermSql();
       UpdateStatementProvider updateProvider = authPermSql.getUpdateProvider(authPermEntity, authPermParam);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(updateProvider.getUpdateStatement(), updateProvider.getParameters());
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
       return result;
   }
   public  int delete(AuthPermParam authPermParam) {
       Connection connection = ConnectionFactory.getDefaultConnection();
       AuthPermSql authPermSql = new AuthPermSql();
       DeleteStatementProvider deleteProvider = authPermSql.getDeleteProvider(authPermParam);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(deleteProvider.getDeleteStatement(), deleteProvider.getParameters());
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
       return result;
   }
}
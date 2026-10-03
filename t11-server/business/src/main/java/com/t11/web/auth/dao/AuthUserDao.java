package com.t11.web.auth.dao;

import com.foundation.sql.SqlUtil;
import com.foundation.sql.record.PrepareSqlRecord;
import com.foundation.sql.SimpleExecutor;
import com.foundation.sql.record.ProviderRecord;
import com.foundation.sql.ConnectionFactory;
import com.t11.web.auth.entity.AuthUserEntity;
import com.t11.web.auth.param.AuthUserParam;
import com.t11.web.auth.mapper.AuthUserMapper;
import com.t11.web.auth.sql.AuthUserSql;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.GeneralInsertStatementProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.List;

@Repository
public class AuthUserDao{
   public  List<AuthUserEntity> selectList(AuthUserParam authUserParam){
       Connection connection = ConnectionFactory.getDefaultConnection();
       AuthUserSql authUserSql = new AuthUserSql();
       ProviderRecord providerRecord = authUserSql.selectProvider(authUserParam);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPageSql(providerRecord,authUserParam.getPageNo(), authUserParam.getPageSize());
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       List<AuthUserEntity> authUserEntityList = simpleExecutor.selectList(connection, prepareSqlRecord, AuthUserEntity.class);
       return authUserEntityList;
   }
   public Long selectCount(AuthUserParam authUserParam){
       Connection connection = ConnectionFactory.getDefaultConnection();
       AuthUserSql authUserSql = new AuthUserSql();
       ProviderRecord providerRecord = authUserSql.selectCountProvider(authUserParam);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(providerRecord);
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       Long count = (Long) simpleExecutor.selectValue(connection, prepareSqlRecord);
       return count;
   }

    public Long selectCount(AuthUserEntity authUserEntity){
        Connection connection = ConnectionFactory.getDefaultConnection();
        AuthUserSql authUserSql = new AuthUserSql();
        ProviderRecord providerRecord = authUserSql.selectCountProvider(authUserEntity);
        PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(providerRecord);
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        Long count = (Long) simpleExecutor.selectValue(connection, prepareSqlRecord);
        return count;
    }

   public  AuthUserEntity selectOne(AuthUserParam authUserParam){
       List<AuthUserEntity> authUserEntityList = selectList(authUserParam);
       if(null == authUserEntityList || authUserEntityList.size() == 0) {
           return null;
       }
       return authUserEntityList.get(0);
   }
   public  int insert(AuthUserEntity authUserEntity) {
       Connection connection = ConnectionFactory.getDefaultConnection();
       AuthUserSql authUserSql = new AuthUserSql();
       GeneralInsertStatementProvider insertProvider = authUserSql.getInsertProvider(authUserEntity);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(insertProvider.getInsertStatement(), insertProvider.getParameters());
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
       return result;
   }
   public  int update(AuthUserEntity authUserEntity, AuthUserParam authUserParam) {
       Connection connection = ConnectionFactory.getDefaultConnection();
       AuthUserSql authUserSql = new AuthUserSql();
       UpdateStatementProvider updateProvider = authUserSql.getUpdateProvider(authUserEntity, authUserParam);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(updateProvider.getUpdateStatement(), updateProvider.getParameters());
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
       return result;
   }
   public  int delete(AuthUserParam authUserParam) {
       Connection connection = ConnectionFactory.getDefaultConnection();
       AuthUserSql authUserSql = new AuthUserSql();
       DeleteStatementProvider deleteProvider = authUserSql.getDeleteProvider(authUserParam);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(deleteProvider.getDeleteStatement(), deleteProvider.getParameters());
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
       return result;
   }
}
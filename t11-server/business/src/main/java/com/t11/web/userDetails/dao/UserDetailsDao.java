package com.t11.web.userDetails.dao;

import com.foundation.sql.SqlUtil;
import com.foundation.sql.record.PrepareSqlRecord;
import com.foundation.sql.SimpleExecutor;
import com.foundation.sql.record.ProviderRecord;
import com.foundation.sql.ConnectionFactory;
import com.t11.web.userDetails.entity.UserDetailsEntity;
import com.t11.web.userDetails.param.UserDetailsParam;
import com.t11.web.userDetails.sql.UserDetailsSql;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.GeneralInsertStatementProvider;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.List;

@Repository
public class UserDetailsDao{

    public  List<UserDetailsEntity> selectList(UserDetailsParam userDetailsParam){
        Connection connection = ConnectionFactory.getDefaultConnection();
        UserDetailsSql userDetailsSql = new UserDetailsSql();
        ProviderRecord providerRecord = userDetailsSql.selectProvider(userDetailsParam);
        PrepareSqlRecord prepareSqlRecord = SqlUtil.getPageSql(providerRecord,userDetailsParam.getPageNo(), userDetailsParam.getPageSize());
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        List<UserDetailsEntity> userDetailsEntityList = simpleExecutor.selectList(connection, prepareSqlRecord, UserDetailsEntity.class);
        return userDetailsEntityList;
    }

    public Long selectCount(UserDetailsParam userDetailsParam){
        Connection connection = ConnectionFactory.getDefaultConnection();
        UserDetailsSql userDetailsSql = new UserDetailsSql();
        ProviderRecord providerRecord = userDetailsSql.selectCountProvider(userDetailsParam);
        PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(providerRecord);
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        Long count = (Long) simpleExecutor.selectValue(connection, prepareSqlRecord);
        return count;
    }
    public UserDetailsEntity selectOne(UserDetailsParam userDetailsParam){
        List<UserDetailsEntity> userDetailsEntityList = selectList(userDetailsParam);
        if(null == userDetailsEntityList || userDetailsEntityList.size() == 0) {
            return null;
        }
        return userDetailsEntityList.get(0);
    }
    public int insert(UserDetailsEntity userDetailsEntity) {
        Connection connection = ConnectionFactory.getDefaultConnection();
        UserDetailsSql userDetailsSql = new UserDetailsSql();
        GeneralInsertStatementProvider insertProvider = userDetailsSql.getInsertProvider(userDetailsEntity);
        PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(insertProvider.getInsertStatement(), insertProvider.getParameters());
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
        return result;
    }
    public  int update(UserDetailsEntity userDetailsEntity, UserDetailsParam userDetailsParam) {
        Connection connection = ConnectionFactory.getDefaultConnection();
        UserDetailsSql userDetailsSql = new UserDetailsSql();
        UpdateStatementProvider updateProvider = userDetailsSql.getUpdateProvider(userDetailsEntity, userDetailsParam);
        PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(updateProvider.getUpdateStatement(), updateProvider.getParameters());
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
        return result;
    }
    public  int delete(UserDetailsParam userDetailsParam) {
        Connection connection = ConnectionFactory.getDefaultConnection();
        UserDetailsSql userDetailsSql = new UserDetailsSql();
        DeleteStatementProvider deleteProvider = userDetailsSql.getDeleteProvider(userDetailsParam);
        PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(deleteProvider.getDeleteStatement(), deleteProvider.getParameters());
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
        return result;
    }
}

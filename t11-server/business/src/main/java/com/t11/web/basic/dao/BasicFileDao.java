package com.t11.web.basic.dao;

import com.foundation.sql.SqlUtil;
import com.foundation.sql.record.PrepareSqlRecord;
import com.foundation.sql.SimpleExecutor;
import com.foundation.sql.record.ProviderRecord;
import com.foundation.sql.ConnectionFactory;
import com.t11.web.basic.entity.BasicFileEntity;
import com.t11.web.basic.param.BasicFileParam;
import com.t11.web.basic.mapper.BasicFileMapper;
import com.t11.web.basic.sql.BasicFileSql;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.GeneralInsertStatementProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.List;

@Repository
public class BasicFileDao{
   public  List<BasicFileEntity> selectList(BasicFileParam basicFileParam){
       Connection connection = ConnectionFactory.getDefaultConnection();
       BasicFileSql basicFileSql = new BasicFileSql();
       ProviderRecord providerRecord = basicFileSql.selectProvider(basicFileParam);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPageSql(providerRecord,basicFileParam.getPageNo(), basicFileParam.getPageSize());
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       List<BasicFileEntity> basicFileEntityList = simpleExecutor.selectList(connection, prepareSqlRecord, BasicFileEntity.class);
       return basicFileEntityList;
   }
   public Long selectCount(BasicFileParam basicFileParam){
       Connection connection = ConnectionFactory.getDefaultConnection();
       BasicFileSql basicFileSql = new BasicFileSql();
       ProviderRecord providerRecord = basicFileSql.selectCountProvider(basicFileParam);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(providerRecord);
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       Long count = (Long) simpleExecutor.selectValue(connection, prepareSqlRecord);
       return count;
   }
   public  BasicFileEntity selectOne(BasicFileParam basicFileParam){
       List<BasicFileEntity> basicFileEntityList = selectList(basicFileParam);
       if(null == basicFileEntityList || basicFileEntityList.size() == 0)return null;
       return basicFileEntityList.get(0);
   }
   public  int insert(BasicFileEntity basicFileEntity) {
       Connection connection = ConnectionFactory.getDefaultConnection();
       BasicFileSql basicFileSql = new BasicFileSql();
       GeneralInsertStatementProvider insertProvider = basicFileSql.getInsertProvider(basicFileEntity);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(insertProvider.getInsertStatement(), insertProvider.getParameters());
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
       return result;
   }
   public  int update(BasicFileEntity basicFileEntity, BasicFileParam basicFileParam) {
       Connection connection = ConnectionFactory.getDefaultConnection();
       BasicFileSql basicFileSql = new BasicFileSql();
       UpdateStatementProvider updateProvider = basicFileSql.getUpdateProvider(basicFileEntity, basicFileParam);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(updateProvider.getUpdateStatement(), updateProvider.getParameters());
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
       return result;
   }
   public  int delete(BasicFileParam basicFileParam) {
       Connection connection = ConnectionFactory.getDefaultConnection();
       BasicFileSql basicFileSql = new BasicFileSql();
       DeleteStatementProvider deleteProvider = basicFileSql.getDeleteProvider(basicFileParam);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(deleteProvider.getDeleteStatement(), deleteProvider.getParameters());
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
       return result;
   }
}
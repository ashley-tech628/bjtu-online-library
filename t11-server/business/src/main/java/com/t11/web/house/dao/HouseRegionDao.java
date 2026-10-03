package com.t11.web.house.dao;

import com.foundation.sql.SqlUtil;
import com.foundation.sql.record.PrepareSqlRecord;
import com.foundation.sql.SimpleExecutor;
import com.foundation.sql.record.ProviderRecord;
import com.foundation.sql.ConnectionFactory;
import com.t11.web.house.entity.HouseRegionEntity;
import com.t11.web.house.param.HouseRegionParam;
import com.t11.web.house.sql.HouseRegionSql;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.GeneralInsertStatementProvider;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.List;

@Repository
public class HouseRegionDao{
   public  List<HouseRegionEntity> selectList(HouseRegionParam houseRegionParam){
       Connection connection = ConnectionFactory.getDefaultConnection();
       HouseRegionSql houseRegionSql = new HouseRegionSql();
       ProviderRecord providerRecord = houseRegionSql.selectProvider(houseRegionParam);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPageSql(providerRecord,houseRegionParam.getPageNo(), houseRegionParam.getPageSize());
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       List<HouseRegionEntity> houseRegionEntityList = simpleExecutor.selectList(connection, prepareSqlRecord, HouseRegionEntity.class);
       return houseRegionEntityList;
   }
   public Long selectCount(HouseRegionParam houseRegionParam){
       Connection connection = ConnectionFactory.getDefaultConnection();
       HouseRegionSql houseRegionSql = new HouseRegionSql();
       ProviderRecord providerRecord = houseRegionSql.selectCountProvider(houseRegionParam);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(providerRecord);
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       Long count = (Long) simpleExecutor.selectValue(connection, prepareSqlRecord);
       return count;
   }
   public HouseRegionEntity selectOne(HouseRegionParam houseRegionParam){
       List<HouseRegionEntity> houseRegionEntityList = selectList(houseRegionParam);
       if(null == houseRegionEntityList || houseRegionEntityList.size() == 0)return null;
       return houseRegionEntityList.get(0);
   }
   public  int insert(HouseRegionEntity houseRegionEntity) {
       Connection connection = ConnectionFactory.getDefaultConnection();
       HouseRegionSql houseRegionSql = new HouseRegionSql();
       GeneralInsertStatementProvider insertProvider = houseRegionSql.getInsertProvider(houseRegionEntity);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(insertProvider.getInsertStatement(), insertProvider.getParameters());
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
       return result;
   }
   public  int update(HouseRegionEntity houseRegionEntity, HouseRegionParam houseRegionParam) {
       Connection connection = ConnectionFactory.getDefaultConnection();
       HouseRegionSql houseRegionSql = new HouseRegionSql();
       UpdateStatementProvider updateProvider = houseRegionSql.getUpdateProvider(houseRegionEntity, houseRegionParam);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(updateProvider.getUpdateStatement(), updateProvider.getParameters());
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
       return result;
   }
   public  int delete(HouseRegionParam houseRegionParam) {
       Connection connection = ConnectionFactory.getDefaultConnection();
       HouseRegionSql houseRegionSql = new HouseRegionSql();
       DeleteStatementProvider deleteProvider = houseRegionSql.getDeleteProvider(houseRegionParam);
       PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(deleteProvider.getDeleteStatement(), deleteProvider.getParameters());
       SimpleExecutor simpleExecutor = new SimpleExecutor();
       int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
       return result;
   }
}
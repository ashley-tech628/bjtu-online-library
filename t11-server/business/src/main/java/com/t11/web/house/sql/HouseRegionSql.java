package com.t11.web.house.sql;

import com.foundation.sql.DynamicSql;
import com.foundation.sql.SqlConstant;
import com.foundation.sql.SqlUtil;
import com.foundation.sql.TableSupport;
import com.foundation.sql.record.JoinTableRecord;
import com.foundation.sql.record.ProviderRecord;
import com.t11.web.house.entity.HouseRegionEntity;
import com.t11.web.house.sql.generic.HouseRegionGenericSql;
import com.framework.web.base.param.BaseParam;
import com.t11.web.house.param.HouseRegionParam;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.SqlTable;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.GeneralInsertStatementProvider;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectModel;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.where.AbstractWhereDSL;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import  com.t11.web.house.sql.support.HouseRegionSupport;
import  com.t11.web.house.sql.support.HouseRegionSupport.HouseRegionTable;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

public final class HouseRegionSql implements DynamicSql {
     public HouseRegionSql(){
            houseRegionSupport = new HouseRegionSupport();
            houseRegionTable = (HouseRegionTable) houseRegionSupport.getSqlTable();
            houseRegionGenericSql = new HouseRegionGenericSql(houseRegionTable);
     }
     public HouseRegionSql(HouseRegionSupport houseRegionSupport){
            houseRegionTable = (HouseRegionTable) houseRegionSupport.getSqlTable();
            houseRegionGenericSql = new HouseRegionGenericSql(houseRegionTable);
     }
    private HouseRegionGenericSql houseRegionGenericSql;
    private HouseRegionSupport houseRegionSupport;
    private HouseRegionTable houseRegionTable;

    public GeneralInsertStatementProvider getInsertProvider(HouseRegionEntity houseRegionEntity){
           return houseRegionGenericSql.getInsertProvider(houseRegionEntity);
    }
    public UpdateStatementProvider getUpdateProvider(HouseRegionEntity houseRegionEntity, HouseRegionParam houseRegionParam){
        return houseRegionGenericSql.getUpdateProvider(houseRegionEntity, houseRegionParam);
    }
    public DeleteStatementProvider getDeleteProvider(HouseRegionParam houseRegionParam){
        return houseRegionGenericSql.getDeleteProvider(houseRegionParam);
    }
    public void appendCondition(AbstractWhereDSL where, SqlTable sqlTable, BaseParam param) {
        houseRegionGenericSql.appendCondition(where, houseRegionTable, param);
    }
    private List<JoinTableRecord> getJoinTableRecordList(HouseRegionParam houseRegionParam){
        List<JoinTableRecord> joinTableRecordList = new ArrayList<>();
        return joinTableRecordList;
    }
    public  ProviderRecord selectCountProvider(HouseRegionParam houseRegionParam) {
        List<JoinTableRecord> joinTableRecordList = getJoinTableRecordList(houseRegionParam);
        QueryExpressionDSL<SelectModel> from = select(count()).from(houseRegionTable, SqlConstant.selfTableAlias);
        QueryExpressionDSL.QueryExpressionWhereBuilder where = leftJoin(from, houseRegionParam, joinTableRecordList);
        SelectStatementProvider selectProvider = SqlUtil.renderWhereBuilder(where);
        Map<String, String> joinTableMap = SqlUtil.getJoinTableMap(joinTableRecordList);
        return new ProviderRecord(selectProvider, joinTableMap);
    }
    public  ProviderRecord selectProvider(HouseRegionParam houseRegionParam) {
        List<JoinTableRecord> joinTableRecordList = getJoinTableRecordList(houseRegionParam);
        List<BasicColumn> fieldList = new ArrayList<>();
        fieldList.addAll(SqlUtil.getStar(houseRegionTable));
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            TableSupport destSupport = JoinTableRecord.destSupport();
            List<BasicColumn> aliasColumnList = SqlUtil.getAliasColumnList(destSupport.getTableAlias(), destSupport.getColumnList());
            fieldList.addAll(aliasColumnList);
        }
        QueryExpressionDSL<SelectModel> from = select(fieldList).from(houseRegionTable, SqlConstant.selfTableAlias);
        QueryExpressionDSL.QueryExpressionWhereBuilder where = leftJoin(from, houseRegionParam, joinTableRecordList);
        orderBy(where);
        SelectStatementProvider selectProvider = SqlUtil.renderWhereBuilder(where);
        Map<String, String> joinTableMap = SqlUtil.getJoinTableMap(joinTableRecordList);
        return new ProviderRecord(selectProvider, joinTableMap);
    }
    public  QueryExpressionDSL.QueryExpressionWhereBuilder leftJoin(QueryExpressionDSL<SelectModel> from,
                                                                    HouseRegionParam houseRegionParam, List<JoinTableRecord> joinTableRecordList) {
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            TableSupport srcSupport = JoinTableRecord.srcSupport();
            TableSupport destSupport = JoinTableRecord.destSupport();
            from.leftJoin(destSupport.getSqlTable(), destSupport.getTableAlias()).on(srcSupport.getJoinColumn(), equalTo(destSupport.getJoinedColumn()));
        }
        QueryExpressionDSL.QueryExpressionWhereBuilder where = from.where();
        appendCondition(where, houseRegionTable, houseRegionParam);
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            DynamicSql dynamicSql = JoinTableRecord.destTableSql();
            TableSupport destSupport = JoinTableRecord.destSupport();
            BaseParam param = destSupport.getParam();
            dynamicSql.appendCondition(where, destSupport.getSqlTable(), param);
        }
        return where;
    }
    public void orderBy(QueryExpressionDSL.QueryExpressionWhereBuilder where){
        where.orderBy(houseRegionTable.createTime.descending());
    }
}
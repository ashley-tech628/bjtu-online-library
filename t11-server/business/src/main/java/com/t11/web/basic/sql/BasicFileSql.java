package com.t11.web.basic.sql;

import com.foundation.sql.DynamicSql;
import com.foundation.sql.SqlConstant;
import com.foundation.sql.SqlUtil;
import com.foundation.sql.TableSupport;
import com.foundation.sql.record.JoinTableRecord;
import com.foundation.sql.record.ProviderRecord;
import com.t11.web.basic.sql.generic.BasicFileGenericSql;
import com.framework.web.base.param.BaseParam;
import com.framework.web.base.sql.BaseDynamicSql;
import com.t11.web.basic.param.BasicFileParam;
import com.t11.web.basic.param.BasicFileParam;
import com.t11.web.basic.entity.BasicFileEntity;
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

import  com.t11.web.basic.sql.support.BasicFileSupport;
import  com.t11.web.basic.sql.support.BasicFileSupport.BasicFileTable;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

public final class BasicFileSql implements DynamicSql {
     public BasicFileSql(){
            basicFileSupport = new BasicFileSupport();
            basicFileTable = (BasicFileTable) basicFileSupport.getSqlTable();
            basicFileGenericSql = new BasicFileGenericSql(basicFileTable);
     }
     public BasicFileSql(BasicFileSupport basicFileSupport){
            basicFileTable = (BasicFileTable) basicFileSupport.getSqlTable();
            basicFileGenericSql = new BasicFileGenericSql(basicFileTable);
     }
    private BasicFileGenericSql basicFileGenericSql;
    private BasicFileSupport basicFileSupport;
    private BasicFileTable basicFileTable;

    public GeneralInsertStatementProvider getInsertProvider(BasicFileEntity basicFileEntity){
           return basicFileGenericSql.getInsertProvider(basicFileEntity);
    }
    public UpdateStatementProvider getUpdateProvider(BasicFileEntity basicFileEntity, BasicFileParam basicFileParam){
        return basicFileGenericSql.getUpdateProvider(basicFileEntity, basicFileParam);
    }
    public DeleteStatementProvider getDeleteProvider(BasicFileParam basicFileParam){
        return basicFileGenericSql.getDeleteProvider(basicFileParam);
    }
    public void appendCondition(AbstractWhereDSL where, SqlTable sqlTable, BaseParam param) {
        basicFileGenericSql.appendCondition(where, basicFileTable, param);
    }
    private List<JoinTableRecord> getJoinTableRecordList(BasicFileParam basicFileParam){
        List<JoinTableRecord> joinTableRecordList = new ArrayList<>();
        return joinTableRecordList;
    }
    public  ProviderRecord selectCountProvider(BasicFileParam basicFileParam) {
        List<JoinTableRecord> joinTableRecordList = getJoinTableRecordList(basicFileParam);
        QueryExpressionDSL<SelectModel> from = select(count()).from(basicFileTable, SqlConstant.selfTableAlias);
        QueryExpressionDSL.QueryExpressionWhereBuilder where = leftJoin(from, basicFileParam, joinTableRecordList);
        SelectStatementProvider selectProvider = SqlUtil.renderWhereBuilder(where);
        Map<String, String> joinTableMap = SqlUtil.getJoinTableMap(joinTableRecordList);
        return new ProviderRecord(selectProvider, joinTableMap);
    }
    public  ProviderRecord selectProvider(BasicFileParam basicFileParam) {
        List<JoinTableRecord> joinTableRecordList = getJoinTableRecordList(basicFileParam);
        List<BasicColumn> fieldList = new ArrayList<>();
        fieldList.addAll(SqlUtil.getStar(basicFileTable));
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            TableSupport destSupport = JoinTableRecord.destSupport();
            List<BasicColumn> aliasColumnList = SqlUtil.getAliasColumnList(destSupport.getTableAlias(), destSupport.getColumnList());
            fieldList.addAll(aliasColumnList);
        }
        QueryExpressionDSL<SelectModel> from = select(fieldList).from(basicFileTable, SqlConstant.selfTableAlias);
        QueryExpressionDSL.QueryExpressionWhereBuilder where = leftJoin(from, basicFileParam, joinTableRecordList);
        orderBy(where);
        SelectStatementProvider selectProvider = SqlUtil.renderWhereBuilder(where);
        Map<String, String> joinTableMap = SqlUtil.getJoinTableMap(joinTableRecordList);
        return new ProviderRecord(selectProvider, joinTableMap);
    }
    public  QueryExpressionDSL.QueryExpressionWhereBuilder leftJoin(QueryExpressionDSL<SelectModel> from,
                                         BasicFileParam basicFileParam, List<JoinTableRecord> joinTableRecordList) {
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            TableSupport srcSupport = JoinTableRecord.srcSupport();
            TableSupport destSupport = JoinTableRecord.destSupport();
            from.leftJoin(destSupport.getSqlTable(), destSupport.getTableAlias()).on(srcSupport.getJoinColumn(), equalTo(destSupport.getJoinedColumn()));
        }
        QueryExpressionDSL.QueryExpressionWhereBuilder where = from.where();
        appendCondition(where, basicFileTable, basicFileParam);
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            DynamicSql dynamicSql = JoinTableRecord.destTableSql();
            TableSupport destSupport = JoinTableRecord.destSupport();
            BaseParam param = destSupport.getParam();
            dynamicSql.appendCondition(where, destSupport.getSqlTable(), param);
        }
        return where;
    }
    public void orderBy(QueryExpressionDSL.QueryExpressionWhereBuilder where){
        where.orderBy(basicFileTable.createTime.descending());
    }
}
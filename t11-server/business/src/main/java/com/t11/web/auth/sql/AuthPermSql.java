package com.t11.web.auth.sql;

import com.foundation.sql.DynamicSql;
import com.foundation.sql.SqlConstant;
import com.foundation.sql.SqlUtil;
import com.foundation.sql.TableSupport;
import com.foundation.sql.record.JoinTableRecord;
import com.foundation.sql.record.ProviderRecord;
import com.t11.web.auth.sql.generic.AuthPermGenericSql;
import com.framework.web.base.param.BaseParam;
import com.framework.web.base.sql.BaseDynamicSql;
import com.t11.web.auth.param.AuthPermParam;
import com.t11.web.auth.param.AuthPermParam;
import com.t11.web.auth.entity.AuthPermEntity;
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

import  com.t11.web.auth.sql.support.AuthPermSupport;
import  com.t11.web.auth.sql.support.AuthPermSupport.AuthPermTable;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

public final class AuthPermSql implements DynamicSql {
     public AuthPermSql(){
            authPermSupport = new AuthPermSupport();
            authPermTable = (AuthPermTable) authPermSupport.getSqlTable();
            authPermGenericSql = new AuthPermGenericSql(authPermTable);
     }
     public AuthPermSql(AuthPermSupport authPermSupport){
            authPermTable = (AuthPermTable) authPermSupport.getSqlTable();
            authPermGenericSql = new AuthPermGenericSql(authPermTable);
     }
    private AuthPermGenericSql authPermGenericSql;
    private AuthPermSupport authPermSupport;
    private AuthPermTable authPermTable;

    public GeneralInsertStatementProvider getInsertProvider(AuthPermEntity authPermEntity){
           return authPermGenericSql.getInsertProvider(authPermEntity);
    }
    public UpdateStatementProvider getUpdateProvider(AuthPermEntity authPermEntity, AuthPermParam authPermParam){
        return authPermGenericSql.getUpdateProvider(authPermEntity, authPermParam);
    }
    public DeleteStatementProvider getDeleteProvider(AuthPermParam authPermParam){
        return authPermGenericSql.getDeleteProvider(authPermParam);
    }
    public void appendCondition(AbstractWhereDSL where, SqlTable sqlTable, BaseParam param) {
        authPermGenericSql.appendCondition(where, authPermTable, param);
    }
    private List<JoinTableRecord> getJoinTableRecordList(AuthPermParam authPermParam){
        List<JoinTableRecord> joinTableRecordList = new ArrayList<>();
        return joinTableRecordList;
    }
    public  ProviderRecord selectCountProvider(AuthPermParam authPermParam) {
        List<JoinTableRecord> joinTableRecordList = getJoinTableRecordList(authPermParam);
        QueryExpressionDSL<SelectModel> from = select(count()).from(authPermTable, SqlConstant.selfTableAlias);
        QueryExpressionDSL.QueryExpressionWhereBuilder where = leftJoin(from, authPermParam, joinTableRecordList);
        SelectStatementProvider selectProvider = SqlUtil.renderWhereBuilder(where);
        Map<String, String> joinTableMap = SqlUtil.getJoinTableMap(joinTableRecordList);
        return new ProviderRecord(selectProvider, joinTableMap);
    }
    public  ProviderRecord selectProvider(AuthPermParam authPermParam) {
        List<JoinTableRecord> joinTableRecordList = getJoinTableRecordList(authPermParam);
        List<BasicColumn> fieldList = new ArrayList<>();
        fieldList.addAll(SqlUtil.getStar(authPermTable));
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            TableSupport destSupport = JoinTableRecord.destSupport();
            List<BasicColumn> aliasColumnList = SqlUtil.getAliasColumnList(destSupport.getTableAlias(), destSupport.getColumnList());
            fieldList.addAll(aliasColumnList);
        }
        QueryExpressionDSL<SelectModel> from = select(fieldList).from(authPermTable, SqlConstant.selfTableAlias);
        QueryExpressionDSL.QueryExpressionWhereBuilder where = leftJoin(from, authPermParam, joinTableRecordList);
        orderBy(where);
        SelectStatementProvider selectProvider = SqlUtil.renderWhereBuilder(where);
        Map<String, String> joinTableMap = SqlUtil.getJoinTableMap(joinTableRecordList);
        return new ProviderRecord(selectProvider, joinTableMap);
    }
    public  QueryExpressionDSL.QueryExpressionWhereBuilder leftJoin(QueryExpressionDSL<SelectModel> from,
                                         AuthPermParam authPermParam, List<JoinTableRecord> joinTableRecordList) {
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            TableSupport srcSupport = JoinTableRecord.srcSupport();
            TableSupport destSupport = JoinTableRecord.destSupport();
            from.leftJoin(destSupport.getSqlTable(), destSupport.getTableAlias()).on(srcSupport.getJoinColumn(), equalTo(destSupport.getJoinedColumn()));
        }
        QueryExpressionDSL.QueryExpressionWhereBuilder where = from.where();
        appendCondition(where, authPermTable, authPermParam);
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            DynamicSql dynamicSql = JoinTableRecord.destTableSql();
            TableSupport destSupport = JoinTableRecord.destSupport();
            BaseParam param = destSupport.getParam();
            dynamicSql.appendCondition(where, destSupport.getSqlTable(), param);
        }
        return where;
    }
    public void orderBy(QueryExpressionDSL.QueryExpressionWhereBuilder where){
        where.orderBy(authPermTable.createTime.descending());
    }
}
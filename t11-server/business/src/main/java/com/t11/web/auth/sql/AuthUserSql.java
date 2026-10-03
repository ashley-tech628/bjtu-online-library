package com.t11.web.auth.sql;

import com.foundation.sql.DynamicSql;
import com.foundation.sql.SqlConstant;
import com.foundation.sql.SqlUtil;
import com.foundation.sql.TableSupport;
import com.foundation.sql.record.JoinTableRecord;
import com.foundation.sql.record.ProviderRecord;
import com.framework.web.base.entity.BaseEntity;
import com.t11.web.auth.sql.generic.AuthUserGenericSql;
import com.framework.web.base.param.BaseParam;
import com.framework.web.base.sql.BaseDynamicSql;
import com.t11.web.auth.param.AuthUserParam;
import com.t11.web.auth.param.AuthUserParam;
import com.t11.web.auth.entity.AuthUserEntity;
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

import  com.t11.web.auth.sql.support.AuthUserSupport;
import  com.t11.web.auth.sql.support.AuthUserSupport.AuthUserTable;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

public final class AuthUserSql implements DynamicSql {
     public AuthUserSql(){
            authUserSupport = new AuthUserSupport();
            authUserTable = (AuthUserTable) authUserSupport.getSqlTable();
            authUserGenericSql = new AuthUserGenericSql(authUserTable);
     }
     public AuthUserSql(AuthUserSupport authUserSupport){
            authUserTable = (AuthUserTable) authUserSupport.getSqlTable();
            authUserGenericSql = new AuthUserGenericSql(authUserTable);
     }
    private AuthUserGenericSql authUserGenericSql;
    private AuthUserSupport authUserSupport;
    private AuthUserTable authUserTable;

    public GeneralInsertStatementProvider getInsertProvider(AuthUserEntity authUserEntity){
           return authUserGenericSql.getInsertProvider(authUserEntity);
    }
    public UpdateStatementProvider getUpdateProvider(AuthUserEntity authUserEntity, AuthUserParam authUserParam){
        return authUserGenericSql.getUpdateProvider(authUserEntity, authUserParam);
    }
    public DeleteStatementProvider getDeleteProvider(AuthUserParam authUserParam){
        return authUserGenericSql.getDeleteProvider(authUserParam);
    }
    public void appendCondition(AbstractWhereDSL where, SqlTable sqlTable, BaseParam param) {
        authUserGenericSql.appendCondition(where, authUserTable, param);
    }

    public void appendCondition(AbstractWhereDSL where, SqlTable sqlTable, BaseEntity entity) {
        authUserGenericSql.appendCondition(where, authUserTable, entity);
    }
    private List<JoinTableRecord> getJoinTableRecordList(AuthUserParam authUserParam){
        List<JoinTableRecord> joinTableRecordList = new ArrayList<>();
        return joinTableRecordList;
    }

    private List<JoinTableRecord> getJoinTableRecordList(AuthUserEntity authUserEntity){
        List<JoinTableRecord> joinTableRecordList = new ArrayList<>();
        return joinTableRecordList;
    }

    public  ProviderRecord selectCountProvider(AuthUserParam authUserParam) {
        List<JoinTableRecord> joinTableRecordList = getJoinTableRecordList(authUserParam);
        QueryExpressionDSL<SelectModel> from = select(count()).from(authUserTable, SqlConstant.selfTableAlias);
        QueryExpressionDSL.QueryExpressionWhereBuilder where = leftJoin(from, authUserParam, joinTableRecordList);
        SelectStatementProvider selectProvider = SqlUtil.renderWhereBuilder(where);
        Map<String, String> joinTableMap = SqlUtil.getJoinTableMap(joinTableRecordList);
        return new ProviderRecord(selectProvider, joinTableMap);
    }

    public  ProviderRecord selectCountProvider(AuthUserEntity authUserEntity) {
        List<JoinTableRecord> joinTableRecordList = getJoinTableRecordList(authUserEntity);
        QueryExpressionDSL<SelectModel> from = select(count()).from(authUserTable, SqlConstant.selfTableAlias);
        QueryExpressionDSL.QueryExpressionWhereBuilder where = leftJoin(from, authUserEntity, joinTableRecordList);
        SelectStatementProvider selectProvider = SqlUtil.renderWhereBuilder(where);
        Map<String, String> joinTableMap = SqlUtil.getJoinTableMap(joinTableRecordList);
        return new ProviderRecord(selectProvider, joinTableMap);
    }

    public  ProviderRecord selectProvider(AuthUserParam authUserParam) {
        List<JoinTableRecord> joinTableRecordList = getJoinTableRecordList(authUserParam);
        List<BasicColumn> fieldList = new ArrayList<>();
        fieldList.addAll(SqlUtil.getStar(authUserTable));
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            TableSupport destSupport = JoinTableRecord.destSupport();
            List<BasicColumn> aliasColumnList = SqlUtil.getAliasColumnList(destSupport.getTableAlias(), destSupport.getColumnList());
            fieldList.addAll(aliasColumnList);
        }
        QueryExpressionDSL<SelectModel> from = select(fieldList).from(authUserTable, SqlConstant.selfTableAlias);
        QueryExpressionDSL.QueryExpressionWhereBuilder where = leftJoin(from, authUserParam, joinTableRecordList);
        orderBy(where);
        SelectStatementProvider selectProvider = SqlUtil.renderWhereBuilder(where);
        Map<String, String> joinTableMap = SqlUtil.getJoinTableMap(joinTableRecordList);
        return new ProviderRecord(selectProvider, joinTableMap);
    }
    public  QueryExpressionDSL.QueryExpressionWhereBuilder leftJoin(QueryExpressionDSL<SelectModel> from,
                                                                    AuthUserEntity authUserEntity, List<JoinTableRecord> joinTableRecordList) {
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            TableSupport srcSupport = JoinTableRecord.srcSupport();
            TableSupport destSupport = JoinTableRecord.destSupport();
            from.leftJoin(destSupport.getSqlTable(), destSupport.getTableAlias()).on(srcSupport.getJoinColumn(), equalTo(destSupport.getJoinedColumn()));
        }
        QueryExpressionDSL.QueryExpressionWhereBuilder where = from.where();
        appendCondition(where, authUserTable, authUserEntity);
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            DynamicSql dynamicSql = JoinTableRecord.destTableSql();
            TableSupport destSupport = JoinTableRecord.destSupport();
            BaseParam param = destSupport.getParam();
            dynamicSql.appendCondition(where, destSupport.getSqlTable(), param);
        }
        return where;
    }

    public  QueryExpressionDSL.QueryExpressionWhereBuilder leftJoin(QueryExpressionDSL<SelectModel> from,
                                                                    AuthUserParam authUserParam, List<JoinTableRecord> joinTableRecordList) {
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            TableSupport srcSupport = JoinTableRecord.srcSupport();
            TableSupport destSupport = JoinTableRecord.destSupport();
            from.leftJoin(destSupport.getSqlTable(), destSupport.getTableAlias()).on(srcSupport.getJoinColumn(), equalTo(destSupport.getJoinedColumn()));
        }
        QueryExpressionDSL.QueryExpressionWhereBuilder where = from.where();
        appendCondition(where, authUserTable, authUserParam);
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            DynamicSql dynamicSql = JoinTableRecord.destTableSql();
            TableSupport destSupport = JoinTableRecord.destSupport();
            BaseParam param = destSupport.getParam();
            dynamicSql.appendCondition(where, destSupport.getSqlTable(), param);
        }
        return where;
    }
    public void orderBy(QueryExpressionDSL.QueryExpressionWhereBuilder where){
        where.orderBy(authUserTable.createTime.descending());
    }
}
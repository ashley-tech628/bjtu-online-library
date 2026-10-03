package com.t11.web.auth.sql;

import com.foundation.sql.DynamicSql;
import com.foundation.sql.SqlConstant;
import com.foundation.sql.SqlUtil;
import com.foundation.sql.TableSupport;
import com.foundation.sql.record.JoinTableRecord;
import com.foundation.sql.record.ProviderRecord;
import com.t11.web.auth.sql.generic.AuthRoleGenericSql;
import com.framework.web.base.param.BaseParam;
import com.framework.web.base.sql.BaseDynamicSql;
import com.t11.web.auth.param.AuthRoleParam;
import com.t11.web.auth.param.AuthRoleParam;
import com.t11.web.auth.entity.AuthRoleEntity;
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

import  com.t11.web.auth.sql.support.AuthRoleSupport;
import  com.t11.web.auth.sql.support.AuthRoleSupport.AuthRoleTable;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

public final class AuthRoleSql implements DynamicSql {
     public AuthRoleSql(){
            authRoleSupport = new AuthRoleSupport();
            authRoleTable = (AuthRoleTable) authRoleSupport.getSqlTable();
            authRoleGenericSql = new AuthRoleGenericSql(authRoleTable);
     }
     public AuthRoleSql(AuthRoleSupport authRoleSupport){
            authRoleTable = (AuthRoleTable) authRoleSupport.getSqlTable();
            authRoleGenericSql = new AuthRoleGenericSql(authRoleTable);
     }
    private AuthRoleGenericSql authRoleGenericSql;
    private AuthRoleSupport authRoleSupport;
    private AuthRoleTable authRoleTable;

    public GeneralInsertStatementProvider getInsertProvider(AuthRoleEntity authRoleEntity){
           return authRoleGenericSql.getInsertProvider(authRoleEntity);
    }
    public UpdateStatementProvider getUpdateProvider(AuthRoleEntity authRoleEntity, AuthRoleParam authRoleParam){
        return authRoleGenericSql.getUpdateProvider(authRoleEntity, authRoleParam);
    }
    public DeleteStatementProvider getDeleteProvider(AuthRoleParam authRoleParam){
        return authRoleGenericSql.getDeleteProvider(authRoleParam);
    }
    public void appendCondition(AbstractWhereDSL where, SqlTable sqlTable, BaseParam param) {
        authRoleGenericSql.appendCondition(where, authRoleTable, param);
    }
    private List<JoinTableRecord> getJoinTableRecordList(AuthRoleParam authRoleParam){
        List<JoinTableRecord> joinTableRecordList = new ArrayList<>();
        return joinTableRecordList;
    }
    public  ProviderRecord selectCountProvider(AuthRoleParam authRoleParam) {
        List<JoinTableRecord> joinTableRecordList = getJoinTableRecordList(authRoleParam);
        QueryExpressionDSL<SelectModel> from = select(count()).from(authRoleTable, SqlConstant.selfTableAlias);
        QueryExpressionDSL.QueryExpressionWhereBuilder where = leftJoin(from, authRoleParam, joinTableRecordList);
        SelectStatementProvider selectProvider = SqlUtil.renderWhereBuilder(where);
        Map<String, String> joinTableMap = SqlUtil.getJoinTableMap(joinTableRecordList);
        return new ProviderRecord(selectProvider, joinTableMap);
    }
    public  ProviderRecord selectProvider(AuthRoleParam authRoleParam) {
        List<JoinTableRecord> joinTableRecordList = getJoinTableRecordList(authRoleParam);
        List<BasicColumn> fieldList = new ArrayList<>();
        fieldList.addAll(SqlUtil.getStar(authRoleTable));
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            TableSupport destSupport = JoinTableRecord.destSupport();
            List<BasicColumn> aliasColumnList = SqlUtil.getAliasColumnList(destSupport.getTableAlias(), destSupport.getColumnList());
            fieldList.addAll(aliasColumnList);
        }
        QueryExpressionDSL<SelectModel> from = select(fieldList).from(authRoleTable, SqlConstant.selfTableAlias);
        QueryExpressionDSL.QueryExpressionWhereBuilder where = leftJoin(from, authRoleParam, joinTableRecordList);
        orderBy(where);
        SelectStatementProvider selectProvider = SqlUtil.renderWhereBuilder(where);
        Map<String, String> joinTableMap = SqlUtil.getJoinTableMap(joinTableRecordList);
        return new ProviderRecord(selectProvider, joinTableMap);
    }
    public  QueryExpressionDSL.QueryExpressionWhereBuilder leftJoin(QueryExpressionDSL<SelectModel> from,
                                         AuthRoleParam authRoleParam, List<JoinTableRecord> joinTableRecordList) {
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            TableSupport srcSupport = JoinTableRecord.srcSupport();
            TableSupport destSupport = JoinTableRecord.destSupport();
            from.leftJoin(destSupport.getSqlTable(), destSupport.getTableAlias()).on(srcSupport.getJoinColumn(), equalTo(destSupport.getJoinedColumn()));
        }
        QueryExpressionDSL.QueryExpressionWhereBuilder where = from.where();
        appendCondition(where, authRoleTable, authRoleParam);
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            DynamicSql dynamicSql = JoinTableRecord.destTableSql();
            TableSupport destSupport = JoinTableRecord.destSupport();
            BaseParam param = destSupport.getParam();
            dynamicSql.appendCondition(where, destSupport.getSqlTable(), param);
        }
        return where;
    }
    public void orderBy(QueryExpressionDSL.QueryExpressionWhereBuilder where){
        where.orderBy(authRoleTable.createTime.descending());
    }
}
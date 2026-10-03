package com.t11.web.auth.sql;

import com.foundation.sql.DynamicSql;
import com.foundation.sql.SqlConstant;
import com.foundation.sql.SqlUtil;
import com.foundation.sql.TableSupport;
import com.foundation.sql.record.JoinTableRecord;
import com.foundation.sql.record.ProviderRecord;
import com.t11.web.auth.sql.generic.AuthRolePermRelGenericSql;
import com.framework.web.base.param.BaseParam;
import com.framework.web.base.sql.BaseDynamicSql;
import com.t11.web.auth.param.AuthRolePermRelParam;
import com.t11.web.auth.param.AuthRolePermRelParam;
import com.t11.web.auth.entity.AuthRolePermRelEntity;
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
import com.t11.web.auth.param.AuthPermParam;
import com.t11.web.auth.param.AuthRoleParam;

import  com.t11.web.auth.sql.support.AuthRolePermRelSupport;
import  com.t11.web.auth.sql.support.AuthRolePermRelSupport.AuthRolePermRelTable;
import com.t11.web.auth.sql.support.AuthPermSupport;
import com.t11.web.auth.sql.support.AuthRoleSupport;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

public final class AuthRolePermRelSql implements DynamicSql {
     public AuthRolePermRelSql(){
            authRolePermRelSupport = new AuthRolePermRelSupport();
            authRolePermRelTable = (AuthRolePermRelTable) authRolePermRelSupport.getSqlTable();
            authRolePermRelGenericSql = new AuthRolePermRelGenericSql(authRolePermRelTable);
     }
     public AuthRolePermRelSql(AuthRolePermRelSupport authRolePermRelSupport){
            authRolePermRelTable = (AuthRolePermRelTable) authRolePermRelSupport.getSqlTable();
            authRolePermRelGenericSql = new AuthRolePermRelGenericSql(authRolePermRelTable);
     }
    private AuthRolePermRelGenericSql authRolePermRelGenericSql;
    private AuthRolePermRelSupport authRolePermRelSupport;
    private AuthRolePermRelTable authRolePermRelTable;

    public GeneralInsertStatementProvider getInsertProvider(AuthRolePermRelEntity authRolePermRelEntity){
           return authRolePermRelGenericSql.getInsertProvider(authRolePermRelEntity);
    }
    public UpdateStatementProvider getUpdateProvider(AuthRolePermRelEntity authRolePermRelEntity, AuthRolePermRelParam authRolePermRelParam){
        return authRolePermRelGenericSql.getUpdateProvider(authRolePermRelEntity, authRolePermRelParam);
    }
    public DeleteStatementProvider getDeleteProvider(AuthRolePermRelParam authRolePermRelParam){
        return authRolePermRelGenericSql.getDeleteProvider(authRolePermRelParam);
    }
    public void appendCondition(AbstractWhereDSL where, SqlTable sqlTable, BaseParam param) {
        authRolePermRelGenericSql.appendCondition(where, authRolePermRelTable, param);
    }
    private List<JoinTableRecord> getJoinTableRecordList(AuthRolePermRelParam authRolePermRelParam){
        List<JoinTableRecord> joinTableRecordList = new ArrayList<>();
         AuthRoleParam roleParam = authRolePermRelParam.getRoleParam();
         if(roleParam != null){
             authRolePermRelSupport.setJoinColumn(authRolePermRelTable.roleId);
             AuthRoleSupport authRoleSupport = new AuthRoleSupport();
             authRoleSupport.setParam(roleParam);
             authRoleSupport.setJoinedColumn(authRoleSupport.authRoleTable.id);
             authRoleSupport.setTableAlias("t1");
             authRoleSupport.setJoinedEntityPropName("roleEntity");
             AuthRoleSql authRoleSql = new AuthRoleSql(authRoleSupport);
             JoinTableRecord authUserSqlRecord = new JoinTableRecord(authRolePermRelSupport, authRoleSupport, authRoleSql);
             joinTableRecordList.add(authUserSqlRecord);
         }
         AuthPermParam permParam = authRolePermRelParam.getPermParam();
         if(permParam != null){
             authRolePermRelSupport.setJoinColumn(authRolePermRelTable.permId);
             AuthPermSupport authPermSupport = new AuthPermSupport();
             authPermSupport.setParam(permParam);
             authPermSupport.setJoinedColumn(authPermSupport.authPermTable.id);
             authPermSupport.setTableAlias("t2");
             authPermSupport.setJoinedEntityPropName("permEntity");
             AuthPermSql authPermSql = new AuthPermSql(authPermSupport);
             JoinTableRecord authUserSqlRecord = new JoinTableRecord(authRolePermRelSupport, authPermSupport, authPermSql);
             joinTableRecordList.add(authUserSqlRecord);
         }
        return joinTableRecordList;
    }
    public  ProviderRecord selectCountProvider(AuthRolePermRelParam authRolePermRelParam) {
        List<JoinTableRecord> joinTableRecordList = getJoinTableRecordList(authRolePermRelParam);
        QueryExpressionDSL<SelectModel> from = select(count()).from(authRolePermRelTable, SqlConstant.selfTableAlias);
        QueryExpressionDSL.QueryExpressionWhereBuilder where = leftJoin(from, authRolePermRelParam, joinTableRecordList);
        SelectStatementProvider selectProvider = SqlUtil.renderWhereBuilder(where);
        Map<String, String> joinTableMap = SqlUtil.getJoinTableMap(joinTableRecordList);
        return new ProviderRecord(selectProvider, joinTableMap);
    }
    public  ProviderRecord selectProvider(AuthRolePermRelParam authRolePermRelParam) {
        List<JoinTableRecord> joinTableRecordList = getJoinTableRecordList(authRolePermRelParam);
        List<BasicColumn> fieldList = new ArrayList<>();
        fieldList.addAll(SqlUtil.getStar(authRolePermRelTable));
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            TableSupport destSupport = JoinTableRecord.destSupport();
            List<BasicColumn> aliasColumnList = SqlUtil.getAliasColumnList(destSupport.getTableAlias(), destSupport.getColumnList());
            fieldList.addAll(aliasColumnList);
        }
        QueryExpressionDSL<SelectModel> from = select(fieldList).from(authRolePermRelTable, SqlConstant.selfTableAlias);
        QueryExpressionDSL.QueryExpressionWhereBuilder where = leftJoin(from, authRolePermRelParam, joinTableRecordList);
        orderBy(where);
        SelectStatementProvider selectProvider = SqlUtil.renderWhereBuilder(where);
        Map<String, String> joinTableMap = SqlUtil.getJoinTableMap(joinTableRecordList);
        return new ProviderRecord(selectProvider, joinTableMap);
    }
    public  QueryExpressionDSL.QueryExpressionWhereBuilder leftJoin(QueryExpressionDSL<SelectModel> from,
                                         AuthRolePermRelParam authRolePermRelParam, List<JoinTableRecord> joinTableRecordList) {
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            TableSupport srcSupport = JoinTableRecord.srcSupport();
            TableSupport destSupport = JoinTableRecord.destSupport();
            from.leftJoin(destSupport.getSqlTable(), destSupport.getTableAlias()).on(srcSupport.getJoinColumn(), equalTo(destSupport.getJoinedColumn()));
        }
        QueryExpressionDSL.QueryExpressionWhereBuilder where = from.where();
        appendCondition(where, authRolePermRelTable, authRolePermRelParam);
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            DynamicSql dynamicSql = JoinTableRecord.destTableSql();
            TableSupport destSupport = JoinTableRecord.destSupport();
            BaseParam param = destSupport.getParam();
            dynamicSql.appendCondition(where, destSupport.getSqlTable(), param);
        }
        return where;
    }
    public void orderBy(QueryExpressionDSL.QueryExpressionWhereBuilder where){
        where.orderBy(authRolePermRelTable.createTime.descending());
    }
}
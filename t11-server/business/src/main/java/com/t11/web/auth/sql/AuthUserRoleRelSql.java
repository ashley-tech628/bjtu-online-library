package com.t11.web.auth.sql;

import com.foundation.sql.DynamicSql;
import com.foundation.sql.SqlConstant;
import com.foundation.sql.SqlUtil;
import com.foundation.sql.TableSupport;
import com.foundation.sql.record.JoinTableRecord;
import com.foundation.sql.record.ProviderRecord;
import com.t11.web.auth.sql.generic.AuthUserRoleRelGenericSql;
import com.framework.web.base.param.BaseParam;
import com.framework.web.base.sql.BaseDynamicSql;
import com.t11.web.auth.param.AuthUserRoleRelParam;
import com.t11.web.auth.param.AuthUserRoleRelParam;
import com.t11.web.auth.entity.AuthUserRoleRelEntity;
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
import com.t11.web.auth.param.AuthUserParam;
import com.t11.web.auth.param.AuthRoleParam;

import  com.t11.web.auth.sql.support.AuthUserRoleRelSupport;
import  com.t11.web.auth.sql.support.AuthUserRoleRelSupport.AuthUserRoleRelTable;
import com.t11.web.auth.sql.support.AuthUserSupport;
import com.t11.web.auth.sql.support.AuthRoleSupport;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

public final class AuthUserRoleRelSql implements DynamicSql {
     public AuthUserRoleRelSql(){
            authUserRoleRelSupport = new AuthUserRoleRelSupport();
            authUserRoleRelTable = (AuthUserRoleRelTable) authUserRoleRelSupport.getSqlTable();
            authUserRoleRelGenericSql = new AuthUserRoleRelGenericSql(authUserRoleRelTable);
     }
     public AuthUserRoleRelSql(AuthUserRoleRelSupport authUserRoleRelSupport){
            authUserRoleRelTable = (AuthUserRoleRelTable) authUserRoleRelSupport.getSqlTable();
            authUserRoleRelGenericSql = new AuthUserRoleRelGenericSql(authUserRoleRelTable);
     }
    private AuthUserRoleRelGenericSql authUserRoleRelGenericSql;
    private AuthUserRoleRelSupport authUserRoleRelSupport;
    private AuthUserRoleRelTable authUserRoleRelTable;

    public GeneralInsertStatementProvider getInsertProvider(AuthUserRoleRelEntity authUserRoleRelEntity){
           return authUserRoleRelGenericSql.getInsertProvider(authUserRoleRelEntity);
    }
    public UpdateStatementProvider getUpdateProvider(AuthUserRoleRelEntity authUserRoleRelEntity, AuthUserRoleRelParam authUserRoleRelParam){
        return authUserRoleRelGenericSql.getUpdateProvider(authUserRoleRelEntity, authUserRoleRelParam);
    }
    public DeleteStatementProvider getDeleteProvider(AuthUserRoleRelParam authUserRoleRelParam){
        return authUserRoleRelGenericSql.getDeleteProvider(authUserRoleRelParam);
    }
    public void appendCondition(AbstractWhereDSL where, SqlTable sqlTable, BaseParam param) {
        authUserRoleRelGenericSql.appendCondition(where, authUserRoleRelTable, param);
    }
    private List<JoinTableRecord> getJoinTableRecordList(AuthUserRoleRelParam authUserRoleRelParam){
        List<JoinTableRecord> joinTableRecordList = new ArrayList<>();
         AuthUserParam userParam = authUserRoleRelParam.getUserParam();
         if(userParam != null){
             authUserRoleRelSupport.setJoinColumn(authUserRoleRelTable.userId);
             AuthUserSupport authUserSupport = new AuthUserSupport();
             authUserSupport.setParam(userParam);
             authUserSupport.setJoinedColumn(authUserSupport.authUserTable.id);
             authUserSupport.setTableAlias("t1");
             authUserSupport.setJoinedEntityPropName("userEntity");
             AuthUserSql authUserSql = new AuthUserSql(authUserSupport);
             JoinTableRecord authUserSqlRecord = new JoinTableRecord(authUserRoleRelSupport, authUserSupport, authUserSql);
             joinTableRecordList.add(authUserSqlRecord);
         }
         AuthRoleParam roleParam = authUserRoleRelParam.getRoleParam();
         if(roleParam != null){
             authUserRoleRelSupport.setJoinColumn(authUserRoleRelTable.roleId);
             AuthRoleSupport authRoleSupport = new AuthRoleSupport();
             authRoleSupport.setParam(roleParam);
             authRoleSupport.setJoinedColumn(authRoleSupport.authRoleTable.id);
             authRoleSupport.setTableAlias("t2");
             authRoleSupport.setJoinedEntityPropName("roleEntity");
             AuthRoleSql authRoleSql = new AuthRoleSql(authRoleSupport);
             JoinTableRecord authUserSqlRecord = new JoinTableRecord(authUserRoleRelSupport, authRoleSupport, authRoleSql);
             joinTableRecordList.add(authUserSqlRecord);
         }
        return joinTableRecordList;
    }
    public  ProviderRecord selectCountProvider(AuthUserRoleRelParam authUserRoleRelParam) {
        List<JoinTableRecord> joinTableRecordList = getJoinTableRecordList(authUserRoleRelParam);
        QueryExpressionDSL<SelectModel> from = select(count()).from(authUserRoleRelTable, SqlConstant.selfTableAlias);
        QueryExpressionDSL.QueryExpressionWhereBuilder where = leftJoin(from, authUserRoleRelParam, joinTableRecordList);
        SelectStatementProvider selectProvider = SqlUtil.renderWhereBuilder(where);
        Map<String, String> joinTableMap = SqlUtil.getJoinTableMap(joinTableRecordList);
        return new ProviderRecord(selectProvider, joinTableMap);
    }
    public  ProviderRecord selectProvider(AuthUserRoleRelParam authUserRoleRelParam) {
        List<JoinTableRecord> joinTableRecordList = getJoinTableRecordList(authUserRoleRelParam);
        List<BasicColumn> fieldList = new ArrayList<>();
        fieldList.addAll(SqlUtil.getStar(authUserRoleRelTable));
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            TableSupport destSupport = JoinTableRecord.destSupport();
            List<BasicColumn> aliasColumnList = SqlUtil.getAliasColumnList(destSupport.getTableAlias(), destSupport.getColumnList());
            fieldList.addAll(aliasColumnList);
        }
        QueryExpressionDSL<SelectModel> from = select(fieldList).from(authUserRoleRelTable, SqlConstant.selfTableAlias);
        QueryExpressionDSL.QueryExpressionWhereBuilder where = leftJoin(from, authUserRoleRelParam, joinTableRecordList);
        orderBy(where);
        SelectStatementProvider selectProvider = SqlUtil.renderWhereBuilder(where);
        Map<String, String> joinTableMap = SqlUtil.getJoinTableMap(joinTableRecordList);
        return new ProviderRecord(selectProvider, joinTableMap);
    }
    public  QueryExpressionDSL.QueryExpressionWhereBuilder leftJoin(QueryExpressionDSL<SelectModel> from,
                                         AuthUserRoleRelParam authUserRoleRelParam, List<JoinTableRecord> joinTableRecordList) {
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            TableSupport srcSupport = JoinTableRecord.srcSupport();
            TableSupport destSupport = JoinTableRecord.destSupport();
            from.leftJoin(destSupport.getSqlTable(), destSupport.getTableAlias()).on(srcSupport.getJoinColumn(), equalTo(destSupport.getJoinedColumn()));
        }
        QueryExpressionDSL.QueryExpressionWhereBuilder where = from.where();
        appendCondition(where, authUserRoleRelTable, authUserRoleRelParam);
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            DynamicSql dynamicSql = JoinTableRecord.destTableSql();
            TableSupport destSupport = JoinTableRecord.destSupport();
            BaseParam param = destSupport.getParam();
            dynamicSql.appendCondition(where, destSupport.getSqlTable(), param);
        }
        return where;
    }
    public void orderBy(QueryExpressionDSL.QueryExpressionWhereBuilder where){
        where.orderBy(authUserRoleRelTable.createTime.descending());
    }
}
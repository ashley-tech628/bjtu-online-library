package com.t11.web.userDetails.sql;

import com.foundation.sql.DynamicSql;
import com.foundation.sql.SqlConstant;
import com.foundation.sql.SqlUtil;
import com.foundation.sql.TableSupport;
import com.foundation.sql.record.JoinTableRecord;
import com.foundation.sql.record.ProviderRecord;
import com.t11.web.userDetails.entity.UserDetailsEntity;
import com.t11.web.userDetails.sql.generic.UserDetailsGenericSql;
import com.framework.web.base.param.BaseParam;
import com.t11.web.userDetails.param.UserDetailsParam;
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

import  com.t11.web.userDetails.sql.support.UserDetailsSupport;
import  com.t11.web.userDetails.sql.support.UserDetailsSupport.UserDetailsTable;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

public final class UserDetailsSql implements DynamicSql {
    public UserDetailsSql(){
        userDetailsSupport = new UserDetailsSupport();
        userDetailsTable = (UserDetailsTable) userDetailsSupport.getSqlTable();
        userDetailsGenericSql = new UserDetailsGenericSql(userDetailsTable);
    }
    public UserDetailsSql(UserDetailsSupport userDetailsSupport){
        userDetailsTable = (UserDetailsTable) userDetailsSupport.getSqlTable();
        userDetailsGenericSql = new UserDetailsGenericSql(userDetailsTable);
    }
    private UserDetailsGenericSql userDetailsGenericSql;
    private UserDetailsSupport userDetailsSupport;
    private UserDetailsTable userDetailsTable;

    public GeneralInsertStatementProvider getInsertProvider(UserDetailsEntity userDetailsEntity){
        return userDetailsGenericSql.getInsertProvider(userDetailsEntity);
    }
    public UpdateStatementProvider getUpdateProvider(UserDetailsEntity userDetailsEntity, UserDetailsParam userDetailsParam){
        return userDetailsGenericSql.getUpdateProvider(userDetailsEntity, userDetailsParam);
    }
    public DeleteStatementProvider getDeleteProvider(UserDetailsParam userDetailsParam){
        return userDetailsGenericSql.getDeleteProvider(userDetailsParam);
    }
    public void appendCondition(AbstractWhereDSL where, SqlTable sqlTable, BaseParam param) {
        userDetailsGenericSql.appendCondition(where, userDetailsTable, param);
    }
    private List<JoinTableRecord> getJoinTableRecordList(UserDetailsParam userDetailsParam){
        List<JoinTableRecord> joinTableRecordList = new ArrayList<>();
        return joinTableRecordList;
    }
    public  ProviderRecord selectCountProvider(UserDetailsParam userDetailsParam) {
        List<JoinTableRecord> joinTableRecordList = getJoinTableRecordList(userDetailsParam);
        QueryExpressionDSL<SelectModel> from = select(count()).from(userDetailsTable, SqlConstant.selfTableAlias);
        QueryExpressionDSL.QueryExpressionWhereBuilder where = leftJoin(from, userDetailsParam, joinTableRecordList);
        SelectStatementProvider selectProvider = SqlUtil.renderWhereBuilder(where);
        Map<String, String> joinTableMap = SqlUtil.getJoinTableMap(joinTableRecordList);
        return new ProviderRecord(selectProvider, joinTableMap);
    }
    public  ProviderRecord selectProvider(UserDetailsParam userDetailsParam) {
        List<JoinTableRecord> joinTableRecordList = getJoinTableRecordList(userDetailsParam);
        List<BasicColumn> fieldList = new ArrayList<>();
        fieldList.addAll(SqlUtil.getStar(userDetailsTable));
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            TableSupport destSupport = JoinTableRecord.destSupport();
            List<BasicColumn> aliasColumnList = SqlUtil.getAliasColumnList(destSupport.getTableAlias(), destSupport.getColumnList());
            fieldList.addAll(aliasColumnList);
        }
        QueryExpressionDSL<SelectModel> from = select(fieldList).from(userDetailsTable, SqlConstant.selfTableAlias);
        QueryExpressionDSL.QueryExpressionWhereBuilder where = leftJoin(from, userDetailsParam, joinTableRecordList);
        orderBy(where);
        SelectStatementProvider selectProvider = SqlUtil.renderWhereBuilder(where);
        Map<String, String> joinTableMap = SqlUtil.getJoinTableMap(joinTableRecordList);
        return new ProviderRecord(selectProvider, joinTableMap);
    }
    public  QueryExpressionDSL.QueryExpressionWhereBuilder leftJoin(QueryExpressionDSL<SelectModel> from,
                                                                    UserDetailsParam userDetailsParam, List<JoinTableRecord> joinTableRecordList) {
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            TableSupport srcSupport = JoinTableRecord.srcSupport();
            TableSupport destSupport = JoinTableRecord.destSupport();
            from.leftJoin(destSupport.getSqlTable(), destSupport.getTableAlias()).on(srcSupport.getJoinColumn(), equalTo(destSupport.getJoinedColumn()));
        }
        QueryExpressionDSL.QueryExpressionWhereBuilder where = from.where();
        appendCondition(where, userDetailsTable, userDetailsParam);
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            DynamicSql dynamicSql = JoinTableRecord.destTableSql();
            TableSupport destSupport = JoinTableRecord.destSupport();
            BaseParam param = destSupport.getParam();
            dynamicSql.appendCondition(where, destSupport.getSqlTable(), param);
        }
        return where;
    }
    public void orderBy(QueryExpressionDSL.QueryExpressionWhereBuilder where){
        where.orderBy(userDetailsTable.user_id.descending());
    }
}

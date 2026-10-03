package com.t11.web.books.sql;

import com.foundation.sql.DynamicSql;
import com.foundation.sql.SqlConstant;
import com.foundation.sql.SqlUtil;
import com.foundation.sql.TableSupport;
import com.foundation.sql.record.JoinTableRecord;
import com.foundation.sql.record.ProviderRecord;
import com.framework.web.base.param.BaseParam;
import com.t11.web.auth.entity.AuthRoleEntity;
import com.t11.web.auth.param.AuthRoleParam;
import com.t11.web.books.entity.BookRecommendsEntity;
import com.t11.web.books.param.BookRecommendsParam;
import com.t11.web.books.sql.generic.BookRecommendsGenericSql;
import com.t11.web.books.sql.support.BookRecommedsSupport;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.SqlTable;
import org.mybatis.dynamic.sql.insert.render.GeneralInsertStatementProvider;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectModel;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.where.AbstractWhereDSL;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import  com.t11.web.books.sql.support.BookRecommedsSupport.BookRecommendsTable;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

public class BookRecommedsSql implements DynamicSql {

    private BookRecommendsGenericSql bookRecommendsGenericSql;

    private BookRecommedsSupport bookRecommedsSupport;

    private BookRecommendsTable bookRecommendsTable;
    public BookRecommedsSql()
    {
        bookRecommedsSupport = new BookRecommedsSupport();
        bookRecommendsTable = (BookRecommendsTable) bookRecommedsSupport.getSqlTable();
        bookRecommendsGenericSql = new BookRecommendsGenericSql(bookRecommendsTable);

    }

    public BookRecommedsSql(BookRecommedsSupport bookRecommedsSupport)
    {
        bookRecommendsTable = (BookRecommendsTable) bookRecommedsSupport.getSqlTable();
        bookRecommendsGenericSql = new BookRecommendsGenericSql(bookRecommendsTable);

    }

    public void appendCondition(AbstractWhereDSL where, SqlTable sqlTable, BaseParam param) {
        bookRecommendsGenericSql.appendCondition(where, bookRecommendsTable, param);
    }
    private List<JoinTableRecord> getJoinTableRecordList(BookRecommendsParam bookRecommendsParam){
        List<JoinTableRecord> joinTableRecordList = new ArrayList<>();
        return joinTableRecordList;
    }

    public  ProviderRecord selectCountProvider(BookRecommendsParam bookRecommendsParam) {
        List<JoinTableRecord> joinTableRecordList = getJoinTableRecordList(bookRecommendsParam);
        QueryExpressionDSL<SelectModel> from = select(count()).from(bookRecommendsTable, SqlConstant.selfTableAlias);
        QueryExpressionDSL.QueryExpressionWhereBuilder where = leftJoin(from, bookRecommendsParam, joinTableRecordList);
        SelectStatementProvider selectProvider = SqlUtil.renderWhereBuilder(where);
        Map<String, String> joinTableMap = SqlUtil.getJoinTableMap(joinTableRecordList);
        return new ProviderRecord(selectProvider, joinTableMap);
    }

    public ProviderRecord selectProvider(BookRecommendsParam bookRecommendsParam) {
        List<JoinTableRecord> joinTableRecordList = getJoinTableRecordList(bookRecommendsParam);
        List<BasicColumn> fieldList = new ArrayList<>();
        fieldList.addAll(SqlUtil.getStar(bookRecommendsTable));
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            TableSupport destSupport = JoinTableRecord.destSupport();
            List<BasicColumn> aliasColumnList = SqlUtil.getAliasColumnList(destSupport.getTableAlias(), destSupport.getColumnList());
            fieldList.addAll(aliasColumnList);
        }
        QueryExpressionDSL<SelectModel> from = select(fieldList).from(bookRecommendsTable, SqlConstant.selfTableAlias);
        QueryExpressionDSL.QueryExpressionWhereBuilder where = leftJoin(from, bookRecommendsParam, joinTableRecordList);
        orderBy(where);
        SelectStatementProvider selectProvider = SqlUtil.renderWhereBuilder(where);
        Map<String, String> joinTableMap = SqlUtil.getJoinTableMap(joinTableRecordList);
        return new ProviderRecord(selectProvider, joinTableMap);
    }

    public  QueryExpressionDSL.QueryExpressionWhereBuilder leftJoin(QueryExpressionDSL<SelectModel> from,
                                                                    BookRecommendsParam bookRecommendsParam, List<JoinTableRecord> joinTableRecordList) {
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            TableSupport srcSupport = JoinTableRecord.srcSupport();
            TableSupport destSupport = JoinTableRecord.destSupport();
            from.leftJoin(destSupport.getSqlTable(), destSupport.getTableAlias()).on(srcSupport.getJoinColumn(), equalTo(destSupport.getJoinedColumn()));
        }
        QueryExpressionDSL.QueryExpressionWhereBuilder where = from.where();
        appendCondition(where, bookRecommendsTable, bookRecommendsParam);
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            DynamicSql dynamicSql = JoinTableRecord.destTableSql();
            TableSupport destSupport = JoinTableRecord.destSupport();
            BaseParam param = destSupport.getParam();
            dynamicSql.appendCondition(where, destSupport.getSqlTable(), param);
        }
        return where;
    }
    public void orderBy(QueryExpressionDSL.QueryExpressionWhereBuilder where){
        where.orderBy(bookRecommendsTable.createTime.descending());
    }

    public GeneralInsertStatementProvider getInsertProvider(BookRecommendsEntity bookRecommendsEntity){
        return bookRecommendsGenericSql.getInsertProvider(bookRecommendsEntity);
    }
    public UpdateStatementProvider getUpdateProvider(BookRecommendsEntity bookRecommendsEntity, BookRecommendsParam bookRecommendsParam){
        return bookRecommendsGenericSql.getUpdateProvider(bookRecommendsEntity, bookRecommendsParam);
    }

}

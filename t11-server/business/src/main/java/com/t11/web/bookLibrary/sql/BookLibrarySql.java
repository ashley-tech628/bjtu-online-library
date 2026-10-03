package com.t11.web.bookLibrary.sql;

import com.foundation.sql.DynamicSql;
import com.foundation.sql.SqlConstant;
import com.foundation.sql.SqlUtil;
import com.foundation.sql.TableSupport;
import com.foundation.sql.record.JoinTableRecord;
import com.foundation.sql.record.ProviderRecord;
import com.t11.web.bookLibrary.sql.generic.BookLibraryGenericSql;
import com.framework.web.base.param.BaseParam;
import com.t11.web.bookLibrary.param.BookLibraryParam;
import com.t11.web.bookLibrary.entity.BookLibraryEntity;
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

import com.t11.web.bookLibrary.sql.support.BookLibrarySupport;
import  com.t11.web.bookLibrary.sql.support.BookLibrarySupport.BookLibraryTable;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

public final class BookLibrarySql implements DynamicSql {
    public BookLibrarySql(){
        bookLibrarySupport = new BookLibrarySupport();
        bookLibraryTable = (BookLibraryTable) bookLibrarySupport.getSqlTable();
        bookLibraryGenericSql = new BookLibraryGenericSql(bookLibraryTable);
    }
    public BookLibrarySql(BookLibrarySupport bookLibrarySupport){
        bookLibraryTable = (BookLibraryTable) bookLibrarySupport.getSqlTable();
        bookLibraryGenericSql = new BookLibraryGenericSql(bookLibraryTable);
    }
    private BookLibraryGenericSql bookLibraryGenericSql;
    private BookLibrarySupport bookLibrarySupport;
    private BookLibraryTable bookLibraryTable;

    public GeneralInsertStatementProvider getInsertProvider(BookLibraryEntity bookLibraryEntity){
        return bookLibraryGenericSql.getInsertProvider(bookLibraryEntity);
    }
    public UpdateStatementProvider getUpdateProvider(BookLibraryEntity bookLibraryEntity, BookLibraryParam bookLibraryParam){
        return bookLibraryGenericSql.getUpdateProvider(bookLibraryEntity, bookLibraryParam);
    }
    public DeleteStatementProvider getDeleteProvider(BookLibraryParam bookLibraryParam){
        return bookLibraryGenericSql.getDeleteProvider(bookLibraryParam);
    }
    public void appendCondition(AbstractWhereDSL where, SqlTable sqlTable, BaseParam param) {
        bookLibraryGenericSql.appendCondition(where, bookLibraryTable, param);
    }
    private List<JoinTableRecord> getJoinTableRecordList(BookLibraryParam bookLibraryParam){
        List<JoinTableRecord> joinTableRecordList = new ArrayList<>();
        return joinTableRecordList;
    }
    public  ProviderRecord selectCountProvider(BookLibraryParam bookLibraryParam) {
        List<JoinTableRecord> joinTableRecordList = getJoinTableRecordList(bookLibraryParam);
        QueryExpressionDSL<SelectModel> from = select(count()).from(bookLibraryTable, SqlConstant.selfTableAlias);
        QueryExpressionDSL.QueryExpressionWhereBuilder where = leftJoin(from, bookLibraryParam, joinTableRecordList);
        SelectStatementProvider selectProvider = SqlUtil.renderWhereBuilder(where);
        Map<String, String> joinTableMap = SqlUtil.getJoinTableMap(joinTableRecordList);
        return new ProviderRecord(selectProvider, joinTableMap);
    }
    public  ProviderRecord selectProvider(BookLibraryParam bookLibraryParam) {
        List<JoinTableRecord> joinTableRecordList = getJoinTableRecordList(bookLibraryParam);
        List<BasicColumn> fieldList = new ArrayList<>();
        fieldList.addAll(SqlUtil.getStar(bookLibraryTable));
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            TableSupport destSupport = JoinTableRecord.destSupport();
            List<BasicColumn> aliasColumnList = SqlUtil.getAliasColumnList(destSupport.getTableAlias(), destSupport.getColumnList());
            fieldList.addAll(aliasColumnList);
        }
        QueryExpressionDSL<SelectModel> from = select(fieldList).from(bookLibraryTable, SqlConstant.selfTableAlias);
        QueryExpressionDSL.QueryExpressionWhereBuilder where = leftJoin(from, bookLibraryParam, joinTableRecordList);
        orderBy(where);
        SelectStatementProvider selectProvider = SqlUtil.renderWhereBuilder(where);
        Map<String, String> joinTableMap = SqlUtil.getJoinTableMap(joinTableRecordList);
        return new ProviderRecord(selectProvider, joinTableMap);
    }
    public  QueryExpressionDSL.QueryExpressionWhereBuilder leftJoin(QueryExpressionDSL<SelectModel> from,
                                                                    BookLibraryParam bookLibraryParam, List<JoinTableRecord> joinTableRecordList) {
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            TableSupport srcSupport = JoinTableRecord.srcSupport();
            TableSupport destSupport = JoinTableRecord.destSupport();
            from.leftJoin(destSupport.getSqlTable(), destSupport.getTableAlias()).on(srcSupport.getJoinColumn(), equalTo(destSupport.getJoinedColumn()));
        }
        QueryExpressionDSL.QueryExpressionWhereBuilder where = from.where();
        appendCondition(where, bookLibraryTable, bookLibraryParam);
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            DynamicSql dynamicSql = JoinTableRecord.destTableSql();
            TableSupport destSupport = JoinTableRecord.destSupport();
            BaseParam param = destSupport.getParam();
            dynamicSql.appendCondition(where, destSupport.getSqlTable(), param);
        }
        return where;
    }
    public void orderBy(QueryExpressionDSL.QueryExpressionWhereBuilder where){
        where.orderBy(bookLibraryTable.publicationTime.descending());
    }
}
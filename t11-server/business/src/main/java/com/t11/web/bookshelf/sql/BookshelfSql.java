package com.t11.web.bookshelf.sql;

import com.foundation.sql.DynamicSql;
import com.foundation.sql.SqlConstant;
import com.foundation.sql.SqlUtil;
import com.foundation.sql.TableSupport;
import com.foundation.sql.record.JoinTableRecord;
import com.foundation.sql.record.ProviderRecord;
import com.framework.web.base.param.BaseParam;
import com.t11.web.bookshelf.entity.BookshelfEntity;
import com.t11.web.bookshelf.param.BookshelfParam;
import com.t11.web.bookshelf.sql.generic.BookshelfGenericSql;
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

import com.t11.web.bookshelf.sql.support.BookshelfSupport;
import  com.t11.web.bookshelf.sql.support.BookshelfSupport.BookshelfTable;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

public class BookshelfSql implements DynamicSql {

    public BookshelfSql(){
        bookshelfSupport = new BookshelfSupport();
        bookshelfTable = (BookshelfTable) bookshelfSupport.getSqlTable();
        bookshelfGenericSql = new BookshelfGenericSql(bookshelfTable);
    }
    public BookshelfSql(BookshelfSupport bookshelfSupport){
        bookshelfTable = (BookshelfTable) bookshelfSupport.getSqlTable();
        bookshelfGenericSql = new BookshelfGenericSql(bookshelfTable);
    }
    private BookshelfGenericSql bookshelfGenericSql;
    private BookshelfSupport bookshelfSupport;
    private BookshelfTable bookshelfTable;

    public GeneralInsertStatementProvider getInsertProvider(BookshelfEntity bookshelfEntity){
        return bookshelfGenericSql.getInsertProvider(bookshelfEntity);
    }
    public UpdateStatementProvider getUpdateProvider(BookshelfEntity bookshelfEntity, BookshelfParam bookshelfParam){
        return bookshelfGenericSql.getUpdateProvider(bookshelfEntity, bookshelfParam);
    }
    public DeleteStatementProvider getDeleteProvider(BookshelfParam bookshelfParam){
        return bookshelfGenericSql.getDeleteProvider(bookshelfParam);
    }
    public void appendCondition(AbstractWhereDSL where, SqlTable sqlTable, BaseParam param) {
        bookshelfGenericSql.appendCondition(where, bookshelfTable, param);
    }
    private List<JoinTableRecord> getJoinTableRecordList(BookshelfParam bookshelfParam){
        List<JoinTableRecord> joinTableRecordList = new ArrayList<>();
        return joinTableRecordList;
    }
    public  ProviderRecord selectCountProvider(BookshelfParam bookshelfParam) {
        List<JoinTableRecord> joinTableRecordList = getJoinTableRecordList(bookshelfParam);
        QueryExpressionDSL<SelectModel> from = select(count()).from(bookshelfTable, SqlConstant.selfTableAlias);
        QueryExpressionDSL.QueryExpressionWhereBuilder where = leftJoin(from, bookshelfParam, joinTableRecordList);
        SelectStatementProvider selectProvider = SqlUtil.renderWhereBuilder(where);
        Map<String, String> joinTableMap = SqlUtil.getJoinTableMap(joinTableRecordList);
        return new ProviderRecord(selectProvider, joinTableMap);
    }
    public  ProviderRecord selectProvider(BookshelfParam bookshelfParam) {
        List<JoinTableRecord> joinTableRecordList = getJoinTableRecordList(bookshelfParam);
        List<BasicColumn> fieldList = new ArrayList<>();
        fieldList.addAll(SqlUtil.getStar(bookshelfTable));
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            TableSupport destSupport = JoinTableRecord.destSupport();
            List<BasicColumn> aliasColumnList = SqlUtil.getAliasColumnList(destSupport.getTableAlias(), destSupport.getColumnList());
            fieldList.addAll(aliasColumnList);
        }
        QueryExpressionDSL<SelectModel> from = select(fieldList).from(bookshelfTable, SqlConstant.selfTableAlias);
        QueryExpressionDSL.QueryExpressionWhereBuilder where = leftJoin(from, bookshelfParam, joinTableRecordList);
        orderBy(where);
        SelectStatementProvider selectProvider = SqlUtil.renderWhereBuilder(where);
        Map<String, String> joinTableMap = SqlUtil.getJoinTableMap(joinTableRecordList);
        return new ProviderRecord(selectProvider, joinTableMap);
    }

    public void orderBy(QueryExpressionDSL.QueryExpressionWhereBuilder where){
        where.orderBy(bookshelfTable.id.descending());
    }

    public  QueryExpressionDSL.QueryExpressionWhereBuilder leftJoin(QueryExpressionDSL<SelectModel> from,
                                                                    BookshelfParam bookshelfParam, List<JoinTableRecord> joinTableRecordList) {
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            TableSupport srcSupport = JoinTableRecord.srcSupport();
            TableSupport destSupport = JoinTableRecord.destSupport();
            from.leftJoin(destSupport.getSqlTable(), destSupport.getTableAlias()).on(srcSupport.getJoinColumn(), equalTo(destSupport.getJoinedColumn()));
        }
        QueryExpressionDSL.QueryExpressionWhereBuilder where = from.where();
        appendCondition(where, bookshelfTable, bookshelfParam);
        for(JoinTableRecord JoinTableRecord : joinTableRecordList){
            DynamicSql dynamicSql = JoinTableRecord.destTableSql();
            TableSupport destSupport = JoinTableRecord.destSupport();
            BaseParam param = destSupport.getParam();
            dynamicSql.appendCondition(where, destSupport.getSqlTable(), param);
        }
        return where;
    }

}

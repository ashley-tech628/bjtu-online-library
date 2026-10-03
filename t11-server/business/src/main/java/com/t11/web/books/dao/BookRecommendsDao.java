package com.t11.web.books.dao;

import com.foundation.sql.ConnectionFactory;
import com.foundation.sql.SimpleExecutor;
import com.foundation.sql.SqlUtil;
import com.foundation.sql.record.PrepareSqlRecord;
import com.foundation.sql.record.ProviderRecord;
import com.t11.web.auth.entity.AuthRoleEntity;
import com.t11.web.auth.param.AuthRoleParam;
import com.t11.web.auth.sql.AuthRoleSql;
import com.t11.web.books.entity.BookRecommendsEntity;
import com.t11.web.books.param.BookRecommendsParam;
import com.t11.web.books.sql.BookRecommedsSql;
import org.mybatis.dynamic.sql.insert.render.GeneralInsertStatementProvider;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;

import java.sql.Connection;
import java.util.List;

public class BookRecommendsDao {

    public  List<BookRecommendsEntity> selectList(BookRecommendsParam bookRecommendsParam){
        Connection connection = ConnectionFactory.getDefaultConnection();
        BookRecommedsSql bookRecommedsSql = new BookRecommedsSql();
        ProviderRecord providerRecord = bookRecommedsSql.selectProvider(bookRecommendsParam);
        PrepareSqlRecord prepareSqlRecord = SqlUtil.getPageSql(providerRecord,bookRecommendsParam.getPageNo(), bookRecommendsParam.getPageSize());
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        List<BookRecommendsEntity> bookRecommendsEntityList = simpleExecutor.selectList(connection, prepareSqlRecord, BookRecommendsEntity.class);
        return bookRecommendsEntityList;
    }

    public BookRecommendsEntity selectOne(BookRecommendsParam bookRecommendsParam){
        List<BookRecommendsEntity> bookRecommendsEntityList = selectList(bookRecommendsParam);
        if(null == bookRecommendsEntityList || bookRecommendsEntityList.size() == 0) {
            return null;
        }
        return bookRecommendsEntityList.get(0);
    }
    public  int update(BookRecommendsEntity bookRecommendsEntity, BookRecommendsParam bookRecommendsParam) {
        Connection connection = ConnectionFactory.getDefaultConnection();
        BookRecommedsSql bookRecommedsSql = new BookRecommedsSql();
        UpdateStatementProvider updateProvider = bookRecommedsSql.getUpdateProvider(bookRecommendsEntity, bookRecommendsParam);
        PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(updateProvider.getUpdateStatement(), updateProvider.getParameters());
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
        return result;
    }

    public  int insert(BookRecommendsEntity bookRecommendsEntity) {
        Connection connection = ConnectionFactory.getDefaultConnection();
        BookRecommedsSql bookRecommedsSql = new BookRecommedsSql();
        GeneralInsertStatementProvider insertProvider = bookRecommedsSql.getInsertProvider(bookRecommendsEntity);
        PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(insertProvider.getInsertStatement(), insertProvider.getParameters());
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
        return result;
    }

    public Long selectCount(BookRecommendsParam bookRecommendsParam){
        Connection connection = ConnectionFactory.getDefaultConnection();
        BookRecommedsSql bookRecommedsSql = new BookRecommedsSql();
        ProviderRecord providerRecord = bookRecommedsSql.selectCountProvider(bookRecommendsParam);
        PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(providerRecord);
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        Long count = (Long) simpleExecutor.selectValue(connection, prepareSqlRecord);
        return count;
    }
}

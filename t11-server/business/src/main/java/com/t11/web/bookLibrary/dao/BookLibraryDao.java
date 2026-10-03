package com.t11.web.bookLibrary.dao;

import com.foundation.sql.SqlUtil;
import com.foundation.sql.record.PrepareSqlRecord;
import com.foundation.sql.SimpleExecutor;
import com.foundation.sql.record.ProviderRecord;
import com.foundation.sql.ConnectionFactory;
import com.t11.web.bookLibrary.entity.BookLibraryEntity;
import com.t11.web.bookLibrary.param.BookLibraryParam;
import com.t11.web.bookLibrary.sql.BookLibrarySql;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.GeneralInsertStatementProvider;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.List;

@Repository
public class BookLibraryDao {
    public  List<BookLibraryEntity> selectList(BookLibraryParam bookLibraryParam){
        Connection connection = ConnectionFactory.getDefaultConnection();
        BookLibrarySql bookLibrarySql = new BookLibrarySql();
        ProviderRecord providerRecord = bookLibrarySql.selectProvider(bookLibraryParam);
        PrepareSqlRecord prepareSqlRecord = SqlUtil.getPageSql(providerRecord,bookLibraryParam.getPageNo(), bookLibraryParam.getPageSize());
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        List<BookLibraryEntity> bookLibraryEntityList = simpleExecutor.selectList(connection, prepareSqlRecord, BookLibraryEntity.class);
        return bookLibraryEntityList;
    }
    public Long selectCount(BookLibraryParam bookLibraryParam){
        Connection connection = ConnectionFactory.getDefaultConnection();
        BookLibrarySql bookLibrarySql = new BookLibrarySql();
        ProviderRecord providerRecord = bookLibrarySql.selectCountProvider(bookLibraryParam);
        PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(providerRecord);
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        Long count = (Long) simpleExecutor.selectValue(connection, prepareSqlRecord);
        return count;
    }
    public BookLibraryEntity selectOne(BookLibraryParam bookLibraryParam){
        List<BookLibraryEntity> bookLibraryEntityList = selectList(bookLibraryParam);
        if(null == bookLibraryEntityList || bookLibraryEntityList.size() == 0)return null;
        return bookLibraryEntityList.get(0);
    }
    public  int insert(BookLibraryEntity bookLibraryEntity) {
        Connection connection = ConnectionFactory.getDefaultConnection();
        BookLibrarySql bookLibrarySql = new BookLibrarySql();
        GeneralInsertStatementProvider insertProvider = bookLibrarySql.getInsertProvider(bookLibraryEntity);
        PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(insertProvider.getInsertStatement(), insertProvider.getParameters());
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
        return result;
    }
    public  int update(BookLibraryEntity bookLibraryEntity, BookLibraryParam bookLibraryParam) {
        Connection connection = ConnectionFactory.getDefaultConnection();
        BookLibrarySql bookLibrarySql = new BookLibrarySql();
        UpdateStatementProvider updateProvider = bookLibrarySql.getUpdateProvider(bookLibraryEntity, bookLibraryParam);
        PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(updateProvider.getUpdateStatement(), updateProvider.getParameters());
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
        return result;
    }
    public  int delete(BookLibraryParam bookLibraryParam) {
        Connection connection = ConnectionFactory.getDefaultConnection();
        BookLibrarySql bookLibrarySql = new BookLibrarySql();
        DeleteStatementProvider deleteProvider = bookLibrarySql.getDeleteProvider(bookLibraryParam);
        PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(deleteProvider.getDeleteStatement(), deleteProvider.getParameters());
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
        return result;
    }
}
package com.t11.web.bookshelf.dao;

import com.foundation.sql.ConnectionFactory;
import com.foundation.sql.SqlUtil;
import com.foundation.sql.record.PrepareSqlRecord;
import com.foundation.sql.record.ProviderRecord;
import com.t11.web.bookshelf.entity.BookshelfEntity;
import com.t11.web.bookshelf.param.BookshelfParam;
import com.t11.web.bookshelf.sql.BookshelfSql;
import com.foundation.sql.SimpleExecutor;
import com.t11.web.house.entity.HouseRegionEntity;
import com.t11.web.house.param.HouseRegionParam;
import com.t11.web.house.sql.HouseRegionSql;
import org.mybatis.dynamic.sql.insert.render.GeneralInsertStatementProvider;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.List;

@Repository
public class BookshelfDao {
    public List<BookshelfEntity> selectList(BookshelfParam bookshelfParam){
        Connection connection = ConnectionFactory.getDefaultConnection();
        BookshelfSql bookshelfSql = new BookshelfSql();
        ProviderRecord providerRecord = bookshelfSql.selectProvider(bookshelfParam);
        PrepareSqlRecord prepareSqlRecord = SqlUtil.getPageSql(providerRecord,bookshelfParam.getPageNo(), bookshelfParam.getPageSize());
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        List<BookshelfEntity> bookshelfEntityList = simpleExecutor.selectList(connection, prepareSqlRecord, BookshelfEntity.class);
        return bookshelfEntityList;
    }
    public Long selectCount(BookshelfParam bookshelfParam){
        Connection connection = ConnectionFactory.getDefaultConnection();
        BookshelfSql bookshelfSql = new BookshelfSql();
        ProviderRecord providerRecord = bookshelfSql.selectCountProvider(bookshelfParam);
        PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(providerRecord);
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        Long count = (Long) simpleExecutor.selectValue(connection, prepareSqlRecord);
        return count;
    }

    public  int insert(BookshelfEntity bookshelfEntity) {
        Connection connection = ConnectionFactory.getDefaultConnection();
        BookshelfSql bookshelfSql = new BookshelfSql();
        GeneralInsertStatementProvider insertProvider = bookshelfSql.getInsertProvider(bookshelfEntity);
        PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(insertProvider.getInsertStatement(), insertProvider.getParameters());
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
        return result;
    }

    public  int update(BookshelfEntity bookshelfEntity, BookshelfParam bookshelfParam) {
        Connection connection = ConnectionFactory.getDefaultConnection();
        BookshelfSql bookshelfSql = new BookshelfSql();
        UpdateStatementProvider updateProvider = bookshelfSql.getUpdateProvider(bookshelfEntity, bookshelfParam);
        PrepareSqlRecord prepareSqlRecord = SqlUtil.getPrepareSqlRecord(updateProvider.getUpdateStatement(), updateProvider.getParameters());
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        int result = simpleExecutor.doUpdate(connection, prepareSqlRecord);
        return result;
    }

    public BookshelfEntity selectOne(BookshelfParam bookshelfParam){
        List<BookshelfEntity> bookshelfEntityList = selectList(bookshelfParam);
        if(null == bookshelfEntityList || bookshelfEntityList.size() == 0) {
            return null;
        }
        return bookshelfEntityList.get(0);
    }

}

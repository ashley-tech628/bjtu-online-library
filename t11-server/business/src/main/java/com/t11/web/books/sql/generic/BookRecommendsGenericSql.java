package com.t11.web.books.sql.generic;

import com.foundation.sql.DynamicSql;
import com.framework.web.base.param.BaseParam;
import com.t11.web.auth.entity.AuthRoleEntity;
import com.t11.web.auth.param.AuthRoleParam;
import com.t11.web.auth.sql.support.AuthRoleSupport;
import com.t11.web.books.entity.BookRecommendsEntity;
import com.t11.web.books.param.BookRecommendsParam;
import com.t11.web.books.sql.support.BookRecommedsSupport;
import com.t11.web.books.sql.support.BookRecommedsSupport.BookRecommendsTable;
import org.mybatis.dynamic.sql.SqlTable;
import org.mybatis.dynamic.sql.insert.render.GeneralInsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.where.AbstractWhereDSL;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

public class BookRecommendsGenericSql {
    private BookRecommendsTable bookRecommendsTable;
    public BookRecommendsGenericSql(BookRecommendsTable bookRecommendsTable){
        this.bookRecommendsTable = bookRecommendsTable;
    }

    public void appendCondition(AbstractWhereDSL whereBuilder, SqlTable sqlTable, BaseParam param) {
        BookRecommendsTable bookRecommendsTable = (BookRecommedsSupport.BookRecommendsTable)sqlTable;
        if(null == param) {
            return;
        }
        BookRecommendsParam bookRecommendsParam = (BookRecommendsParam) param;
        whereBuilder
                .and(bookRecommendsTable.id,isEqualToWhenPresent(bookRecommendsParam.getId()))
                .and(bookRecommendsTable.code,isEqualToWhenPresent(bookRecommendsParam.getCode()))
        ;
    }

    public GeneralInsertStatementProvider getInsertProvider(BookRecommendsEntity bookRecommendsEntity){
        //Integer intId = Integer.parseInt(covidTestingEntity.getId());
        GeneralInsertStatementProvider insertProvider = insertInto(bookRecommendsTable)
                .set(bookRecommendsTable.id).toValue(bookRecommendsEntity.getId())
                .set(bookRecommendsTable.code).toValue(bookRecommendsEntity.getCode())
                .set(bookRecommendsTable.name).toValue(bookRecommendsEntity.getName())
                .set(bookRecommendsTable.isValid).toValue(bookRecommendsEntity.getIsValid())
                .set(bookRecommendsTable.sortNum).toValue(bookRecommendsEntity.getSortNum())
                .set(bookRecommendsTable.createTime).toValue(bookRecommendsEntity.getCreateTime())
                .set(bookRecommendsTable.updateTime).toValue(bookRecommendsEntity.getUpdateTime())
                .set(bookRecommendsTable.createUser).toValue(bookRecommendsEntity.getCreateUser())
                .set(bookRecommendsTable.updateUser).toValue(bookRecommendsEntity.getUpdateUser())
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return insertProvider;
    }
    public UpdateStatementProvider getUpdateProvider(BookRecommendsEntity bookRecommendsEntity, BookRecommendsParam bookRecommendsParam){
        UpdateDSL<UpdateModel> updateModelUpdateDSL = update(bookRecommendsTable)
                .set(bookRecommendsTable.code).equalTo(bookRecommendsEntity.getCode())
                .set(bookRecommendsTable.name).equalTo(bookRecommendsEntity.getName())
                .set(bookRecommendsTable.isValid).equalTo(bookRecommendsEntity.getIsValid())
                .set(bookRecommendsTable.sortNum).equalTo(bookRecommendsEntity.getSortNum())
                .set(bookRecommendsTable.createTime).equalTo(bookRecommendsEntity.getCreateTime())
                .set(bookRecommendsTable.updateTime).equalTo(bookRecommendsEntity.getUpdateTime())
                .set(bookRecommendsTable.createUser).equalTo(bookRecommendsEntity.getCreateUser())
                .set(bookRecommendsTable.updateUser).equalTo(bookRecommendsEntity.getUpdateUser())
                ;
        UpdateDSL<UpdateModel>.UpdateWhereBuilder where = updateModelUpdateDSL.where();
        appendCondition(where,bookRecommendsTable,bookRecommendsParam);
        return  where.build().render(RenderingStrategies.MYBATIS3);
    }




}

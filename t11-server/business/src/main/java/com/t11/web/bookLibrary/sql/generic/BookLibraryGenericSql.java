package com.t11.web.bookLibrary.sql.generic;

import com.framework.web.base.param.BaseParam;
import com.t11.web.bookLibrary.param.BookLibraryParam;
import com.t11.web.bookLibrary.entity.BookLibraryEntity;
import org.mybatis.dynamic.sql.SqlTable;
import org.mybatis.dynamic.sql.delete.DeleteDSL;
import org.mybatis.dynamic.sql.delete.DeleteModel;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.GeneralInsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.where.AbstractWhereDSL;

import  com.t11.web.bookLibrary.sql.support.BookLibrarySupport.BookLibraryTable;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

public  class BookLibraryGenericSql {
    public BookLibraryGenericSql(BookLibraryTable bookLibraryTable) {
        this.bookLibraryTable = bookLibraryTable;
    }
    private BookLibraryTable bookLibraryTable;

    public GeneralInsertStatementProvider getInsertProvider(BookLibraryEntity bookLibraryEntity){
        //Integer intId = Integer.parseInt(covidTestingEntity.getId());
        GeneralInsertStatementProvider insertProvider = insertInto(bookLibraryTable)
                .set(bookLibraryTable.id).toValue(bookLibraryEntity.getId())
//                .set(bookLibraryTable.createTime).toValue(bookLibraryEntity.getCreateTime())
//                .set(bookLibraryTable.updateTime).toValue(bookLibraryEntity.getUpdateTime())
                .set(bookLibraryTable.createUser).toValue(bookLibraryEntity.getCreateUser())
                .set(bookLibraryTable.updateUser).toValue(bookLibraryEntity.getUpdateUser())
                .set(bookLibraryTable.type).toValue(bookLibraryEntity.getType())
                .set(bookLibraryTable.title).toValue(bookLibraryEntity.getTitle())
                .set(bookLibraryTable.author).toValue(bookLibraryEntity.getAuthor())
                .set(bookLibraryTable.publicationTime).toValue(bookLibraryEntity.getPublicationTime())
                .set(bookLibraryTable.cover).toValue(bookLibraryEntity.getCover())
                .set(bookLibraryTable.description).toValue(bookLibraryEntity.getDescription())
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return insertProvider;
    }
    public UpdateStatementProvider getUpdateProvider(BookLibraryEntity bookLibraryEntity, BookLibraryParam bookLibraryParam){
        UpdateDSL<UpdateModel> updateModelUpdateDSL = update(bookLibraryTable)
//                .set(bookLibraryTable.createTime).equalTo(bookLibraryEntity.getCreateTime())
//                .set(bookLibraryTable.updateTime).equalTo(bookLibraryEntity.getUpdateTime())
                .set(bookLibraryTable.createUser).equalTo(bookLibraryEntity.getCreateUser())
                .set(bookLibraryTable.updateUser).equalTo(bookLibraryEntity.getUpdateUser())
                .set(bookLibraryTable.type).equalTo(bookLibraryEntity.getType())
                .set(bookLibraryTable.title).equalTo(bookLibraryEntity.getTitle())
                .set(bookLibraryTable.author).equalTo(bookLibraryEntity.getAuthor())
                .set(bookLibraryTable.publicationTime).equalTo(bookLibraryEntity.getPublicationTime())
                .set(bookLibraryTable.cover).equalTo(bookLibraryEntity.getCover())
                .set(bookLibraryTable.description).equalTo(bookLibraryEntity.getDescription())
                ;
        UpdateDSL<UpdateModel>.UpdateWhereBuilder where = updateModelUpdateDSL.where();
        appendCondition(where,bookLibraryTable,bookLibraryParam);
        return  where.build().render(RenderingStrategies.MYBATIS3);
    }
    public DeleteStatementProvider  getDeleteProvider(BookLibraryParam bookLibraryParam){
        DeleteDSL<DeleteModel> deleteModelDeleteDSL = deleteFrom(bookLibraryTable);
        DeleteDSL<DeleteModel>.DeleteWhereBuilder where = deleteModelDeleteDSL.where();
        appendCondition(where,bookLibraryTable,bookLibraryParam);
        return  where.build().render(RenderingStrategies.MYBATIS3);
    }
    public void appendCondition(AbstractWhereDSL whereBuilder, SqlTable sqlTable, BaseParam param) {
        BookLibraryTable bookLibraryTable = (BookLibraryTable)sqlTable;
        if(null == param)return;
        BookLibraryParam bookLibraryParam = (BookLibraryParam)param;
        whereBuilder
                .and(bookLibraryTable.id,isEqualToWhenPresent(bookLibraryParam.getId()))
                .and(bookLibraryTable.title,isLikeWhenPresent(bookLibraryParam.getTitle()).map(s->"%" + s + "%"))
        ;
    }
}
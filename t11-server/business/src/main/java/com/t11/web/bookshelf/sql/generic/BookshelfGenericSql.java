package com.t11.web.bookshelf.sql.generic;

import com.framework.web.base.param.BaseParam;
import com.t11.web.bookshelf.entity.BookshelfEntity;
import com.t11.web.bookshelf.param.BookshelfParam;
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

import  com.t11.web.bookshelf.sql.support.BookshelfSupport.BookshelfTable;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

public class BookshelfGenericSql {

    public BookshelfGenericSql(BookshelfTable bookshelfTable) {
        this.bookshelfTable = bookshelfTable;
    }
    private BookshelfTable bookshelfTable;

    public GeneralInsertStatementProvider getInsertProvider(BookshelfEntity bookshelfEntity){
        //Integer intId = Integer.parseInt(covidTestingEntity.getId());
        GeneralInsertStatementProvider insertProvider = insertInto(bookshelfTable)
                .set(bookshelfTable.id).toValue(bookshelfEntity.getId())
                .set(bookshelfTable.name).toValue(bookshelfEntity.getName())
                .set(bookshelfTable.allbooks).toValue(bookshelfEntity.getAllbooks())
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return insertProvider;
    }
    public UpdateStatementProvider getUpdateProvider(BookshelfEntity bookshelfEntity, BookshelfParam bookshelfParam){
        UpdateDSL<UpdateModel> updateModelUpdateDSL = update(bookshelfTable)
                .set(bookshelfTable.id).equalTo(bookshelfEntity.getId())
                .set(bookshelfTable.name).equalTo(bookshelfEntity.getName())
                .set(bookshelfTable.allbooks).equalTo(bookshelfEntity.getAllbooks())
                ;
        UpdateDSL<UpdateModel>.UpdateWhereBuilder where = updateModelUpdateDSL.where();
        appendCondition(where,bookshelfTable,bookshelfParam);
        return  where.build().render(RenderingStrategies.MYBATIS3);
    }
    public DeleteStatementProvider getDeleteProvider(BookshelfParam bookshelfParam){
        DeleteDSL<DeleteModel> deleteModelDeleteDSL = deleteFrom(bookshelfTable);
        DeleteDSL<DeleteModel>.DeleteWhereBuilder where = deleteModelDeleteDSL.where();
        appendCondition(where,bookshelfTable,bookshelfParam);
        return  where.build().render(RenderingStrategies.MYBATIS3);
    }
    public void appendCondition(AbstractWhereDSL whereBuilder, SqlTable sqlTable, BaseParam param) {
        BookshelfTable bookshelfTable = (BookshelfTable)sqlTable;
        if(null == param)return;
        BookshelfParam bookshelfParam = (BookshelfParam)param;
        whereBuilder
                .and(bookshelfTable.id,isEqualToWhenPresent(bookshelfParam.getId()))
                .and(bookshelfTable.name,isLikeWhenPresent(bookshelfParam.getName()).map(s->"%" + s + "%"))
        ;
    }

}



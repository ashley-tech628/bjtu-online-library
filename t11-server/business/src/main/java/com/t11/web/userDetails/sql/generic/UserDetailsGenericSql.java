package com.t11.web.userDetails.sql.generic;


import com.framework.web.base.param.BaseParam;
import com.t11.web.userDetails.entity.UserDetailsEntity;
import com.t11.web.userDetails.param.UserDetailsParam;
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

import  com.t11.web.userDetails.sql.support.UserDetailsSupport.UserDetailsTable;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

public  class UserDetailsGenericSql{
    public UserDetailsGenericSql(UserDetailsTable userDetailsTable) {
        this.userDetailsTable = userDetailsTable;
    }
    private UserDetailsTable userDetailsTable;

    public GeneralInsertStatementProvider getInsertProvider(UserDetailsEntity userDetailsEntity){
        //Integer intId = Integer.parseInt(covidTestingEntity.getId());
        GeneralInsertStatementProvider insertProvider = insertInto(userDetailsTable)
                .set(userDetailsTable.user_id).toValue(userDetailsEntity.getUser_id())
                .set(userDetailsTable.user_name).toValue(userDetailsEntity.getUser_name())
                .set(userDetailsTable.books).toValue(userDetailsEntity.getBooks())
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return insertProvider;
    }
    public UpdateStatementProvider getUpdateProvider(UserDetailsEntity userDetailsEntity, UserDetailsParam userDetailsParam){
        UpdateDSL<UpdateModel> updateModelUpdateDSL = update(userDetailsTable)
                .set(userDetailsTable.user_id).equalTo(userDetailsEntity.getUser_id())
                .set(userDetailsTable.user_name).equalTo(userDetailsEntity.getUser_name())
                .set(userDetailsTable.books).equalTo(userDetailsEntity.getBooks())
                ;
        UpdateDSL<UpdateModel>.UpdateWhereBuilder where = updateModelUpdateDSL.where();
        appendCondition(where,userDetailsTable,userDetailsParam);
        return  where.build().render(RenderingStrategies.MYBATIS3);
    }
    public DeleteStatementProvider  getDeleteProvider(UserDetailsParam userDetailsParam){
        DeleteDSL<DeleteModel> deleteModelDeleteDSL = deleteFrom(userDetailsTable);
        DeleteDSL<DeleteModel>.DeleteWhereBuilder where = deleteModelDeleteDSL.where();
        appendCondition(where,userDetailsTable,userDetailsParam);
        return  where.build().render(RenderingStrategies.MYBATIS3);
    }
    public void appendCondition(AbstractWhereDSL whereBuilder, SqlTable sqlTable, BaseParam param) {
        UserDetailsTable userDetailsTable = (UserDetailsTable)sqlTable;
        if(null == param)return;
        UserDetailsParam userDetailsParam = (UserDetailsParam)param;
        whereBuilder
                .and(userDetailsTable.user_id,isEqualToWhenPresent(userDetailsParam.getUser_id()))
                .and(userDetailsTable.user_name,isLikeWhenPresent(userDetailsParam.getUser_name()).map(s->"%" + s + "%"))
        ;
    }
}

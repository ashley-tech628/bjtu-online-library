package com.t11.web.auth.sql.generic;

import com.framework.web.base.param.BaseParam;
import com.framework.web.base.sql.BaseDynamicSql;
import com.t11.web.auth.param.AuthPermParam;
import com.t11.web.auth.entity.AuthPermEntity;
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

import  com.t11.web.auth.sql.support.AuthPermSupport;
import  com.t11.web.auth.sql.support.AuthPermSupport.AuthPermTable;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

public  class AuthPermGenericSql{
    public AuthPermGenericSql(AuthPermTable authPermTable) {
        this.authPermTable = authPermTable;
    }
    private AuthPermTable authPermTable;

    public GeneralInsertStatementProvider getInsertProvider(AuthPermEntity authPermEntity){
        //Integer intId = Integer.parseInt(covidTestingEntity.getId());
        GeneralInsertStatementProvider insertProvider = insertInto(authPermTable)
            .set(authPermTable.id).toValue(authPermEntity.getId())
            .set(authPermTable.code).toValue(authPermEntity.getCode())
            .set(authPermTable.name).toValue(authPermEntity.getName())
            .set(authPermTable.isValid).toValue(authPermEntity.getIsValid())
            .set(authPermTable.sortNum).toValue(authPermEntity.getSortNum())
            .set(authPermTable.createTime).toValue(authPermEntity.getCreateTime())
            .set(authPermTable.updateTime).toValue(authPermEntity.getUpdateTime())
            .set(authPermTable.createUser).toValue(authPermEntity.getCreateUser())
            .set(authPermTable.updateUser).toValue(authPermEntity.getUpdateUser())
            .build()
            .render(RenderingStrategies.MYBATIS3);
        return insertProvider;
    }
    public UpdateStatementProvider getUpdateProvider(AuthPermEntity authPermEntity, AuthPermParam authPermParam){
         UpdateDSL<UpdateModel> updateModelUpdateDSL = update(authPermTable)
                 .set(authPermTable.code).equalTo(authPermEntity.getCode())
                 .set(authPermTable.name).equalTo(authPermEntity.getName())
                 .set(authPermTable.isValid).equalTo(authPermEntity.getIsValid())
                 .set(authPermTable.sortNum).equalTo(authPermEntity.getSortNum())
                 .set(authPermTable.createTime).equalTo(authPermEntity.getCreateTime())
                 .set(authPermTable.updateTime).equalTo(authPermEntity.getUpdateTime())
                 .set(authPermTable.createUser).equalTo(authPermEntity.getCreateUser())
                 .set(authPermTable.updateUser).equalTo(authPermEntity.getUpdateUser())
        ;
         UpdateDSL<UpdateModel>.UpdateWhereBuilder where = updateModelUpdateDSL.where();
         appendCondition(where,authPermTable,authPermParam);
         return  where.build().render(RenderingStrategies.MYBATIS3);
    }
    public DeleteStatementProvider  getDeleteProvider(AuthPermParam authPermParam){
        DeleteDSL<DeleteModel> deleteModelDeleteDSL = deleteFrom(authPermTable);
        DeleteDSL<DeleteModel>.DeleteWhereBuilder where = deleteModelDeleteDSL.where();
        appendCondition(where,authPermTable,authPermParam);
        return  where.build().render(RenderingStrategies.MYBATIS3);
    }
    public void appendCondition(AbstractWhereDSL whereBuilder, SqlTable sqlTable, BaseParam param) {
        AuthPermTable authPermTable = (AuthPermTable)sqlTable;
        if(null == param)return;
        AuthPermParam authPermParam = (AuthPermParam)param;
        whereBuilder
            .and(authPermTable.id,isEqualToWhenPresent(authPermParam.getId()))
            .and(authPermTable.code,isEqualToWhenPresent(authPermParam.getCode()))
            ;
    }
}
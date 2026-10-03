package com.t11.web.auth.sql.generic;

import com.framework.web.base.param.BaseParam;
import com.framework.web.base.sql.BaseDynamicSql;
import com.t11.web.auth.param.AuthRoleParam;
import com.t11.web.auth.entity.AuthRoleEntity;
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

import  com.t11.web.auth.sql.support.AuthRoleSupport;
import  com.t11.web.auth.sql.support.AuthRoleSupport.AuthRoleTable;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

public  class AuthRoleGenericSql{
    public AuthRoleGenericSql(AuthRoleTable authRoleTable) {
        this.authRoleTable = authRoleTable;
    }
    private AuthRoleTable authRoleTable;

    public GeneralInsertStatementProvider getInsertProvider(AuthRoleEntity authRoleEntity){
        //Integer intId = Integer.parseInt(covidTestingEntity.getId());
        GeneralInsertStatementProvider insertProvider = insertInto(authRoleTable)
            .set(authRoleTable.id).toValue(authRoleEntity.getId())
            .set(authRoleTable.code).toValue(authRoleEntity.getCode())
            .set(authRoleTable.name).toValue(authRoleEntity.getName())
            .set(authRoleTable.isValid).toValue(authRoleEntity.getIsValid())
            .set(authRoleTable.sortNum).toValue(authRoleEntity.getSortNum())
            .set(authRoleTable.createTime).toValue(authRoleEntity.getCreateTime())
            .set(authRoleTable.updateTime).toValue(authRoleEntity.getUpdateTime())
            .set(authRoleTable.createUser).toValue(authRoleEntity.getCreateUser())
            .set(authRoleTable.updateUser).toValue(authRoleEntity.getUpdateUser())
            .build()
            .render(RenderingStrategies.MYBATIS3);
        return insertProvider;
    }
    public UpdateStatementProvider getUpdateProvider(AuthRoleEntity authRoleEntity, AuthRoleParam authRoleParam){
         UpdateDSL<UpdateModel> updateModelUpdateDSL = update(authRoleTable)
                 .set(authRoleTable.code).equalTo(authRoleEntity.getCode())
                 .set(authRoleTable.name).equalTo(authRoleEntity.getName())
                 .set(authRoleTable.isValid).equalTo(authRoleEntity.getIsValid())
                 .set(authRoleTable.sortNum).equalTo(authRoleEntity.getSortNum())
                 .set(authRoleTable.createTime).equalTo(authRoleEntity.getCreateTime())
                 .set(authRoleTable.updateTime).equalTo(authRoleEntity.getUpdateTime())
                 .set(authRoleTable.createUser).equalTo(authRoleEntity.getCreateUser())
                 .set(authRoleTable.updateUser).equalTo(authRoleEntity.getUpdateUser())
        ;
         UpdateDSL<UpdateModel>.UpdateWhereBuilder where = updateModelUpdateDSL.where();
         appendCondition(where,authRoleTable,authRoleParam);
         return  where.build().render(RenderingStrategies.MYBATIS3);
    }
    public DeleteStatementProvider  getDeleteProvider(AuthRoleParam authRoleParam){
        DeleteDSL<DeleteModel> deleteModelDeleteDSL = deleteFrom(authRoleTable);
        DeleteDSL<DeleteModel>.DeleteWhereBuilder where = deleteModelDeleteDSL.where();
        appendCondition(where,authRoleTable,authRoleParam);
        return  where.build().render(RenderingStrategies.MYBATIS3);
    }
    public void appendCondition(AbstractWhereDSL whereBuilder, SqlTable sqlTable, BaseParam param) {
        AuthRoleTable authRoleTable = (AuthRoleTable)sqlTable;
        if(null == param) {
            return;
        }
        AuthRoleParam authRoleParam = (AuthRoleParam)param;
        whereBuilder
            .and(authRoleTable.id,isEqualToWhenPresent(authRoleParam.getId()))
            .and(authRoleTable.code,isEqualToWhenPresent(authRoleParam.getCode()))
            ;
    }
}
package com.t11.web.auth.sql.generic;

import com.framework.web.base.param.BaseParam;
import com.framework.web.base.sql.BaseDynamicSql;
import com.t11.web.auth.param.AuthUserRoleRelParam;
import com.t11.web.auth.entity.AuthUserRoleRelEntity;
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

import  com.t11.web.auth.sql.support.AuthUserRoleRelSupport;
import  com.t11.web.auth.sql.support.AuthUserRoleRelSupport.AuthUserRoleRelTable;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

public  class AuthUserRoleRelGenericSql{
    public AuthUserRoleRelGenericSql(AuthUserRoleRelTable authUserRoleRelTable) {
        this.authUserRoleRelTable = authUserRoleRelTable;
    }
    private AuthUserRoleRelTable authUserRoleRelTable;

    public GeneralInsertStatementProvider getInsertProvider(AuthUserRoleRelEntity authUserRoleRelEntity){
        //Integer intId = Integer.parseInt(covidTestingEntity.getId());
        GeneralInsertStatementProvider insertProvider = insertInto(authUserRoleRelTable)
            .set(authUserRoleRelTable.id).toValue(authUserRoleRelEntity.getId())
            .set(authUserRoleRelTable.userId).toValue(authUserRoleRelEntity.getUserId())
            .set(authUserRoleRelTable.roleId).toValue(authUserRoleRelEntity.getRoleId())
            .set(authUserRoleRelTable.isValid).toValue(authUserRoleRelEntity.getIsValid())
            .set(authUserRoleRelTable.sortNum).toValue(authUserRoleRelEntity.getSortNum())
            .set(authUserRoleRelTable.createTime).toValue(authUserRoleRelEntity.getCreateTime())
            .set(authUserRoleRelTable.updateTime).toValue(authUserRoleRelEntity.getUpdateTime())
            .set(authUserRoleRelTable.createUser).toValue(authUserRoleRelEntity.getCreateUser())
            .set(authUserRoleRelTable.updateUser).toValue(authUserRoleRelEntity.getUpdateUser())
            .build()
            .render(RenderingStrategies.MYBATIS3);
        return insertProvider;
    }
    public UpdateStatementProvider getUpdateProvider(AuthUserRoleRelEntity authUserRoleRelEntity, AuthUserRoleRelParam authUserRoleRelParam){
         UpdateDSL<UpdateModel> updateModelUpdateDSL = update(authUserRoleRelTable)
                 .set(authUserRoleRelTable.userId).equalTo(authUserRoleRelEntity.getUserId())
                 .set(authUserRoleRelTable.roleId).equalTo(authUserRoleRelEntity.getRoleId())
                 .set(authUserRoleRelTable.isValid).equalTo(authUserRoleRelEntity.getIsValid())
                 .set(authUserRoleRelTable.sortNum).equalTo(authUserRoleRelEntity.getSortNum())
                 .set(authUserRoleRelTable.createTime).equalTo(authUserRoleRelEntity.getCreateTime())
                 .set(authUserRoleRelTable.updateTime).equalTo(authUserRoleRelEntity.getUpdateTime())
                 .set(authUserRoleRelTable.createUser).equalTo(authUserRoleRelEntity.getCreateUser())
                 .set(authUserRoleRelTable.updateUser).equalTo(authUserRoleRelEntity.getUpdateUser())
        ;
         UpdateDSL<UpdateModel>.UpdateWhereBuilder where = updateModelUpdateDSL.where();
         appendCondition(where,authUserRoleRelTable,authUserRoleRelParam);
         return  where.build().render(RenderingStrategies.MYBATIS3);
    }
    public DeleteStatementProvider  getDeleteProvider(AuthUserRoleRelParam authUserRoleRelParam){
        DeleteDSL<DeleteModel> deleteModelDeleteDSL = deleteFrom(authUserRoleRelTable);
        DeleteDSL<DeleteModel>.DeleteWhereBuilder where = deleteModelDeleteDSL.where();
        appendCondition(where,authUserRoleRelTable,authUserRoleRelParam);
        return  where.build().render(RenderingStrategies.MYBATIS3);
    }
    public void appendCondition(AbstractWhereDSL whereBuilder, SqlTable sqlTable, BaseParam param) {
        AuthUserRoleRelTable authUserRoleRelTable = (AuthUserRoleRelTable)sqlTable;
        if(null == param)return;
        AuthUserRoleRelParam authUserRoleRelParam = (AuthUserRoleRelParam)param;
        whereBuilder
            .and(authUserRoleRelTable.id,isEqualToWhenPresent(authUserRoleRelParam.getId()))
            .and(authUserRoleRelTable.userId,isEqualToWhenPresent(authUserRoleRelParam.getUserId()))
            .and(authUserRoleRelTable.roleId,isEqualToWhenPresent(authUserRoleRelParam.getRoleId()))
            ;
    }
}
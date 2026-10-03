package com.t11.web.auth.sql.generic;

import com.framework.web.base.param.BaseParam;
import com.framework.web.base.sql.BaseDynamicSql;
import com.t11.web.auth.param.AuthRolePermRelParam;
import com.t11.web.auth.entity.AuthRolePermRelEntity;
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

import  com.t11.web.auth.sql.support.AuthRolePermRelSupport;
import  com.t11.web.auth.sql.support.AuthRolePermRelSupport.AuthRolePermRelTable;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

public  class AuthRolePermRelGenericSql{
    public AuthRolePermRelGenericSql(AuthRolePermRelTable authRolePermRelTable) {
        this.authRolePermRelTable = authRolePermRelTable;
    }
    private AuthRolePermRelTable authRolePermRelTable;

    public GeneralInsertStatementProvider getInsertProvider(AuthRolePermRelEntity authRolePermRelEntity){
        //Integer intId = Integer.parseInt(covidTestingEntity.getId());
        GeneralInsertStatementProvider insertProvider = insertInto(authRolePermRelTable)
            .set(authRolePermRelTable.id).toValue(authRolePermRelEntity.getId())
            .set(authRolePermRelTable.roleId).toValue(authRolePermRelEntity.getRoleId())
            .set(authRolePermRelTable.permId).toValue(authRolePermRelEntity.getPermId())
            .set(authRolePermRelTable.isValid).toValue(authRolePermRelEntity.getIsValid())
            .set(authRolePermRelTable.sortNum).toValue(authRolePermRelEntity.getSortNum())
            .set(authRolePermRelTable.createTime).toValue(authRolePermRelEntity.getCreateTime())
            .set(authRolePermRelTable.updateTime).toValue(authRolePermRelEntity.getUpdateTime())
            .set(authRolePermRelTable.createUser).toValue(authRolePermRelEntity.getCreateUser())
            .set(authRolePermRelTable.updateUser).toValue(authRolePermRelEntity.getUpdateUser())
            .build()
            .render(RenderingStrategies.MYBATIS3);
        return insertProvider;
    }
    public UpdateStatementProvider getUpdateProvider(AuthRolePermRelEntity authRolePermRelEntity, AuthRolePermRelParam authRolePermRelParam){
         UpdateDSL<UpdateModel> updateModelUpdateDSL = update(authRolePermRelTable)
                 .set(authRolePermRelTable.roleId).equalTo(authRolePermRelEntity.getRoleId())
                 .set(authRolePermRelTable.permId).equalTo(authRolePermRelEntity.getPermId())
                 .set(authRolePermRelTable.isValid).equalTo(authRolePermRelEntity.getIsValid())
                 .set(authRolePermRelTable.sortNum).equalTo(authRolePermRelEntity.getSortNum())
                 .set(authRolePermRelTable.createTime).equalTo(authRolePermRelEntity.getCreateTime())
                 .set(authRolePermRelTable.updateTime).equalTo(authRolePermRelEntity.getUpdateTime())
                 .set(authRolePermRelTable.createUser).equalTo(authRolePermRelEntity.getCreateUser())
                 .set(authRolePermRelTable.updateUser).equalTo(authRolePermRelEntity.getUpdateUser())
        ;
         UpdateDSL<UpdateModel>.UpdateWhereBuilder where = updateModelUpdateDSL.where();
         appendCondition(where,authRolePermRelTable,authRolePermRelParam);
         return  where.build().render(RenderingStrategies.MYBATIS3);
    }
    public DeleteStatementProvider  getDeleteProvider(AuthRolePermRelParam authRolePermRelParam){
        DeleteDSL<DeleteModel> deleteModelDeleteDSL = deleteFrom(authRolePermRelTable);
        DeleteDSL<DeleteModel>.DeleteWhereBuilder where = deleteModelDeleteDSL.where();
        appendCondition(where,authRolePermRelTable,authRolePermRelParam);
        return  where.build().render(RenderingStrategies.MYBATIS3);
    }
    public void appendCondition(AbstractWhereDSL whereBuilder, SqlTable sqlTable, BaseParam param) {
        AuthRolePermRelTable authRolePermRelTable = (AuthRolePermRelTable)sqlTable;
        if(null == param)return;
        AuthRolePermRelParam authRolePermRelParam = (AuthRolePermRelParam)param;
        whereBuilder
            .and(authRolePermRelTable.id,isEqualToWhenPresent(authRolePermRelParam.getId()))
            .and(authRolePermRelTable.roleId,isEqualToWhenPresent(authRolePermRelParam.getRoleId()))
            .and(authRolePermRelTable.permId,isEqualToWhenPresent(authRolePermRelParam.getPermId()))
            ;
    }
}
package com.t11.web.auth.sql.generic;

import com.framework.web.base.entity.BaseEntity;
import com.framework.web.base.param.BaseParam;
import com.framework.web.base.sql.BaseDynamicSql;
import com.t11.web.auth.param.AuthUserParam;
import com.t11.web.auth.entity.AuthUserEntity;
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

import  com.t11.web.auth.sql.support.AuthUserSupport;
import  com.t11.web.auth.sql.support.AuthUserSupport.AuthUserTable;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

public  class AuthUserGenericSql{
    public AuthUserGenericSql(AuthUserTable authUserTable) {
        this.authUserTable = authUserTable;
    }
    private AuthUserTable authUserTable;

    public GeneralInsertStatementProvider getInsertProvider(AuthUserEntity authUserEntity){
        //Integer intId = Integer.parseInt(covidTestingEntity.getId());
        GeneralInsertStatementProvider insertProvider = insertInto(authUserTable)
            .set(authUserTable.id).toValue(authUserEntity.getId())
            .set(authUserTable.username).toValue(authUserEntity.getUsername())
            .set(authUserTable.password).toValue(authUserEntity.getPassword())
            .set(authUserTable.realName).toValue(authUserEntity.getRealName())
            .set(authUserTable.lastLoginTime).toValue(authUserEntity.getLastLoginTime())
            .set(authUserTable.avatarGroupId).toValue(authUserEntity.getAvatarGroupId())
            .set(authUserTable.mobile).toValue(authUserEntity.getMobile())
            .set(authUserTable.remark).toValue(authUserEntity.getRemark())
            .set(authUserTable.isValid).toValue(authUserEntity.getIsValid())
            .set(authUserTable.sortNum).toValue(authUserEntity.getSortNum())
            .set(authUserTable.createTime).toValue(authUserEntity.getCreateTime())
            .set(authUserTable.updateTime).toValue(authUserEntity.getUpdateTime())
            .set(authUserTable.createUser).toValue(authUserEntity.getCreateUser())
            .set(authUserTable.updateUser).toValue(authUserEntity.getUpdateUser())
            .build()
            .render(RenderingStrategies.MYBATIS3);
        return insertProvider;
    }
    public UpdateStatementProvider getUpdateProvider(AuthUserEntity authUserEntity, AuthUserParam authUserParam){
         UpdateDSL<UpdateModel> updateModelUpdateDSL = update(authUserTable)
                 .set(authUserTable.username).equalTo(authUserEntity.getUsername())
                 .set(authUserTable.password).equalTo(authUserEntity.getPassword())
                 .set(authUserTable.realName).equalTo(authUserEntity.getRealName())
                 .set(authUserTable.lastLoginTime).equalTo(authUserEntity.getLastLoginTime())
                 .set(authUserTable.avatarGroupId).equalTo(authUserEntity.getAvatarGroupId())
                 .set(authUserTable.mobile).equalTo(authUserEntity.getMobile())
                 .set(authUserTable.remark).equalTo(authUserEntity.getRemark())
                 .set(authUserTable.isValid).equalTo(authUserEntity.getIsValid())
                 .set(authUserTable.sortNum).equalTo(authUserEntity.getSortNum())
                 .set(authUserTable.createTime).equalTo(authUserEntity.getCreateTime())
                 .set(authUserTable.updateTime).equalTo(authUserEntity.getUpdateTime())
                 .set(authUserTable.createUser).equalTo(authUserEntity.getCreateUser())
                 .set(authUserTable.updateUser).equalTo(authUserEntity.getUpdateUser())
        ;
         UpdateDSL<UpdateModel>.UpdateWhereBuilder where = updateModelUpdateDSL.where();
         appendCondition(where,authUserTable,authUserParam);
         return  where.build().render(RenderingStrategies.MYBATIS3);
    }
    public DeleteStatementProvider  getDeleteProvider(AuthUserParam authUserParam){
        DeleteDSL<DeleteModel> deleteModelDeleteDSL = deleteFrom(authUserTable);
        DeleteDSL<DeleteModel>.DeleteWhereBuilder where = deleteModelDeleteDSL.where();
        appendCondition(where,authUserTable,authUserParam);
        return  where.build().render(RenderingStrategies.MYBATIS3);
    }
    public void appendCondition(AbstractWhereDSL whereBuilder, SqlTable sqlTable, BaseParam param) {
        AuthUserTable authUserTable = (AuthUserTable)sqlTable;
        if(null == param)return;
        AuthUserParam authUserParam = (AuthUserParam)param;
        whereBuilder
            .and(authUserTable.id,isEqualToWhenPresent(authUserParam.getId()))
            .and(authUserTable.username,isEqualToWhenPresent(authUserParam.getUsername()))
            .and(authUserTable.realName,isEqualToWhenPresent(authUserParam.getRealName()))
            ;
    }

    public void appendCondition(AbstractWhereDSL whereBuilder, SqlTable sqlTable, BaseEntity entity) {
        AuthUserTable authUserTable = (AuthUserTable)sqlTable;
        if(null == entity)return;
        AuthUserEntity authUserParam = (AuthUserEntity)entity;
        whereBuilder
                .and(authUserTable.id,isEqualToWhenPresent(authUserParam.getId()))
                .and(authUserTable.username,isEqualToWhenPresent(authUserParam.getUsername()))
                .and(authUserTable.realName,isEqualToWhenPresent(authUserParam.getRealName()))
        ;
    }
}
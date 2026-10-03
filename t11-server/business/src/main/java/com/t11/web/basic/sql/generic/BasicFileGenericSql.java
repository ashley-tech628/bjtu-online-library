package com.t11.web.basic.sql.generic;

import com.framework.web.base.param.BaseParam;
import com.framework.web.base.sql.BaseDynamicSql;
import com.t11.web.basic.param.BasicFileParam;
import com.t11.web.basic.entity.BasicFileEntity;
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

import  com.t11.web.basic.sql.support.BasicFileSupport;
import  com.t11.web.basic.sql.support.BasicFileSupport.BasicFileTable;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

public  class BasicFileGenericSql{
    public BasicFileGenericSql(BasicFileTable basicFileTable) {
        this.basicFileTable = basicFileTable;
    }
    private BasicFileTable basicFileTable;

    public GeneralInsertStatementProvider getInsertProvider(BasicFileEntity basicFileEntity){
        //Integer intId = Integer.parseInt(covidTestingEntity.getId());
        GeneralInsertStatementProvider insertProvider = insertInto(basicFileTable)
            .set(basicFileTable.id).toValue(basicFileEntity.getId())
            .set(basicFileTable.fromType).toValue(basicFileEntity.getFromType())
            .set(basicFileTable.groupId).toValue(basicFileEntity.getGroupId())
            .set(basicFileTable.name).toValue(basicFileEntity.getName())
            .set(basicFileTable.extName).toValue(basicFileEntity.getExtName())
            .set(basicFileTable.contentType).toValue(basicFileEntity.getContentType())
            .set(basicFileTable.size).toValue(basicFileEntity.getSize())
            .set(basicFileTable.path).toValue(basicFileEntity.getPath())
            .set(basicFileTable.isValid).toValue(basicFileEntity.getIsValid())
            .set(basicFileTable.sortNum).toValue(basicFileEntity.getSortNum())
            .set(basicFileTable.createTime).toValue(basicFileEntity.getCreateTime())
            .set(basicFileTable.updateTime).toValue(basicFileEntity.getUpdateTime())
            .set(basicFileTable.createUser).toValue(basicFileEntity.getCreateUser())
            .set(basicFileTable.updateUser).toValue(basicFileEntity.getUpdateUser())
            .build()
            .render(RenderingStrategies.MYBATIS3);
        return insertProvider;
    }
    public UpdateStatementProvider getUpdateProvider(BasicFileEntity basicFileEntity, BasicFileParam basicFileParam){
         UpdateDSL<UpdateModel> updateModelUpdateDSL = update(basicFileTable)
                 .set(basicFileTable.fromType).equalTo(basicFileEntity.getFromType())
                 .set(basicFileTable.groupId).equalTo(basicFileEntity.getGroupId())
                 .set(basicFileTable.name).equalTo(basicFileEntity.getName())
                 .set(basicFileTable.extName).equalTo(basicFileEntity.getExtName())
                 .set(basicFileTable.contentType).equalTo(basicFileEntity.getContentType())
                 .set(basicFileTable.size).equalTo(basicFileEntity.getSize())
                 .set(basicFileTable.path).equalTo(basicFileEntity.getPath())
                 .set(basicFileTable.isValid).equalTo(basicFileEntity.getIsValid())
                 .set(basicFileTable.sortNum).equalTo(basicFileEntity.getSortNum())
                 .set(basicFileTable.createTime).equalTo(basicFileEntity.getCreateTime())
                 .set(basicFileTable.updateTime).equalTo(basicFileEntity.getUpdateTime())
                 .set(basicFileTable.createUser).equalTo(basicFileEntity.getCreateUser())
                 .set(basicFileTable.updateUser).equalTo(basicFileEntity.getUpdateUser())
        ;
         UpdateDSL<UpdateModel>.UpdateWhereBuilder where = updateModelUpdateDSL.where();
         appendCondition(where,basicFileTable,basicFileParam);
         return  where.build().render(RenderingStrategies.MYBATIS3);
    }
    public DeleteStatementProvider  getDeleteProvider(BasicFileParam basicFileParam){
        DeleteDSL<DeleteModel> deleteModelDeleteDSL = deleteFrom(basicFileTable);
        DeleteDSL<DeleteModel>.DeleteWhereBuilder where = deleteModelDeleteDSL.where();
        appendCondition(where,basicFileTable,basicFileParam);
        return  where.build().render(RenderingStrategies.MYBATIS3);
    }
    public void appendCondition(AbstractWhereDSL whereBuilder, SqlTable sqlTable, BaseParam param) {
        BasicFileTable basicFileTable = (BasicFileTable)sqlTable;
        if(null == param)return;
        BasicFileParam basicFileParam = (BasicFileParam)param;
        whereBuilder
            .and(basicFileTable.id,isEqualToWhenPresent(basicFileParam.getId()))
            .and(basicFileTable.groupId,isEqualToWhenPresent(basicFileParam.getGroupId()))
            ;
    }
}
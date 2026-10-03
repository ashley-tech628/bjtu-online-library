package com.t11.web.house.sql.generic;

import com.framework.web.base.param.BaseParam;
import com.t11.web.house.entity.HouseRegionEntity;
import com.t11.web.house.param.HouseRegionParam;
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

import  com.t11.web.house.sql.support.HouseRegionSupport.HouseRegionTable;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

public  class HouseRegionGenericSql{
    public HouseRegionGenericSql(HouseRegionTable houseRegionTable) {
        this.houseRegionTable = houseRegionTable;
    }
    private HouseRegionTable houseRegionTable;

    public GeneralInsertStatementProvider getInsertProvider(HouseRegionEntity houseRegionEntity){
        //Integer intId = Integer.parseInt(covidTestingEntity.getId());
        GeneralInsertStatementProvider insertProvider = insertInto(houseRegionTable)
            .set(houseRegionTable.id).toValue(houseRegionEntity.getId())
            .set(houseRegionTable.createTime).toValue(houseRegionEntity.getCreateTime())
            .set(houseRegionTable.updateTime).toValue(houseRegionEntity.getUpdateTime())
            .set(houseRegionTable.createUser).toValue(houseRegionEntity.getCreateUser())
            .set(houseRegionTable.updateUser).toValue(houseRegionEntity.getUpdateUser())
            .set(houseRegionTable.code).toValue(houseRegionEntity.getCode())
            .set(houseRegionTable.name).toValue(houseRegionEntity.getName())
            .set(houseRegionTable.shortName).toValue(houseRegionEntity.getShortName())
            .set(houseRegionTable.landArea).toValue(houseRegionEntity.getLandArea())
            .set(houseRegionTable.constructionArea).toValue(houseRegionEntity.getConstructionArea())
            .set(houseRegionTable.roadArea).toValue(houseRegionEntity.getRoadArea())
            .set(houseRegionTable.greenArea).toValue(houseRegionEntity.getGreenArea())
            .set(houseRegionTable.constructionNum).toValue(houseRegionEntity.getConstructionNum())
            .set(houseRegionTable.ownerStatus).toValue(houseRegionEntity.getOwnerStatus())
            .set(houseRegionTable.estateCardGroupId).toValue(houseRegionEntity.getEstateCardGroupId())
            .set(houseRegionTable.sortNum).toValue(houseRegionEntity.getSortNum())
            .build()
            .render(RenderingStrategies.MYBATIS3);
        return insertProvider;
    }
    public UpdateStatementProvider getUpdateProvider(HouseRegionEntity houseRegionEntity, HouseRegionParam houseRegionParam){
         UpdateDSL<UpdateModel> updateModelUpdateDSL = update(houseRegionTable)
                 .set(houseRegionTable.createTime).equalTo(houseRegionEntity.getCreateTime())
                 .set(houseRegionTable.updateTime).equalTo(houseRegionEntity.getUpdateTime())
                 .set(houseRegionTable.createUser).equalTo(houseRegionEntity.getCreateUser())
                 .set(houseRegionTable.updateUser).equalTo(houseRegionEntity.getUpdateUser())
                 .set(houseRegionTable.code).equalTo(houseRegionEntity.getCode())
                 .set(houseRegionTable.name).equalTo(houseRegionEntity.getName())
                 .set(houseRegionTable.shortName).equalTo(houseRegionEntity.getShortName())
                 .set(houseRegionTable.landArea).equalTo(houseRegionEntity.getLandArea())
                 .set(houseRegionTable.constructionArea).equalTo(houseRegionEntity.getConstructionArea())
                 .set(houseRegionTable.roadArea).equalTo(houseRegionEntity.getRoadArea())
                 .set(houseRegionTable.greenArea).equalTo(houseRegionEntity.getGreenArea())
                 .set(houseRegionTable.constructionNum).equalTo(houseRegionEntity.getConstructionNum())
                 .set(houseRegionTable.ownerStatus).equalTo(houseRegionEntity.getOwnerStatus())
                 .set(houseRegionTable.estateCardGroupId).equalTo(houseRegionEntity.getEstateCardGroupId())
                 .set(houseRegionTable.sortNum).equalTo(houseRegionEntity.getSortNum())
        ;
         UpdateDSL<UpdateModel>.UpdateWhereBuilder where = updateModelUpdateDSL.where();
         appendCondition(where,houseRegionTable,houseRegionParam);
         return  where.build().render(RenderingStrategies.MYBATIS3);
    }
    public DeleteStatementProvider  getDeleteProvider(HouseRegionParam houseRegionParam){
        DeleteDSL<DeleteModel> deleteModelDeleteDSL = deleteFrom(houseRegionTable);
        DeleteDSL<DeleteModel>.DeleteWhereBuilder where = deleteModelDeleteDSL.where();
        appendCondition(where,houseRegionTable,houseRegionParam);
        return  where.build().render(RenderingStrategies.MYBATIS3);
    }
    public void appendCondition(AbstractWhereDSL whereBuilder, SqlTable sqlTable, BaseParam param) {
        HouseRegionTable houseRegionTable = (HouseRegionTable)sqlTable;
        if(null == param)return;
        HouseRegionParam houseRegionParam = (HouseRegionParam)param;
        whereBuilder
            .and(houseRegionTable.id,isEqualToWhenPresent(houseRegionParam.getId()))
            .and(houseRegionTable.name,isLikeWhenPresent(houseRegionParam.getName()).map(s->"%" + s + "%"))
            ;
    }
}
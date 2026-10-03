package com.framework.web.base.sql;

import com.framework.web.base.param.BaseParam;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectModel;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.where.AbstractWhereDSL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualToWhenPresent;
import static org.mybatis.dynamic.sql.SqlBuilder.isLikeWhenPresent;

public class BaseDynamicSql {
    protected SqlTable sqlTable = null;
    protected List<SqlColumn> sqlColumnList = null;
    public List<BasicColumn> getSelectColumnList(String tableAlias) {
        if (StringUtils.isBlank(tableAlias)) {
            BasicColumn basicColumn = sqlTable.allColumns();
            List<BasicColumn> columnList = new ArrayList<>();
            columnList.add(basicColumn);
            return columnList;
        }
        List<BasicColumn> resultList = new ArrayList<>();
        for (SqlColumn sqlColumn: sqlColumnList) {
            resultList.add(getColumn(tableAlias, sqlColumn));
        }
        return resultList;
    }
    private SqlColumn getColumn(String tableAlias, SqlColumn sqlColumn){
        String tableAliasWithDot = tableAlias + ".";
        StringBuilder sb = new StringBuilder();
        sb.append("`").append(tableAliasWithDot).append(sqlColumn.name()).append("`");
        SqlColumn column = sqlColumn.as(sb.toString());
        return column;
    }
    protected SelectStatementProvider renderWhereBuilder(QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder whereBuilder){
        return  whereBuilder.build().render(RenderingStrategies.MYBATIS3);
    }
    //append条件时，如果表在join的时候设置了别名，那么在拼接条件时自动取别名。
    public   void appendAndCondition(AbstractWhereDSL whereBuilder, BaseParam param){
    }
    protected List<BasicColumn> getFieldList(Map<String , BaseDynamicSql> dynamicSqlMap,List<String> joinTableAliasList){
        List<BasicColumn> fieldList = new ArrayList<>();
        if(joinTableAliasList == null){
            joinTableAliasList = new ArrayList<>();
        }else if(joinTableAliasList.contains("t0")){
            joinTableAliasList.remove("t0");
        }
        List<BasicColumn> selfColumnList = this.getSelectColumnList(null);
        fieldList.addAll(selfColumnList);
        for(String key:dynamicSqlMap.keySet()){
            BaseDynamicSql baseDynamicSql = dynamicSqlMap.get(key);
            if(joinTableAliasList.contains(key)){
                List<BasicColumn> joinSelectColumnList = baseDynamicSql.getSelectColumnList(key);
                fieldList.addAll(joinSelectColumnList);
            }
        }
        return  fieldList;
    }
}

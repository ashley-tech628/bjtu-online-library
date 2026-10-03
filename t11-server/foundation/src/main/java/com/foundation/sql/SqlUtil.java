package com.foundation.sql;

import com.foundation.sql.record.PrepareSqlRecord;
import com.foundation.sql.record.JoinTableRecord;
import com.foundation.sql.record.ProviderRecord;
import com.foundation.sql.record.SqlRecord;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectModel;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.*;

public class SqlUtil {
    public  static  List<BasicColumn> getStar(SqlTable sqlTable){
        List<BasicColumn> list = new ArrayList<>();
        list.add(SqlColumn.of("*", sqlTable));
        return list;
    }
    public  static  List<SqlColumn> getColumnList(Object obj){
        Class  clazz = obj.getClass();
        List<SqlColumn> objectList = new ArrayList<>();
//        BeanWrapper beanWrapper = new BeanWrapperImpl(obj);
//        PropertyDescriptor[] propertyDescriptors = beanWrapper.getPropertyDescriptors();
//        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
//            Object value = propertyDescriptor.getValue(propertyDescriptor.getName());
//            System.out.println(value);
//        }
        Field[] declaredFields = clazz.getFields();
        AccessibleObject.setAccessible(declaredFields,true);
        Iterator<Field> iterator = Arrays.stream(declaredFields).iterator();
//        try {
//            obj = clazz.getDeclaredConstructor().newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        while (iterator.hasNext()){
            Field field = iterator.next();
            try {
                SqlColumn value = (SqlColumn) field.get(obj);
                objectList.add(value);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return objectList;
    }
    public static PrepareSqlRecord getPageSql(ProviderRecord providerRecord, int pageNo, int pageSize){
        PrepareSqlRecord prepareSqlRecord = getPrepareSqlRecord(providerRecord);
        String sql = prepareSqlRecord.sql();
        if(pageSize > 0){
            sql += limit(pageNo, pageSize);
        }
        return new PrepareSqlRecord(sql, prepareSqlRecord.paramValueList(), prepareSqlRecord.joinTableMap());
    }
    public static String limit(int pageNo, int pageSize){
        StringBuilder sb = new StringBuilder();
        int offset = (pageNo - 1) * pageSize;
        sb.append(" limit ").append(offset).append(",").append(pageSize);
        return sb.toString();
    }
    public static PrepareSqlRecord getPrepareSqlRecord(ProviderRecord providerRecord){
        Map<String, String> joinTableMap = providerRecord.joinTableMap();
        SelectStatementProvider provider = providerRecord.provider();
        String selectStatement = provider.getSelectStatement();
        Map<String, Object> parameters = provider.getParameters();
        SqlRecord sqlRecord = SqlBuilder.getSqlRecord(selectStatement, parameters);
        PrepareSqlRecord prepareSqlRecord = new PrepareSqlRecord(sqlRecord.sql(), sqlRecord.paramValueList(), joinTableMap);
        return prepareSqlRecord;
    }
//    String sql, List<Object> paramValueList
    public static PrepareSqlRecord getPrepareSqlRecord(String parameterSql, Map<String, Object> parameterMap){
        SqlRecord sqlRecord = SqlBuilder.getSqlRecord(parameterSql, parameterMap);
        PrepareSqlRecord prepareSqlRecord = new PrepareSqlRecord(sqlRecord.sql(), sqlRecord.paramValueList(), null);
        return prepareSqlRecord;
    }
    public static Map<String, String> getJoinTableMap(List<JoinTableRecord> joinTableRecordList){
        Map<String, String> map = new HashMap<>();
        for (JoinTableRecord joinTableRecord : joinTableRecordList) {
            TableSupport tableSupport = joinTableRecord.destSupport();
            String tableAlias = tableSupport.getTableAlias();
            String joinedEntityPropName = tableSupport.getJoinedEntityPropName();
            map.put(tableAlias, joinedEntityPropName);
        }
        return map;
    }
    public static SelectStatementProvider renderWhereBuilder(QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder whereBuilder){
        return  whereBuilder.build().render(RenderingStrategies.MYBATIS3);
    }
    public static List<BasicColumn> getAliasColumnList(String tableAlias, List<SqlColumn> columnList) {
        List<BasicColumn> resultList = new ArrayList<>();
        for (SqlColumn sqlColumn: columnList) {
            resultList.add(getColumn(tableAlias, sqlColumn));
        }
        return resultList;
    }
    private static SqlColumn getColumn(String tableAlias, SqlColumn sqlColumn){
        String tableAliasWithDot = tableAlias + SqlConstant.columnNameConjunction;
        StringBuilder sb = new StringBuilder();
        sb.append("`").append(tableAliasWithDot).append(sqlColumn.name()).append("`");
        SqlColumn column = sqlColumn.as(sb.toString());
        return column;
    }
}

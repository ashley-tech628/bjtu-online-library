package com.foundation.sql;

import com.foundation.sql.record.PrepareSqlRecord;
import com.foundation.sql.record.SqlRecord;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleExecutor {
    private JdbcExecutor jdbcExecutor;
    public SimpleExecutor(){
        jdbcExecutor = new JdbcExecutor();
    }
//    public <P> int doUpdate(Connection connection, String parameterSql,Map<String, Object> parameterMap){
//        SqlRecord sqlRecord = SqlBuilder.getSqlRecord(parameterSql, parameterMap);
//        return doUpdate(connection, sqlRecord);
//    }
    public <P> int doUpdate(Connection connection, PrepareSqlRecord prepareSqlRecord){
        int result = jdbcExecutor.doUpdate(connection, prepareSqlRecord);
        return result;
    }
    public <P> List<Map<String, Object>> selectRowMapList(Connection connection, PrepareSqlRecord prepareSqlRecord){
        List<Map<String, Object>> recordMapList = jdbcExecutor.doQuery(connection, prepareSqlRecord);
        return recordMapList;
    }
//    public <R> PageResponse selectPage(Connection connection, ProviderRecord providerRecord, Class<R> entityClass, PageRecord pageRecord){
//        int pageNo = pageRecord.pageNo();
//        int pageSize = pageRecord.pageSize();
//        Map<String, String> joinTableMap = providerRecord.joinTableMap();
//        String selectStatement = providerRecord.provider().getSelectStatement();
//        SqlRecord sqlRecord = SqlBuilder.getSqlRecord(selectStatement, providerRecord.provider().getParameters());
//        String selectSql = sqlRecord.sql();
//        String pageSql = selectSql + this.limit(pageNo, pageSize);
//        SqlRecord pageSqlRecord = new SqlRecord(pageSql, sqlRecord.paramValueList());
//        List<R> list = selectList(connection,  pageSqlRecord, joinTableMap, entityClass);
//        String from = selectSql.substring(selectSql.indexOf("from"));
//        String countSql = "select count(0) " + from;
//        SqlRecord countSqlRecord = new SqlRecord(countSql, sqlRecord.paramValueList());
//        Long count = (Long) selectValue(connection, countSqlRecord);
//        PageResponse pageResponse = new PageResponse(pageNo, pageSize, count, list);
//        return pageResponse;
//    }

//    public <R>  List<R> selectList(Connection connection, JoinSqlRecord joinSqlRecord, Class<R> entityClass){
//        Map<String, String> joinTableMap = joinSqlRecord.joinTableMap();
//        SqlRecord sqlRecord = SqlBuilder.getSqlRecord(providerRecord.provider().getSelectStatement(), providerRecord.provider().getParameters());
//        return selectList(connection,  sqlRecord, joinTableMap, entityClass);
//    }
    public <R>  List<R> selectList(Connection connection, PrepareSqlRecord prepareSqlRecord, Class<R> entityClass){
        List<R> resultList = new ArrayList<>();
        List<Map<String, Object>> rowMapList = this.selectRowMapList(connection, prepareSqlRecord);
        for(Map<String, Object> rowMap : rowMapList){
            R entity = getEntity(rowMap, entityClass, prepareSqlRecord.joinTableMap());
            resultList.add(entity);
        }
        return resultList;
    }
//    public Object selectValue(Connection connection ,ProviderRecord providerRecord){
//        SqlRecord sqlRecord = SqlBuilder.getSqlRecord(providerRecord.provider().getSelectStatement(), providerRecord.provider().getParameters());
//        return selectValue(connection, sqlRecord);
//    }
    public Object selectValue(Connection connection , PrepareSqlRecord prepareSqlRecord){
        List<Map<String, Object>> rowMapList = this.selectRowMapList(connection, prepareSqlRecord);
        if(rowMapList.size() == 0)return null;
        Map<String, Object> stringObjectMap = rowMapList.get(0);
        Object next = stringObjectMap.values().iterator().next();
        return next;
    }
    private <R,P> R getEntity(Map<String, Object> rowMap, Class<R> entityClass, Map<String, String> joinTableMap){
        if(null == joinTableMap)joinTableMap = new HashMap<>();
        try{
            R entity = entityClass.getDeclaredConstructor().newInstance();
//            List<String> stringList = new ArrayList<>();
//            joinTableMap.keySet().stream()anyMatch((ele) -> "".startsWith(ele));
//            User user = list.stream().filter(u -> u.getName().endsWith("sh"))
//                    .findFirst().orElse(null);
            BeanWrapper beanWrapper = new BeanWrapperImpl(entity);
            //if(null == rowMap)joinTableMap = new HashMap<>();
            //先new一个属性值放在那
            joinTableMap.values().stream().forEach((ele) ->{
                Class<?> propertyType = beanWrapper.getPropertyType(ele);
                Object propInstance = null;
                try {
                    propInstance = propertyType.getDeclaredConstructor().newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                beanWrapper.setPropertyValue(ele, propInstance);
            });
            for(Map.Entry<String, Object> row : rowMap.entrySet()){
                String underlineKey = row.getKey();
                Object value = row.getValue();
                this.setValue(underlineKey, value, joinTableMap, beanWrapper);
            }
            return entity;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    private void setValue(String underlineKey, Object value, Map<String, String> joinTableMap, BeanWrapper beanWrapper){
        //查找这个属性的开头部分是否在joinTableMap的key中存在
        String key = joinTableMap.keySet().stream().filter((e) -> underlineKey.startsWith(e)).findFirst().orElse(null);
        //有前缀
        if(null != key){
            String entityPropName = joinTableMap.get(key);
            int len = key.length() + SqlConstant.columnNameConjunction.length();
            Object propEntityObject = beanWrapper.getPropertyValue(entityPropName);
            BeanWrapper propEntityObjectWrapper = new BeanWrapperImpl(propEntityObject);
            String realColumnName = underlineKey.substring(len);
            String humpCaseKey = Underline2HumpMap.get(realColumnName);
            if(propEntityObjectWrapper.isWritableProperty(humpCaseKey)){
                trySetStringVal(propEntityObjectWrapper, humpCaseKey, value);
            }
        }else{
            String humpCaseKey = Underline2HumpMap.get(underlineKey);
            if(beanWrapper.isWritableProperty(humpCaseKey)){
                trySetStringVal(beanWrapper, humpCaseKey, value);
            }
        }
    }
//    private void trySetStringVal(BeanWrapper beanWrapper, String prop, Object value){
//        try{
//            beanWrapper.setPropertyValue(prop, value);
//        }catch (Exception e){
////             e.printStackTrace();
//            String valueString = null;
//            if(null != value){
//                valueString = value.toString();
//            }
//            beanWrapper.setPropertyValue(prop, valueString);
//        }
//    }
    private void trySetStringVal(BeanWrapper beanWrapper, String prop, Object value) {
        if(null == value) return;
        PropertyDescriptor propertyDescriptor = beanWrapper.getPropertyDescriptor(prop);
        Class<?> propertyType = propertyDescriptor.getPropertyType();
        propertyDescriptor.getPropertyEditorClass();
        if (String.class == propertyType) {
            String valueString = value.toString();
            beanWrapper.setPropertyValue(prop, valueString);
        }else {
            beanWrapper.setPropertyValue(prop, value);
        }
    }
}

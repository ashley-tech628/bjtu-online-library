package com.foundation.sql;

import com.foundation.sql.record.PrepareSqlRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.*;

public class JdbcExecutor {
    private <P> PreparedStatement createPreparedStatement(Connection connection, PrepareSqlRecord prepareSqlRecord){
        List<Object> paramValueList = prepareSqlRecord.paramValueList();
        String sql = prepareSqlRecord.sql();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(sql);
            for(int i=0;i<paramValueList.size();i++) {
                preparedStatement.setObject(i + 1, paramValueList.get(i));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return preparedStatement;
    }
    public <P> int doUpdate(Connection connection, PrepareSqlRecord prepareSqlRecord){
        PreparedStatement preparedStatement = createPreparedStatement(connection, prepareSqlRecord);
        try{
            int result = preparedStatement.executeUpdate();
            try(connection; preparedStatement) {}
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    public <P>  List<Map<String, Object>> doQuery(Connection connection, PrepareSqlRecord prepareSqlRecord){
        PreparedStatement preparedStatement = createPreparedStatement(connection, prepareSqlRecord);
//        PrepareSqlRecord prepareSqlRecord = ConvertUtil.parseSql(sql, param);
//        if(null == prepareSqlRecord)return null;
//        String prepareSql = prepareSqlRecord.sql();
//        List<Object> paramValueList = prepareSqlRecord.paramList();
        try{
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Map<String, Object>> resultList = new ArrayList<>();
            ResultSetMetaData metaData = resultSet.getMetaData();
            List<String> columnNameList = new ArrayList<>();
            for (int i = 0; i < metaData.getColumnCount(); i++){
                columnNameList.add(metaData.getColumnLabel(i+1));
            }
            while (resultSet.next()){
                Map<String, Object> rowMap = getRowMap(resultSet, columnNameList);
                resultList.add(rowMap);
            }
            try(connection; preparedStatement; resultSet) {}
            return resultList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    //    public <R,P> R selectOne(Connection connection,String sql, P param, Class<R> resultEntityClass){
//        Map<String, Object> stringObjectMap = ConvertUtil.parseSql(sql, param);
//        if(null == stringObjectMap)return null;
//        String sql = (String) stringObjectMap.get("sql");
//        List<String> paramValueList = (List<String>) stringObjectMap.get("paramValueList");
//        try{
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            for(int i=0;i<paramValueList.size();i++){
//                preparedStatement.setObject(i+1,paramValueList.get(i));
//            }
//            ResultSet resultSet = preparedStatement.executeQuery();
//            R entityInstance = resultEntityClass.getDeclaredConstructor().newInstance();
//            if (resultSet.next()){
//                Object object = resultSet.getObject(1);
//                System.out.println(object);
//            }
//            try(connection; preparedStatement; resultSet) {}
//            return entityInstance;
//        }catch (Exception e){
//
//        }
//       return null;
//    }




    //    public <R,P>  List<R> selectList(Connection connection,String sql, P param, Class<R> resultEntityClass,boolean selectOne){
//        Map<String, Object> stringObjectMap = ConvertUtil.parseSql(sql, param);
//        if(null == stringObjectMap)return null;
//        String sql = (String) stringObjectMap.get("sql");
//        List<String> paramValueList = (List<String>) stringObjectMap.get("paramValueList");
//        try{
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            for(int i=0;i<paramValueList.size();i++){
//                preparedStatement.setObject(i+1,paramValueList.get(i));
//            }
//            ResultSet resultSet = preparedStatement.executeQuery();
//            List<R> resultList = new ArrayList<>();
//
//
//
//            ResultSetMetaData metaData = resultSet.getMetaData();
//            List<String> columnNameList = new ArrayList<>();
//            for (int i = 1; i < metaData.getColumnCount(); i++){
//                columnNameList.add(metaData.getColumnLabel(i));
//            }
//            if(selectOne && resultSet.next()){
//                R bean = getBean(resultSet, columnNameList, resultEntityClass);
//                resultList.add(bean);
//            }else{
//                while (resultSet.next()){
//                    R bean = getBean(resultSet, columnNameList, resultEntityClass);
//                    resultList.add(bean);
//                }
//            }
//            try(connection; preparedStatement; resultSet) {}
//            return resultList;
//        }catch (Exception e){
//
//        }
//       return null;
//    }
    private Map<String,Object> getRowMap(ResultSet resultSet, List<String> columnNameList){
        try{
            Map<String,Object> rowMap = new HashMap<>();
            for(String columnName : columnNameList){
                Object columnValue = resultSet.getObject(columnName);
                rowMap.put(columnName,columnValue);
            }
            return rowMap;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

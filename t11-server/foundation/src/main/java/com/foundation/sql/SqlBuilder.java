package com.foundation.sql;

import com.foundation.sql.record.SqlRecord;

import java.util.*;

public class SqlBuilder {
    StringBuilder stringBuilder = null;
//    private int paramSn;
//    private String paramSql;
//    private Map<String, Object> paramMap = null;
    private List<Object> paramValueList = null;
    private SqlBuilder getSelf(){
        return this;
    }
    public SqlBuilder(){
        stringBuilder = new StringBuilder();
//        paramSn = 0;
//        this.paramMap = new LinkedHashMap<>();
        paramValueList = new ArrayList<>();
    }
    public SqlBuilder append(Object content){
        stringBuilder.append(content);
        return getSelf();
    }
    public String toString(){
        return stringBuilder.toString();
    }
    /**
     * dynamic  expression
     * @param param
     * @return
     */
//    public String getParamExpression(Object param) {
//        paramSn++;
//        String key = "p" + paramSn;
//        this.paramMap.put(key, param);
//        return "#{param." + key + "}";
//    }
    public String getQuestionExpression(Object param) {
        if(param == null)return null;
        paramValueList.add(param);
        return "?";
    }
    public SqlBuilder appendParam(Object value) {
        String paramExpression = getQuestionExpression(value);
        stringBuilder.append(paramExpression);
        return getSelf();
    }
    public SqlBuilder appendIn(Collection collection) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            Object value = iterator.next();
            String paramExpression = getQuestionExpression(value);
            if(i > 0){
                sb.append(",");
            }
            sb.append(paramExpression);
            i++;
        }
        stringBuilder.append(" in (").append(sb).append(")");
        return getSelf();
    }

//    public void setParamSql(String paramSql) {
//        this.paramSql = paramSql;
//    }

//    public SqlRecord getParamSqlRecord() {
//        if(null == this.paramSql){
//            this.paramSql = toString();
//        }
//        return new SqlRecord(this.paramSql, this.paramMap);
//    }
    public SqlRecord getSqlRecord() {
        return new SqlRecord(toString(), this.paramValueList);
    }
    public String getRealSql() {
        String sql = toString();
        String s = sql.replaceAll("\\?", "'%s'");
//        String s = "asdf %s,aaaa,%s";
        String realSql = String.format(s, this.paramValueList.toArray());
        return realSql;
    }
    //#{aaa}转?
    public static SqlRecord getSqlRecord(String parameterSql, Map<String, Object> parameterMap) {
        GenericTokenParser genericTokenParser = new GenericTokenParser("#{", "}");
        SqlRecord sqlRecord = genericTokenParser.getPrepareSql(parameterSql, parameterMap);
        return sqlRecord;
    }
////    public SqlRecord getPrepareSqlRecord() {
//        if(null == this.paramSql){
//            this.paramSql = toString();
//        }
//        GenericTokenParser genericTokenParser = new GenericTokenParser("#{", "}");
//        String prepareSql = genericTokenParser.getPrepareSql(this.paramSql);
//        return new SqlRecord(prepareSql, this.paramMap);
////    }



}

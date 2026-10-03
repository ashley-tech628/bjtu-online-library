package com.foundation.sql;

import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvertUtil {
    /**
     * 将字符串的首字母转大写
     * @param str 需要转换的字符串
     * @return
   */
    public static String upperFirst(String str) {
        // 进行字母的ascii编码前移，效率要高于截取字符串进行转换的操作
        char[] cs=str.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);
    }
    /**
     * 将字符串的首字母转小写
     * @param str 需要转换的字符串
     * @return
     */
    public static String lowFirst(String str) {
        // 同理
        char[] cs=str.toCharArray();
        cs[0]+=32;
        return String.valueOf(cs);
    }
    /**
     * 驼峰转下划线
     * @param str   目标字符串
     * @return: java.lang.String
     */
    public static String humpToUnderline(String str) {
        String regex = "([A-Z])";
        Matcher matcher = Pattern.compile(regex).matcher(str);
        while (matcher.find()) {
            String target = matcher.group();
            str = str.replaceAll(target, "_"+target.toLowerCase());
        }
        return str;
    }

    /**
     * 下划线转驼峰
     * @param str   目标字符串
     * @return: java.lang.String
     */
    public static String underlineToHump(String str) {
        String regex = "_(.)";
        Matcher matcher = Pattern.compile(regex).matcher(str);
        while (matcher.find()) {
            String target = matcher.group(1);
            str = str.replaceAll("_"+target, target.toUpperCase());
        }
        return str;
    }
    public static String db2java(String str) {
        String lowCase = str.toLowerCase();
        String s = underlineToHump(lowCase);
//        s = upperFirst(s);
        return s;
    }

    /**
     * parse to get the prepare sql(marked by ?) and the calculated param value with .
     * @param sql
     * @param paramObj
     * @return
     */
//    public static PrepareSqlRecord parseSql(String sql, Object paramObj){
//
//        //handle sql
//        GenericTokenParser genericTokenParser = new GenericTokenParser("#{", "}");
//        PrepareSqlRecord prepareSqlRecord = genericTokenParser.parse(sql);
//        String prepareSql = prepareSqlRecord.sql();
//        List<Object> paramNameList = prepareSqlRecord.paramList();
//        List<Object> paramValueList = new ArrayList<>();
//
//        for(Object paramName : paramNameList){
//            Object propertyValue = getValue(paramObj, paramName.toString());
//            if(null != propertyValue){
//                paramValueList.add(propertyValue);
//            }
//        }
//        return new PrepareSqlRecord(prepareSql, paramValueList);
//    }
    private static Object getValue(Object obj, String propertyName){
        PropertyTokenizer propertyTokenizer = new PropertyTokenizer(propertyName);
        BeanWrapper beanWrapper = new BeanWrapperImpl(obj);
        Map<String, Object> stringObjectMap = navigateProp(propertyTokenizer, beanWrapper);
        PropertyTokenizer propertyTokenizer1 = (PropertyTokenizer) stringObjectMap.get("propertyTokenizer");
        BeanWrapper beanWrapper1 = (BeanWrapper) stringObjectMap.get("beanWrapper");
        String name = propertyTokenizer1.getName();
        Object propertyValue = beanWrapper1.getPropertyValue(name);
        return propertyValue;
    }
    public static Object setValue(Object obj, String propertyName, Object value){
        PropertyTokenizer propertyTokenizer = new PropertyTokenizer(propertyName);
        BeanWrapper beanWrapper = new BeanWrapperImpl(obj);
        Map<String, Object> stringObjectMap = navigateProp(propertyTokenizer, beanWrapper);
        PropertyTokenizer propertyTokenizer1 = (PropertyTokenizer) stringObjectMap.get("propertyTokenizer");
        BeanWrapper beanWrapper1 = (BeanWrapper) stringObjectMap.get("beanWrapper");
        String name = propertyTokenizer1.getName();
        beanWrapper1.setPropertyValue(name,value);
        return beanWrapper1.getWrappedInstance();
    }
    private static Map<String, Object> navigateProp(PropertyTokenizer propertyTokenizer, BeanWrapper beanWrapper){
        Object tempObj = null;
        while(propertyTokenizer.hasNext()){
            String name = propertyTokenizer.getName();
            tempObj = beanWrapper.getPropertyValue(name);
            beanWrapper = new BeanWrapperImpl(tempObj);
//                propertyDescriptor = beanWrapper.getPropertyDescriptor(name);
            propertyTokenizer = propertyTokenizer.next();;
        }
        return Map.of("propertyTokenizer",propertyTokenizer,"beanWrapper", beanWrapper);
    }
//    private String getVal(String name){
//        PropertyTokenizer propertyTokenizer = new PropertyTokenizer(paramName.toString());
////            String stringName = paramName.toString();
////            String[] split = stringName.split("\\.");
////            int len = split.length;
//
////            String s = null;
////            for (int i = 0; i < len-1; i++) {
////                s = split[i];
////                obj = beanWrapper.getPropertyValue(s);
////                beanWrapper = new BeanWrapperImpl(obj);
////            }
////            Object propertyValue1 = beanWrapper.getPropertyValue(s);
////            PropertyDescriptor propertyDescriptor = beanWrapper.getPropertyDescriptor(s);
////            propertyDescriptor.getReadMethod().invoke(obj)
//
////            PropertyDescriptor propertyDescriptor= null;
//        Object obj = null;
//        while(propertyTokenizer.hasNext()){
//            String name = propertyTokenizer.getName();
//            obj = beanWrapper.getPropertyValue(name);
//            beanWrapper = new BeanWrapperImpl(obj);
////                propertyDescriptor = beanWrapper.getPropertyDescriptor(name);
//            propertyTokenizer = propertyTokenizer.next();;
//        }
//    }
    public static void main(String[] args) {
        String a="a.b";
        String[] split = a.split("\\.");
        System.out.println(split.length);
    }

}

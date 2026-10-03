package com.foundation.sql;

import java.util.HashMap;
import java.util.Map;

public class Underline2HumpMap {
    private static Map<String, String> map= new HashMap<>();
    public static String get(String key){
        String value = map.get(key);
        if(null == value){
            String humpCaseKey = ConvertUtil.db2java(key);
            put(key, humpCaseKey);
            return humpCaseKey;
        }
        return value;
    }
    private static void put(String key,String value){
        map.put(key, value);
    }

}

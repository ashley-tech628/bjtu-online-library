package com.foundation.sql;


import com.foundation.sql.record.SqlRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Clinton Begin
 */
public class GenericTokenParser {

    private final String openToken;
    private final String closeToken;

    public GenericTokenParser(String openToken, String closeToken) {
        this.openToken = openToken;
        this.closeToken = closeToken;
    }
//    public  PrepareSqlRecord parse(String text) {
//        List<Object> paramNameList = new ArrayList<>();
//        if (text == null || text.isEmpty()) {
//            return null;
//        }
//        // search open token
//        int start = text.indexOf(openToken);
//        if (start == -1) {
//            return new PrepareSqlRecord(text, paramNameList);
//        }
//        char[] src = text.toCharArray();
//        int offset = 0;
//        final StringBuilder builder = new StringBuilder();
//        StringBuilder expression = null;
//        do {
//            if (start > 0 && src[start - 1] == '\\') {
//                // this open token is escaped. remove the backslash and continue.
//                builder.append(src, offset, start - offset - 1).append(openToken);
//                offset = start + openToken.length();
//            } else {
//                // found open token. let's search close token.
//                if (expression == null) {
//                    expression = new StringBuilder();
//                } else {
//                    expression.setLength(0);
//                }
//                builder.append(src, offset, start - offset);
//                offset = start + openToken.length();
//                int end = text.indexOf(closeToken, offset);
//                while (end > -1) {
//                    if (end > offset && src[end - 1] == '\\') {
//                        // this close token is escaped. remove the backslash and continue.
//                        expression.append(src, offset, end - offset - 1).append(closeToken);
//                        offset = end + closeToken.length();
//                        end = text.indexOf(closeToken, offset);
//                    } else {
//                        expression.append(src, offset, end - offset);
//                        break;
//                    }
//                }
//                if (end == -1) {
//                    // close token was not found.
//                    builder.append(src, start, src.length - start);
//                    offset = src.length;
//                } else {
//                    builder.append(handleToken(expression.toString()));
//                    offset = end + closeToken.length();
//                }
//            }
//            paramNameList.add(expression.toString());
//            start = text.indexOf(openToken, offset);
//        } while (start > -1);
//        if (offset < src.length) {
//            builder.append(src, offset, src.length - offset);
//        }
//        String sql = builder.toString();
//        return new PrepareSqlRecord(sql, paramNameList);
//    }
    public SqlRecord getPrepareSql(String text, Map<String, Object> parameterMap) {
        List<Object> paramValueList = new ArrayList<>();
        if (text == null || text.isEmpty()) {
            return null;
        }
        // search open token
        int start = text.indexOf(openToken);
        if (start == -1) {
            return new SqlRecord(text, paramValueList);
        }
        char[] src = text.toCharArray();
        int offset = 0;
        final StringBuilder builder = new StringBuilder();
        StringBuilder expression = null;
        do {
            if (start > 0 && src[start - 1] == '\\') {
                // this open token is escaped. remove the backslash and continue.
                builder.append(src, offset, start - offset - 1).append(openToken);
                offset = start + openToken.length();
            } else {
                // found open token. let's search close token.
                if (expression == null) {
                    expression = new StringBuilder();
                } else {
                    expression.setLength(0);
                }
                builder.append(src, offset, start - offset);
                offset = start + openToken.length();
                int end = text.indexOf(closeToken, offset);
                while (end > -1) {
                    if (end > offset && src[end - 1] == '\\') {
                        // this close token is escaped. remove the backslash and continue.
                        expression.append(src, offset, end - offset - 1).append(closeToken);
                        offset = end + closeToken.length();
                        end = text.indexOf(closeToken, offset);
                    } else {
                        expression.append(src, offset, end - offset);
                        break;
                    }
                }
                if (end == -1) {
                    // close token was not found.
                    builder.append(src, start, src.length - start);
                    offset = src.length;
                } else {
                    builder.append(handleToken(expression.toString()));
                    offset = end + closeToken.length();
                }
            }
            String innerContent = expression.toString();
            String[] splitArr = innerContent.split("\\.");
            String px = splitArr[1];
            Object value = parameterMap.get(px);
            paramValueList.add(value);
            start = text.indexOf(openToken, offset);
        } while (start > -1);
        if (offset < src.length) {
            builder.append(src, offset, src.length - offset);
        }
        String sql = builder.toString();
        return new SqlRecord(sql, paramValueList);
    }
    private String handleToken(String content){
//        Map<String, String> aa = Map.of("?", "kkkk");
//        return null;
        return "?";
    }
}
//package com.foundation.sql.appendSqlTest;
//
//import com.foundation.sql.SqlBuilder;
//import com.foundation.sql.record.SqlRecord;
//import com.u3.web.auth.entity.AuthUserEntity;
//import com.u3.web.auth.param.AuthUserParam;
//
//public final class AuthUserTestSql {
//    public SqlRecord insert(AuthUserEntity authUserEntity){
//        SqlBuilder sqlBuilder = new SqlBuilder();
//        sqlBuilder.append("insert into auth_user(id, username,password)values(");
//        sqlBuilder.appendParam(authUserEntity.getId()).append(",");
//        sqlBuilder.appendParam(authUserEntity.getUsername()).append(",");
//        sqlBuilder.appendParam(authUserEntity.getPassword()).append(")");
//        SqlRecord sqlRecord = sqlBuilder.getSqlRecord();
//        System.out.println(sqlBuilder.getRealSql());
//        return sqlRecord;
//    }
//    public SqlRecord update(AuthUserEntity authUserEntity, AuthUserParam authUserParam){
//        SqlBuilder sqlBuilder = new SqlBuilder();
//        sqlBuilder.append("update auth_user set username=").appendParam(authUserEntity.getUsername());
//        sqlBuilder.append(",password=").appendParam(authUserEntity.getPassword());
//        sqlBuilder.append(" where 1=1 and id=").appendParam(authUserParam.getId());
//        SqlRecord sqlRecord = sqlBuilder.getSqlRecord();
//        System.out.println(sqlBuilder.getRealSql());
//        return sqlRecord;
//    }
//    public SqlRecord select(AuthUserParam authUserParam){
//        SqlBuilder sqlBuilder = new SqlBuilder();
//        sqlBuilder.append("select * from auth_user where 1=1");
//        where(sqlBuilder, authUserParam);
//        SqlRecord sqlRecord = sqlBuilder.getSqlRecord();
//        System.out.println(sqlBuilder.getRealSql());
//        return sqlRecord;
//    }
//    public SqlRecord selectPage(AuthUserParam authUserParam){
//        SqlBuilder sqlBuilder = new SqlBuilder();
//        sqlBuilder.append("select * from auth_user where 1=1");
//        where(sqlBuilder, authUserParam);
//        orderBy(sqlBuilder);
//        limit(sqlBuilder, authUserParam);
//        SqlRecord sqlRecord = sqlBuilder.getSqlRecord();
//        System.out.println(sqlBuilder.getRealSql());
//        return sqlRecord;
//    }
//    public SqlRecord selectCount(AuthUserParam authUserParam){
//        SqlBuilder sqlBuilder = new SqlBuilder();
//        sqlBuilder.append("select  count(*) from auth_user where 1=1");
//        where(sqlBuilder, authUserParam);
//        SqlRecord sqlRecord = sqlBuilder.getSqlRecord();
//        System.out.println(sqlBuilder.getRealSql());
//        return sqlRecord;
//    }
//    public void where(SqlBuilder sqlBuilder, AuthUserParam authUserParam){
//        if(null != authUserParam.getId()){
//            sqlBuilder.append(" and  id=").appendParam(authUserParam.getId());
//        }
//        if(null != authUserParam.getUsername()){
//            sqlBuilder.append(" and  username=").appendParam(authUserParam.getUsername());
//        }
//    }
//    public void orderBy(SqlBuilder sqlBuilder){
//        sqlBuilder.append(" order by create_time desc");
//    }
//    public void limit(SqlBuilder sqlBuilder, AuthUserParam authUserParam){
//        int pageNo = authUserParam.getPageNo();
//        int pageSize = authUserParam.getPageSize();
//        int offset = (pageNo - 1) * pageSize;
//        sqlBuilder.append(" limit ").append(offset).append(",").append(pageSize);
//    }
//    public SqlRecord delete(AuthUserParam authUserParam){
//        SqlBuilder sqlBuilder = new SqlBuilder();
//        sqlBuilder.append("delete from auth_user where 1=1");
//        sqlBuilder.append(" and  id=").appendParam(authUserParam.getId());
//        SqlRecord sqlRecord = sqlBuilder.getSqlRecord();
//        System.out.println(sqlBuilder.getRealSql());
//        return sqlRecord;
//    }
////    public SqlRecord select01(AuthUserParam authUserParam){
////        StringBuilder sqlBuilder = new StringBuilder();
////        String ss = authUserParam.getPassword();
////        if(null != ss){
////            ss = ss.replace("'", "");
////        }
////        sqlBuilder.append("select * from auth_user where 1=1  username='").append(authUserParam.getUsername());
////        sqlBuilder.append("' and password='").append(ss).append("'");
////        String sql = sqlBuilder.toString();
////        System.out.println(sql);
////        return new SqlRecord(sql, new ArrayList<>());
////    }
//}
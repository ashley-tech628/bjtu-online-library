//package com.foundation.sql.appendSqlTest;
//
//import com.foundation.sql.ConnectionFactory;
//import com.foundation.sql.SimpleExecutor;
//import com.foundation.sql.record.SqlRecord;
//import com.u3.web.auth.entity.AuthUserEntity;
//import com.u3.web.auth.param.AuthUserParam;
//import com.u3.web.auth.sql.AuthUserTestSql;
//import org.springframework.stereotype.Repository;
//
//import java.sql.Connection;
//import java.util.List;
//
//public class AuthUserTestDao {
//    public  List<AuthUserEntity> selectList(AuthUserParam authUserParam){
//            Connection connection = ConnectionFactory.getDefaultConnection();
//            AuthUserTestSql authUserTestSql = new AuthUserTestSql();
//            SqlRecord sqlRecord = authUserTestSql.select(authUserParam);
//            SimpleExecutor simpleExecutor = new SimpleExecutor();
////            List<AuthUserEntity> authUserEntityList = simpleExecutor.selectList(connection, sqlRecord,null, AuthUserEntity.class);
////            return authUserEntityList;
//            return null;
//    }
//    public  List<AuthUserEntity> selectPage(AuthUserParam authUserParam){
//            Connection connection = ConnectionFactory.getDefaultConnection();
//            AuthUserTestSql authUserTestSql = new AuthUserTestSql();
//            SqlRecord sqlRecord = authUserTestSql.selectPage(authUserParam);
//            SimpleExecutor simpleExecutor = new SimpleExecutor();
////            List<AuthUserEntity> authUserEntityList = simpleExecutor.selectList(connection, sqlRecord,null, AuthUserEntity.class);
////            return authUserEntityList;
//            return null;
//    }
//    public  AuthUserEntity selectOne(AuthUserParam authUserParam){
//        List<AuthUserEntity> authUserEntityList = selectPage(authUserParam);
//        if(null == authUserEntityList || authUserEntityList.size() == 0)return null;
//        return authUserEntityList.get(0);
//    }
//    public Long selectCount(AuthUserParam authUserParam){
//        Connection connection = ConnectionFactory.getDefaultConnection();
//        AuthUserTestSql authUserTestSql = new AuthUserTestSql();
//        SqlRecord sqlRecord = authUserTestSql.selectCount(authUserParam);
//        SimpleExecutor simpleExecutor = new SimpleExecutor();
////        Long count = (Long) simpleExecutor.selectValue(connection, sqlRecord);
//        return 0L;
//    }
//    public  int insert(AuthUserEntity authUserEntity) {
//        Connection connection = ConnectionFactory.getDefaultConnection();
//        AuthUserTestSql authUserTestSql = new AuthUserTestSql();
//        SqlRecord sqlRecord = authUserTestSql.insert(authUserEntity);
//        SimpleExecutor simpleExecutor = new SimpleExecutor();
//        int result = simpleExecutor.doUpdate(connection, sqlRecord);
//        return result;
//    }
//    public  int update(AuthUserEntity authUserEntity, AuthUserParam authUserParam) {
//        Connection connection = ConnectionFactory.getDefaultConnection();
//        AuthUserTestSql authUserTestSql = new AuthUserTestSql();
//        SqlRecord sqlRecord = authUserTestSql.update(authUserEntity, authUserParam);
//        SimpleExecutor simpleExecutor = new SimpleExecutor();
//        int result = simpleExecutor.doUpdate(connection, sqlRecord);
//        return result;
//    }
//    public  int delete(AuthUserParam authUserParam) {
//        Connection connection = ConnectionFactory.getDefaultConnection();
//        AuthUserTestSql authUserTestSql = new AuthUserTestSql();
//        SqlRecord sqlRecord = authUserTestSql.delete(authUserParam);
//        SimpleExecutor simpleExecutor = new SimpleExecutor();
//        int result = simpleExecutor.doUpdate(connection, sqlRecord);
//        return result;
//    }
//}
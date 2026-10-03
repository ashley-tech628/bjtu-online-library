package com.foundation.sql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
    static HikariDataSource hikariDataSource = null;
    static {
        hikariDataSource = createDefaultDataSource();
    }
    private static HikariDataSource createDefaultDataSource(){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setUsername(System.getenv("DB_USERNAME"));
        hikariConfig.setPassword(System.getenv("DB_PASSWORD"));




        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setJdbcUrl(System.getenv("DB_URL"));
        return new HikariDataSource(hikariConfig);
    }
    public static Connection getDefaultConnection(){
        try {
            return hikariDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

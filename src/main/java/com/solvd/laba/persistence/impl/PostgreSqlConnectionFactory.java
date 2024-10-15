package com.solvd.laba.persistence.impl;

import com.solvd.laba.ConnectionPool;
import com.solvd.laba.persistence.ConnectionFactory;
import com.solvd.laba.persistence.DatabaseDialect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;

public class PostgreSqlConnectionFactory implements ConnectionFactory {

    @Override
    public Connection getConnection() throws SQLException {
        return ConnectionPool.getConnection();
    }

    @Override
    public DatabaseDialect getDialect() {
        return DatabaseDialect.POSTGRESQL;
    }

}
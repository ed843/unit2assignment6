package com.solvd.laba.persistence.impl;

import com.solvd.laba.persistence.ConnectionFactory;
import com.solvd.laba.persistence.DatabaseDialect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;

public class MySqlConnectionFactory implements ConnectionFactory {
    private static final Properties props = new Properties();

    static {
        try (InputStream input = MySqlConnectionFactory.class.getClassLoader().getResourceAsStream("database.properties")) {
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Error loading database configuration", e);
        }
    }

    @Override
    public DatabaseDialect getDialect() {
        return DatabaseDialect.MYSQL;
    }


    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                props.getProperty("jdbc.url"),
                props.getProperty("jdbc.username"),
                props.getProperty("jdbc.password")
        );
    }
}

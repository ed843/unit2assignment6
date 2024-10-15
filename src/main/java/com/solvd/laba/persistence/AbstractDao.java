package com.solvd.laba.persistence;


import com.solvd.laba.generics.GenericDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public abstract class AbstractDao<T, ID> implements GenericDao<T, ID> {
    protected ConnectionFactory connectionFactory;
    protected SqlProvider sqlProvider;

    public AbstractDao(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
        this.sqlProvider = new SqlProvider(connectionFactory.getDialect());
    }

    protected Connection getConnection() throws SQLException {
        return connectionFactory.getConnection();
    }

    protected void closeResources(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
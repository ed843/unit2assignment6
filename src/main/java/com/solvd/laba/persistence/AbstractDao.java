package com.solvd.laba.DAO;

import com.solvd.laba.ConnectionPool;
import com.solvd.laba.generics.GenericDao;

import java.sql.*;

public abstract class AbstractDao<T, ID> implements GenericDao<T, ID> {
    protected Connection getConnection() throws SQLException {
        return ConnectionPool.getConnection();
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

    // Other methods...
}
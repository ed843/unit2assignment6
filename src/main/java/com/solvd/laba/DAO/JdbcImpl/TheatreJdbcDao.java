package com.solvd.laba.DAO.JdbcImpl;

import com.solvd.laba.DAO.TheatreDao;
import com.solvd.laba.models.Theatre;
import com.solvd.laba.persistence.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.laba.ConnectionPool.getConnection;

public class TheatreJdbcDao implements TheatreDao {
    private final ConnectionFactory connectionFactory;

    public TheatreJdbcDao(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public Theatre findById(Integer id) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = connectionFactory.getConnection();
            String sql = "SELECT * FROM Theatre WHERE theatre_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return extractTheatreFromResultSet(rs);
            }
        } finally {
            closeResources(conn, stmt, rs);
        }
        return null;
    }

    @Override
    public List<Theatre> findAll() throws SQLException {
        List<Theatre> theatres = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = connectionFactory.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Theatre");
            while (rs.next()) {
                theatres.add(extractTheatreFromResultSet(rs));
            }
        } finally {
            closeResources(conn, stmt, rs);
        }
        return theatres;
    }

    @Override
    public void save(Theatre theatre) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = connectionFactory.getConnection();
            String sql = "INSERT INTO Theatre (theatre_name, location) VALUES (?, ?)";
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, theatre.getTheatreName());
            stmt.setString(2, theatre.getLocation());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    theatre.setTheatreId(generatedKeys.getInt(1));
                }
            }
        } finally {
            closeResources(conn, stmt, null);
        }
    }

    @Override
    public void update(Theatre theatre) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = connectionFactory.getConnection();
            String sql = "UPDATE Theatre SET theatre_name = ?, location = ? WHERE theatre_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, theatre.getTheatreName());
            stmt.setString(2, theatre.getLocation());
            stmt.setInt(3, theatre.getTheatreId());
            stmt.executeUpdate();
        } finally {
            closeResources(conn, stmt, null);
        }
    }

    @Override
    public void delete(Theatre theatre) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = connectionFactory.getConnection();
            String sql = "DELETE FROM Theatre WHERE theatre_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, theatre.getTheatreId());
            stmt.executeUpdate();
        } finally {
            closeResources(conn, stmt, null);
        }
    }

    @Override
    public List<Theatre> findByLocation(String location) throws SQLException {
        List<Theatre> theatres = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = connectionFactory.getConnection();
            String sql = "SELECT * FROM Theatre WHERE location = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, location);
            rs = stmt.executeQuery();
            while (rs.next()) {
                theatres.add(extractTheatreFromResultSet(rs));
            }
        } finally {
            closeResources(conn, stmt, rs);
        }
        return theatres;
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

    private Theatre extractTheatreFromResultSet(ResultSet rs) throws SQLException {
        Theatre theatre = new Theatre();
        theatre.setTheatreId(rs.getInt("theatre_id"));
        theatre.setTheatreName(rs.getString("theatre_name"));
        theatre.setLocation(rs.getString("location"));
        theatre.setCapacity(rs.getInt("capacity"));
        return theatre;
    }
}

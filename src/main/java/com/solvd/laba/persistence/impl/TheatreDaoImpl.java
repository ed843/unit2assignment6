package com.solvd.laba.persistence.impl;

import com.solvd.laba.DAO.TheatreDao;
import com.solvd.laba.persistence.AbstractDao;
import com.solvd.laba.persistence.ConnectionFactory;
import com.solvd.laba.records.Theatre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TheatreDaoImpl extends AbstractDao<Theatre, Integer> implements TheatreDao {

    public TheatreDaoImpl(ConnectionFactory connectionFactory) {
        super(connectionFactory);
    }

    @Override
    public Theatre findById(Integer id) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            String sql = "SELECT * FROM Theatre WHERE theater_id = ?";
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
            conn = getConnection();
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
            conn = getConnection();
            String sql = "INSERT INTO Theatre (name, location) VALUES (?, ?)";
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
            conn = getConnection();
            String sql = "UPDATE Theatre SET name = ?, location = ? WHERE theater_id = ?";
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
            conn = getConnection();
            String sql = "DELETE FROM Theatre WHERE theater_id = ?";
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
            conn = getConnection();
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

    private Theatre extractTheatreFromResultSet(ResultSet rs) throws SQLException {
        Theatre theatre = new Theatre();
        theatre.setTheatreId(rs.getInt("theatre_id"));
        theatre.setTheatreName(rs.getString("theatre_name"));
        theatre.setLocation(rs.getString("location"));
        theatre.setCapacity(rs.getInt("capacity"));
        return theatre;
    }
}
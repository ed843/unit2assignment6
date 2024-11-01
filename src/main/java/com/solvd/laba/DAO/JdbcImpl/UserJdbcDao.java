package com.solvd.laba.DAO.JdbcImpl;

import com.solvd.laba.DAO.UserDao;
import com.solvd.laba.models.User;
import com.solvd.laba.persistence.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDao implements UserDao {

    private final ConnectionFactory connectionFactory;

    public UserJdbcDao(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }
    @Override
    public User findByUsername(String username) throws SQLException {
        return null;
    }

    @Override
    public User findById(Integer integer) throws SQLException {
        User user = new User();
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection conn = connectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            user = extractUserFromResultSet(rs);
        }
        return user;
    }

    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection conn = connectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                users.add(extractUserFromResultSet(rs));
            }
        }
        return users;
    }

    private User extractUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUserId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setEmail(rs.getString("email"));
        user.setPhoneNumber(rs.getString("phone_number"));
        return user;
    }

    @Override
    public void save(User user) throws SQLException {
        String sql = "INSERT INTO users (user_id, username, email, phone_number) VALUES (?, ?, ?, ?)";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, user.getUserId());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPhoneNumber());
            stmt.executeUpdate();
        }
    }

    @Override
    public void update(User user) throws SQLException {
        String sql = "UPDATE users SET username = ?, email = ?, phone_number = ? WHERE user_id = ?";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPhoneNumber());
            stmt.setInt(4, user.getUserId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(User user) throws SQLException {
        String sql = "DELETE FROM users WHERE user_id = ?";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, user.getUserId());
            stmt.executeUpdate();
        }
    }
}

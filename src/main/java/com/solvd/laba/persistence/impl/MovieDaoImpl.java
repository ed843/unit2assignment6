package com.solvd.laba.persistence.impl;

import com.solvd.laba.DAO.MovieDao;
import com.solvd.laba.persistence.AbstractDao;
import com.solvd.laba.persistence.ConnectionFactory;
import com.solvd.laba.persistence.DatabaseDialect;
import com.solvd.laba.models.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDaoImpl extends AbstractDao<Movie, Integer> implements MovieDao {
    public MovieDaoImpl(ConnectionFactory connectionFactory) {
        super(connectionFactory);
    }

    @Override
    public Movie findById(Integer id) throws SQLException {
        String sql = sqlProvider.getFindMovieByIdQuery();
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return extractMovieFromResultSet(rs);
                }
            }
        }
        return null;
    }


    @Override
    public List<Movie> findAll() throws SQLException {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM Movie";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                movies.add(extractMovieFromResultSet(rs));
            }
        }
        return movies;
    }

    @Override
    public void save(Movie movie) throws SQLException {
        String sql = sqlProvider.getInsertMovieQuery();
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, movie.getTitle());
            stmt.setInt(2, movie.getDuration());
            stmt.setString(3, movie.getGenre());
            stmt.setDate(4, new java.sql.Date(movie.getReleaseDate().getTime()));

            if (connectionFactory.getDialect() == DatabaseDialect.POSTGRESQL) {
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        movie.setMovieId(rs.getInt(1));
                    }
                }
            } else {
                stmt.executeUpdate();
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        movie.setMovieId(generatedKeys.getInt(1));
                    }
                }
            }
        }
    }


    @Override
    public void update(Movie movie) throws SQLException {
        String sql = "UPDATE Movie SET title = ?, duration = ?, genre = ?, release_date = ? WHERE movie_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, movie.getTitle());
            stmt.setInt(2, movie.getDuration());
            stmt.setString(3, movie.getGenre());
            stmt.setDate(4, new java.sql.Date(movie.getReleaseDate().getTime()));
            stmt.setInt(5, movie.getMovieId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(Movie movie) throws SQLException {
        String sql = "DELETE FROM Movie WHERE movie_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, movie.getMovieId());
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Movie> findByGenre(String genre) throws SQLException {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM Movie WHERE genre = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, genre);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    movies.add(extractMovieFromResultSet(rs));
                }
            }
        }
        return movies;
    }

    private Movie extractMovieFromResultSet(ResultSet rs) throws SQLException {
        Movie movie = new Movie();
        movie.setMovieId(rs.getInt("movie_id"));
        movie.setTitle(rs.getString("title"));
        movie.setDuration(rs.getInt("duration"));
        movie.setGenre(rs.getString("genre"));
        movie.setReleaseDate(rs.getDate("release_date"));
        return movie;
    }
}
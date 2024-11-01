package com.solvd.laba.DAO.JdbcImpl;

import com.solvd.laba.DAO.ScreeningDao;
import com.solvd.laba.models.Screening;
import com.solvd.laba.persistence.ConnectionFactory;

import java.sql.SQLException;
import java.util.List;

public class ScreeningJdbcDao implements ScreeningDao {
    private final ConnectionFactory connectionFactory;

    public ScreeningJdbcDao(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public List<Screening> findByMovieId(Integer movieId) throws SQLException {
        return null;
    }

    @Override
    public Screening findById(Integer integer) throws SQLException {
        return null;
    }

    @Override
    public List<Screening> findAll() throws SQLException {
        return null;
    }

    @Override
    public void save(Screening entity) throws SQLException {

    }

    @Override
    public void update(Screening entity) throws SQLException {

    }

    @Override
    public void delete(Screening entity) throws SQLException {

    }
}

package com.solvd.laba.DAO.JdbcImpl;

import com.solvd.laba.DAO.ReservationDao;
import com.solvd.laba.models.Reservation;
import com.solvd.laba.persistence.ConnectionFactory;

import java.sql.SQLException;
import java.util.List;

public class ReservationJdbcDao implements ReservationDao {

    private final ConnectionFactory connectionFactory;

    public ReservationJdbcDao(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }
    @Override
    public Reservation findByStatus(String status) throws SQLException {
        return null;
    }

    @Override
    public Reservation findById(Integer integer) throws SQLException {
        return null;
    }

    @Override
    public List<Reservation> findAll() throws SQLException {
        return null;
    }

    @Override
    public void save(Reservation entity) throws SQLException {

    }

    @Override
    public void update(Reservation entity) throws SQLException {

    }

    @Override
    public void delete(Reservation entity) throws SQLException {

    }
}

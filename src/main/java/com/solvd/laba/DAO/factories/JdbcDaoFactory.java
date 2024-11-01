package com.solvd.laba.DAO.factories;


import com.solvd.laba.DAO.*;
import com.solvd.laba.DAO.AbstractFactory.DaoAbstractFactory;
import com.solvd.laba.DAO.JdbcImpl.*;
import com.solvd.laba.persistence.ConnectionFactory;

public class JdbcDaoFactory implements DaoAbstractFactory {
    private final ConnectionFactory connectionFactory;

    JdbcDaoFactory(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public MovieDao createMovieDao() {
        return new MovieJdbcDao(connectionFactory);
    }

    @Override
    public TheatreDao createTheatreDao() {
        return new TheatreJdbcDao(connectionFactory);
    }

    @Override
    public UserDao createUserDao() {
       return new UserJdbcDao(connectionFactory);
    }

    @Override
    public ReservationDao createReservationDao() {
        return new ReservationJdbcDao(connectionFactory);
    }

    @Override
    public ScreeningDao createScreeningDao() {
        return new ScreeningJdbcDao(connectionFactory);
    }


}

package com.solvd.laba.DAO.factories;

import com.solvd.laba.DAO.*;
import com.solvd.laba.DAO.JdbcImpl.*;
import com.solvd.laba.DAO.MyBatisImpl.*;
import com.solvd.laba.persistence.ConnectionFactory;
import com.solvd.laba.persistence.impl.MySqlConnectionFactory;

public class DaoFactory {
    private static final ConnectionFactory connectionFactory = new MySqlConnectionFactory();

    public enum DaoType {
        MYBATIS, JDBC
    }

    public static MovieDao getMovieDao(DaoType type) {
        switch (type) {
            case MYBATIS:
                return new MovieMyBatisDao();
            case JDBC:
                return new MovieJdbcDao(connectionFactory);
            default:
                throw new IllegalArgumentException("Unknown DAO type");
        }
    }

    public static TheatreDao getTheatreDao(DaoType type) {
        switch (type) {
            case MYBATIS:
                return new TheatreMyBatisDao();
            case JDBC:
                return new TheatreJdbcDao(connectionFactory);
            default:
                throw new IllegalArgumentException("Unknown DAO type");
        }
    }

    public static ScreeningDao getScreeningDao(DaoType type) {
        switch (type) {
            case MYBATIS:
                return new ScreeningMyBatisDao();
            case JDBC:
                return new ScreeningJdbcDao(connectionFactory);
            default:
                throw new IllegalArgumentException("Unknown DAO type");
        }
    }

    public static UserDao getUserDao(DaoType type) {
        switch (type) {
            case MYBATIS:
                return new UserMyBatisDao();
            case JDBC:
                return new UserJdbcDao(connectionFactory);
            default:
                throw new IllegalArgumentException("Unknown DAO type");
        }
    }

    public static ReservationDao getReservationDao(DaoType type) {
        switch (type) {
            case MYBATIS:
                return new ReservationMyBatisDao();
            case JDBC:
                return new ReservationJdbcDao(connectionFactory);
            default:
                throw new IllegalArgumentException("Unknown DAO type");
        }
    }
}
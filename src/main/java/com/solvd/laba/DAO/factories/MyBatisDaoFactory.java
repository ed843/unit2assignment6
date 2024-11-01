package com.solvd.laba.DAO.factories;

import com.solvd.laba.DAO.*;
import com.solvd.laba.DAO.AbstractFactory.DaoAbstractFactory;
import com.solvd.laba.DAO.MyBatisImpl.*;

public class MyBatisDaoFactory implements DaoAbstractFactory {
    @Override
    public MovieDao createMovieDao() {
        return new MovieMyBatisDao();
    }

    @Override
    public TheatreDao createTheatreDao() {
        return new TheatreMyBatisDao();
    }

    @Override
    public UserDao createUserDao() {
        return new UserMyBatisDao();
    }

    @Override
    public ReservationDao createReservationDao() {
        return new ReservationMyBatisDao();
    }

    @Override
    public ScreeningDao createScreeningDao() {
        return new ScreeningMyBatisDao();
    }


}

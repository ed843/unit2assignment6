package com.solvd.laba.DAO.AbstractFactory;

import com.solvd.laba.DAO.*;

public interface DaoAbstractFactory {
    MovieDao createMovieDao();
    TheatreDao createTheatreDao();
    UserDao createUserDao();
    ReservationDao createReservationDao();
    ScreeningDao createScreeningDao();
}
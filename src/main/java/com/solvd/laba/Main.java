package com.solvd.laba;

import com.solvd.laba.DAO.AbstractFactory.DaoAbstractFactory;
import com.solvd.laba.DAO.factories.MyBatisDaoFactory;
import com.solvd.laba.models.*;
import com.solvd.laba.models.builders.ReservationBuilder;
import com.solvd.laba.models.facade.CinemaBookingFacade;
import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.services.MVC.MovieController;
import com.solvd.laba.services.MVC.MovieModel;
import com.solvd.laba.services.MVC.MovieView;
import com.solvd.laba.services.decorators.MovieServiceLoggingDecorator;
import com.solvd.laba.services.impl.*;
import com.solvd.laba.services.interfaces.MovieService.MovieService;
import com.solvd.laba.services.interfaces.ReservationService.ReservationService;
import com.solvd.laba.services.listener.EmailNotificationListener;
import com.solvd.laba.services.proxies.CachingMovieServiceProxy;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws SQLException, ServiceException {
        Application application = new Application();
        application.run();
    }
}
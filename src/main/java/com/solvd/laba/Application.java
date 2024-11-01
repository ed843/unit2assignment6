package com.solvd.laba;

import com.solvd.laba.DAO.AbstractFactory.DaoAbstractFactory;
import com.solvd.laba.DAO.factories.MyBatisDaoFactory;
import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.models.Reservation;
import com.solvd.laba.models.Screening;
import com.solvd.laba.models.Seat;
import com.solvd.laba.models.User;
import com.solvd.laba.models.builders.ReservationBuilder;
import com.solvd.laba.models.facade.CinemaBookingFacade;
import com.solvd.laba.services.MVC.MovieController;
import com.solvd.laba.services.MVC.MovieModel;
import com.solvd.laba.services.MVC.MovieView;
import com.solvd.laba.services.decorators.MovieServiceLoggingDecorator;
import com.solvd.laba.services.impl.MovieServiceImpl;
import com.solvd.laba.services.impl.ReservationServiceImpl;
import com.solvd.laba.services.interfaces.MovieService.MovieService;
import com.solvd.laba.services.interfaces.ReservationService.ReservationService;
import com.solvd.laba.services.listener.EmailNotificationListener;
import com.solvd.laba.services.proxies.CachingMovieServiceProxy;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Application {
    // Set up factory
    DaoAbstractFactory daoFactory = new MyBatisDaoFactory();

    // Create facade
    CinemaBookingFacade facade = new CinemaBookingFacade();

    // Set up services with decorators and proxies
    MovieService movieService = new MovieServiceLoggingDecorator(
            new CachingMovieServiceProxy(
                    new MovieServiceImpl()
            )
    );

    // Set up MVC
    MovieModel model = new MovieModel(movieService);
    MovieView view = new MovieView();
    MovieController controller = new MovieController(model, view);


    // Set up reservation with listeners
    ReservationService reservationService = new ReservationServiceImpl();
    User user = new User(2, "username", "email@test.com", "123-456-7890");
    Screening screening = new Screening(2, Timestamp.valueOf(LocalDateTime.now()), 3, 2, 10.00);
    Seat seat = new Seat(2, 1, 3, 2);

    // Use builder
    Reservation reservation = new ReservationBuilder()
            .setUser(user)
            .setScreening(screening)
            .setSeat(seat)
            .setReservedAt(Timestamp.valueOf(LocalDateTime.now()))
            .build();

    // Use facade for booking
        public void run() throws ServiceException, SQLException {
            System.out.println(movieService.findById(2));

            // Use controller to view movies
            controller.displayMovies();

            // Set up reservation with listeners
            reservationService.addListener(new EmailNotificationListener());

            // Print out reservation from builder
            System.out.println(reservation);

            // Use facade for booking
            facade.bookTicket(1, 3, 2, seat);
        }
}

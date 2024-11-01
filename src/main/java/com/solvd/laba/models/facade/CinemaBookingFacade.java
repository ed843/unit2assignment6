package com.solvd.laba.models.facade;

import com.solvd.laba.DAO.*;
import com.solvd.laba.DAO.AbstractFactory.DaoAbstractFactory;
import com.solvd.laba.DAO.factories.MyBatisDaoFactory;
import com.solvd.laba.models.*;
import com.solvd.laba.models.builders.ReservationBuilder;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class CinemaBookingFacade {
    private MovieDao movieService;
    private TheatreDao theatreService;
    private ReservationDao reservationService;
    private UserDao userService;
    private ScreeningDao screeningService;

    public CinemaBookingFacade() {
        DaoAbstractFactory daoFactory = new MyBatisDaoFactory();
        this.movieService = daoFactory.createMovieDao();
        this.theatreService = daoFactory.createTheatreDao();
        this.reservationService = daoFactory.createReservationDao();
        this.userService = daoFactory.createUserDao();
        this.screeningService = daoFactory.createScreeningDao();
    }

    public Reservation bookTicket(int userId, int movieId, int theatreId, Seat seat) throws SQLException {
        // Simplified booking process
        Movie movie = movieService.findById(movieId);
        Theatre theatre = theatreService.findById(theatreId);

        ReservationBuilder builder = new ReservationBuilder()
                .setUser(userService.findById(userId))
                .setSeat(seat)
                .setScreening(findAvailableScreening(movie, theatre))
                .setReservedAt(Timestamp.valueOf(LocalDateTime.now()));

        reservationService.save(builder.build());
        return builder.build();
    }

    private Screening findAvailableScreening(Movie movie, Theatre theatre) throws SQLException {
        List<Screening> screenings = screeningService.findByMovieId(movie.getMovieId());
        return screenings.get(0);
    }
}

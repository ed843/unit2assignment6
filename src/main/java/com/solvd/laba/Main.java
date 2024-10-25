package com.solvd.laba;

import com.solvd.laba.models.*;
import com.solvd.laba.persistence.ConnectionFactory;
import com.solvd.laba.persistence.impl.MovieDaoImpl;
import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.persistence.impl.MySqlConnectionFactory;
import com.solvd.laba.persistence.impl.TheatreDaoImpl;
import com.solvd.laba.services.impl.*;
import com.solvd.laba.services.interfaces.*;

public class Main {
    public static void main(String[] args) {

        MovieService movieService = new MovieServiceImpl();
        TheatreService theatreService = new TheatreServiceImpl();
        ScreeningService screeningService = new ScreeningServiceImpl();
        UserService userService = new UserServiceImpl();
        ReservationService reservationService = new ReservationServiceImpl();


        try {
            Movie movie = movieService.findById(1);
            System.out.println("Found movie: " + movie.getTitle());
            Theatre theatre = theatreService.findById(1);
            System.out.println("Found theatre: " + theatre.getTheatreName());
            Screening screening = screeningService.findById(1);
            System.out.println("Found screening: " + screening.getScreeningId());
            User user = userService.findById(1);
            System.out.println("Found user: " + user.getUsername());
            Reservation reservation = reservationService.findById(1);
            System.out.println("Found reservation: " + reservation.getReservationId());
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}

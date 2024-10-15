package com.solvd.laba;

import com.solvd.laba.DAO.MovieDao;
import com.solvd.laba.persistence.ConnectionFactory;
import com.solvd.laba.persistence.impl.MovieDaoImpl;
import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.persistence.impl.MySqlConnectionFactory;
import com.solvd.laba.persistence.impl.TheatreDaoImpl;
import com.solvd.laba.records.Movie;
import com.solvd.laba.services.MovieService;
import com.solvd.laba.services.MovieServiceImpl;
import com.solvd.laba.services.TheatreServiceImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new MySqlConnectionFactory();

        MovieDaoImpl movieDao = new MovieDaoImpl(connectionFactory);
        TheatreDaoImpl theatreDao = new TheatreDaoImpl(connectionFactory);

        MovieServiceImpl movieService = new MovieServiceImpl(movieDao);
        TheatreServiceImpl theatreService = new TheatreServiceImpl(theatreDao);

        try {
            Movie movie = movieService.findById(1);
            System.out.println("Found movie: " + movie.getTitle());

            List<Movie> actionMovies = movieService.findByGenre("Action");
            System.out.println("Found " + actionMovies.size() + " action movies");

            Movie newMovie = new Movie("New Movie", 202, "Action", Date.valueOf(LocalDate.now()));
            movieService.save(newMovie);
            System.out.println("Saved new movie with ID: " + newMovie.getMovieId());
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}

package com.solvd.laba;

import com.solvd.laba.DAO.MovieDao;
import com.solvd.laba.DAO.MovieDaoImpl;
import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.records.Movie;
import com.solvd.laba.services.MovieService;
import com.solvd.laba.services.MovieServiceImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
        } catch (ClassNotFoundException e) {
            System.out.println("Error in loading the driver... " + e.getMessage());
            System.exit(1);
        }

        MovieDao movieDao = new MovieDaoImpl();
        MovieService movieService = new MovieServiceImpl(movieDao);

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

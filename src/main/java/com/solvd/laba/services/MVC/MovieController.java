package com.solvd.laba.services.MVC;

import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.models.Movie;

import java.util.List;

public class MovieController {
    private MovieModel model;
    private MovieView view;

    public MovieController(MovieModel model, MovieView view) {
        this.model = model;
        this.view = view;
    }

    public void displayMovies() {
        try {
            List<Movie> movies = model.getAllMovies();
            view.displayMovies(movies);
        } catch (ServiceException e) {
            view.displayError("Error loading movies: " + e.getMessage());
        }
    }
}

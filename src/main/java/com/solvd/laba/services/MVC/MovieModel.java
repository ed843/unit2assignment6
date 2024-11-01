package com.solvd.laba.services.MVC;

import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.models.Movie;
import com.solvd.laba.services.interfaces.MovieService.MovieService;

import java.util.List;

public class MovieModel {
    private MovieService movieService;

    public MovieModel(MovieService movieService) {
        this.movieService = movieService;
    }

    public List<Movie> getAllMovies() throws ServiceException {
        return movieService.findAll();
    }
}
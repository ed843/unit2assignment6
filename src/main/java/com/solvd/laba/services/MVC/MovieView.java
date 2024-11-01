package com.solvd.laba.services.MVC;

import com.solvd.laba.models.Movie;

import java.util.List;

// View
public class MovieView {
    public void displayMovies(List<Movie> movies) {
        movies.forEach(System.out::println);
    }

    public void displayError(String message) {
        System.err.println(message);
    }
}
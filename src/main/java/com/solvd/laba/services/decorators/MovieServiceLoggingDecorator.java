package com.solvd.laba.services.decorators;

import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.models.Movie;
import com.solvd.laba.services.interfaces.MovieService.MovieService;

import java.util.List;

public class MovieServiceLoggingDecorator extends AbstractLoggingDecorator implements MovieService {
    private final MovieService movieService;

    public MovieServiceLoggingDecorator(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public Movie findById(Integer id) throws ServiceException {
        String methodName = "findById";
        logMethodEntry(methodName, id);
        try {
            Movie result = movieService.findById(id);
            logMethodExit(methodName, result);
            return result;
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }

    @Override
    public List<Movie> findAll() throws ServiceException {
        String methodName = "findAll";
        logMethodEntry(methodName);
        try {
            List<Movie> result = movieService.findAll();
            logMethodExit(methodName, result);
            return result;
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }

    @Override
    public void save(Movie movie) throws ServiceException {
        String methodName = "save";
        logMethodEntry(methodName, movie);
        try {
            movieService.save(movie);
            logMethodExit(methodName, "Movie saved successfully");
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }

    @Override
    public void update(Movie movie) throws ServiceException {
        String methodName = "update";
        logMethodEntry(methodName, movie);
        try {
            movieService.update(movie);
            logMethodExit(methodName, "Movie updated successfully");
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }

    @Override
    public void delete(Movie movie) throws ServiceException {
        String methodName = "delete";
        logMethodEntry(methodName, movie);
        try {
            movieService.delete(movie);
            logMethodExit(methodName, "Movie deleted successfully");
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }

    @Override
    public List<Movie> findByGenre(String genre) throws ServiceException {
        String methodName = "findByGenre";
        logMethodEntry(methodName, genre);
        try {
            List<Movie> result = movieService.findByGenre(genre);
            logMethodExit(methodName, result);
            return result;
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }
}
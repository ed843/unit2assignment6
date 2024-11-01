package com.solvd.laba.services.interfaces.MovieService;

import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.models.Movie;

public interface MovieWriter {
    void save(Movie movie) throws ServiceException;
    void update(Movie movie) throws ServiceException;
    void delete(Movie movie) throws ServiceException;
}
package com.solvd.laba.services.interfaces.MovieService;

import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.models.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieReader {
    Movie findById(Integer id) throws ServiceException;
    List<Movie> findAll() throws ServiceException;
    List<Movie> findByGenre(String genre) throws ServiceException;
}

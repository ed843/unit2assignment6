package com.solvd.laba.services;

import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.generics.GenericService;
import com.solvd.laba.records.Movie;

import java.util.List;

public interface MovieService extends GenericService<Movie, Integer> {
    List<Movie> findByGenre(String genre) throws ServiceException;
}

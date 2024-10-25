package com.solvd.laba.services.interfaces;

import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.generics.GenericService;
import com.solvd.laba.models.Movie;

import java.util.List;

public interface MovieService extends GenericService<Movie, Integer> {
    List<Movie> findByGenre(String genre) throws ServiceException;
}

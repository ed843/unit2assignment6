package com.solvd.laba.services.proxies;

import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.models.Movie;
import com.solvd.laba.services.interfaces.MovieService.MovieService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CachingMovieServiceProxy implements MovieService {
    private MovieService movieService;
    private Map<Integer, Movie> cache = new HashMap<>();

    public CachingMovieServiceProxy(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public Movie findById(Integer id) throws ServiceException {
        if (cache.containsKey(id)) {
            return cache.get(id);
        }
        Movie movie = movieService.findById(id);
        cache.put(id, movie);
        return movie;
    }

    // The rest of the services run normally
    @Override
    public List<Movie> findAll() throws ServiceException {
        return movieService.findAll();
    }

    @Override
    public void save(Movie entity) throws ServiceException {
        movieService.save(entity);
    }

    @Override
    public void update(Movie entity) throws ServiceException {
        movieService.update(entity);
    }

    @Override
    public void delete(Movie entity) throws ServiceException {
        movieService.delete(entity);
    }

    @Override
    public List<Movie> findByGenre(String genre) throws ServiceException {
        return movieService.findByGenre(genre);
    }
}

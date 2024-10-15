package com.solvd.laba.services;

import com.solvd.laba.DAO.MovieDao;
import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.records.Movie;

import java.sql.SQLException;
import java.util.List;

public class MovieServiceImpl extends AbstractService<Movie, Integer> implements MovieService {

    private final MovieDao movieDao;

    public MovieServiceImpl(MovieDao movieDao) {
        super(movieDao);
        this.movieDao = movieDao;
    }

    @Override
    public Movie findById(Integer id) throws ServiceException {
        try {
            return movieDao.findById(id);
        } catch (SQLException e) {
            throw new ServiceException("Error finding movie by ID", e);
        }
    }

    @Override
    public List<Movie> findAll() throws ServiceException {
        try {
            return movieDao.findAll();
        } catch (SQLException e) {
            throw new ServiceException("Error finding all movies", e);
        }
    }

    @Override
    public void save(Movie movie) throws ServiceException {
        try {
            movieDao.save(movie);
        } catch (SQLException e) {
            throw new ServiceException("Error saving movie", e);
        }
    }

    @Override
    public void update(Movie movie) throws ServiceException {
        try {
            movieDao.update(movie);
        } catch (SQLException e) {
            throw new ServiceException("Error updating movie", e);
        }
    }

    @Override
    public void delete(Movie movie) throws ServiceException {
        try {
            movieDao.delete(movie);
        } catch (SQLException e) {
            throw new ServiceException("Error deleting movie", e);
        }
    }

    @Override
    public List<Movie> findByGenre(String genre) throws ServiceException {
        try {
            return movieDao.findByGenre(genre);
        } catch (SQLException e) {
            throw new ServiceException("Error finding movies by genre", e);
        }
    }
}
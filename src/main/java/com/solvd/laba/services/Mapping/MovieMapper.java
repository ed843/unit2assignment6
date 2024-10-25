package com.solvd.laba.services;

import com.solvd.laba.models.Movie;

import java.util.List;

public interface MovieMapper {
    Movie findById(Integer id);
    List<Movie> findAll();
    void insert(Movie movie);
    void update(Movie movie);
    void delete(Movie movie);
    List<Movie> findByGenre(String genre);
}

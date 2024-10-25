package com.solvd.laba.DAO;

import com.solvd.laba.generics.GenericDao;
import com.solvd.laba.models.Movie;

import java.sql.SQLException;
import java.util.List;

public interface MovieDao extends GenericDao<Movie, Integer> {
    List<Movie> findByGenre(String genre) throws SQLException;
}


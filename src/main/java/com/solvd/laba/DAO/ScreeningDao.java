package com.solvd.laba.DAO;

import com.solvd.laba.generics.GenericDao;
import com.solvd.laba.models.Screening;

import java.sql.SQLException;
import java.util.List;

public interface ScreeningDao extends GenericDao<Screening, Integer> {
    List<Screening> findByMovieId(Integer movieId) throws SQLException;
}
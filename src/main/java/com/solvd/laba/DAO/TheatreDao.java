package com.solvd.laba.DAO;

import com.solvd.laba.generics.GenericDao;
import com.solvd.laba.records.Theatre;

import java.sql.SQLException;
import java.util.List;

public interface TheatreDao extends GenericDao<Theatre, Integer> {
    List<Theatre> findByLocation(String location) throws SQLException;
}

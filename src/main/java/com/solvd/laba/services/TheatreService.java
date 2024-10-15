package com.solvd.laba.services;

import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.records.Theatre;

import java.sql.SQLException;
import java.util.List;

public interface TheatreService {
    List<Theatre> findByLocation(String location) throws ServiceException;
}

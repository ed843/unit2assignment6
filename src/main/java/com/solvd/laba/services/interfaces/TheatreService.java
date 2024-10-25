package com.solvd.laba.services.interfaces;

import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.generics.GenericService;
import com.solvd.laba.models.Theatre;

import java.util.List;

public interface TheatreService extends GenericService<Theatre, Integer> {
    List<Theatre> findByLocation(String location) throws ServiceException;
}

package com.solvd.laba.services;

import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.generics.GenericService;
import com.solvd.laba.models.Screening;

import java.util.List;

public interface ScreeningService extends GenericService<Screening, Integer> {
    List<Screening> findByMovieId(Integer id) throws ServiceException;
}

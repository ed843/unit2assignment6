package com.solvd.laba.services.interfaces.ReservationService;

import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.models.Movie;
import com.solvd.laba.models.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationReader {
    Reservation findById(Integer id) throws ServiceException;
    List<Reservation> findAll() throws ServiceException;
    Reservation findByStatus(String status) throws ServiceException;
}

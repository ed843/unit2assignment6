package com.solvd.laba.services.interfaces;

import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.generics.GenericService;
import com.solvd.laba.models.Reservation;

public interface ReservationService extends GenericService<Reservation, Integer> {
    Reservation findByStatus(String status) throws ServiceException;
}

package com.solvd.laba.services.interfaces.ReservationService;

import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.models.Reservation;

public interface ReservationWriter {
    void save(Reservation reservation) throws ServiceException;
    void update(Reservation reservation) throws ServiceException;
    void delete(Reservation reservation) throws ServiceException;
}

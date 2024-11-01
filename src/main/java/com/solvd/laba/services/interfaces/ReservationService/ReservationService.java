package com.solvd.laba.services.interfaces.ReservationService;

import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.models.Reservation;
import com.solvd.laba.services.listener.ReservationListener;

public interface ReservationService extends ReservationReader, ReservationWriter {

    void addListener(ReservationListener listener);
}

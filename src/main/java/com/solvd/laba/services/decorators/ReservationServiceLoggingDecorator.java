package com.solvd.laba.services.decorators;

import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.models.Reservation;
import com.solvd.laba.services.interfaces.ReservationService.ReservationService;
import com.solvd.laba.services.listener.ReservationListener;

import java.util.List;

public class ReservationServiceLoggingDecorator extends AbstractLoggingDecorator implements ReservationService {
    private final ReservationService reservationService;

    public ReservationServiceLoggingDecorator(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Override
    public Reservation findByStatus(String status) throws ServiceException {
        String methodName = "findByUser";
        logMethodEntry(methodName, status);
        try {
            Reservation result = reservationService.findByStatus(status);
            logMethodExit(methodName, result);
            return result;
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }

    @Override
    public void addListener(ReservationListener listener) {
        String methodName = "addListener";
        logMethodEntry(methodName, listener);
        try {
            reservationService.addListener(listener);
            logMethodExit(methodName, listener);
        } catch (Exception e) {
            logException(methodName, e);
            throw e;
        }

    }

    @Override
    public Reservation findById(Integer integer) throws ServiceException {
        String methodName = "findById";
        logMethodEntry(methodName, integer);
        try {
            Reservation result = reservationService.findById(integer);
            logMethodExit(methodName, result);
            return result;
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }

    @Override
    public List<Reservation> findAll() throws ServiceException {
        String methodName = "findAll";
        logMethodEntry(methodName);
        try {
            List<Reservation> result = reservationService.findAll();
            logMethodExit(methodName, result);
            return result;
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }

    @Override
    public void save(Reservation entity) throws ServiceException {
        String methodName = "save";
        logMethodEntry(methodName, entity);
        try {
            reservationService.save(entity);
            logMethodExit(methodName, entity);
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }

    @Override
    public void update(Reservation entity) throws ServiceException {
        String methodName = "update";
        logMethodEntry(methodName, entity);
        try {
            reservationService.update(entity);
            logMethodExit(methodName, entity);
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }

    @Override
    public void delete(Reservation entity) throws ServiceException {
        String methodName = "delete";
        logMethodEntry(methodName, entity);
        try {
            reservationService.delete(entity);
            logMethodExit(methodName, entity);
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }
}

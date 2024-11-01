package com.solvd.laba.services.decorators;

import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.models.Screening;
import com.solvd.laba.services.interfaces.ScreeningService;

import java.util.List;

public class ScreeningServiceLoggingDecorator extends AbstractLoggingDecorator implements ScreeningService {
    private final ScreeningService screeningService;

    public ScreeningServiceLoggingDecorator(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }

    @Override
    public List<Screening> findByMovieId(Integer movieId) throws ServiceException {
        String methodName = "findByMovieId";
        logMethodEntry(methodName, movieId);
        try {
            List<Screening> result = screeningService.findByMovieId(movieId);
            logMethodExit(methodName, result);
            return result;
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }

    @Override
    public Screening findById(Integer integer) throws ServiceException {
        String methodName = "findById";
        logMethodEntry(methodName, integer);
        try {
            Screening result = screeningService.findById(integer);
            logMethodExit(methodName, result);
            return result;
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }

    @Override
    public List<Screening> findAll() throws ServiceException {
        String methodName = "findAll";
        logMethodEntry(methodName);
        try {
            List<Screening> result = screeningService.findAll();
            logMethodExit(methodName, result);
            return result;
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }

    @Override
    public void save(Screening entity) throws ServiceException {
        String methodName = "save";
        logMethodEntry(methodName, entity);
        try {
            screeningService.save(entity);
            logMethodExit(methodName, entity);
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }

    @Override
    public void update(Screening entity) throws ServiceException {
        String methodName = "update";
        logMethodEntry(methodName, entity);
        try {
            screeningService.update(entity);
            logMethodExit(methodName, entity);
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }

    @Override
    public void delete(Screening entity) throws ServiceException {
        String methodName = "delete";
        logMethodEntry(methodName, entity);
        try {
            screeningService.delete(entity);
            logMethodExit(methodName, entity);
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }
}
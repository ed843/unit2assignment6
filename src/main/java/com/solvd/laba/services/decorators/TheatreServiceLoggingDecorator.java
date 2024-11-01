package com.solvd.laba.services.decorators;

import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.models.Theatre;
import com.solvd.laba.services.interfaces.TheatreService;

import java.util.List;

public class TheatreServiceLoggingDecorator extends AbstractLoggingDecorator implements TheatreService {
    private final TheatreService theatreService;

    public TheatreServiceLoggingDecorator(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @Override
    public Theatre findById(Integer id) throws ServiceException {
        String methodName = "findById";
        logMethodEntry(methodName, id);
        try {
            Theatre result = theatreService.findById(id);
            logMethodExit(methodName, result);
            return result;
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }

    @Override
    public List<Theatre> findAll() throws ServiceException {
        String methodName = "findAll";
        logMethodEntry(methodName);
        try {
            List<Theatre> result = theatreService.findAll();
            logMethodExit(methodName, result);
            return result;
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }

    @Override
    public void save(Theatre entity) throws ServiceException {
        String methodName = "save";
        logMethodEntry(methodName, entity);
        try {
            theatreService.save(entity);
            logMethodExit(methodName, entity);
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }

    @Override
    public void update(Theatre entity) throws ServiceException {
        String methodName = "update";
        logMethodEntry(methodName, entity);
        try {
            theatreService.update(entity);
            logMethodExit(methodName, entity);
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }

    @Override
    public void delete(Theatre entity) throws ServiceException {
        String methodName = "delete";
        logMethodEntry(methodName, entity);
        try {
            theatreService.delete(entity);
            logMethodExit(methodName, entity);
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }

    @Override
    public List<Theatre> findByLocation(String location) throws ServiceException {
        String methodName = "findByLocation";
        logMethodEntry(methodName, location);
        try {
            List<Theatre> result = theatreService.findByLocation(location);
            logMethodExit(methodName, result);
            return result;
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }
}
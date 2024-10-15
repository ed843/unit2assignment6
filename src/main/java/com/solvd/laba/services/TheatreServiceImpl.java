package com.solvd.laba.services;

import com.solvd.laba.DAO.TheatreDao;
import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.records.Theatre;

import java.sql.SQLException;
import java.util.List;

public class TheatreServiceImpl extends AbstractService<Theatre, Integer> implements TheatreService {

    private final TheatreDao theatreDao;

    public TheatreServiceImpl(TheatreDao theatreDao) {
        super(theatreDao);
        this.theatreDao = theatreDao;
    }

    @Override
    public Theatre findById(Integer id) throws ServiceException {
        try {
            return theatreDao.findById(id);
        } catch (SQLException e) {
            throw new ServiceException("Error finding theatre by ID", e);
        }
    }

    @Override
    public List<Theatre> findAll() throws ServiceException {
        try {
            return theatreDao.findAll();
        } catch (SQLException e) {
            throw new ServiceException("Error finding all theatres", e);
        }
    }

    @Override
    public void save(Theatre theatre) throws ServiceException {
        try {
            theatreDao.save(theatre);
        } catch (SQLException e) {
            throw new ServiceException("Error saving theatre", e);
        }
    }

    @Override
    public void update(Theatre theatre) throws ServiceException {
        try {
            theatreDao.update(theatre);
        } catch (SQLException e) {
            throw new ServiceException("Error updating theatre", e);
        }
    }

    @Override
    public void delete(Theatre theatre) throws ServiceException {
        try {
            theatreDao.delete(theatre);
        } catch (SQLException e) {
            throw new ServiceException("Error deleting theatre", e);
        }
    }

    @Override
    public List<Theatre> findByLocation(String location) throws ServiceException {
        try {
            return theatreDao.findByLocation(location);
        } catch (SQLException e) {
            throw new ServiceException("Error finding theatres by location", e);
        }
    }
}
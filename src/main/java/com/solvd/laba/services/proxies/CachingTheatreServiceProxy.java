package com.solvd.laba.services.proxies;

import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.models.Theatre;
import com.solvd.laba.services.interfaces.TheatreService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CachingTheatreServiceProxy implements TheatreService {
    private TheatreService theatreService;
    private Map<Integer, Theatre> cache = new HashMap<>();

    public CachingTheatreServiceProxy(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @Override
    public List<Theatre> findByLocation(String location) throws ServiceException {
        return theatreService.findByLocation(location);
    }

    @Override
    public Theatre findById(Integer id) throws ServiceException {
        if (cache.containsKey(id)) {
            return cache.get(id);
        }
        Theatre theatre = theatreService.findById(id);
        cache.put(id, theatre);
        return theatre;
    }

    @Override
    public List<Theatre> findAll() throws ServiceException {
        return theatreService.findAll();
    }

    @Override
    public void save(Theatre theatre) throws ServiceException {
        theatreService.save(theatre);
    }

    @Override
    public void update(Theatre theatre) throws ServiceException {
        theatreService.update(theatre);
    }

    @Override
    public void delete(Theatre theatre) throws ServiceException {
        theatreService.delete(theatre);
    }
}

package com.solvd.laba.services;

import com.solvd.laba.generics.GenericDao;
import com.solvd.laba.generics.GenericService;

public abstract class AbstractService<T, ID> implements GenericService<T, ID> {
    protected GenericDao<T, ID> dao;

    public AbstractService(GenericDao<T, ID> dao) {
        this.dao = dao;
    }

    // Implement common methods, wrapping DAO calls in try-catch blocks
    // and throwing ServiceException
}

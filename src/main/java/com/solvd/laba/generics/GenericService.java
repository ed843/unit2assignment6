package com.solvd.laba.generics;

import com.solvd.laba.exceptions.ServiceException;

import java.util.List;

public interface GenericService<T, ID> {
    T findById(ID id) throws ServiceException;
    List<T> findAll() throws ServiceException;
    void save(T entity) throws ServiceException;
    void update(T entity) throws ServiceException;
    void delete(T entity) throws ServiceException;
}


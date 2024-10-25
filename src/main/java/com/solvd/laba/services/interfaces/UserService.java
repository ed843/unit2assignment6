package com.solvd.laba.services;

import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.generics.GenericService;
import com.solvd.laba.models.User;

public interface UserService extends GenericService<User, Integer> {
    User findByUsername(String username) throws ServiceException;
}

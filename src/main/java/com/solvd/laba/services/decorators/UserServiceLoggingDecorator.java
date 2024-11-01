package com.solvd.laba.services.decorators;

import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.models.User;
import com.solvd.laba.services.interfaces.UserService;

import java.util.List;

public class UserServiceLoggingDecorator extends AbstractLoggingDecorator implements UserService {
    private final UserService userService;

    public UserServiceLoggingDecorator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User findByUsername(String username) throws ServiceException {
        String methodName = "findByUsername";
        logMethodEntry(methodName, username);
        try {
            User result = userService.findByUsername(username);
            logMethodExit(methodName, result);
            return result;
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }

    @Override
    public User findById(Integer integer) throws ServiceException {
        String methodName = "findById";
        logMethodEntry(methodName, integer);
        try {
            User result = userService.findById(integer);
            logMethodExit(methodName, result);
            return result;
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }

    @Override
    public List<User> findAll() throws ServiceException {
        String methodName = "findAll";
        logMethodEntry(methodName);
        try {
            List<User> result = userService.findAll();
            logMethodExit(methodName, result);
            return result;
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }

    @Override
    public void save(User entity) throws ServiceException {
        String methodName = "save";
        logMethodEntry(methodName, entity);
        try {
            userService.save(entity);
            logMethodExit(methodName, entity);
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }

    @Override
    public void update(User entity) throws ServiceException {
        String methodName = "update";
        logMethodEntry(methodName, entity);
        try {
            userService.update(entity);
            logMethodExit(methodName, entity);
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }

    @Override
    public void delete(User entity) throws ServiceException {
        String methodName = "delete";
        logMethodEntry(methodName, entity);
        try {
            userService.delete(entity);
            logMethodExit(methodName, entity);
        } catch (ServiceException e) {
            logException(methodName, e);
            throw e;
        }
    }
}
package com.solvd.laba.services.Mapping;

import com.solvd.laba.models.User;

import java.util.List;

public interface UserMapper {
    User findById(Integer id);
    List<User> findAll();
    void insert(User user);
    void update(User user);
    void delete(User user);
    User findByUsername(String username);
}

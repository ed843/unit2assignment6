package com.solvd.laba.DAO;

import com.solvd.laba.generics.GenericDao;
import com.solvd.laba.models.User;

import java.sql.SQLException;

public interface UserDao extends GenericDao<User, Integer> {
    User findByUsername(String username) throws SQLException;
}

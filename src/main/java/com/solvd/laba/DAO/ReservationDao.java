package com.solvd.laba.DAO;

import com.solvd.laba.generics.GenericDao;
import com.solvd.laba.models.Reservation;

import java.sql.SQLException;
import java.util.List;

public interface ReservationDao extends GenericDao<Reservation, Integer> {
    Reservation findByStatus(String status) throws SQLException;
}

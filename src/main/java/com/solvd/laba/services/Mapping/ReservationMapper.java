package com.solvd.laba.services.Mapping;

import com.solvd.laba.models.Reservation;

import java.util.List;

public interface ReservationMapper {
    Reservation findById(Integer id);
    List<Reservation> findAll();
    void insert(Reservation reservation);
    void update(Reservation reservation);
    void delete(Reservation reservation);
    Reservation findByStatus(String status);
}

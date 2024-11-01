package com.solvd.laba.services.listener;

import com.solvd.laba.models.Reservation;

public interface ReservationListener {
    void onReservationCreated(Reservation reservation);
    void onReservationCancelled(Reservation reservation);
}

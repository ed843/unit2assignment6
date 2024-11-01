package com.solvd.laba.services.listener;

import com.solvd.laba.models.Reservation;

public class EmailNotificationListener implements ReservationListener {
    @Override
    public void onReservationCreated(Reservation reservation) {
        // Send confirmation email
    }

    @Override
    public void onReservationCancelled(Reservation reservation) {
        // Send cancellation email
    }
}
package com.solvd.laba.models.builders;

import com.solvd.laba.models.Reservation;
import com.solvd.laba.models.Screening;
import com.solvd.laba.models.Seat;
import com.solvd.laba.models.User;

import java.sql.Timestamp;

public class ReservationBuilder {
    private int reservationId;
    private User user;
    private Screening screening;
    private Seat seat;
    private Timestamp reservedAt;
    private String status;

    public ReservationBuilder setUser(User user) {
        this.user = user;
        return this;
    }

    public ReservationBuilder setScreening(Screening screening) {
        this.screening = screening;
        return this;
    }

    public ReservationBuilder setSeat(Seat seat) {
        this.seat = seat;
        return this;
    }

    public ReservationBuilder setReservedAt(Timestamp reservedAt) {
        this.reservedAt = reservedAt;
        return this;
    }

    public ReservationBuilder setStatus(String status) {
        this.status = status;
        return this;
    }

    public Reservation build() {
        // Validate and create reservation
        return new Reservation(reservationId, user.getUserId(),
                screening.getScreeningId(), seat.getSeatId(), reservedAt, status);
    }
}
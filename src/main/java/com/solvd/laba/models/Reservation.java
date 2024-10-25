package com.solvd.laba.models;

import java.sql.Date;
import java.sql.Timestamp;

public class Reservation {
    Integer reservationId;
    Integer userId;
    Integer screeningId;
    Integer seatId;
    Timestamp reservedAt;
    String status;

    public Reservation(int reservationId, Integer userId, Integer screeningId, Integer seatId, Timestamp reservedAt, String status) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.screeningId = screeningId;
        this.seatId = seatId;
        this.reservedAt = reservedAt;
        this.status = status;
    }

    public int getReservationId() {
        return reservationId;
    }
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getScreeningId() {
        return screeningId;
    }
    public void setScreeningId(int screeningId) {
        this.screeningId = screeningId;
    }
    public int getSeatId() {
        return seatId;
    }
    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }
    public Timestamp getReservedAt() {
        return reservedAt;
    }
    public void setReservedAt(Timestamp reservedAt) {
        this.reservedAt = reservedAt;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}

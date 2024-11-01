package com.solvd.laba.models;

public class Seat {
    private int seatId;
    private int rowNum;
    private int seatNumber;
    private int theatreId;

    public Seat(int seatId, int rowNum, int seatNumber, int theatreId) {
        this.seatId = seatId;
        this.rowNum = rowNum;
        this.seatNumber = seatNumber;
        this.theatreId = theatreId;
    }
    public int getSeatId() {
        return seatId;
    }
    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }
    public int getRowNum() {
        return rowNum;
    }
    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }
    public int getSeatNumber() {
        return seatNumber;
    }
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
    public int getTheatreId() {
        return theatreId;
    }
    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }
}

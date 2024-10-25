package com.solvd.laba.models;

import java.sql.Timestamp;

public class Screening {
    private int screeningId;
    private Timestamp screeningTime;
    private Integer movieId;
    private Integer theatreId;
    private double price;

    Screening(int screeningId, Timestamp screeningTime, Integer movieId, Integer theatreId, double price) {
        this.screeningId = screeningId;
        this.screeningTime = screeningTime;
        this.movieId = movieId;
        this.theatreId = theatreId;
        this.price = price;
    }

    public int getScreeningId() {
        return screeningId;
    }
    public void setScreeningId(int screeningId) {
        this.screeningId = screeningId;
    }
    public Timestamp getScreeningTime() {
        return screeningTime;
    }
    public void setScreeningTime(Timestamp screeningTime) {
        this.screeningTime = screeningTime;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }
    public Integer getTheatreId() {
        return theatreId;
    }
    public void setTheaterId(Integer theatreId) {
        this.theatreId = theatreId;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}

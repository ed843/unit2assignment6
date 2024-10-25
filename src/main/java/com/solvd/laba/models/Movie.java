package com.solvd.laba.models;

import java.sql.*;

public class Movie {
    private int movieId;
    private String title;
    private int duration;
    private String genre;
    private Date releaseDate;

    // Constructor
    public Movie(String title, int duration, String genre, Date releaseDate) {
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public Movie() {

    }

    // Getters
    public int getMovieId() {
        return movieId;
    }
    public String getTitle() {
        return title;
    }
    public int getDuration() {
        return duration;
    }
    public String getGenre() {
        return genre;
    }
    public Date getReleaseDate() {
        return releaseDate;
    }

    // Setters
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}






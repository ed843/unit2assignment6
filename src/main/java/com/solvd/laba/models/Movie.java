package com.solvd.laba.models;

import java.sql.Timestamp;

public class Movie {
    private int movieId;
    private String title;
    private int duration;
    private String genre;
    private Timestamp releaseDate;

    // Constructor
    public Movie(String title, int duration, String genre, Timestamp releaseDate) {
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
    public Timestamp getReleaseDate() {
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
    public void setReleaseDate(Timestamp releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "{movieId=" + movieId + ", title=" + title + ", duration=" + duration + ", genre=" + genre + ", releaseDate=" + releaseDate + "}";
    }
}






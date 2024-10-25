package com.solvd.laba.models;

public class Theatre {
    private int theatreId;
    private String theatre_name;
    private String location;
    private int capacity;

    // Constructor
    public Theatre(String theatre_name, String location, int capacity) {
        this.theatre_name = theatre_name;
        this.location = location;
        this.capacity = capacity;
    }

    public Theatre() {}

    // Getters
    public int getTheatreId() {
        return theatreId;
    }
    public String getTheatreName() {
        return theatre_name;
    }
    public String getLocation() {
        return location;
    }
    public int getCapacity() {
        return capacity;
    }

    // Setters
    public void setTheatreId(int theatre_id) {
        this.theatreId = theatre_id;
    }
    public void setTheatreName(String theatre_name) {
        this.theatre_name = theatre_name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

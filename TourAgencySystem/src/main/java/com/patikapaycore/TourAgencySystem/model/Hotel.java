package com.patikapaycore.TourAgencySystem.model;

public class Hotel {
    private String name;

    public Hotel(String name) {
        this.name = name;
    }

    public Hotel(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

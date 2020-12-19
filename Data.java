package com.andrey;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Data {
    private String movieName;
    private String genres;
    private Date premierData;
    private int duration;
    private double boxOfficeFees;
    DateFormat format = new SimpleDateFormat("dd.mm.yyyy");

    public Data(String movieName, String genres, Date premierData, int duration, int boxOfficeFees) {
        this.movieName = movieName;
        this.genres = genres;
        this.premierData = premierData;
        this.duration = duration;
        this.boxOfficeFees = boxOfficeFees;
    }

    public Data(String[] params) throws Exception{
        this.movieName = params[0];
        this.genres = params[1];
        this.premierData = format.parse(params[2]);
        this.duration =  Integer.parseInt(params[3]);
        this.boxOfficeFees = Double.parseDouble(params[4]);
    }

    @Override
    public String toString() {
        return movieName
                + " " + genres
                + " " + premierData
                + " " + duration
                + " minutes";
    }

    public String getMovieName() {
        return movieName;
    }

    public Date getPremierData() {
        return premierData;
    }

    public int getDuration() {
        return duration;
    }

    public double getBoxOfficeFees() {
        return boxOfficeFees;
    }

    public String getGenres() {
        return genres;
    }
}

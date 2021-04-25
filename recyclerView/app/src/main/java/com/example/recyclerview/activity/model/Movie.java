package com.example.recyclerview.activity.model;

public class Movie {
    private String title;
    private String year;
    private String gender;

    public Movie(){

    }

    public Movie(String title, String year, String gender) {
        this.title = title;
        this.year = year;
        this.gender = gender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

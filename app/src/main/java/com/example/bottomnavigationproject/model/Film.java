package com.example.bottomnavigationproject.model;

import java.util.List;

public class Film {
    public String id;
    public String title;
    public String description;
    public String director;
    public String producer;
    public String release_date;
    public String rt_score;
    public List<String> people;
    public List<String> species;
    public List<String> locations;
    public List<String> vehicles;
    public String url;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public String getRelease_date() {
        return release_date;
    }
    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getProducer() {
        return producer;
    }
    public void setProducer(String producer) {
        this.producer = producer;
    }
    public String getRt_score() {
        return rt_score;
    }
    public void setRt_score(String rt_score) {
        this.rt_score = rt_score;
    }
}

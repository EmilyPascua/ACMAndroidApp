package com.example.kylo.acm_app.model;

import java.util.Date;

public class Announcement {
    private String title;
    private String author;
    private String message;
    private String image;
    private String date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Announcement(String title, String author, String message, String image, String date){
        this.title = title;
        this.author = author;
        this.message = message;
        this.image = image;
        this.date = date;
    }

}

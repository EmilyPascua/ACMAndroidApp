package com.example.kylo.acm_app.model;

import java.util.Date;

public class Announcement {
    private String title;
    private String author;
    private String message;
    private String image;
    private Date date;

    public Announcement(String title, String author, String message, String image, Date date){
        this.title = title;
        this.author = author;
        this.message = message;
        this.image = image;
        this.date = date;
    }

}

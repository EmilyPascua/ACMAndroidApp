package com.example.kylo.acm_app.model;

import com.google.gson.annotations.SerializedName;

public class Hackathon {

    private int userId;

    private int id;

    private String title;

    @SerializedName("body")
    private String text;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

//    private String name;
//    private String logoUrl;
//    private String hackUrl;
//    private String date;
//
//    public Hackathon(String name, String logoUrl, String hackUrl, String date){
//        this.name = name;
//        this.logoUrl = logoUrl;
//        this.hackUrl = hackUrl;
//        this.date = date;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getLogoUrl() {
//        return logoUrl;
//    }
//
//    public void setLogoUrl(String logoUrl) {
//        this.logoUrl = logoUrl;
//    }
//
//    public String getHackUrl() {
//        return hackUrl;
//    }
//
//    public void setHackUrl(String hackUrl) {
//        this.hackUrl = hackUrl;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }

}


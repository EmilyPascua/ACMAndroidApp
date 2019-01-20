package com.example.kylo.acm_app.model.mlh;

public class Event {
    private String name;
    private String url;
    private String startDate;
    private String endDate;
    private String location;
    private boolean isHighSchool;
    private String imageUrl;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getLocation() {
        return location;
    }

    public Event(String name, String url, String startDate, String endDate, String location, boolean isHighSchool, String imageUrl) {
        this.name = name;
        this.url = url;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.isHighSchool = isHighSchool;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {

        return imageUrl;
    }

}

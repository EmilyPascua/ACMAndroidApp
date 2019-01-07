package com.example.kylo.acm_app.model.eventbrite;

public class Events {
    public Name getName() {
        return name;
    }

    public Description getDescription() {
        return description;
    }

    public Start getStart() {
        return start;
    }

    public End getEnd() {
        return end;
    }

    public String getCreated() {
        return created;
    }

    private Name name;
    private Description description;
    private  Start start;
    private End end;
    private String created;


}

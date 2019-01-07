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

    Name name;
    Description description;
    Start start;
    End end;
    String created;


}

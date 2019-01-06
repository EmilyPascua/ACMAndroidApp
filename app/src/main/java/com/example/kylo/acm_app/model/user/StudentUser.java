package com.example.kylo.acm_app.model.user;

public class StudentUser {
    private String firstName;
    private String lastName;

    //Needed for verification
    private String email;
    private String hashPassword;
    private String major;
    private String year;

    public StudentUser(String firstName, String lastName, String email, String hashPassword, String major, String year){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hashPassword = hashPassword;
        this.major = major;
        this.year = year;
    }
}

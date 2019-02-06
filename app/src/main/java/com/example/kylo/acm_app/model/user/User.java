package com.example.kylo.acm_app.model.user;

public class User {
    String username;
    String firstname;
    String lastname;
    String age;
    String position;
    String email;
    String admin;

    public User() {}

    public User(String username, String firstname, String lastname, String age, String position, String email, String admin) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.position = position;
        this.email = email;
        this.admin = admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
}

package org.launchcode.spaday.models;

public class User {
    //username, email, password usual format: class variables, constructors, methods
    //class variables
    private String username;
    private String email;
    private String password;

    //constructors
    //methods (getters and setters)

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
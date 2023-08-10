package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static java.util.Objects.isNull;

public class User {
    @NotBlank(message = "Username is required")
    @Size(min = 5, max = 15)
    private String username;
    @Email
    private String email;
    @NotBlank(message="Please enter password")
    @Size(min = 6, message = "Passwords must be at least 6 characters long.")
    private String password;
    @NotNull(message="Passwords must match")
    private String verifyPassword;


    public User() {

    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    private void checkPassword(){
        if ((!isNull(this.password) && !isNull(this.verifyPassword)) && !this.password.equals(this.verifyPassword)) {
            this.verifyPassword = null;
        }
    }
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

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }
}

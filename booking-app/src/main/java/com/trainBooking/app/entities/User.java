package com.trainBooking.app.entities;

import org.mindrot.jbcrypt.BCrypt;

import java.util.List;
public class User {
    public User() {}

    public User(String name,
                String password,
                String email) {
        this.name = name;
        this.email = email;
        this.hashedPassword = BCrypt.hashpw(password,BCrypt.gensalt());
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String userId;
    private String name;
    private String email;
    private String hashedPassword;

}

package com.mvolinger.cardapiosemanal.core.domain.models;

import java.util.UUID;

public class User {

    private UUID userId;
    private String email;
    private String password;
    private String name;
    private String lastname;
    private DietType dietType;

    public User() {}

    public User(UUID userId, String email, String password, String name, String lastname, DietType dietType) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.dietType = dietType;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public DietType getDietType() {
        return dietType;
    }

    public void setDietType(DietType dietType) {
        this.dietType = dietType;
    }
}
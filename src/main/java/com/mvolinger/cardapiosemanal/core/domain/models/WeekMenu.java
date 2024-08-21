package com.mvolinger.cardapiosemanal.core.domain.models;

import java.util.List;
import java.util.UUID;

public class WeekMenu {

    private UUID weekMenuId;
    private String description;
    private User user;
    private List<Meal> meals;

    public WeekMenu() {}

    public WeekMenu(UUID weekMenuId, String description, User user, List<Meal> meals) {
        this.weekMenuId = weekMenuId;
        this.description = description;
        this.user = user;
        this.meals = meals;
    }

    public UUID getWeekMenuId() {
        return weekMenuId;
    }

    public void setWeekMenuId(UUID weekMenuId) {
        this.weekMenuId = weekMenuId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }
}
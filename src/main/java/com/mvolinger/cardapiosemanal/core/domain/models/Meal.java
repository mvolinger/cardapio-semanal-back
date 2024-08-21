package com.mvolinger.cardapiosemanal.core.domain.models;

import java.util.List;
import java.util.UUID;

public class Meal {

    private UUID mealId;
    private String description;
    private User user;
    private MealType mealType;
    private List<Ingredient> ingredients;

    public Meal() {}

    public Meal(UUID mealId, String description, User user, MealType mealType, List<Ingredient> ingredients) {
        this.mealId = mealId;
        this.description = description;
        this.user = user;
        this.mealType = mealType;
        this.ingredients = ingredients;
    }

    public UUID getMealId() {
        return mealId;
    }

    public void setMealId(UUID mealId) {
        this.mealId = mealId;
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

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
package com.mvolinger.cardapiosemanal.core.domain.models;

import java.util.List;
import java.util.UUID;

public class Recipe {

    private UUID recipeId;
    private String title;
    private String description;
    private String category;
    private String preparation;
    private User user;
    private List<RecipeIngredient> ingredients;

    public Recipe() {}

    public Recipe(UUID recipeId, String title, String description, String category, String preparation, User user, List<RecipeIngredient> ingredients) {
        this.recipeId = recipeId;
        this.title = title;
        this.description = description;
        this.category = category;
        this.preparation = preparation;
        this.user = user;
        this.ingredients = ingredients;
    }

    public UUID getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(UUID recipeId) {
        this.recipeId = recipeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<RecipeIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<RecipeIngredient> ingredients) {
        this.ingredients = ingredients;
    }
}
package com.mvolinger.cardapiosemanal.core.domain.models;

import java.util.List;
import java.util.UUID;

public class GroceryList {

    private UUID groceryListId;
    private User user;
    private List<GroceryIngredient> ingredients;

    public GroceryList() {}

    public GroceryList(UUID groceryListId, User user, List<GroceryIngredient> ingredients) {
        this.groceryListId = groceryListId;
        this.user = user;
        this.ingredients = ingredients;
    }

    public UUID getGroceryListId() {
        return groceryListId;
    }

    public void setGroceryListId(UUID groceryListId) {
        this.groceryListId = groceryListId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<GroceryIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<GroceryIngredient> ingredients) {
        this.ingredients = ingredients;
    }
}
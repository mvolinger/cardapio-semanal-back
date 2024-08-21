package com.mvolinger.cardapiosemanal.core.domain.models;

public class GroceryIngredient {

    private GroceryList groceryList;
    private Ingredient ingredient;
    private String quantity;

    public GroceryIngredient() {}

    public GroceryIngredient(GroceryList groceryList, Ingredient ingredient, String quantity) {
        this.groceryList = groceryList;
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public GroceryList getGroceryList() {
        return groceryList;
    }

    public void setGroceryList(GroceryList groceryList) {
        this.groceryList = groceryList;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
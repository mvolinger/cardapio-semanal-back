package com.mvolinger.cardapiosemanal.core.domain.models;

import java.util.UUID;

public class Ingredient {

    private UUID ingredientId;
    private String description;
    private String name;
    private NutritionalTable nutritionalTable;
    private IngredientType ingredientType;
    private DietType dietType;
    private MealType mealType;

    public Ingredient() {}

    public Ingredient(UUID ingredientId, String description, String name, NutritionalTable nutritionalTable, IngredientType ingredientType, DietType dietType, MealType mealType) {
        this.ingredientId = ingredientId;
        this.description = description;
        this.name = name;
        this.nutritionalTable = nutritionalTable;
        this.ingredientType = ingredientType;
        this.dietType = dietType;
        this.mealType = mealType;
    }

    public UUID getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(UUID ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NutritionalTable getNutritionalTable() {
        return nutritionalTable;
    }

    public void setNutritionalTable(NutritionalTable nutritionalTable) {
        this.nutritionalTable = nutritionalTable;
    }

    public IngredientType getIngredientType() {
        return ingredientType;
    }

    public void setIngredientType(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    public DietType getDietType() {
        return dietType;
    }

    public void setDietType(DietType dietType) {
        this.dietType = dietType;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }
}
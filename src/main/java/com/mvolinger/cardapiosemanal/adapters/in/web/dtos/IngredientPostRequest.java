package com.mvolinger.cardapiosemanal.adapters.in.web.dtos;

import lombok.Data;

@Data
public class IngredientPostRequest {

    private String name;
    private String description;
    private NutritionalTableRequest nutritionalTable;
    private IngredientTypeRequest ingredientType;
    private DietTypeRequest dietType;
    private MealTypeRequest mealType;
}
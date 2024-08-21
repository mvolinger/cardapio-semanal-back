package com.mvolinger.cardapiosemanal.adapters.in.web.dtos;

import lombok.Data;

@Data
public class IngredientTypeRequest {

    private Boolean carbohydrate;
    private Boolean animalProtein;
    private Boolean plantProtein;
    private Boolean leafVegetable;
    private Boolean rootVegetable;
    private Boolean fruit;
}
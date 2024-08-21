package com.mvolinger.cardapiosemanal.adapters.in.web.mapper;

import com.mvolinger.cardapiosemanal.adapters.in.web.dtos.IngredientPostRequest;
import com.mvolinger.cardapiosemanal.core.domain.models.*;

public class IngredientDTOMapper {

    public static Ingredient toModel(IngredientPostRequest ingredientPostRequest) {
        return new Ingredient(
                null,
                ingredientPostRequest.getDescription(),
                ingredientPostRequest.getName(),
                getNutritionalTable(ingredientPostRequest),
                getIngredientType(ingredientPostRequest),
                getDietType(ingredientPostRequest),
                geMealType(ingredientPostRequest)

        );
    }

    private static NutritionalTable getNutritionalTable(IngredientPostRequest ingredientPostRequest) {
        return new NutritionalTable(
                null,
                ingredientPostRequest.getNutritionalTable().getEnergy(),
                ingredientPostRequest.getNutritionalTable().getCarbohydrates(),
                ingredientPostRequest.getNutritionalTable().getFiber(),
                ingredientPostRequest.getNutritionalTable().getSaturatedFat(),
                ingredientPostRequest.getNutritionalTable().getTotalLipid(),
                ingredientPostRequest.getNutritionalTable().getProtein(),
                ingredientPostRequest.getNutritionalTable().getSodium()
        );
    }

    private static IngredientType getIngredientType(IngredientPostRequest ingredientPostRequest) {
        return new IngredientType(
                null,
                ingredientPostRequest.getIngredientType().getCarbohydrate(),
                ingredientPostRequest.getIngredientType().getAnimalProtein(),
                ingredientPostRequest.getIngredientType().getPlantProtein(),
                ingredientPostRequest.getIngredientType().getLeafVegetable(),
                ingredientPostRequest.getIngredientType().getRootVegetable(),
                ingredientPostRequest.getIngredientType().getFruit()
        );
    }

    private static DietType getDietType(IngredientPostRequest ingredientPostRequest) {
        return new DietType(
                null,
                ingredientPostRequest.getDietType().getOmnivorous(),
                ingredientPostRequest.getDietType().getCeliacDisease(),
                ingredientPostRequest.getDietType().getDiabetes(),
                ingredientPostRequest.getDietType().getLactoseIntolerance(),
                ingredientPostRequest.getDietType().getLactovegetarian(),
                ingredientPostRequest.getDietType().getOvolactovegetarian(),
                ingredientPostRequest.getDietType().getOvovegetarian(),
                ingredientPostRequest.getDietType().getPescetarian(),
                ingredientPostRequest.getDietType().getVegan()
        );
    }

    private static MealType geMealType(IngredientPostRequest ingredientPostRequest) {
        return new MealType(
                null,
                ingredientPostRequest.getMealType().getBreakfast(),
                ingredientPostRequest.getMealType().getLunch(),
                ingredientPostRequest.getMealType().getSnack(),
                ingredientPostRequest.getMealType().getDinner()
        );
    }
}
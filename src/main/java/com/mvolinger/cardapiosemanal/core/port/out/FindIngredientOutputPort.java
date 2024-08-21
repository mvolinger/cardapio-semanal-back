package com.mvolinger.cardapiosemanal.core.port.out;

import com.mvolinger.cardapiosemanal.core.domain.models.Ingredient;

import java.util.List;
import java.util.UUID;

public interface FindIngredientOutputPort {

    Ingredient findById(UUID id);
    List<Ingredient> findIngredientsMatchingUserDiet(List<String> userDietTrueAttributes);
}
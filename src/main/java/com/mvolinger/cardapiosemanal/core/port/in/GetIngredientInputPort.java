package com.mvolinger.cardapiosemanal.core.port.in;

import com.mvolinger.cardapiosemanal.core.domain.models.Ingredient;
import com.mvolinger.cardapiosemanal.core.domain.models.User;

import java.util.List;
import java.util.UUID;

public interface GetIngredientInputPort {

    Ingredient getById(UUID id);
    List<Ingredient> getMealIngredientsList(User user, String mealType);
}
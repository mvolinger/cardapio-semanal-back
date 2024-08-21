package com.mvolinger.cardapiosemanal.core.port.in;

import com.mvolinger.cardapiosemanal.core.domain.models.Ingredient;

public interface PostIngredientInputPort {

    Ingredient create(Ingredient ingredient);
}
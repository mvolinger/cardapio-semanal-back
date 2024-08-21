package com.mvolinger.cardapiosemanal.core.port.out;

import com.mvolinger.cardapiosemanal.core.domain.models.Ingredient;

public interface SaveIngredientOutputPort {

    Ingredient save(Ingredient ingredient);
}
package com.mvolinger.cardapiosemanal.core.usecase;

import com.mvolinger.cardapiosemanal.core.domain.models.Ingredient;
import com.mvolinger.cardapiosemanal.core.port.in.PostIngredientInputPort;
import com.mvolinger.cardapiosemanal.core.port.out.SaveIngredientOutputPort;

public class CreateIngredientUseCase implements PostIngredientInputPort {

    private final SaveIngredientOutputPort saveIngredientOutputPort;

    public CreateIngredientUseCase(SaveIngredientOutputPort saveIngredientOutputPort) {
        this.saveIngredientOutputPort = saveIngredientOutputPort;
    }

    @Override
    public Ingredient create(Ingredient ingredient) {
        return saveIngredientOutputPort.save(ingredient);
    }
}
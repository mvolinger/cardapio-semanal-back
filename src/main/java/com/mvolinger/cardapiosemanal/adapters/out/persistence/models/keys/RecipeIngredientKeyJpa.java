package com.mvolinger.cardapiosemanal.adapters.out.persistence.models.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Embeddable
public class RecipeIngredientKeyJpa implements Serializable {

    @Column(name="receita_id")
    private UUID recipeId;

    @Column(name="ingrediente_id")
    private UUID ingredientId;
}

package com.mvolinger.cardapiosemanal.adapters.out.persistence.models.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Embeddable
public class GroceryIngredientKeyJpa implements Serializable {

    @Column(name="lista_compras_id")
    private UUID groceryListId;

    @Column(name="ingrediente_id")
    private UUID ingredientId;
}
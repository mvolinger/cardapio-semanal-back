package com.mvolinger.cardapiosemanal.adapters.out.persistence.models;

import com.mvolinger.cardapiosemanal.adapters.out.persistence.models.keys.GroceryIngredientKeyJpa;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
@Table(name = "ingrediente_compras")
public class GroceryIngredientJpa {

    @EmbeddedId
    private GroceryIngredientKeyJpa id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @MapsId("groceryListId")
    @JoinColumn(name = "lista_compras_id")
    private GroceryListJpa groceryList;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @MapsId("ingredientId")
    @JoinColumn(name = "ingrediente_id")
    private IngredientJpa ingredient;

    @Column(name="quantidade", nullable = false)
    private String quantity;
}
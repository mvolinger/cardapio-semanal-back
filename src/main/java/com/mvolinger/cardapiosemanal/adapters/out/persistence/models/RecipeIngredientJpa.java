package com.mvolinger.cardapiosemanal.adapters.out.persistence.models;

import com.mvolinger.cardapiosemanal.adapters.out.persistence.models.keys.RecipeIngredientKeyJpa;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
@Table(name = "ingrediente_receita")
public class RecipeIngredientJpa {

    @EmbeddedId
    private RecipeIngredientKeyJpa id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @MapsId("recipeId")
    @JoinColumn(name = "receita_id")
    private RecipeJpa recipe;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @MapsId("ingredientId")
    @JoinColumn(name = "ingrediente_id")
    private IngredientJpa ingredient;

    @Column(name="quantidade", nullable = false)
    private String quantity;
}
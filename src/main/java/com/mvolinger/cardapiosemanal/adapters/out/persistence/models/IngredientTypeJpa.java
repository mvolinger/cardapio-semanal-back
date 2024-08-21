package com.mvolinger.cardapiosemanal.adapters.out.persistence.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "tipo_ingrediente")
public class IngredientTypeJpa {

    @Id
    @GeneratedValue
    @Column(name="tipo_ingrediente_id", nullable = false)
    private UUID ingredientTypeId;

    @Column(name="carboidrato")
    private Boolean carbohydrate;

    @Column(name="proteina_animal")
    private Boolean animalProtein;

    @Column(name="proteina_vegetal")
    private Boolean plantProtein;

    @Column(name="verdura")
    private Boolean leafVegetable;

    @Column(name="legume")
    private Boolean rootVegetable;

    @Column(name="fruta")
    private Boolean fruit;
}
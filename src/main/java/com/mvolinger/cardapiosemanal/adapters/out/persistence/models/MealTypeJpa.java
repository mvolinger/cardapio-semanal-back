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
@Table(name = "tipo_refeicao")
public class MealTypeJpa {

    @Id
    @GeneratedValue
    @Column(name="tipo_refeicao_id", nullable = false)
    private UUID mealTypeId;

    @Column(name="cafe_da_manha")
    private Boolean breakfast;

    @Column(name="almoco")
    private Boolean lunch;

    @Column(name="lanche")
    private Boolean snack;

    @Column(name="jantar")
    private Boolean dinner;
}
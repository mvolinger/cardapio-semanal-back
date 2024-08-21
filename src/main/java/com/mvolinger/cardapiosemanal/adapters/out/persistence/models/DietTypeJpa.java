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
@Table(name = "tipo_dieta")
public class DietTypeJpa {

    @Id
    @GeneratedValue
    @Column(name="tipo_dieta_id", nullable = false)
    private UUID dietTypeId;

    @Column(name="onivoro")
    private Boolean omnivorous;

    @Column(name="doenca_celiaca")
    private Boolean celiacDisease;

    @Column(name="doenca_diabetes")
    private Boolean diabetes;

    @Column(name="doenca_hipolactasia")
    private Boolean lactoseIntolerance;

    @Column(name="lactovegetariano")
    private Boolean lactovegetarian;

    @Column(name="ovolactovegetariano")
    private Boolean ovolactovegetarian;

    @Column(name="ovovegetariano")
    private Boolean ovovegetarian;

    @Column(name="pescetariano")
    private Boolean pescetarian;

    @Column(name="vegetariano_estrito")
    private Boolean vegan;
}
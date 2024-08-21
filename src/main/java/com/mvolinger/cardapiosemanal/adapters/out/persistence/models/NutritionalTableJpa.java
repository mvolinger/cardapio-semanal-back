package com.mvolinger.cardapiosemanal.adapters.out.persistence.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "tabela_nutricional")
public class NutritionalTableJpa {

    @Id
    @GeneratedValue
    @Column(name="tabela_nutricional_id", nullable = false)
    private UUID nutritionalTableId;

    @Column(name="calorias")
    private BigDecimal energy;

    @Column(name="carboidratos")
    private BigDecimal carbohydrates;

    @Column(name="fibra_alimentar")
    private BigDecimal fiber;

    @Column(name="gorduras_saturadas")
    private BigDecimal saturatedFat;

    @Column(name="gorduras_totais")
    private BigDecimal totalLipid;

    @Column(name="proteinas")
    private BigDecimal protein;

    @Column(name="sodio")
    private BigDecimal sodium;

}
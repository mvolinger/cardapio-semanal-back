package com.mvolinger.cardapiosemanal.adapters.out.persistence.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "ingrediente")
public class IngredientJpa {

    @Id
    @GeneratedValue
    @Column(name="ingrediente_id", nullable = false)
    private UUID ingredientId;

    @Column(name="descricao", nullable = false)
    private String description;

    @Column(name="nome", nullable = false)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tabela_nutricional_id", referencedColumnName = "tabela_nutricional_id")
    private NutritionalTableJpa nutritionalTable;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_ingrediente_id", referencedColumnName = "tipo_ingrediente_id")
    private IngredientTypeJpa ingredientType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_dieta_id", referencedColumnName = "tipo_dieta_id")
    private DietTypeJpa dietType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_refeicao_id", referencedColumnName = "tipo_refeicao_id")
    private MealTypeJpa mealType;
}
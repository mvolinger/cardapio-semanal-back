package com.mvolinger.cardapiosemanal.adapters.out.persistence.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "refeicao_individual")
public class MealJpa {

    @Id
    @GeneratedValue
    @Column(name="refeicao_individual_id", nullable = false)
    private UUID mealId;

    @Column(name="descricao", nullable = false)
    private String description;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private UserJpa user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_refeicao_id", referencedColumnName = "tipo_refeicao_id")
    private MealTypeJpa mealType;

    @ManyToMany
    @JoinTable(
            name = "refeicao_ingrediente",
            joinColumns = @JoinColumn(name = "refeicao_individual_id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediente_id"))
    private List<IngredientJpa> ingredients;
}
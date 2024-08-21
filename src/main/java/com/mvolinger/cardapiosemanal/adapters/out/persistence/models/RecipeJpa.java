package com.mvolinger.cardapiosemanal.adapters.out.persistence.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "receita")
public class RecipeJpa {

    @Id
    @GeneratedValue
    @Column(name="receita_id", nullable = false)
    private UUID recipeId;

    @Column(name="titulo", nullable = false)
    private String title;

    @Column(name="descricao", nullable = false)
    private String description;

    @Column(name="categoria", nullable = false)
    private String category;

    @Column(name="preparacao", nullable = false)
    private String preparation;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private UserJpa user;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<RecipeIngredientJpa> ingredients;
}
package com.mvolinger.cardapiosemanal.adapters.out.persistence.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "cardapio_semanal")
public class WeekMenuJpa {

    @Id
    @GeneratedValue
    @Column(name="cardapio_semanal_id", nullable = false)
    private UUID weekMenuId;

    @Column(name="descricao", nullable = false)
    private String description;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private UserJpa user;

    @ManyToMany
    @JoinTable(
            name = "cardapio_refeicao",
            joinColumns = @JoinColumn(name = "cardapio_semanal_id"),
            inverseJoinColumns = @JoinColumn(name = "refeicao_individual_id"))
    private List<MealJpa> meals;
}
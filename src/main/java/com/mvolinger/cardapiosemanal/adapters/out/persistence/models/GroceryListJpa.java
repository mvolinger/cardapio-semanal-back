package com.mvolinger.cardapiosemanal.adapters.out.persistence.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "lista_compras")
public class GroceryListJpa {

    @Id
    @GeneratedValue
    @Column(name="lista_compras_id", nullable = false)
    private UUID groceryListId;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private UserJpa user;

    @OneToMany(mappedBy = "groceryList", cascade = CascadeType.ALL)
    private List<GroceryIngredientJpa> ingredients;
}
package com.mvolinger.cardapiosemanal.adapters.out.persistence.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "usuario")
public class UserJpa {

    @Id
    @GeneratedValue
    @Column(name="usuario_id", nullable = false)
    private UUID userId;

    @Column(nullable = false)
    private String email;

    @Column(name="senha", nullable = false)
    private String password;

    @Column(name="nome", nullable = false)
    private String name;

    @Column(name="sobrenome", nullable = false)
    private String lastname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_dieta_id", referencedColumnName = "tipo_dieta_id")
    private DietTypeJpa dietType;
}
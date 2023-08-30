package com.concesionaria.concesionaria.entidades;

import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private String password;

    @ManyToOne
    @NotNull
    private Rol rol;
}



package com.concesionaria.concesionaria.entidades;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank(message = "Campo obligatorio")
    @Size(max = 50, message = "Nombre demasiado largo")
    @Column(unique = true)
    private String nombre;
}
package com.concesionaria.concesionaria.entidades;

import jakarta.validation.constraints.*;
import lombok.*;
import jakarta.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank(message = "Campo obligatorio")
    @Size(max = 50, message = "Nombre demasiado largo")
    private String nombre;

    @NotNull
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Marca marca;

    @NotNull
    @ManyToOne(cascade = CascadeType.REFRESH)
    private TipoVehiculo tipoVehiculo;

    
    private Integer km;

    @NotNull
    @NotBlank(message = "Campo obligatorio")
    @Size(max = 50, message = "Nombre demasiado largo")
    private String color;

    
    private Integer annio;


    private Integer precio;

    @Size(max = 255, message = "Descripcion demasiada larga")
    private String descripcion;

    //! como ingresar el Path en bd
    private String imagen;



}

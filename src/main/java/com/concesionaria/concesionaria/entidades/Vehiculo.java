package com.concesionaria.concesionaria.entidades;

import lombok.*;
import jakarta.persistence.*;
import com.concesionaria.concesionaria.entidades.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Marca marca;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private TipoVehiculo tipoVehiculo;

    private Float km;

    private String color;

    private Integer annio;

    private String descripcion;

    //! como ingresar el Path en bd
    private String imagen;



}

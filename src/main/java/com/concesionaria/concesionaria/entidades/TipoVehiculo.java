package com.concesionaria.concesionaria.entidades;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;
import com.concesionaria.concesionaria.entidades.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipoVehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "tipoVehiculo")
    private Set<Vehiculo> vehiculos;

}

package com.concesionaria.concesionaria.entidades;

import lombok.*;
import jakarta.persistence.*;
import java.util.*;
import com.concesionaria.concesionaria.entidades.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "marca")
    private Set<Vehiculo> vehiculos;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "marca_tipo",
            joinColumns = @JoinColumn(name = "id_tipov"),
            inverseJoinColumns = @JoinColumn(name = "id_marca")
    )
    private Set<TipoVehiculo> tipoVehiculos;


}
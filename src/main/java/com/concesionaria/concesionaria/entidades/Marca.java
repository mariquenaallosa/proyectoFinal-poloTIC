package com.concesionaria.concesionaria.entidades;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import jakarta.persistence.*;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank(message = "Campo obligatorio")
    @Size(max = 50, message = "Nombre demasiado largo")
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

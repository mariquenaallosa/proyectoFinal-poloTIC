package com.concesionaria.concesionaria.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.util.Set;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipoVehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank(message = "Campo obligatorio")
    @Size(max = 50, message = "Nombre demasiado largo")
    private String nombre;


    @OneToMany(mappedBy = "tipoVehiculo", fetch = FetchType.EAGER)
    private Set<Vehiculo> vehiculos;

}

package com.concesionaria.concesionaria.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.concesionaria.concesionaria.entidades.*;
import org.springframework.data.jpa.repository.Query;
import java.util.*;

@Repository
public interface VehiculoRepositorio extends CrudRepository<Vehiculo, Long> {

    @Query("SELECT v FROM Vehiculo v WHERE v.tipoVehiculo.id = ?1")
    List<Vehiculo> findByTipoVehiculo(Long id);

    @Query("SELECT v FROM Vehiculo v WHERE v.marca.id = ?1")
    List<Vehiculo> findByMarca(Long id);

}

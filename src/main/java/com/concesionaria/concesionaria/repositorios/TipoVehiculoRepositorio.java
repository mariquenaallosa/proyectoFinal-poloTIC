package com.concesionaria.concesionaria.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.concesionaria.concesionaria.entidades.*;

@Repository
public interface TipoVehiculoRepositorio extends CrudRepository<TipoVehiculo, Long>{

    @Query("SELECT CASE WHEN COUNT(v) > 0 THEN true ELSE false END FROM Vehiculo v WHERE v.tipoVehiculo.id = ?1")
    boolean hasReferences(Long id);


}

package com.concesionaria.concesionaria.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.concesionaria.concesionaria.entidades.*;
import java.util.Optional;

@Repository
public interface RolRepositorio extends CrudRepository<Rol, Long> {

    Optional<Rol> findByNombre(String string);
}

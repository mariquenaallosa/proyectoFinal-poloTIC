package com.concesionaria.concesionaria.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.concesionaria.concesionaria.entidades.*;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    boolean existsByEmail(String email);
}

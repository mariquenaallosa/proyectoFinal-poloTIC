package com.concesionaria.concesionaria.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.concesionaria.concesionaria.entidades.*;

@Repository
public interface MarcaRepositorio extends CrudRepository<Marca, Long> {

}

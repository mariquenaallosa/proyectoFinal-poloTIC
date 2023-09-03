package com.concesionaria.concesionaria.servicios;

import com.concesionaria.concesionaria.entidades.*;
import com.concesionaria.concesionaria.repositorios.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;

@Service
public class RolServicio {

    @Autowired
    RolRepositorio rolRepositorio;

    //Obtener todos los roles en una lista
    public List<Rol> getAll(){
        List<Rol> lista = new ArrayList<Rol>();
       rolRepositorio.findAll().forEach(registro -> lista.add(registro));
        return lista;
    }

    //Obtener el rol según su id
    public Rol getById(Long id){
        return rolRepositorio.findById(id).get();
    }

    //Guardar un rol en la base de datos
    public void save(Rol rol){
        rolRepositorio.save(rol);
    }

    //Eliminar una marca según su id
    public void delete(Long id){
       rolRepositorio.deleteById(id);
    }
}

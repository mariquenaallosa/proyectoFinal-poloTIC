package com.concesionaria.concesionaria.servicios;

import com.concesionaria.concesionaria.entidades.*;
import com.concesionaria.concesionaria.repositorios.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;

@Service
public class MarcaServicio {

    @Autowired
    MarcaRepositorio marcaRepositorio;

    //Obtener todas las marcas en una lista
    public List<Marca> getAll(){
        List<Marca> lista = new ArrayList<Marca>();
        marcaRepositorio.findAll().forEach(registro -> lista.add(registro));
        return lista;
    }

    //Obtener la marca según su id
    public Marca getById(Long id){
        return marcaRepositorio.findById(id).get();
    }

    //Guardar una marca en la base de datos
    public void save(Marca marca){
       marcaRepositorio.save(marca);
    }

    //Eliminar una marca según su id
    public void delete(Long id){
        marcaRepositorio.deleteById(id);
    }
}

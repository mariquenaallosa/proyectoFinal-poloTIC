package com.concesionaria.concesionaria.servicios;

import com.concesionaria.concesionaria.entidades.*;
import com.concesionaria.concesionaria.repositorios.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;


@Service
public class VehiculoServicio {

    @Autowired
    VehiculoRepositorio vehiculoRepositorio;

    @Autowired
    EntityManager entityManager;

    //Obtener todos los vehiculos en una lista
    public List<Vehiculo> getAll(){
        List<Vehiculo> lista = new ArrayList<Vehiculo>();
        vehiculoRepositorio.findAll().forEach(registro -> lista.add(registro));
        return lista;
    }

    //obtener los 6 vehiculos aleatorios
    public List<Vehiculo> getRandomSix() {
        String sql = "SELECT * FROM vehiculo ORDER BY RAND() LIMIT 6";
        Query query = entityManager.createNativeQuery(sql, Vehiculo.class);
        return query.getResultList();
    }

    //Obtener los primeros 6
    public List<Vehiculo> getFirstSix() {
    List<Vehiculo> lista = new ArrayList<Vehiculo>();
    Iterable<Vehiculo> vehiculos = vehiculoRepositorio.findAll();
    Iterator<Vehiculo> iterator = vehiculos.iterator();
    
    int count = 0;
    while (iterator.hasNext() && count < 6) {
        lista.add(iterator.next());
        count++;
    }
    
    return lista;
}


    //Obtener el vehiculo según su id
    public Vehiculo getById(Long id){
        return vehiculoRepositorio.findById(id).get();
    }

    //Obtener el vehiculo según Tipo de vehiculo
    public List<Vehiculo> getByTipoVehiculo(Long id) {
        return vehiculoRepositorio.findByTipoVehiculo(id);
    }

    //Obtener el vehiculo según Marca
    public List<Vehiculo> getByMarca(Long id) {
        return vehiculoRepositorio.findByMarca(id);
    }
    //Guardar un vehiculo en la base de datos
    public void save(Vehiculo vehiculo){
        vehiculoRepositorio.save(vehiculo);
    }

    //Eliminar un vehiculo según su id
    public void delete(Long id){
        vehiculoRepositorio.deleteById(id);
    }


}

package com.concesionaria.concesionaria.servicios;

import com.concesionaria.concesionaria.entidades.*;
import com.concesionaria.concesionaria.repositorios.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;

@Service
public class VehiculoServicio {

    @Autowired
    VehiculoRepositorio vehiculoRepositorio;

    //Obtener todos los vehiculos en una lista
    public List<Vehiculo> getAll(){
        List<Vehiculo> lista = new ArrayList<Vehiculo>();
        vehiculoRepositorio.findAll().forEach(registro -> lista.add(registro));
        return lista;
    }

    //Obtener el vehiculo según su id
    public Vehiculo getById(Long id){
        return vehiculoRepositorio.findById(id).get();
    }

    //Obtener el vehiculo según Tipo de vehiculo
    public List<Vehiculo> getByTipoVehiculo(Long id) {
        return vehiculoRepositorio.findByTipoVehiculo(id);


    //Obtener el vehiculo según Marca
    public List<Vehiculo> getByMarca(Long id) {
        return vehiculoRepositorio.findByTipoMarca(id);

    //Guardar un vehiculo en la base de datos
    public void save(Vehiculo vehiculo){
        vehiculoRepositorio.save(vehiculo);
    }

    //Eliminar un vehiculo según su id
    public void delete(Long id){
        vehiculoRepositorio.deleteById(id);
    }


}

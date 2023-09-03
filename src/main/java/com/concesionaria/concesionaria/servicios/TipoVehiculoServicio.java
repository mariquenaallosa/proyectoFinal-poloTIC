package com.concesionaria.concesionaria.servicios;

import com.concesionaria.concesionaria.entidades.*;
import com.concesionaria.concesionaria.repositorios.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;

@Service
public class TipoVehiculoServicio {

    @Autowired
    TipoVehiculoRepositorio tipoVehiculoRepositorio;

    //Obtener todos los tipoVehiculos en una lista
    public List<TipoVehiculo> getAll(){
        List<TipoVehiculo> lista = new ArrayList<TipoVehiculo>();
        tipoVehiculoRepositorio.findAll().forEach(registro -> lista.add(registro));
        return lista;
    }

    //Obtener el tipoVehiculo según su id
    public TipoVehiculo getById(Long id){
        return tipoVehiculoRepositorio.findById(id).get();
    }

    //Guardar un tipoVehiculo en la base de datos
    public void save(TipoVehiculo tipoVehiculo){
        tipoVehiculoRepositorio.save(tipoVehiculo);
    }

    //Eliminar un tipoVehiculo según su id
    public void delete(Long id){
        tipoVehiculoRepositorio.deleteById(id);
    }
}

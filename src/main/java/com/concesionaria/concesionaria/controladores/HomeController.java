package com.concesionaria.concesionaria.controladores;

import com.concesionaria.concesionaria.repositorios.VehiculoRepositorio;
import com.concesionaria.concesionaria.servicios.VehiculoServicio;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.context.SecurityContextHolder;

@RestController
public class HomeController {

    @Autowired
    VehiculoServicio vehiculoServicio;

    @Autowired
    VehiculoRepositorio vehiculoRepositorio;

    @RequestMapping("/")
    public ModelAndView home()
    {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("fragments/base");
        maw.addObject("titulo", "Inicio");
        maw.addObject("vista", "inicio/home");
        maw.addObject("vehiculos",vehiculoServicio.getRandomSix());
        return maw;
    }


    @PostMapping("/buscar") //Método para el buscador del header
    public ModelAndView buscarVehiculo(@RequestParam String nombre){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("fragments/base");
        mav.addObject("titulo", "Busqueda");
        mav.addObject("vista","inicio/busqueda");
        mav.addObject("vehiculosBuscar", vehiculoServicio.getAll().stream().filter(p -> (p.getNombre().toLowerCase().contains(nombre.toLowerCase()))).toList());
        return mav;
    }

    @GetMapping("/todos")
    public ModelAndView vehiculos(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("fragments/base");
        mav.addObject("titulo", "Listado de vehículos");
        mav.addObject("vista","vehiculos/vehiculos");
        mav.addObject("vehiculos", vehiculoServicio.getAll());
        return mav;
    }


}

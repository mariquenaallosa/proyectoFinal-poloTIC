package com.concesionaria.concesionaria.controladores;

import com.concesionaria.concesionaria.entidades.*;
import com.concesionaria.concesionaria.servicios.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("formulario")
public class FormController implements WebMvcConfigurer{

    @Autowired
    VehiculoServicio vehiculoServicio;

    @Autowired
    TipoVehiculoServicio tipoVehiculoServicio;

    @Autowired
    MarcaServicio marcaServicio;

    @GetMapping
    @RequestMapping("/form/{id}")
    public ModelAndView Crear(@PathVariable("id") Long id, Vehiculo vehiculo){

        ModelAndView mav = new ModelAndView();
        mav.setViewName("fragments/base");
        mav.addObject("titulo", "Listado de vehículos");
        mav.addObject("vista","form/formularioVehiculo");
        mav.addObject("vehiculo", vehiculoServicio.getById(id)); 
        mav.addObject("tipoVehiculo", tipoVehiculoServicio.getAll());
        mav.addObject("marca", marcaServicio.getAll());
        
        return mav;
    }

    
}

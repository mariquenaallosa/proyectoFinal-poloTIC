package com.concesionaria.concesionaria.controladores;

import com.concesionaria.concesionaria.entidades.*;
import com.concesionaria.concesionaria.servicios.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RestController
@RequestMapping("tipoVehiculos")
public class TipoVehiculoController implements WebMvcConfigurer {
    @Autowired
    TipoVehiculoServicio tipoVehiculoServicio;

    @GetMapping
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("fragments/base");
        mav.addObject("titulo","Lista de tipos de vehiculos");
        mav.addObject("vista","tipoVehiculos/index");
        mav.addObject("tipoVehiculos", tipoVehiculoServicio.getAll());
        return mav;
    }

    @GetMapping("/crear")
    public ModelAndView crear(TipoVehiculo tipoVehiculo) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("fragments/base");
        mav.addObject("titulo", "Crear tipo de vehiculo");
        mav.addObject("vista", "tipoVehiculos/crear");
        mav.addObject("tipoVehiculo", tipoVehiculo);
        return mav;
    }

    @PostMapping("/crear")
    public ModelAndView guardar(@Valid TipoVehiculo tipoVehiculo, BindingResult br, RedirectAttributes ra) {
        if ( br.hasErrors() ) {
            return this.crear(tipoVehiculo);
        }

        tipoVehiculoServicio.save(tipoVehiculo);

        ModelAndView mav = this.index();
        mav.addObject("exito", "Tipo de vehiculo creada exitosamente");
        return mav;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Long id, TipoVehiculo tipoVehiculo){

        ModelAndView mav = new ModelAndView();
        mav.setViewName("fragments/base");
        mav.addObject("titulo", "Editar tipo de vehiculo");
        mav.addObject("vista", "tipoVehiculos/editar");
        mav.addObject("tipoVehiculo", tipoVehiculoServicio.getById(id));

        return mav;
    }

    @PutMapping("/editar/{id}")
    private ModelAndView update(@PathVariable("id") Long id, @Valid TipoVehiculo tipoVehiculo, BindingResult br, RedirectAttributes ra) {
        if ( br.hasErrors() ) {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("fragments/base");
            mav.addObject("titulo", "Editar tipo de vehiculo");
            mav.addObject("vista", "tipoVehiculos/editar");
            mav.addObject("tipoVehiculo", tipoVehiculo);
            return mav;
        }

        TipoVehiculo registro = tipoVehiculoServicio.getById(id);
        registro.setNombre( tipoVehiculo.getNombre() );
        ModelAndView mav = this.index();

        tipoVehiculoServicio.save(registro);
        mav.addObject("exito", "Tipo de vehiculo editada exitosamente");
        return mav;
    }

    @DeleteMapping("/{id}")
    public ModelAndView eliminar(@PathVariable("id") Long id) {
        tipoVehiculoServicio.delete(id);
        ModelAndView mav = this.index();
        mav.addObject("exito", "Tipo de vehiculo eliminada exitosamente");
        return mav;
    }

}


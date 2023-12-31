package com.concesionaria.concesionaria.controladores;

import com.concesionaria.concesionaria.entidades.*;
import com.concesionaria.concesionaria.repositorios.TipoVehiculoRepositorio;
import com.concesionaria.concesionaria.servicios.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RestController
@RequestMapping("tipovehiculos")
public class TipoVehiculoController implements WebMvcConfigurer {

    @Autowired
    TipoVehiculoServicio tipoVehiculoServicio;

    @Autowired
    TipoVehiculoRepositorio tipoVehiculoRepositorio;

    @GetMapping
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("fragments/base");
        mav.addObject("titulo","Lista tipos de vehiculos");
        mav.addObject("vista","tipovehiculos/index");
        mav.addObject("tipovehiculos", tipoVehiculoServicio.getAll());
        return mav;
    }
    @GetMapping("/{id}")
    public ModelAndView mostrar(@PathVariable("id") Long id, TipoVehiculo tipoVehiculo){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("fragments/base");
        mav.addObject("titulo","Tipo");
        mav.addObject("vista","tipoVehiculos/ver");
        mav.addObject("tipovehiculos", tipoVehiculoServicio.getById(id));
        return mav;
    }

    @GetMapping("/crear")
    public ModelAndView crear(TipoVehiculo tipoVehiculo) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("fragments/base");
        mav.addObject("titulo", "Crear tipo de vehiculo");
        mav.addObject("vista", "tipovehiculos/crear");
        mav.addObject("tipovehiculo", tipoVehiculo);
        return mav;
    }

    @PostMapping("/crear")
    public ModelAndView guardar(@Valid TipoVehiculo tipoVehiculo, BindingResult br, RedirectAttributes ra) {
        if ( br.hasErrors() ) {
            return this.crear(tipoVehiculo);
        }

        tipoVehiculoServicio.save(tipoVehiculo);

        ModelAndView mav = this.index();
        mav.addObject("exito", "Tipo de vehiculo creado exitosamente");
        return mav;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Long id, TipoVehiculo tipoVehiculo){

        ModelAndView mav = new ModelAndView();
        mav.setViewName("fragments/base");
        mav.addObject("titulo", "Editar tipo de vehiculo");
        mav.addObject("vista", "tipovehiculos/editar");
        mav.addObject("tipovehiculo", tipoVehiculoServicio.getById(id));

        return mav;
    }

    @PutMapping("/editar/{id}")
    private ModelAndView update(@PathVariable("id") Long id, @Valid TipoVehiculo tipoVehiculo, BindingResult br, RedirectAttributes ra) {
        if ( br.hasErrors() ) {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("fragments/base");
            mav.addObject("titulo", "Editar tipo de vehiculo");
            mav.addObject("vista", "tipovehiculos/editar");
            mav.addObject("tipovehiculo", tipoVehiculo);
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

        ModelAndView mav;

        if (tipoVehiculoRepositorio.hasReferences(id)) {
            mav = this.index();
            mav.addObject("error", "No se puede borrar el registro porque posee datos asociados");
        }else{
            tipoVehiculoServicio.delete(id);
            mav = this.index();
            mav.addObject("exito", "Tipo de vehiculo eliminada exitosamente");
        }

        
        return mav;
    }

}


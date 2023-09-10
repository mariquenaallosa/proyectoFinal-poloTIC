package com.concesionaria.concesionaria.controladores;

import com.concesionaria.concesionaria.entidades.Marca;
import com.concesionaria.concesionaria.servicios.MarcaServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RestController
@RequestMapping("marcas")
public class MarcaController implements WebMvcConfigurer {
    
    @Autowired
     MarcaServicio marcaServicio;

    @GetMapping
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("fragments/base");
        mav.addObject("titulo","Lista de Marcas");
        mav.addObject("vista","marcas/index");
        mav.addObject("marcas", marcaServicio.getAll());
        return mav;
    }
    @GetMapping("/{id}") //muestra UNA marca,responde al boton eye
    public ModelAndView mostrar(@PathVariable("id") Long id, Marca marca){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("fragments/base");
        mav.addObject("titulo","Marca");
        mav.addObject("vista","marcas/ver");
        mav.addObject("marcas", marcaServicio.getById(id));
        return mav;
    }
    @GetMapping("/crear")
    public ModelAndView crear(Marca marca) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("fragments/base");
        mav.addObject("titulo", "Crear marca");
        mav.addObject("vista", "marcas/crear");
        mav.addObject("marca", marca);
        return mav;
    }

    @PostMapping("/crear")
    public ModelAndView guardar(@Valid Marca marca, BindingResult br, RedirectAttributes ra) {
        if ( br.hasErrors() ) {
            return this.crear(marca);
        }

        marcaServicio.save(marca);

        ModelAndView mav = this.index();
        mav.addObject("exito", "Marca creada exitosamente");
        return mav;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Long id, Marca marca){
     
        ModelAndView mav = new ModelAndView();
        mav.setViewName("fragments/base");
        mav.addObject("titulo", "Editar marca");
        mav.addObject("vista", "marcas/editar");
        mav.addObject("marca", marcaServicio.getById(id));

        return mav;
    }

    @PutMapping("/editar/{id}")
    private ModelAndView update(@PathVariable("id") Long id, @Valid Marca marca, BindingResult br, RedirectAttributes ra) {
        if ( br.hasErrors() ) {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("fragments/base");
            mav.addObject("titulo", "Editar marca");
            mav.addObject("vista", "marcas/editar");
            mav.addObject("marca", marca);
            return mav;
        }

        Marca registro = marcaServicio.getById(id);
        registro.setNombre( marca.getNombre() );
        ModelAndView mav = this.index();

        marcaServicio.save(registro);
        mav.addObject("exito", "Marca editada exitosamente");
        return mav;
    }

    @DeleteMapping("/{id}")
    public ModelAndView eliminar(@PathVariable("id") Long id) {
        marcaServicio.delete(id);
        ModelAndView mav = this.index();
        mav.addObject("exito", "Marca eliminada exitosamente");
        return mav;
    }

}

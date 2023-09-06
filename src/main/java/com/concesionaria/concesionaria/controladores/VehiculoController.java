package com.concesionaria.concesionaria.controladores;

import com.concesionaria.concesionaria.entidades.*;
import com.concesionaria.concesionaria.servicios.*;
import jakarta.validation.Valid;
import java.io.File;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("vehiculos")
public class VehiculoController implements WebMvcController{

    @Autowired
    TipoVehiculoServicio tipoVehiculoServicio;

    @Autowired
    MarcaServicio marcaServicio;

    @Autowired
    VehiculoServicio vehiculoServicio;



    @GetMapping
    public ModelAndView index(){

        ModelAndView mav = new ModelAndView();
        mav.setViewName("fragments/base");
        mav.addObject("titulo", "Listado de vehículos");
        mav.addObject("vista","vehiculos/index");
        mav.addObject("vehiculos", vehiculoServicio.getAll());
        return mav;

    }

    @GetMapping("tipoVehiculo/{id}")
        public ModelAndView vehiculoPorTipo(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView();
        TipoVehiculo tipo = tipoVehiculoServicio.getById(id);
        mav.setViewName("fragments/base");
        mav.addObject("titulo", "Listado de vehículos de " + tipo.getNombre());
        mav.addObject("vista", "vehiculos/tipo");
        mav.addObject("vehiculos", vehiculoServicio.getByTipoVehiculo(id));
        mav.addObject("tipoVehiculo", tipo);
        return mav;
    } 

    @GetMapping("marca/{id}")
        public ModelAndView vehiculoPorMarca(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView();
        Marca marca = marcaServicio.getById(id);
        mav.setViewName("fragments/base");
        mav.addObject("titulo", "Listado de vehículos de " + marca.getNombre());
        mav.addObject("vista", "vehiculos/marca");
        mav.addObject("vehiculos", vehiculoServicio.getByMarca(id));
        mav.addObject("marca", marca);
        return mav;
    }

    @GetMapping("/crear")
    public ModelAndView crear(Vehiculo vehiculo) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("fragments/base");
        mav.addObject("titulo", "Crear vehiculo");
        mav.addObject("vista", "vehiculos/crear");
        mav.addObject("vehiculo", vehiculo);
        mav.addObject("tipoVehiculo", tipoVehiculoServicio.getAll());
        mav.addObject("marca", marcaServicio.getAll());
        return mav;
    }


    @PostMapping("/crear")
    public ModelAndView guardar(@RequestParam("archivo") MultipartFile archivo, @Valid Vehiculo vehiculo, BindingResult br, RedirectAttributes ra) {
        if ( archivo.isEmpty() )
        br.reject("archivo", "Por favor, cargue una imagen");

        if ( br.hasErrors() ) {
        return this.crear(vehiculo);
        }
        vehiculoServicio.save(vehiculo);

        String tipo = archivo.getContentType();
        String extension = "." + tipo.substring(tipo.indexOf('/') + 1, tipo.length());
        String imagen = vehiculo.getId() + extension;
        String path = Paths.get("src/main/resources/static/images/vehiculos", imagen).toAbsolutePath().toString();
        ModelAndView mav = this.index();

        try {
        archivo.transferTo( new File(path) );
        } catch (Exception e) {
        mav.addObject("error", "No se pudo guardar la imagen");
        return mav;
        }

        vehiculo.setImagen(imagen);
        vehiculoServicio.save(vehiculo);
        mav.addObject("exito", "Vehiculo creado exitosamente");
        return mav;
    }




    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Long id, Vehiculo vehiculo){
        return this.editar(id, vehiculo, true);
    }

    public ModelAndView editar(@PathVariable("id") Long id, Vehiculo vehiculo, boolean estaPersistido) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("fragments/base");
        mav.addObject("titulo", "Editar vehiculo");
        mav.addObject("vista", "vehiculos/editar");
        mav.addObject("vehiculo", vehiculoServicio.getById(id));
        mav.addObject("tipoVehiculo", tipoVehiculoServicio.getAll());
        mav.addObject("marca", marcaServicio.getAll());

        if (estaPersistido)
        mav.addObject("vehiculo", vehiculoServicio.getById(id));
        else
        vehiculo.setImagen( vehiculoServicio.getById(id).getImagen() );

        return mav;
    }

    @PutMapping("/editar/{id}")
    private ModelAndView update(@PathVariable("id") Long id,
    @RequestParam(value = "archivo", required = false) MultipartFile archivo,
    @Valid Vehiculo vehiculo, BindingResult br, RedirectAttributes ra) {
    if ( br.hasErrors() ) {
      return this.editar(id, vehiculo, false);
    }

    Vehiculo registro = vehiculoServicio.getById(id);
    registro.setNombre( vehiculo.getNombre() );
    registro.setMarca( vehiculo.getMarca() );
    registro.setTipoVehiculo( vehiculo.getTipoVehiculo() );
    registro.setKm( vehiculo.getKm() );
    registro.setColor( vehiculo.getColor() );
    registro.setAnnio(vehiculo.getAnnio() );
    registro.setDescripcion( vehiculo.getDescripcion() );
    ModelAndView maw = this.index();

    if ( ! archivo.isEmpty() ) {
      String tipo = archivo.getContentType();
      String extension = "." + tipo.substring(tipo.indexOf('/') + 1, tipo.length());
      String imagen = vehiculo.getId() + extension;
      String path = Paths.get("src/main/resources/static/images/vehiculos", imagen).toAbsolutePath().toString();

      try {
        archivo.transferTo( new File(path) );
      } catch (Exception e) {
        maw.addObject("error", "No se pudo guardar la imagen");
        return maw;
      }

        registro.setImagen(imagen);
    }

    vehiculoServicio.save(registro);
    maw.addObject("exito", "Vehiculo editado exitosamente");
    return maw;
  }

  @DeleteMapping("/{id}")
  public ModelAndView eliminar(@PathVariable("id") Long id) {
    vehiculoServicio.delete(id);
    ModelAndView mav = this.index();
    mav.addObject("exito", "Vehiculo eliminado exitosamente");
    return mav;
  }
}


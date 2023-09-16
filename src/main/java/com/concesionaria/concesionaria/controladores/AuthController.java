package com.concesionaria.concesionaria.controladores;

import com.concesionaria.concesionaria.dto.*;
import com.concesionaria.concesionaria.entidades.*;
import com.concesionaria.concesionaria.servicios.*;
import com.concesionaria.concesionaria.repositorios.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;


@Controller
public class AuthController {

    @Autowired
    private BCryptPasswordEncoder codificador;

    @Autowired
    private RolRepositorio rolRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private RecaptchaServicio recaptchaServicio;

    @GetMapping("/login")
    public ModelAndView showLoginForm(Model model,

      @RequestParam(name = "error", required = false) String error,
      @RequestParam(name="logout", required = false) String logout) {

        ModelAndView maw = new ModelAndView();
        maw.setViewName("fragments/base");
        maw.addObject("titulo", "Iniciar sesión");
        maw.addObject("vista", "auth/login");
        model.addAttribute("error", error);
        model.addAttribute("logout", logout);
        return maw;
    }

    @GetMapping({"/loginSuccess"})
    public RedirectView loginCheck(){
        return new RedirectView("/");
    }

    @GetMapping("/registro")
    public ModelAndView registro(RegistroDto registroDto)
    {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("fragments/base");
        maw.addObject("titulo", "Registrarse");
        maw.addObject("vista", "auth/registro");
        maw.addObject("registroDto", registroDto);
        return maw;
    }

    @PostMapping("/registro")
    public ModelAndView registrar(@RequestParam(name="g-recaptcha-response") String recaptchaResponse, @Valid RegistroDto registroDto, BindingResult br, RedirectAttributes ra, HttpServletRequest request)
    {
        String ip = request.getRemoteAddr();
        String captchaVerifyMessage = recaptchaServicio.verifyRecaptcha(ip, recaptchaResponse);

        if (captchaVerifyMessage != "") {
            br.rejectValue("recaptcha", "recaptcha", captchaVerifyMessage);
        }

        if ( br.hasErrors() ) {

            return this.registro(registroDto);
        }

        Usuario u = new Usuario();
        u.setEmail(registroDto.getEmail());
        u.setPassword(codificador.encode(registroDto.getPassword()));
        u.setRol(rolRepositorio.findByNombre("Usuario").orElseThrow(() -> new IllegalArgumentException("Error al crear usuario")));

        usuarioRepositorio.save(u);

        try {
            request.login(registroDto.getEmail(), registroDto.getPassword());
        } catch (ServletException e) {
            e.printStackTrace();
        }


        // HomeController hc = new HomeController();
        // return hc.home();

        return new ModelAndView("redirect:/");
    }

}
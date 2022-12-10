package Creando.CRUD.CrudSpringBoot.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import Creando.CRUD.CrudSpringBoot.domain.Persona;
import Creando.CRUD.CrudSpringBoot.interfaces.PersonaService;
import lombok.extern.slf4j.Slf4j;

@Controller // Le decimos que es un controlador
@Slf4j
public class ControladorInicio {

    @Autowired
    private PersonaService personaService;

    // ! Mostrar Personas
    @GetMapping("/") // Mostrar datos
    public String inicio(Model model, @AuthenticationPrincipal User user) {

        var personas = personaService.listarPersonas();
        log.info("Usuario que hizo login: " + user);
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("personas", personas);
        var saldoTotal = 0;
        for(var p: personas){
            saldoTotal += p.getSaldo();
        }
        model.addAttribute("saldoTotal", saldoTotal);
        model.addAttribute("totalCLientes", personas.size());
        return "index";
    }

    // ! Agregar Personas
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }

    // ! Guardar datos
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores){
        System.out.println(errores);
        if(errores.hasErrors()){
            return "modificar";
        }
        personaService.guardar(persona);
        return "redirect:/";
    }

    // ! Editar Datos
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }

    // ! Eliminar datos
    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }

    
}

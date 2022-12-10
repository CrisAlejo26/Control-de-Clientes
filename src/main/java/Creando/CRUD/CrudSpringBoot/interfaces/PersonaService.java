package Creando.CRUD.CrudSpringBoot.interfaces;

import java.util.List;

import Creando.CRUD.CrudSpringBoot.domain.Persona;

public interface PersonaService {

    // ! MOSTRAR
    public List<Persona> listarPersonas();

    // ! CREAR
    public void guardar(Persona persona);
    
    // ! ELIMINAR
    public void eliminar(Persona persona);

    // ! BUSCAR POR ID
    public Persona encontrarPersona(Persona persona);
}

package Creando.CRUD.CrudSpringBoot.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import Creando.CRUD.CrudSpringBoot.domain.Persona;

public interface PersonaDaoInterface extends JpaRepository<Persona, Long>{ // no hay necesidad de anotaciones como la de repository, solo asi funciona correctamente, persona es la clase o la entidad y long es el tipo de dato de la llave primaria
    
}

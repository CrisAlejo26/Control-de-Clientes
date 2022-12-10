package Creando.CRUD.CrudSpringBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Creando.CRUD.CrudSpringBoot.domain.Persona;
import Creando.CRUD.CrudSpringBoot.interfaces.PersonaDaoInterface;
import Creando.CRUD.CrudSpringBoot.interfaces.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaDaoInterface personaDao;

    @Override
    @Transactional(readOnly = true) // Solo va a leer datos, esta anotacion se usa porque son muchas personas las que pueden ver los datos al mismo tiempo, solo la va a leer
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaDao.findAll(); // Hacemos un cast para convertir de un objeto a una lista      
        
    }

    @Override
    @Transactional // Aqui la lee y la modifica
    public void guardar(Persona persona) {
        personaDao.save(persona);        
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);        
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        return personaDao.findById(persona.getIdPersona()).orElse(null); // sino encuentra nada entonces traiga un null
        
    }
    

}

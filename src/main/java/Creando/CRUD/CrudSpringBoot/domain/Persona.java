package Creando.CRUD.CrudSpringBoot.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

// Data con la dependencia lombok agrega todos los set, get y contructor
@Data
@Entity // Anotacion de entidad
@Table(name = "persona") // Corregimos el nombre por minusculas
public class Persona implements Serializable { // extendemos la clase hacia nuevas propiedades
    // usamos una de esas propiedades
    private static final long serialVersionUID = 1L;
    @Id // Le decimos que esta es la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Se va a generar automaticamente el id
    private Long idPersona;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String apellido;

    @NotEmpty
    @Email
    private String email;

    private String telefono;

    @NotNull
    private Double saldo;
}

package Creando.CRUD.CrudSpringBoot.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import Creando.CRUD.CrudSpringBoot.domain.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    Usuario findByUsername(String username);
}

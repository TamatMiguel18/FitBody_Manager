package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.crud;

import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudUsuarioEntity
        extends CrudRepository<UsuarioEntity, Long> {
    //Se crea el acceso al CRUD de mi entidad
    UsuarioEntity findFirstsByNombre(String nombre);
}

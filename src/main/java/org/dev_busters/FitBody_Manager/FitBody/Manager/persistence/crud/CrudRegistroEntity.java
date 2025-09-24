package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.crud;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.RegistroDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity.RegistroEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudRegistroEntity extends CrudRepository<RegistroEntity, Long> {
    RegistroEntity findFirstByCorreo(String correo);
}

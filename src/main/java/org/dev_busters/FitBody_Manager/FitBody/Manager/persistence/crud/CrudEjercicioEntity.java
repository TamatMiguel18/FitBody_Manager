package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.crud;

import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity.EjercicioEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CrudEjercicioEntity extends CrudRepository<EjercicioEntity, Long> {
    Optional<EjercicioEntity> findByNombreEjercicio(String nombre);
}

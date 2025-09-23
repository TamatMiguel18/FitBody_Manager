package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.crud;

import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity.PlanEntrenamientoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.Optional;

public interface CrudPlanEntrenamientoEntity extends CrudRepository<PlanEntrenamientoEntity, Long> {

    Optional<PlanEntrenamientoEntity> findByIdPlanEntrenamiento(Integer IdPlanEntrenamiento);

    PlanEntrenamientoEntity findByIdUsuarioAndFechaInicio(Integer idUsuario, Date fechaInicio);
}
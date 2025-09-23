package org.dev_busters.FitBody_Manager.FitBody.Manager.repository;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModPlanEntrenamientoDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.PlanEntrenamientoDto;

import java.util.List;

public interface PlanEntrenamientoRepository {

    List<PlanEntrenamientoDto> obtenerTodo();

    PlanEntrenamientoDto buscarPorId(Long IdPlanEntrenamiento);

    PlanEntrenamientoDto guardarPlanEntrenamiento(PlanEntrenamientoDto planEntrenamientoDto);

    PlanEntrenamientoDto modificarPlanEntrenamiento(Long idPlan, ModPlanEntrenamientoDto modPlanEntrenamientoDto);

    void eliminarPlanEntrenamiento(Long IdPlanEntrenamiento);
}
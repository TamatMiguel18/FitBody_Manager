package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.service;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.PlanEntrenamientoDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModPlanEntrenamientoDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.repository.PlanEntrenamientoRepository;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity.PlanEntrenamientoEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanEntrenamientoService {

    private final PlanEntrenamientoRepository planEntrenamientoRepository;

    public PlanEntrenamientoService(PlanEntrenamientoRepository planEntrenamientoRepository) {
        this.planEntrenamientoRepository = planEntrenamientoRepository;
    }

    public List<PlanEntrenamientoDto> obtenerTodo() {
        return this.planEntrenamientoRepository.obtenerTodo();
    }

    public PlanEntrenamientoDto buscarPorId(Long IdPlanEntrenamiento) {
        return this.planEntrenamientoRepository.buscarPorId(IdPlanEntrenamiento);
    }

    public PlanEntrenamientoDto guardarPlanEntrenamiento(PlanEntrenamientoDto PlanEntrenamientoDto) {
        return this.planEntrenamientoRepository.guardarPlanEntrenamiento(PlanEntrenamientoDto);
    }

    public PlanEntrenamientoDto modificarPlanEntrenamiento(Long IdPlanEntrenamiento, ModPlanEntrenamientoDto modPlanEntrenamientoDto) {
        return this.planEntrenamientoRepository.modificarPlanEntrenamiento(IdPlanEntrenamiento, modPlanEntrenamientoDto);
    }

    public void eliminarPlanEntrenamiento(Integer IdPlanEntrenamiento) {
        this.planEntrenamientoRepository.eliminarPlanEntrenamiento(Long.valueOf(IdPlanEntrenamiento));
    }
}
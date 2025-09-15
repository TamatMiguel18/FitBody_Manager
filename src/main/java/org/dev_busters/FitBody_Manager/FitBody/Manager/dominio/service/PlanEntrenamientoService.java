package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.service;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.PlanEntrenamientoDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModPlanEntrenamientoDTO;
import org.dev_busters.FitBody_Manager.FitBody.Manager.repository.PlanEntrenamientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanEntrenamientoService {

    private final PlanEntrenamientoRepository planEntrenamientoRepository;

    public PlanEntrenamientoService(PlanEntrenamientoRepository planEntrenamientoRepository) {
        this.planEntrenamientoRepository = planEntrenamientoRepository;
    }

    public List<PlanEntrenamientoDto> obtenerTodos() {
        return this.planEntrenamientoRepository.obtenerTodos;
    }

    public PlanEntrenamientoDto buscarPorId(Integer idPlan) {
        return this.planEntrenamientoRepository.buscarporId;
    }

    public PlanEntrenamientoDto guardarPlanEntrenamiento(PlanEntrenamientoDto planDTO) {
        return this.planEntrenamientoRepository.guardarPlanEntrenamiento;
    }

    public PlanEntrenamientoDto modificarPlanEntrenamiento(Integer idPlan, ModPlanEntrenamientoDto modPlanDTO) {
        return this.planEntrenamientoRepository.modificarPlanEntrenamiento;
    }

    public void eliminarPlanEntrenamiento(Integer idPlan) {
        this.planEntrenamientoRepository.eliminarPlanEntrenamiento(IdPlanEntrenamiento);
    }
}
package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModPlanEntrenamientoDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.PlanEntrenamientoDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception.PlanEntrenamientoNoExisteException;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception.PlanEntrenamientoYaExisteException;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.crud.CrudPlanEntrenamientoEntity;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity.PlanEntrenamientoEntity;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.mapper.PlanEntrenamientoMapper;
import org.dev_busters.FitBody_Manager.FitBody.Manager.repository.PlanEntrenamientoRepository;

import java.util.List;

public class PlanEntrenamientoEntityRepository implements PlanEntrenamientoRepository {

    private final CrudPlanEntrenamientoEntity crudPlanEntrenamientoEntity;
    private final PlanEntrenamientoMapper planEntrenamientoMapper;

    public PlanEntrenamientoEntityRepository(CrudPlanEntrenamientoEntity crudPlanEntrenamientoEntity, PlanEntrenamientoMapper planEntrenamientoMapper) {
        this.crudPlanEntrenamientoEntity = crudPlanEntrenamientoEntity;
        this.planEntrenamientoMapper = planEntrenamientoMapper;
    }

    @Override
    public List<PlanEntrenamientoDto> obtenerTodo(){
        return this.planEntrenamientoMapper.toDto(this.crudPlanEntrenamientoEntity.findAll());
    }

    @Override
    public PlanEntrenamientoDto buscarPorId(Long IdPlanEntrenamiento){
        return this.planEntrenamientoMapper.toDto(this.crudPlanEntrenamientoEntity.findById(IdPlanEntrenamiento).orElse(null));
    }

    @Override
    public PlanEntrenamientoDto guardarPlanEntrenamiento(PlanEntrenamientoDto planEntrenamientoDto){
        if (this.crudPlanEntrenamientoEntity.findByIdUsuarioAndFechaInicio(planEntrenamientoDto.idUsuario(), planEntrenamientoDto.fechaInicio()) != null) {
            throw new PlanEntrenamientoYaExisteException("El plan de entrenamiento para el usuario " + planEntrenamientoDto.idUsuario() + " en la fecha " + planEntrenamientoDto.fechaInicio() + " ya existe.");
        }
        PlanEntrenamientoEntity planEntrenamiento = this.planEntrenamientoMapper.toEntity(planEntrenamientoDto);
        this.crudPlanEntrenamientoEntity.save(planEntrenamiento);
        return this.planEntrenamientoMapper.toDto(planEntrenamiento);
    }

    @Override
    public PlanEntrenamientoDto modificarPlanEntrenamiento(Long idPlan, ModPlanEntrenamientoDto modPlanEntrenamientoDto){
        PlanEntrenamientoEntity planEntrenamiento = this.crudPlanEntrenamientoEntity.findById(idPlan).orElse(null);
        if (planEntrenamiento == null){
            throw new PlanEntrenamientoNoExisteException(idPlan);
        }
        this.planEntrenamientoMapper.modificarEntityFromDto(modPlanEntrenamientoDto, planEntrenamiento);
        return planEntrenamientoMapper.toDto(this.crudPlanEntrenamientoEntity.save(planEntrenamiento));
    }

    @Override
    public void eliminarPlanEntrenamiento(Long IdPlanEntrenamiento) {
        PlanEntrenamientoEntity planEntrenamiento = this.crudPlanEntrenamientoEntity.findById(IdPlanEntrenamiento).orElse(null);
        if (planEntrenamiento == null){
            throw new PlanEntrenamientoNoExisteException(IdPlanEntrenamiento);
        } else {
            this.crudPlanEntrenamientoEntity.deleteById(IdPlanEntrenamiento);
        }
    }
}
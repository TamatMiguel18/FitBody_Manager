package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.mapper;


import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModPlanEntrenamientoDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.PlanEntrenamientoDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity.PlanEntrenamientoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlanEntrenamientoMapper {

    PlanEntrenamientoDto toDto(PlanEntrenamientoEntity planEntrenamientoEntity);
    PlanEntrenamientoEntity toEntity(PlanEntrenamientoDto planEntrenamientoDto);
    List<PlanEntrenamientoDto> toDto(Iterable<PlanEntrenamientoEntity> entities);

    PlanEntrenamientoEntity modificarEntityFromDto(ModPlanEntrenamientoDto dto, @MappingTarget PlanEntrenamientoEntity entity);
}

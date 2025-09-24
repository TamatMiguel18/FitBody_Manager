package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.mapper;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.EjercicioDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModEjercicioDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity.EjercicioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EjercicioMapper {

    EjercicioDto toDto(EjercicioEntity entity);

    List<EjercicioDto> toDto(Iterable<EjercicioEntity> entities);
    EjercicioEntity toEntity(EjercicioDto dto);
    void modificarEntityFromDto(ModEjercicioDto modEjercicioDto, @MappingTarget EjercicioEntity ejercicioEntity);
}

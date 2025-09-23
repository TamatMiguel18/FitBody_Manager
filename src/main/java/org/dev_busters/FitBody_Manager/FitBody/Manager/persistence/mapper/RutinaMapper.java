package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.mapper;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModRutinaDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.RutinaDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity.RutinaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RutinaMapper {
    RutinaDto toDto(RutinaEntity rutinaEntity);
    RutinaEntity toEntity(RutinaDto rutinaDto);
    List<RutinaDto> toDto(Iterable<RutinaEntity> rutinaEntities);
    void modificarRutina(ModRutinaDto modRutinaDto, @MappingTarget RutinaEntity rutinaEntity);
}

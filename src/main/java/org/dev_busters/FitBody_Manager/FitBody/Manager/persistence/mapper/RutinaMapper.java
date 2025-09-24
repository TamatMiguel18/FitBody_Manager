package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.mapper;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModRutinaDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.RutinaDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity.RutinaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RutinaMapper {
    @Mapping(source = "idRutina", target = "idRutina")
    @Mapping(source = "nombreRutina", target = "nombreRutina")
    @Mapping(source = "dificultad", target = "dificultad")
    @Mapping(source = "duracion", target = "duracion")
    @Mapping(source = "frecuencia", target = "frecuencia")
    @Mapping(source = "clasificacionImc", target = "clasificacionImc")
    RutinaDto toDto(RutinaEntity entity);

    List<RutinaDto> toDto(Iterable<RutinaEntity> entities);

    @Mapping(source = "idRutina", target = "idRutina")
    @Mapping(source = "nombreRutina", target = "nombreRutina")
    @Mapping(source = "dificultad", target = "dificultad")
    @Mapping(source = "duracion", target = "duracion")
    @Mapping(source = "frecuencia", target = "frecuencia")
    @Mapping(source = "clasificacionImc", target = "clasificacionImc")
    RutinaEntity toEntity(RutinaDto dto);
    void modificarRutina(ModRutinaDto modRutinaDto, @MappingTarget RutinaEntity rutinaEntity);
}

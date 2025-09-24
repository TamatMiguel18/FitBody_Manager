package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.mapper;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.DetalleRutinaDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModDetalleRutinaDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity.DetalleRutinaEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetalleRutinaMapper {

    @Mapping(source = "idDetalleRutina", target = "idDetalleRutina")
    @Mapping(source = "ejercicio", target = "ejercicio")
    @Mapping(source = "rutina", target = "rutina")
    @Mapping(source = "nombreRutina", target = "nombreRutina")
    @Mapping(source = "dificultad", target = "dificultad")
    @Mapping(source = "duracion", target = "duracion")
    @Mapping(source = "frecuencia", target = "frecuencia")
    @Mapping(source = "clasificacionImc", target = "clasificacionImc")
    DetalleRutinaDto toDto(DetalleRutinaEntity entity);

    List<DetalleRutinaDto> toDto(Iterable<DetalleRutinaEntity> entities);

    @Mapping(source = "idDetalleRutina", target = "idDetalleRutina")
    @Mapping(source = "ejercicio", target = "ejercicio")
    @Mapping(source = "rutina", target = "rutina")
    @Mapping(source = "nombreRutina", target = "nombreRutina")
    @Mapping(source = "dificultad", target = "dificultad")
    @Mapping(source = "duracion", target = "duracion")
    @Mapping(source = "frecuencia", target = "frecuencia")
    @Mapping(source = "clasificacionImc", target = "clasificacionImc")
    DetalleRutinaEntity toEntity(DetalleRutinaDto dto);

    void modificarEntityFromDto(ModDetalleRutinaDto modDetalleRutinaDto, @MappingTarget DetalleRutinaEntity entity);
}
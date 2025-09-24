package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.mapper;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.DetalleRutinaDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModDetalleRutinaDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity.DetalleRutinaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetalleRutinaMapper {

    DetalleRutinaDto toDto(DetalleRutinaEntity entity);

    List<DetalleRutinaDto> toDto(Iterable<DetalleRutinaEntity> entities);
    DetalleRutinaEntity toEntity(DetalleRutinaDto dto);

    void modificarEntityFromDto(ModDetalleRutinaDto modDetalleRutinaDto, @MappingTarget DetalleRutinaEntity entity);
}
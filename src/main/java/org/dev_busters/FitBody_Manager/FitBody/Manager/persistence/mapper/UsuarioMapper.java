package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.mapper;


import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.UsuarioDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModUsuarioDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity.UsuarioEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioDto toDto(UsuarioEntity entity);

    List<UsuarioDto> toDto(Iterable<UsuarioEntity> entities);
    UsuarioEntity toEntity(UsuarioDto dto);

    void modificarEntityFromDto(ModUsuarioDto modUsuarioDto, @MappingTarget UsuarioEntity entity);
}
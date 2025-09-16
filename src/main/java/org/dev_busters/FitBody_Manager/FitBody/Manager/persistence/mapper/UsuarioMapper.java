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

    @Mapping(source = "idUsuario", target = "idUsuario")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "edad", target = "edad")
    @Mapping(source = "sexo", target = "sexo")
    @Mapping(source = "altura", target = "altura")
    @Mapping(source = "peso", target = "peso")
    @Mapping(source = "pesoDeseado", target = "pesoDeseado")
    @Mapping(source = "clasificacionImc", target = "clasificacionImc")
    @Mapping(source = "objetivoPersonal", target = "objetivoPersonal")
    @Mapping(source = "masaCorporal", target = "masaCorporal")
    UsuarioDto toDto(UsuarioEntity entity);

    List<UsuarioDto> toDto(Iterable<UsuarioEntity> entities);

    @InheritInverseConfiguration
    UsuarioEntity toEntity(UsuarioDto dto);

    @Mapping(source = "altura", target = "altura")
    @Mapping(source = "peso", target = "peso")
    @Mapping(source = "pesoDeseado", target = "pesoDeseado")
    @Mapping(source = "objetivoPersonal", target = "objetivoPersonal")
    void modificarEntityFromDto(ModUsuarioDto modUsuarioDto, @MappingTarget UsuarioEntity entity);
}
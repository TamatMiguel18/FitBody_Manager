package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.mapper;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModRegistroDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.RegistroDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity.RegistroEntity;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = UsuarioMapper.class) //Para poder tomar el objeto y pasarlo al dto de Registro
public interface RegistroMapper {
    @Mapping(source = "idRegistro", target = "idRegistro")
    @Mapping(source = "usuario", target = "usuario")
    @Mapping(source = "correo", target = "correo")
    @Mapping(source = "contrasena", target = "contrasena")
    RegistroDto toDto(RegistroEntity registroEntity);
    List<RegistroDto> toDto(Iterable<RegistroEntity> entities);
    @Mapping(source = "idRegistro", target = "idRegistro")
    @Mapping(source = "usuario", target = "usuario")
    @Mapping(source = "correo", target = "correo")
    @Mapping(source = "contrasena", target = "contrasena")
    RegistroEntity toEntity(RegistroDto usuarioRegistroDto);
    void modificarEntityFromDto(ModRegistroDto modRegistroDto, @MappingTarget RegistroEntity registroEntity);
}

package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.mapper;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModRegistroDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.RegistroDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity.RegistroEntity;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = UsuarioMapper.class) //Para poder tomar el objeto y pasarlo al dto de Registro
public interface RegistroMapper {
    RegistroDto toDto(RegistroEntity registroEntity);
    List<RegistroDto> toDto(Iterable<RegistroEntity> entities);
    RegistroEntity toEntity(RegistroDto usuarioRegistroDto);
    void modificarEntityFromDto(ModRegistroDto modRegistroDto, @MappingTarget RegistroEntity registroEntity);
}

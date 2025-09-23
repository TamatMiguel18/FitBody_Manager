package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entityRepository;


import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModUsuarioDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.UsuarioDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception.UsuarioNoExisteException;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception.UsuarioYaExisteException;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.crud.CrudUsuarioEntity;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity.UsuarioEntity;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.mapper.UsuarioMapper;
import org.dev_busters.FitBody_Manager.FitBody.Manager.repository.UsuarioRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioEntityRepository implements UsuarioRepository {

    private final CrudUsuarioEntity crudUsuarioEntity;
    private final UsuarioMapper usuarioMapper;

    public UsuarioEntityRepository(CrudUsuarioEntity crudUsuarioEntity, UsuarioMapper usuarioMapper) {
        this.crudUsuarioEntity = crudUsuarioEntity;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public List<UsuarioDto> obtenerTodos() {
        return this.usuarioMapper.toDto(this.crudUsuarioEntity.findAll());
    }

    @Override
    public UsuarioDto buscarPorId(Long idUsuario) {
        return this.usuarioMapper.toDto(this.crudUsuarioEntity.findById(idUsuario).orElse(null));
    }

    @Override
    public UsuarioDto guardarUsuario(UsuarioDto usuarioDto) {
        if (this.crudUsuarioEntity.findFirstsByNombre(usuarioDto.nombre()) != null) {
            throw new UsuarioYaExisteException(usuarioDto.nombre());
        }

        UsuarioEntity usuario = this.usuarioMapper.toEntity(usuarioDto);
        this.crudUsuarioEntity.save(usuario);
        return this.usuarioMapper.toDto(usuario);
    }

    @Override
    public UsuarioDto modificarUsuario(Long Id, ModUsuarioDto modUsuarioDto) {
        UsuarioEntity usuario = this.crudUsuarioEntity.findById(Id).orElse(null);

        if (usuario == null) {
            throw new UsuarioNoExisteException(Id);
        } else {
            this.usuarioMapper.modificarEntityFromDto(modUsuarioDto, usuario);
            return usuarioMapper.toDto(this.crudUsuarioEntity.save(usuario));
        }
    }

    @Override
    public void eliminarUsuario(Long Id) {
        UsuarioEntity usuario = this.crudUsuarioEntity.findById(Id).orElse(null);

        if (usuario == null) {
            throw new UsuarioNoExisteException(Id);
        } else {
            this.crudUsuarioEntity.deleteById(Id);
        }
    }
}
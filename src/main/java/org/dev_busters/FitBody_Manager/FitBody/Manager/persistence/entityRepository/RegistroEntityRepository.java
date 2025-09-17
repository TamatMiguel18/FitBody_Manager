package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entityRepository;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModRegistroDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.RegistroDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception.RegistroNotFound;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception.RegistroYaExiste;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.crud.CrudRegistroEntity;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.crud.CrudUsuarioEntity;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity.RegistroEntity;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity.UsuarioEntity;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.mapper.RegistroMapper;
import org.dev_busters.FitBody_Manager.FitBody.Manager.repository.RegistroRepository;
import org.dev_busters.FitBody_Manager.FitBody.Manager.repository.UsuarioRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegistroEntityRepository implements RegistroRepository {
    private final CrudRegistroEntity crudRegistroEntity;
    private final RegistroMapper registroMapper;
    private final CrudUsuarioEntity crudUsuarioEntity;

    public RegistroEntityRepository(CrudRegistroEntity crudRegistroEntity, RegistroMapper registroMapper, UsuarioRepository usuarioRepository, CrudUsuarioEntity crudUsuarioEntity) {
        this.crudRegistroEntity = crudRegistroEntity;
        this.registroMapper = registroMapper;
        this.crudUsuarioEntity = crudUsuarioEntity;
    }

    @Override
    public List<RegistroDto> obtenerTodo() {
        return this.registroMapper.toDto(this.crudRegistroEntity.findAll());
    }

    @Override
    public RegistroDto buscarPorId(Long idRegistro) {
        return this.registroMapper.toDto(this.crudRegistroEntity.findById(idRegistro).orElse(null));
    }

    @Override
    public RegistroDto guardarRegistro(RegistroDto registro) {
        if (this.crudRegistroEntity.findFirstByCorreo(registro.correo()) != null){
            throw new RegistroYaExiste(registro.correo());
        }
        RegistroEntity registroEntity = this.registroMapper.toEntity(registro);

        Long idUsuario = registro.usuario().idUsuario();
        UsuarioEntity usuario = crudUsuarioEntity.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id " + idUsuario));
        registroEntity.setUsuario(usuario);
        this.crudRegistroEntity.save(registroEntity);
        return this.registroMapper.toDto(registroEntity);
    }

    @Override
    public RegistroDto modificarRegistro(Long idRegistro, ModRegistroDto modRegistro) {
        RegistroEntity registroEntity = this.crudRegistroEntity.findById(idRegistro).orElse(null);
        registroEntity.setCorreo(modRegistro.correo());
        registroEntity.setContrasena(modRegistro.contrasena());

        if (registroEntity == null){
            throw new RegistroNotFound(idRegistro);
        }

        this.registroMapper.modificarEntityFromDto(modRegistro, registroEntity);
        return this.registroMapper.toDto(this.crudRegistroEntity.save(registroEntity));
    }

    @Override
    public void eliminarRegistro(Long idRegistro) {
        RegistroEntity registroEntity = this.crudRegistroEntity.findById(idRegistro).orElse(null);
        if (registroEntity == null){
            throw new RegistroNotFound(idRegistro);
        }else{
            this.crudRegistroEntity.deleteById(idRegistro);
        }
        this.crudRegistroEntity.delete(registroEntity);

    }
}

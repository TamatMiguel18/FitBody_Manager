package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entityRepository;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.RegistroDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception.RegistroYaExiste;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.crud.CrudRegistroEntity;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity.RegistroEntity;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.mapper.RegistroMapper;
import org.dev_busters.FitBody_Manager.FitBody.Manager.repository.RegistroRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegistroEntityRepository implements RegistroRepository {
    private final CrudRegistroEntity crudRegistroEntity;
    private final RegistroMapper registroMapper;

    public RegistroEntityRepository(CrudRegistroEntity crudRegistroEntity, RegistroMapper registroMapper) {
        this.crudRegistroEntity = crudRegistroEntity;
        this.registroMapper = registroMapper;
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
        RegistroEntity registroEntity = new RegistroEntity();
        registroEntity = this.registroMapper.toEntity(registro);
        this.crudRegistroEntity.save(registroEntity);
        return this.registroMapper.toDto(registroEntity);
    }

    @Override
    public RegistroDto modificarRegistro(Long idRegistro, RegistroDto registro) {
        return null;
    }

    @Override
    public void eliminarRegistro(Long idRegistro) {

    }
}

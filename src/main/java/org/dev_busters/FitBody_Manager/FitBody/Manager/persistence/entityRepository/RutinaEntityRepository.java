package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entityRepository;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModRutinaDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.RutinaDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception.RutinaNotFound;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception.RutinaYaExiste;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.crud.CrudRutinaEntity;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity.RutinaEntity;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.mapper.RutinaMapper;
import org.dev_busters.FitBody_Manager.FitBody.Manager.repository.RutinaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RutinaEntityRepository  implements RutinaRepository {
    private final CrudRutinaEntity crudRutinaEntity;
    private final RutinaMapper rutinaMapper;

    public RutinaEntityRepository(CrudRutinaEntity crudRutinaEntity, RutinaMapper rutinaMapper) {
        this.crudRutinaEntity = crudRutinaEntity;
        this.rutinaMapper = rutinaMapper;
    }

    @Override
    public List<RutinaDto> obtenerTodo() {
        return this.rutinaMapper.toDto(this.crudRutinaEntity.findAll());
    }

    @Override
    public RutinaDto buscarPorCodigo(Long idRutina) {
        return this.rutinaMapper.toDto(this.crudRutinaEntity.findById(idRutina).orElse(null));
    }

    @Override
    public RutinaDto guardarRutina(RutinaDto rutinaDto) {
        if (this.crudRutinaEntity.findFirstByNombreRutina(rutinaDto.nombreRutina()) != null) {
            throw new RutinaYaExiste("La rutina con este nombre ya existe.");
        }
        RutinaEntity rutinaEntity = this.rutinaMapper.toEntity(rutinaDto);
        rutinaEntity = this.crudRutinaEntity.save(rutinaEntity);
        return this.rutinaMapper.toDto(rutinaEntity);
    }

    @Override
    public RutinaDto modificarRutina(Long idRutina, ModRutinaDto modRutinaDto) {
        RutinaEntity rutinaEntity = this.crudRutinaEntity.findById(idRutina).orElse(null);
        rutinaEntity.setNombreRutina(modRutinaDto.nombreRutina());
        rutinaEntity.setDificultad(modRutinaDto.dificultad());
        rutinaEntity.setDuracion(modRutinaDto.duracion());
        rutinaEntity.setClasificacionImc(modRutinaDto.clasificacionImc());
        rutinaEntity.setFrecuencia(modRutinaDto.frecuencia());
        if (rutinaEntity == null){
            throw new RutinaNotFound(idRutina);
        }
        this.rutinaMapper.modificarRutina(modRutinaDto, rutinaEntity);
        return this.rutinaMapper.toDto(this.crudRutinaEntity.save(rutinaEntity));
    }

    @Override
    public void eliminarRutina(Long codigo) {
        RutinaEntity rutinaEntity = this.crudRutinaEntity.findById(codigo).orElse(null);
        if (rutinaEntity == null){
            throw new RutinaNotFound(codigo);
        }else{
            this.crudRutinaEntity.deleteById(codigo);
        }
        this.crudRutinaEntity.delete(rutinaEntity);

    }


}

package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entityRepository;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.DetalleRutinaDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModDetalleRutinaDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception.DetalleRutinaNoExisteException;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception.DetalleRutinaYaExisteException;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception.UsuarioNoExisteException;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception.UsuarioYaExisteException;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.crud.CrudDetalleRutinaEntity;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity.DetalleRutinaEntity;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.mapper.DetalleRutinaMapper;
import org.dev_busters.FitBody_Manager.FitBody.Manager.repository.DetalleRutinaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DetalleRutinaEntityRepository implements DetalleRutinaRepository {

    private final CrudDetalleRutinaEntity crudDetalleRutinaEntity;
    private final DetalleRutinaMapper detalleRutinaMapper;

    public DetalleRutinaEntityRepository(CrudDetalleRutinaEntity crudDetalleRutinaEntity, DetalleRutinaMapper detalleRutinaMapper) {
        this.crudDetalleRutinaEntity = crudDetalleRutinaEntity;
        this.detalleRutinaMapper = detalleRutinaMapper;
    }

    @Override
    public List<DetalleRutinaDto> obtenerTodos() {
        return this.detalleRutinaMapper.toDto(this.crudDetalleRutinaEntity.findAll());
    }

    @Override
    public DetalleRutinaDto buscarPorId(Long idDetalleRutina) {
        return this.detalleRutinaMapper.toDto(this.crudDetalleRutinaEntity.findById(idDetalleRutina).orElse(null));
    }


    @Override
    public DetalleRutinaDto guardarDetalleRutina(DetalleRutinaDto detalleRutinaDto) {
        if (this.crudDetalleRutinaEntity.findByIdDetalleRutina(detalleRutinaDto.getIdDetalleRutina()) != null){
            throw new DetalleRutinaYaExisteException(detalleRutinaDto.getIdDetalleRutina());
        }

        DetalleRutinaEntity detalleRutina = this.detalleRutinaMapper.toEntity(detalleRutinaDto);
        this.crudDetalleRutinaEntity.save(detalleRutina);
        return this.detalleRutinaMapper.toDto(detalleRutina);
    }

    @Override
    public DetalleRutinaDto modificarDetalleRutina(Long idDetalleRutina, ModDetalleRutinaDto modDetalleRutinaDto) {
        DetalleRutinaEntity detalleRutina = this.crudDetalleRutinaEntity.findById(idDetalleRutina).orElse(null);

        if (detalleRutina == null) {
            throw new DetalleRutinaNoExisteException(idDetalleRutina);
        } else {
            this.detalleRutinaMapper.modificarEntityFromDto(modDetalleRutinaDto, detalleRutina);
            return detalleRutinaMapper.toDto(this.crudDetalleRutinaEntity.save(detalleRutina));
        }
    }

    @Override
    public void eliminarDetalleRutina(Long idDetalleRutina) {
        DetalleRutinaEntity detalleRutina = this.crudDetalleRutinaEntity.findById(idDetalleRutina).orElse(null);
        if (detalleRutina == null) {
            throw new DetalleRutinaNoExisteException(idDetalleRutina);
        } else {
            this.crudDetalleRutinaEntity.deleteById(idDetalleRutina);
        }
    }
}
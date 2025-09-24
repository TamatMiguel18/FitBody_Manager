package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entityRepository;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.EjercicioDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModEjercicioDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception.EjercicioNoExisteExeption;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception.EjercicioYaExisteExeption;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.crud.CrudEjercicioEntity;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity.EjercicioEntity;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.mapper.EjercicioMapper;
import org.dev_busters.FitBody_Manager.FitBody.Manager.repository.EjercicioRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ejercicioEntityRepository implements EjercicioRepository {

    private final CrudEjercicioEntity crudEjercicioEntity;
    private final EjercicioMapper ejercicioMapper;

    public ejercicioEntityRepository(CrudEjercicioEntity crudEjercicioEntity, EjercicioMapper ejercicioMapper) {
        this.crudEjercicioEntity = crudEjercicioEntity;
        this.ejercicioMapper = ejercicioMapper;
    }

    @Override
    public List<EjercicioDto> obtenerTodo() {
        return this.ejercicioMapper.toDto(this.crudEjercicioEntity.findAll());
    }

    @Override
    public EjercicioDto buscarPorId(Long idEjercicio) {
        return this.ejercicioMapper.toDto(this.crudEjercicioEntity.findById(idEjercicio).orElse(null));
    }

    @Override
    public EjercicioDto guardarEjercicio(EjercicioDto ejercicioDto) {
        // Verifica si el ejercicio ya existe por su nombre.
        if (this.crudEjercicioEntity.findByNombreEjercicio(ejercicioDto.getNombreEjercicio()).isPresent()) {
            throw new EjercicioYaExisteExeption(ejercicioDto.getNombreEjercicio());
        }

        EjercicioEntity ejercicio = this.ejercicioMapper.toEntity(ejercicioDto);
        EjercicioEntity ejercicioGuardado = this.crudEjercicioEntity.save(ejercicio);

        return this.ejercicioMapper.toDto(ejercicioGuardado);
    }

    // En ejercicioEntityRepository.java
    @Override
    public EjercicioDto modificarEjercicio(Long idEjercicio, ModEjercicioDto ejercicioDto) {
        EjercicioEntity ejercicio = this.crudEjercicioEntity.findById(idEjercicio)
                .orElseThrow(() -> new EjercicioNoExisteExeption(idEjercicio));

        this.ejercicioMapper.modificarEntityFromDto(ejercicioDto, ejercicio);
        EjercicioEntity ejercicioModificado = this.crudEjercicioEntity.save(ejercicio);

        return ejercicioMapper.toDto(ejercicioModificado);
    }

    @Override
    public void eliminarEjercicio(Long idEjercicio) {
        // Usa una búsqueda por ID y lanza una excepción si no se encuentra.
        if (!this.crudEjercicioEntity.existsById(idEjercicio)) {
            throw new EjercicioNoExisteExeption(idEjercicio);
        }
        this.crudEjercicioEntity.deleteById(idEjercicio);
    }

    @Override
    public void modificarEjercicio(Long idEjercicio, EjercicioDto ejercicio) {

    }
}
package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence;


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

    public ejercicioEntityRepository(CrudEjercicioEntity crudEjercicioEntity, EjercicioMapper ejercicioMapper){
        this.crudEjercicioEntity = crudEjercicioEntity;
        this.ejercicioMapper = ejercicioMapper;
    }

    @Override
    public List<EjercicioDto> obtenerTodo(){
        return this.ejercicioMapper.toDto(this.crudEjercicioEntity.findAll());
    }

    @Override
    public EjercicioDto buscarPorId(Long idEjercicio){
        return this.ejercicioMapper.toDto(this.crudEjercicioEntity.findById(idEjercicio).orElse(null));
    }

    @Override
    public EjercicioDto guardarEjercicio(EjercicioDto ejercicioDto){
        if (this.crudEjercicioEntity.findByNombreEjercicio(ejercicioDto.nombreEjercicio()) !=null) {
            throw new EjercicioYaExisteExeption(ejercicioDto.nombreEjercicio());
        }
        EjercicioEntity ejercicio = new EjercicioEntity();
        ejercicio = this.ejercicioMapper.toEntity(ejercicioDto);
        this.crudEjercicioEntity.save(ejercicio);
        return this.ejercicioMapper.toDto(ejercicio);
    }

    @Override
    public EjercicioDto modificarEjercicio(Long idEjercicio, ModEjercicioDto modEjercicioDto){
        EjercicioEntity ejercicio = this.crudEjercicioEntity.findById(idEjercicio).orElse(null);
        if (ejercicio == null){
            throw new EjercicioNoExisteExeption(idEjercicio);
        }
        this.ejercicioMapper.modificarEntityFromDto(modEjercicioDto, ejercicio);
        return ejercicioMapper.toDto(this.crudEjercicioEntity.save(ejercicio));
    }

    @Override
    public void eliminarEjercicio(Long idEjercicio) {
        EjercicioEntity pelicula = this.crudEjercicioEntity.findById(idEjercicio).orElse(null);
        //Esepcion
        if (pelicula == null){
            throw new EjercicioNoExisteExeption(idEjercicio);
        }else {
            this.crudEjercicioEntity.deleteById(idEjercicio);
    }

    }
}











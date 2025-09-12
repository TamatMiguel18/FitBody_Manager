package org.dev_busters.FitBody_Manager.FitBody.Manager.repository;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.EjercicioDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.crud.CrudEjercicioEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EjercicioRepository{

    List<EjercicioDto> obtenerTodo();
    EjercicioDto buscarPorCodigo(Long idEjercicio);
    EjercicioDto guardarEjercicio(EjercicioDto ejercicioDto);
    EjercicioDto modificarEjercicio(Long idEjercicio);
}

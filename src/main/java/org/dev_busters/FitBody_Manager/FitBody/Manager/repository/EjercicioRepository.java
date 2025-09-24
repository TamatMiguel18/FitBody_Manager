package org.dev_busters.FitBody_Manager.FitBody.Manager.repository;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.EjercicioDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModEjercicioDto;

import java.util.List;

public interface EjercicioRepository {

    List<EjercicioDto>obtenerTodo();

    EjercicioDto buscarPorId(Long idEjercicio);

    EjercicioDto guardarEjercicio(EjercicioDto ejercicioDto);

    EjercicioDto modificarEjercicio(Long idEjercicio, ModEjercicioDto modEjercicioDto);

    void eliminarEjercicio(Long idEjercicio);
}

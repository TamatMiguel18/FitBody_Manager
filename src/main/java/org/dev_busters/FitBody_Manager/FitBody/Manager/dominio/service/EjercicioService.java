package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.service;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.EjercicioDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.repository.EjercicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjercicioService {
    private final EjercicioRepository ejercicioRepository;

    public EjercicioService (EjercicioRepository ejercicioRepository){
        this.ejercicioRepository = ejercicioRepository;
    }

    public List<EjercicioDto> obtenerTodo(){
        return this.ejercicioRepository.obtenerTodo();
    }

    public EjercicioDto buscarPorCodigo (Long idEjercicio){
        return this.ejercicioRepository.buscarPorCodigo(idEjercicio);
    }

    public EjercicioDto guardarRutina(EjercicioDto ejercicioDto){
        return this.ejercicioRepository.guardarEjercicio(ejercicioDto);
    }

}

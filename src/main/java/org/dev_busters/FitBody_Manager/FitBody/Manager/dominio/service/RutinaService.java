package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.service;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.RutinaDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.repository.RutinaRepository;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class RutinaService {
    private final RutinaRepository rutinaRepository;

    public RutinaService (RutinaRepository rutinaRepository){
        this.rutinaRepository = rutinaRepository;
    }

    public List<RutinaDto> obtenerTodo(){
        return this.rutinaRepository.obtenerTodo();
    }

    public RutinaDto buscarPorCodigo (Long idRutina){
        return this.rutinaRepository.buscarPorCodigo(idRutina);
    }

    public RutinaDto guardarRutina(RutinaDto rutinaDto){
        return this.rutinaRepository.guardarRutina(rutinaDto);
    }

}

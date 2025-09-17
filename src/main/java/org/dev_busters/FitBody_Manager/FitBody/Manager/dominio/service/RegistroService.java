package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.service;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModRegistroDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.RegistroDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.repository.RegistroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroService {

    private final RegistroRepository registroRepository;

    public RegistroService(RegistroRepository registroRepository) {
        this.registroRepository = registroRepository;
    }

    public List<RegistroDto> listarRegistros(){
        return this.registroRepository.obtenerTodo();
    }

    public RegistroDto buscarRegistroPorId(Long idRegistro){
        return this.registroRepository.buscarPorId(idRegistro);
    }

    public RegistroDto guardarRegistro(RegistroDto registroDto){
        return this.registroRepository.guardarRegistro(registroDto);
    }

    public RegistroDto modificarRegistro(Long idRegistro, ModRegistroDto modRegistroDto){
        return this.registroRepository.modificarRegistro(idRegistro, modRegistroDto);
    }

    public void eliminarRegistro(Long idRegistro){
        this.registroRepository.eliminarRegistro(idRegistro);
    }
}

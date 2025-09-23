package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.service;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.UsuarioDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModUsuarioDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){ this.usuarioRepository = usuarioRepository;}

    public List<UsuarioDto> obtenerTodos(){ return this.usuarioRepository.obtenerTodos();}

    public UsuarioDto buscarPorId(Long Id){
        return this.usuarioRepository.buscarPorId(Id);
    }

    public UsuarioDto guardarUsuario(UsuarioDto usuarioDto){
        return this.usuarioRepository.guardarUsuario(usuarioDto);
    }

    public UsuarioDto modificarUsuario(Long Id, ModUsuarioDto modUsuarioDto){
        return this.usuarioRepository.modificarUsuario(Id, modUsuarioDto);
    }

    public void eliminarUsuario(Long Id){
        this.usuarioRepository.eliminarUsuario(Id);
    }
}

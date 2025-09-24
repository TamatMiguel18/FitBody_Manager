package org.dev_busters.FitBody_Manager.FitBody.Manager.repository;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModUsuarioDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.UsuarioDto;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsuarioRepository {
    // Firmas de los métodos para la entidad Usuario
    List<UsuarioDto> obtenerTodos();
    UsuarioDto buscarPorId(Long idUsuario);
    UsuarioDto guardarUsuario(UsuarioDto usuarioDto);
    UsuarioDto modificarUsuario(Long idUsuario, ModUsuarioDto modUsuarioDto);
    void eliminarUsuario(Long idUsuario);
}
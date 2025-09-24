package org.dev_busters.FitBody_Manager.FitBody.Manager.repository;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModUsuarioDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.UsuarioDto;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsuarioRepository {
    // Firmas de los métodos para la entidad Usuario
    public List<UsuarioDto> obtenerTodos();
    public UsuarioDto buscarPorId(Long idUsuario);
    public UsuarioDto guardarUsuario(UsuarioDto usuarioDto);
    public UsuarioDto modificarUsuario(Long idUsuario, ModUsuarioDto modUsuarioDto);
    public void eliminarUsuario(Long idUsuario);
}
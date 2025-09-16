package org.dev_busters.FitBody_Manager.FitBody.Manager.repository;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.RegistroDto;

import java.util.List;

public interface RegistroRepository {
    public List<RegistroDto> obtenerTodo();
    public RegistroDto buscarPorId(Long idRegistro);
    public RegistroDto guardarRegistro(RegistroDto registro);
    public RegistroDto modificarRegistro(Long idRegistro, RegistroDto registro);
    public void eliminarRegistro(Long idRegistro);
}

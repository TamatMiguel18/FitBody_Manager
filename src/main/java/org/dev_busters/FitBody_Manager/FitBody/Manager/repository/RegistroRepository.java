package org.dev_busters.FitBody_Manager.FitBody.Manager.repository;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModRegistroDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.RegistroDto;

import java.util.List;

public interface RegistroRepository {
    public List<RegistroDto> obtenerTodo();
    public RegistroDto buscarPorId(Long idRegistro);
    public RegistroDto guardarRegistro(RegistroDto registro);
    public RegistroDto modificarRegistro(Long idRegistro, ModRegistroDto modRegistroDto);
    public void eliminarRegistro(Long idRegistro);
}

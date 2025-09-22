package org.dev_busters.FitBody_Manager.FitBody.Manager.repository;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.DetalleRutinaDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModDetalleRutinaDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DetalleRutinaRepository {
    // Firmas de los métodos para la entidad DetalleRutina
    List<DetalleRutinaDto> obtenerTodos();
    Optional<DetalleRutinaDto> buscarPorId(Integer idDetalleRutina);
    DetalleRutinaDto guardarDetalleRutina(DetalleRutinaDto detalleRutinaDto);
    DetalleRutinaDto modificarDetalleRutina(Integer idDetalleRutina, ModDetalleRutinaDto modDetalleRutinaDto);
    void eliminarDetalleRutina(Integer idDetalleRutina);
}
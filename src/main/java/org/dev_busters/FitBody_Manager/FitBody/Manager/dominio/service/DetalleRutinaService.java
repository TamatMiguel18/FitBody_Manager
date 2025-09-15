package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.service;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.DetalleRutinaDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModDetalleRutinaDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.repository.DetalleRutinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleRutinaService {
    private final DetalleRutinaRepository detalleRutinaRepository;

    public DetalleRutinaService(DetalleRutinaRepository detalleRutinaRepository) {
        this.detalleRutinaRepository = detalleRutinaRepository;
    }

    public List<DetalleRutinaDto> obtenerTodos() {
        return this.detalleRutinaRepository.obtenerTodos();
    }

    public DetalleRutinaDto buscarPorId(Integer idDetalleRutina) {
        return this.detalleRutinaRepository.buscarPorId(idDetalleRutina);
    }

    public DetalleRutinaDto guardarDetalleRutina(DetalleRutinaDto detalleRutinaDto) {
        return this.detalleRutinaRepository.guardarDetalleRutina(detalleRutinaDto);
    }

    public DetalleRutinaDto modificarDetalleRutina(Integer idDetalleRutina, ModDetalleRutinaDto modDetalleRutinaDto) {
        return this.detalleRutinaRepository.modificarDetalleRutina(idDetalleRutina, modDetalleRutinaDto);
    }

    public void eliminarDetalleRutina(Integer idDetalleRutina) {
        this.detalleRutinaRepository.eliminarDetalleRutina(idDetalleRutina);
    }
}
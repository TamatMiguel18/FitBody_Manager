package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.service;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.DetalleRutinaDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModDetalleRutinaDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.repository.DetalleRutinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleRutinaService {
    private final DetalleRutinaRepository detalleRutinaRepository;

    public DetalleRutinaService(DetalleRutinaRepository detalleRutinaRepository) {
        this.detalleRutinaRepository = detalleRutinaRepository;
    }

    public List<DetalleRutinaDto> obtenerTodos() {
        return this.detalleRutinaRepository.obtenerTodos();
    }

    public DetalleRutinaDto buscarPorId(Long Id) {
        return this.detalleRutinaRepository.buscarPorId(Id);
    }

    public DetalleRutinaDto guardarDetalleRutina(DetalleRutinaDto detalleRutinaDto) {
        return this.detalleRutinaRepository.guardarDetalleRutina(detalleRutinaDto);
    }

    public DetalleRutinaDto modificarDetalleRutina(Long Id, ModDetalleRutinaDto modDetalleRutinaDto) {
        return this.detalleRutinaRepository.modificarDetalleRutina(Id, modDetalleRutinaDto);
    }

    public void eliminarDetalleRutina(Long Id) {
        this.detalleRutinaRepository.eliminarDetalleRutina(Id);
    }
}
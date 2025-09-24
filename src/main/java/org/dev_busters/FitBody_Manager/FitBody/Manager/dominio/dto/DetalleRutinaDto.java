package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto;

public record DetalleRutinaDto(
        String nombreRutina,
        String dificultad,
        String duracion,
        Integer frecuencia,
        String clasificacionImc
) {}
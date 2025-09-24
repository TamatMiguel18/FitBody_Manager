package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Dificultad;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Duracion;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Clasificacion;

public record ModRutinaDto(
        String nombreRutina,
        Dificultad dificultad,
        Duracion duracion,
        Integer frecuencia,
        Clasificacion clasificacion
) {
}

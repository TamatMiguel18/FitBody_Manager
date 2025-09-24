package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Clasificacion;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Dificultad;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Duracion;

public record RutinaDto(
        Long idRutina,
        String nombreRutina,
        Dificultad dificultad,
        Duracion duracion,
        Integer frecuencia,
        Clasificacion clasificacion
) {
}

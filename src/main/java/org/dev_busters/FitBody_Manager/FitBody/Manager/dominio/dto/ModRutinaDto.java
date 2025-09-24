package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.ClasificacionImc;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Dificultad;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Duracion;

public record ModRutinaDto(
        String nombreRutina,
        Dificultad dificultad,
        Duracion duracion,
        Integer frecuencia,
        ClasificacionImc clasificacionImc
) {
}

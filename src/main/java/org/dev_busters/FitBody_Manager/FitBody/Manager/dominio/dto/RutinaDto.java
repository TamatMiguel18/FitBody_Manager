package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto;

import jakarta.validation.constraints.NotNull;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.ClasificacionImc;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Dificultad;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Duracion;

public record RutinaDto(
        Long idRutina,
        String nombreRutina,
        Dificultad dificultad,
        Duracion duracion,
        Integer frecuencia,
        ClasificacionImc clasificacionImc
) {
}

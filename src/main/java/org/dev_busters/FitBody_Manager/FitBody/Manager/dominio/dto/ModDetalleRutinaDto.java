package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Clasificacion;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Dificultad;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Duracion;

public record ModDetalleRutinaDto(
        @NotBlank(message = "El nombre de la rutina es obligatorio")
        String nombreRutina,

        @NotNull(message = "La dificultad es obligatoria")
        Dificultad dificultad,

        @NotNull(message = "La duración es obligatoria")
        Duracion duracion,

        @NotNull(message = "La frecuencia es obligatoria")
        @Positive(message = "La frecuencia debe ser un número positivo")
        Integer frecuencia,

        @NotNull(message = "La clasificación IMC es obligatoria")
        Clasificacion clasificacionImc
) {}
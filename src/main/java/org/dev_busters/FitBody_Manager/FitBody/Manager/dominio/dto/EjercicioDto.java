package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto;

import jakarta.validation.constraints.NotBlank;

public record EjercicioDto (
        @NotBlank(message = "Es obligatorio el nombre del ejercicio")
        String nombreEjercicio,

        @NotBlank(message = "Es obligatoria la descripcion del ejercicio")
        String descripcion,

        @NotBlank(message = "Es obligatorio el grupo muscular del ejercicio")
        String grupoMuscular,

        @NotBlank(message = "Es obligatorio el tipo de ejercicio")
        String tipoEjercicio,

        @NotBlank(message = "Es obligatoria la dificultad del ejercicio")
        String dificultad
){
}

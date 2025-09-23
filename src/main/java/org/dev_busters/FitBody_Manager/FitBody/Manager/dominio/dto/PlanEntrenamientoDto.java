package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

public record PlanEntrenamientoDto(
        @NotNull(message = "El ID del plan es obligatorio")
        Integer idPlan,

        @NotNull(message = "El ID del usuario es obligatorio")
        Integer idUsuario,

        @NotNull(message = "El ID de la rutina es obligatorio")
        Integer idRutina,

        @NotNull(message = "La fecha de inicio es obligatoria")
        java.util.Date fechaInicio,

        @NotBlank(message = "El progreso es obligatorio")
        String progreso
) {}
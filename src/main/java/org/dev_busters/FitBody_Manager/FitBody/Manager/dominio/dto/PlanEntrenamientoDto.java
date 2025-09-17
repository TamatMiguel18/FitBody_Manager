package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public record PlanEntrenamientoDto (
        int idPlan,
        int idUsuario,
        int idRutina,
        java.util.Date fechaInicio,
        String progreso
) {}

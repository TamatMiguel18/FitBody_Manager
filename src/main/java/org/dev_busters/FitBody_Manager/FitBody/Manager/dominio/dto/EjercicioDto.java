package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto;


import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Dificultad;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.GrupoMuscular;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.TipoDeEjercicio;

public record EjercicioDto(
        Long idEjercicio,
        String nombre,
        String descripcion,
        GrupoMuscular grupoMuscular,
        TipoDeEjercicio tIpoDeEjercicio,
        Dificultad dificultad
) {
}

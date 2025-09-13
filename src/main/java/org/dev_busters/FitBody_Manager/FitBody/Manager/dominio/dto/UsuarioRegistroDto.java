package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Clasification;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Objetivo;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Sex;

public record UsuarioDto(
        Long idUsuario,
        String nombre,
        Integer edad,
        Sex sexo,
        Double altura,
        Double peso,
        Double pesoDeseado,
        Clasification clasification,
        Objetivo objetivo,
        Double masaCorporal
) {
}

package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Clasification;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Objetivo;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Sex;

public record UsuarioRegistroDto(
        Long idUsuario,
        String nombre,
        Integer edad,
        String correo, //atributo que se obtiene desde el RegistroEntity para manejar una sola presentacion
        Sex sexo,
        Double altura,
        Double peso,
        Double pesoDeseado,
        Clasification clasification,
        Objetivo objetivo,
        Double masaCorporal
) {
}

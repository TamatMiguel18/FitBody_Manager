package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Clasificacion;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Dificultad;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Duracion;

@Data
@AllArgsConstructor
public class DetalleRutinaDto{
    Long idDetalleRutina;

    @NotNull(message = "El id del ejercicio es obligatorio")
    @Positive(message = "El id del ejercicio debe ser un número positivo")
    Integer idEjercicio;

    @NotNull(message = "El id de la rutina es obligatorio")
    @Positive(message = "El id de la rutina debe ser un número positivo")
    Integer idRutina;

    @NotBlank(message = "El nombre de la rutina es obligatorio")
    String nombreRutina;

    @Valid
    @NotNull(message = "La dificultad es obligatoria")
    Dificultad dificultad;

    @Valid
    @NotNull(message = "La duración es obligatoria")
    Duracion duracion;

    @NotNull(message = "La frecuencia es obligatoria")
    @Positive(message = "La frecuencia debe ser un número positivo")
    Integer frecuencia;

    @Valid
    @NotNull(message = "La clasificación IMC es obligatoria")
    Clasificacion clasificacionImc;
}
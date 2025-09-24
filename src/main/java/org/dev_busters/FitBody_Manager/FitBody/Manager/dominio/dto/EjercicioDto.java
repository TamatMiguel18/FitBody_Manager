package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EjercicioDto implements Serializable {

    private Long idEjercicio;

    @NotBlank(message = "Es obligatorio el nombre del ejercicio")
    private String nombreEjercicio;

    @NotBlank(message = "Es obligatoria la descripcion del ejercicio")
    private String descripcion;

    @NotBlank(message = "Es obligatorio el grupo muscular del ejercicio")
    private String grupoMuscular;

    @NotBlank(message = "Es obligatorio el tipo de ejercicio")
    private String tipoEjercicio;

    @NotBlank(message = "Es obligatoria la dificultad del ejercicio")
    private String dificultad;

}
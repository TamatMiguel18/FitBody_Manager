package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Genera getters, setters, toString, equals y hashCode
@AllArgsConstructor // Genera un constructor con todos los campos
@NoArgsConstructor // Genera un constructor sin argumentos
public class ModEjercicioDto {
    @NotBlank(message = "Es obligatorio el nombre del ejercicio")
    String nombreEjercicio;

    @NotBlank(message = "Es obligatoria la descripcion del ejercicio")
    String descripcion;

    @NotBlank(message = "Es obligatorio el grupo muscular del ejercicio")
    String gupoMuscular;

    @NotBlank(message = "Es obligatorio el tipo de ejercicio")
    String tipoEjercicio;

    @NotBlank(message = "Es obligatoria la dificultad del ejercicio")
    String dificultad;

    public String getNombreEjercicio() {
        return nombreEjercicio;
    }

    public void setNombreEjercicio(String nombreEjercicio) {
        this.nombreEjercicio = nombreEjercicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGupoMuscular() {
        return gupoMuscular;
    }

    public void setGupoMuscular(String gupoMuscular) {
        this.gupoMuscular = gupoMuscular;
    }

    public String getTipoEjercicio() {
        return tipoEjercicio;
    }

    public void setTipoEjercicio(String tipoEjercicio) {
        this.tipoEjercicio = tipoEjercicio;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }
}
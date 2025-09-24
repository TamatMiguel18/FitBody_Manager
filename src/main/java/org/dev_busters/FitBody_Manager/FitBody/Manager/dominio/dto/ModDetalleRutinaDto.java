package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.ClasificacionImc;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Dificultad;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Duracion;

@Data
@AllArgsConstructor
public class ModDetalleRutinaDto{
    @NotBlank(message = "El nombre de la rutina es obligatorio")
    String nombreRutina;

    @NotNull(message = "La dificultad es obligatoria")
    Dificultad dificultad;

    @NotNull(message = "La duración es obligatoria")
    Duracion duracion;

    @NotNull(message = "La frecuencia es obligatoria")
    @Positive(message = "La frecuencia debe ser un número positivo")
    Integer frecuencia;

    @NotNull(message = "La clasificación IMC es obligatoria")
    ClasificacionImc clasificacionImc;

    public String getNombreRutina() {
        return nombreRutina;
    }

    public void setNombreRutina(String nombreRutina) {
        this.nombreRutina = nombreRutina;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    public Duracion getDuracion() {
        return duracion;
    }

    public void setDuracion(Duracion duracion) {
        this.duracion = duracion;
    }

    public Integer getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(Integer frecuencia) {
        this.frecuencia = frecuencia;
    }

    public ClasificacionImc getClasificacionImc() {
        return clasificacionImc;
    }

    public void setClasificacionImc(ClasificacionImc clasificacionImc) {
        this.clasificacionImc = clasificacionImc;
    }
}
package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.ClasificacionImc;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Dificultad;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Duracion;

@Data
@AllArgsConstructor
public class ModRutinaDto{
        String nombreRutina;
        Dificultad dificultad;
        Duracion duracion;
        Integer frecuencia;
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

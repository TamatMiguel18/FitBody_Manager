package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto;


import lombok.Data;

@Data
public class DetalleRutinaDto{
        String nombreRutina;
        String dificultad;
        String duracion;
        Integer frecuencia;
        String clasificacionImc;

    public String getNombreRutina() {
        return nombreRutina;
    }

    public void setNombreRutina(String nombreRutina) {
        this.nombreRutina = nombreRutina;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Integer getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(Integer frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getClasificacionImc() {
        return clasificacionImc;
    }

    public void setClasificacionImc(String clasificacionImc) {
        this.clasificacionImc = clasificacionImc;
    }
}

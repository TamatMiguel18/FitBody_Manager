package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetalleRutinaDto{
        Long idDetalleRutina;
        RutinaDto rutina;
        EjercicioDto ejercicio;
        String nombreRutina;
        String dificultad;
        String duracion;
        Integer frecuencia;
        String clasificacionImc;

    public Long getIdDetallerRunina() {
        return idDetalleRutina;
    }

    public void setIdDetallerRunina(Long idDetallerRunina) {
        this.idDetalleRutina = idDetallerRunina;
    }

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

    public Long getIdDetalleRutina() {
        return idDetalleRutina;
    }

    public void setIdDetallerRutina(Long idDetalleRutina) {
        this.idDetalleRutina = idDetalleRutina;
    }

    public RutinaDto getId_rutina() {
        return rutina;
    }

    public RutinaDto setId_rutina(RutinaDto id_rutina) {
        this.rutina = id_rutina;
        return id_rutina;
    }

    public EjercicioDto getId_ejercicio() {
        return ejercicio;
    }

    public EjercicioDto setId_ejercicio(EjercicioDto id_ejercicio) {
        this.ejercicio = id_ejercicio;
        return id_ejercicio;
    }
}
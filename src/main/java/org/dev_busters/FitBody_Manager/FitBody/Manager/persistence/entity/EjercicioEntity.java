package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Dificultad;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.grupoMuscular;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.tipoEjercicio;

@Entity
@Table(name= "Ejercicio")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class EjercicioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEjercicio;

    @Column(length = 64, nullable = false)
    private String nombreEjercicio;

    @Column(length = 255, nullable = false)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private grupoMuscular grupoMuscular;

    @Enumerated(EnumType.STRING)
    private tipoEjercicio tipoEjercicio;

    @Enumerated(EnumType.STRING)
    private Dificultad dificultad;

    public int getIdEjercicio() {
        return idEjercicio;
    }

    public void setIdEjercicio(int idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

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

    public org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.grupoMuscular getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.grupoMuscular grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    public org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.tipoEjercicio getTipoEjercicio() {
        return tipoEjercicio;
    }

    public void setTipoEjercicio(org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.tipoEjercicio tipoEjercicio) {
        this.tipoEjercicio = tipoEjercicio;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }
}

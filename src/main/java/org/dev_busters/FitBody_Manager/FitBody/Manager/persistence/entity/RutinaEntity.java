package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.ClasificacionImc;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Dificultad;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Duracion;

@Entity
@Table(name = "Rutina")
@Data
public class RutinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rutina")
    private long idRutina;

    @Column (name = "nombre_rutina", length = 100, unique = true, nullable = false)
    private String nombreRutina;

    @Enumerated(EnumType.STRING)
    @Column (length = 40, nullable = false)
    private Dificultad dificultad;

    @Enumerated(EnumType.STRING)
    @Column (length = 150, nullable = false)
    private Duracion duracion;

    @Column (length = 150, nullable = false)
    private Integer frecuencia;

    @Enumerated(EnumType.STRING)
    @Column (name = "clasificacion_imc", length = 150, nullable = false)
    private ClasificacionImc clasificacionImc;

    public long getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(long idRutina) {
        this.idRutina = idRutina;
    }

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

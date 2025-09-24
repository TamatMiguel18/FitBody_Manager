package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Clasificacion;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Dificultad;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Duracion;

@Entity
@Table(name = "DetalleRutina")
@Data
public class DetalleRutinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleRutina;

    @ManyToOne
    @JoinColumn(name = "idEjercicio", referencedColumnName = "idEjercicio", nullable = false)
    private EjercicioEntity ejercicio;

    @ManyToOne
    @JoinColumn(name = "idRutina", referencedColumnName = "id_Rutina", nullable = false)
    private RutinaEntity rutina;
}
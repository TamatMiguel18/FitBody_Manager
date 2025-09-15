package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity.EjercicioEntity;
import org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity.RutinaEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DetalleRutina")
@Data
public class DetalleRutinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleRutina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEjercicio", nullable = false)
    private EjercicioEntity ejercicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idRutina", nullable = false)
    private RutinaEntity rutina;

    @Column(length = 64, nullable = false)
    private String nombreRutina;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Dificultad dificultad;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Duracion duracion;

    private Integer frecuencia;

    @Enumerated(EnumType.STRING)
    @Column(name = "clasificacionImc", nullable = false)
    private ClasificacionImc clasificacionImc;
}
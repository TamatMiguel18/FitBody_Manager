package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Progreso;

import java.util.Date;

@Entity
@Table(name = "PlanEntrnamiento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanEntrenamientoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdPlanEntrenamiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioEntity usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idRutina", nullable = false)
    private RutinaEntity rutina;

    @Column(name = "fechaInicio")
    private Date fechaInicio;

    @Enumerated(EnumType.STRING)
    private Progreso progreso;


}

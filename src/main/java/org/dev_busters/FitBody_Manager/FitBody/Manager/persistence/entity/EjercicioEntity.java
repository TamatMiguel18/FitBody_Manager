package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Dificultad;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.GrupoMuscular;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.TipoDeEjercicio;

@Entity
@Table(name = "Ejercicio")
@Data
public class EjercicioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEjercicio;

    @Column (length = 50, unique = true, nullable = false)
    private String nombre;

    @Column (length = 100, nullable = false)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column (length = 40, nullable = false)
    private Dificultad dificultad;

    @Enumerated(EnumType.STRING)
    @Column (length = 40, nullable = false)
    private GrupoMuscular grupoMuscular;

    @Enumerated(EnumType.STRING)
    @Column (length = 40, nullable = false)
    private TipoDeEjercicio tIpoDeEjercicio;

}

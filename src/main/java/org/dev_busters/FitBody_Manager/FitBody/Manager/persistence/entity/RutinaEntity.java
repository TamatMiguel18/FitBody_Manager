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
    private long idRutina;

    @Column (length = 100, unique = true, nullable = false)
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
    @Column (length = 150, nullable = false)
    private ClasificacionImc clasificacionImc;
}

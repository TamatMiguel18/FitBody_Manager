package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Clasification;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Objetivo;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Sex;

@Entity
@Table(name = "Usuarios")
@Data
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @OneToOne(mappedBy = "usuario")
    private RegistroEntity registro; //referencia del atributo usuario en RegistroEntity por si se necesita.
    @Column(length = 64, nullable = false)
    private String nombre;
    @Column(precision = 2, nullable = false)
    private Integer edad;
    @Enumerated(EnumType.STRING)
    private Sex sexo;
    @Column(precision = 10, scale = 2, nullable = false)
    private Double altura;
    @Column(precision = 10, scale = 2, nullable = false)
    private Double peso;
    @Column(precision = 10, scale = 2, nullable = false)
    private Double pesoDeseado;
    @Enumerated(EnumType.STRING)
    private Clasification clasification;
    @Enumerated(EnumType.STRING)
    private Objetivo objetivo;
    @Column(precision = 10, scale = 2, nullable = false)
    private Double masaCorporal;
}

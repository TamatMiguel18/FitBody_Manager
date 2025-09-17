package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "Usuarios")
@Data
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nombre", length = 64, nullable = false)
    private String nombre;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name = "sexo", nullable = false)
    private String sexo;

    @Column(name = "altura", precision = 10, scale = 2, nullable = false)
    private BigDecimal altura;

    @Column(name = "peso", precision = 10, scale = 2, nullable = false)
    private BigDecimal peso;

    @Column(name = "peso_deseado", precision = 10, scale = 2, nullable = false)
    private BigDecimal pesoDeseado;

    @Column(name = "clasificacion_imc", nullable = false)
    private String clasificacionImc;

    @Column(name = "objetivo_personal", nullable = false)
    private String objetivoPersonal;

    @Column(name = "masa_corporal", precision = 10, scale = 2, nullable = false)
    private BigDecimal masaCorporal;
}
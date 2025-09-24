package org.dev_busters.FitBody_Manager.FitBody.Manager.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Registro")
@Data
public class RegistroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro")
    private Long idRegistro;
    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioEntity usuario;
    @Column(length = 64, unique = true, nullable = false)
    private String correo;
    @Column(length = 12, unique = true, nullable = false)
    private String contrasena;
}
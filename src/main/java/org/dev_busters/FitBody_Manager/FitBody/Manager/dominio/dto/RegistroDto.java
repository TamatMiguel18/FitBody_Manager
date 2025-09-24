package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroDto {
    Long idRegistro;
    UsuarioDto usuario;
    @NotNull(message = "El correo no puede estar vacio")
    String correo;
    @NotBlank(message = "La contrasena no puede estar vacio")
    String contrasena;

    public Long getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Long idRegistro) {
        this.idRegistro = idRegistro;
    }

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }

    public @NotNull(message = "El correo no puede estar vacio") String getCorreo() {
        return correo;
    }

    public void setCorreo(@NotNull(message = "El correo no puede estar vacio") String correo) {
        this.correo = correo;
    }

    public @NotBlank(message = "La contrasena no puede estar vacio") String getContrasena() {
        return contrasena;
    }

    public void setContrasena(@NotBlank(message = "La contrasena no puede estar vacio") String contrasena) {
        this.contrasena = contrasena;
    }
}

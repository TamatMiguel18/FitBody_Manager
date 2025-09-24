package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ModRegistroDto{
    @NotNull(message = "El nuevo correo no puede estar vacio")
    String correo;
    @NotBlank(message = "La contrasena no puede estar vacia")
    String contrasena;
}

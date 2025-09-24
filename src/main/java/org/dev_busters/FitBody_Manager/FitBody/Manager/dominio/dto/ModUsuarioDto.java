package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ModUsuarioDto {
    @DecimalMin(value = "0.01", message = "La altura debe ser mayor que 0")
    BigDecimal altura;

    @DecimalMin(value = "0.01", message = "El peso debe ser mayor que 0")
    BigDecimal peso;

    @DecimalMin(value = "0.01", message = "El peso deseado debe ser mayor que 0")
    BigDecimal pesoDeseado;

    @NotBlank(message = "El objetivo personal es obligatorio")
    String objetivoPersonal;

}

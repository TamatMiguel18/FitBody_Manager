package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Sex;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Clasificacion;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Objetivo;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class UsuarioDto {
    Long idUsuario;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 64, message = "El nombre no puede tener más de 64 caracteres")
    String nombre;

    @Min(value = 1, message = "La edad debe ser mayor que 0")
    Integer edad;

    @Valid
    @NotNull(message = "El sexo es obligatorio")
    Sex sexo;

    @DecimalMin(value = "0.01", message = "La altura debe ser mayor que 0")
    BigDecimal altura;

    @DecimalMin(value = "0.01", message = "El peso debe ser mayor que 0")
    BigDecimal peso;

    @DecimalMin(value = "0.01", message = "El peso deseado debe ser mayor que 0")
    BigDecimal pesoDeseado;

    @Valid
    @NotNull(message = "La clasificación es obligatoria")
    Clasificacion clasificacion;

    @Valid
    @NotNull(message = "El objetivo personal es obligatorio")
    Objetivo objetivoPersonal;

    @DecimalMin(value = "0.0", message = "La masa corporal no puede ser negativa")
    BigDecimal masaCorporal;

    public UsuarioDto() {

    }
}
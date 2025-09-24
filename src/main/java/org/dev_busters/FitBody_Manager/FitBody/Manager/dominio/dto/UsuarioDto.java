package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Sex;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.ClasificacionImc;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.enums.Objetivo;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {
    Long idUsuario;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 64, message = "El nombre no puede tener más de 64 caracteres")
    String nombre;

    @Min(value = 1, message = "La edad debe ser mayor que 0")
    Integer edad;

    @Valid
    @NotBlank(message = "El sexo es obligatorio")
    Sex sexo;

    @DecimalMin(value = "0.01", message = "La altura debe ser mayor que 0")
    BigDecimal altura;

    @DecimalMin(value = "0.01", message = "El peso debe ser mayor que 0")
    BigDecimal peso;

    @DecimalMin(value = "0.01", message = "El peso deseado debe ser mayor que 0")
    BigDecimal pesoDeseado;

    @Valid
    @NotBlank(message = "La clasificación IMC es obligatoria")
    ClasificacionImc clasificacionImc;

    @Valid
    @NotBlank(message = "El objetivo personal es obligatorio")
    Objetivo objetivoPersonal;

    @DecimalMin(value = "0.0", message = "La masa corporal no puede ser negativa")
    BigDecimal masaCorpora;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Sex getSexo() {
        return sexo;
    }

    public void setSexo(Sex sexo) {
        this.sexo = sexo;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getPesoDeseado() {
        return pesoDeseado;
    }

    public void setPesoDeseado(BigDecimal pesoDeseado) {
        this.pesoDeseado = pesoDeseado;
    }

    public ClasificacionImc getClasificacionImc() {
        return clasificacionImc;
    }

    public void setClasificacionImc(ClasificacionImc clasificacionImc) {
        this.clasificacionImc = clasificacionImc;
    }

    public Objetivo getObjetivoPersonal() {
        return objetivoPersonal;
    }

    public void setObjetivoPersonal(Objetivo objetivoPersonal) {
        this.objetivoPersonal = objetivoPersonal;
    }

    public BigDecimal getMasaCorpora() {
        return masaCorpora;
    }

    public void setMasaCorpora(BigDecimal masaCorpora) {
        this.masaCorpora = masaCorpora;
    }
}
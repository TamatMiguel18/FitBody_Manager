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

        public String getObjetivoPersonal() {
                return objetivoPersonal;
        }

        public void setObjetivoPersonal(String objetivoPersonal) {
                this.objetivoPersonal = objetivoPersonal;
        }
}
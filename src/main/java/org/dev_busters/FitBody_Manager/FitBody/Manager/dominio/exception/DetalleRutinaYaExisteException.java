package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception;

public class DetalleRutinaYaExisteException extends RuntimeException {
    public DetalleRutinaYaExisteException(Long Id) {
        super("El detalle de rutina con id: " + Id + " ya existe entre los registros");
    }
}
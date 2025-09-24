package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception;

public class DetalleRutinaNoExisteException extends RuntimeException {
    public DetalleRutinaNoExisteException(Long Id) {
        super("El detalle de rutina con id: " + Id + " no existe entre los registros");
    }
}
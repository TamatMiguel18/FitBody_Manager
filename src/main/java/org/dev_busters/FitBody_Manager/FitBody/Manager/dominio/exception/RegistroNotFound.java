package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception;

public class RegistroNotFound extends RuntimeException {
    public RegistroNotFound(Long codigo) {
        super("No se encontró el registro con código: " + codigo);
    }
}

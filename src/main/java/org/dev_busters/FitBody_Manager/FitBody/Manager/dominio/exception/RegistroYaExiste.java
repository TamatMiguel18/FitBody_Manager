package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception;

public class RegistroYaExiste extends RuntimeException {
    public RegistroYaExiste(String correo) {
        super("El registro con correo: " + correo + " ya existe.");
    }
}

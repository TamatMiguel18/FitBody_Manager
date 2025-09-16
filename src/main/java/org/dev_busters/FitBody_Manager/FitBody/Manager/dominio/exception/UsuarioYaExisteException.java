package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception;

public class UsuarioYaExisteException extends RuntimeException {
    public UsuarioYaExisteException(String nombre) {
            super("El usuario con nombre: " +nombre+ " ya existe entre los registros");
    }
}

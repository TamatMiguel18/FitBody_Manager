package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception;

public class UsuarioNoExisteException extends RuntimeException {
    public UsuarioNoExisteException(Long Id) {
        super("El usuario con id: " +Id+ " no existe entre los registros de usuario");
    }
}

package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception;

public class RutinaYaExiste extends RuntimeException {
    public RutinaYaExiste(String nombre) {
        super("La rutina con este nombre ya existe");
    }
}

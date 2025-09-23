package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception;

public class RutinaNotFound extends RuntimeException {
    public RutinaNotFound(Long codigo) {
        super("La rutina con codigo "+codigo+" no existe");
    }
}

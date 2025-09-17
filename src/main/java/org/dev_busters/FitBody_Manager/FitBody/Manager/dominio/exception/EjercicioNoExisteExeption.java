package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception;

public class EjercicioNoExisteExeption extends RuntimeException {
    public EjercicioNoExisteExeption(Long IdEjercicio) {

      super("El ejercicio con id " + " no existe");
    }
}

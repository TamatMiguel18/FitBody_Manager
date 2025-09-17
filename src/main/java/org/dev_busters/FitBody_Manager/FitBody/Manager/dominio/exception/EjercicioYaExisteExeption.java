package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception;

public class EjercicioYaExisteExeption extends RuntimeException {
    public EjercicioYaExisteExeption(String nombreEjercicio) {

        super(nombreEjercicio + " ya existe");
    }
}

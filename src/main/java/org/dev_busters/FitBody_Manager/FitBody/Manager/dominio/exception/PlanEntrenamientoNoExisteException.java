package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception;

public class PlanEntrenamientoNoExisteException extends RuntimeException {
    public PlanEntrenamientoNoExisteException(Long IdPlanEntrenamento) {

        super("El Plan de Entrenamiento con id " + " no existe");
    }
}

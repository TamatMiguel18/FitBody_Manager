package org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception;

public class PlanEntrenamientoYaExisteException extends RuntimeException {
    public PlanEntrenamientoYaExisteException(String IdPlanEntrenamiento) {

        super("El Plan de Entrenamiento con id " + " ya existe");
    }
}

package org.dev_busters.FitBody_Manager.FitBody.Manager.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.EjercicioDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.service.EjercicioService;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component("ejercicioFormController")
@Data
@ViewScoped
public class EjercicioFrontendController implements Serializable {

    @Autowired
    private EjercicioService ejercicioService;
    private List<EjercicioDto> listaEjercicios;
    private EjercicioDto ejercicio;

    @PostConstruct
    public void init(){
        cargarDatos();
    }

    public void cargarDatos(){
        this.listaEjercicios = this.ejercicioService.obtenerTodo();
    }

    public void agregarEjercicio(){
        this.ejercicio = new EjercicioDto();
    }

    public void guardarEjercicio() {
        if (this.ejercicio.getIdEjercicio() == null) {
            this.ejercicioService.guardarEjercicio(this.ejercicio);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ejercicio agregado con exito"));
        } else {
            this.ejercicioService.modificarEjercicio(this.ejercicio.getIdEjercicio(), this.ejercicio);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ejercicio actualizado con exito"));
        }

        cargarDatos();

        PrimeFaces.current().ajax().update("formulario-ejercicios:mensaje-emergente", "formulario-ejercicios:tabla-ejercicios");
        PrimeFaces.current().executeScript("PF('ventanaModalEjercicio').hide()");

        this.ejercicio = null;
    }

    public void eliminarEjercicio() {
        if (this.ejercicio != null && this.ejercicio.getIdEjercicio() != null) {
            this.ejercicioService.eliminarEjercicio(this.ejercicio.getIdEjercicio());
            this.cargarDatos();
            this.ejercicio = null;

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ejercicio eliminado con exito"));
            PrimeFaces.current().ajax().update("formulario-ejercicios:mensaje-emergente", "formulario-ejercicios:tabla-ejercicios");
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se puede eliminar el ejercicio. El ID es nulo."));
        }
    }
    }
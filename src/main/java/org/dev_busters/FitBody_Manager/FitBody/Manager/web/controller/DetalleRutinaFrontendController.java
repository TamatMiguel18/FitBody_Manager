package org.dev_busters.FitBody_Manager.FitBody.Manager.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.DetalleRutinaDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.service.DetalleRutinaService;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component("detalleRutinaFormController")
@Data
@ViewScoped
public class DetalleRutinaFrontendController implements Serializable {

    @Autowired
    private DetalleRutinaService detalleRutinaService;

    private List<DetalleRutinaDto> listaDetalleRutinas;
    private DetalleRutinaDto detalleRutina;

    @PostConstruct
    public void init() {
        cargarDatos();
    }

    public void cargarDatos() {
        this.listaDetalleRutinas = this.detalleRutinaService.obtenerTodos();
    }

    public void agregarDetalleRutina() {
        this.detalleRutina = new DetalleRutinaDto();
    }

    public void guardarDetalleRutina() {
        if (this.detalleRutina.getIdDetallerRunina() == null) {
            this.detalleRutinaService.guardarDetalleRutina(this.detalleRutina);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Detalle de rutina agregado con éxito"));
        } else {
            this.detalleRutinaService.guardarDetalleRutina(this.detalleRutina);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Detalle de rutina actualizado"));
        }

        PrimeFaces.current().executeScript("PF('ventanaModalDetalleRutina').hide()");
        PrimeFaces.current().ajax().update("formulario-detalle-rutina:mensaje-emergente", "formulario-detalle-rutina:tabla-detalle-rutina");
        this.detalleRutina = null;
    }

    public void eliminarDetalleRutina() {
        this.detalleRutinaService.eliminarDetalleRutina(this.detalleRutina.getIdDetallerRunina());
        this.listaDetalleRutinas.remove(this.detalleRutina);
        this.detalleRutina = null;

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Detalle de rutina eliminado con éxito"));
        PrimeFaces.current().ajax().update("formulario-detalle-rutina:mensaje-emergente", "formulario-detalle-rutina:tabla-detalle-rutina");
    }
}

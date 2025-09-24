package org.dev_busters.FitBody_Manager.FitBody.Manager.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.RegistroDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.UsuarioDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.service.RegistroService;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component("registroFormController")
@Data
@ViewScoped
public class RegistroFrontendController implements Serializable {

    @Autowired
    private RegistroService registroService;
    private List<RegistroDto> listaRegistros;
    private RegistroDto registro;

    @PostConstruct
    public void init() {
        this.registro = new RegistroDto();
        this.registro.setUsuario(new UsuarioDto());
        cargarDatos();
    }

    public void cargarDatos(){
        this.listaRegistros = this.registroService.listarRegistros();
    }

    public void agregarRegistro(){
        this.registro = new RegistroDto();
    }

    public void guardarRegistro() {
        if (this.registro.getIdRegistro() == null) {
            this.registroService.guardarRegistro(this.registro);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro agregado con exito"));
        } else {
            this.registroService.guardarRegistro(this.registro);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro actualizado"));
        }
        PrimeFaces.current().executeScript("PF('ventanaModalRegistros').hide()");
        PrimeFaces.current().ajax().update("formulario-registros:mensaje-emergente", "formulario-registros:tabla-registros");
        this.registro = null;
    }

    public void eliminarRegistro() {
        this.registroService.eliminarRegistro(this.registro.getIdRegistro());
        this.listaRegistros.remove(this.registro);
        this.registro = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro eliminado con exito"));
        PrimeFaces.current().ajax().update("formulario-registros:mensaje-emergente", "formulario-registros:tabla-registros");
    }
}

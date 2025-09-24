package org.dev_busters.FitBody_Manager.FitBody.Manager.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.UsuarioDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.service.UsuarioService;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component("usuarioFormController")
@Data
@ViewScoped
public class UsuarioFrontEndController implements Serializable {

    @Autowired
    private UsuarioService usuarioService;
    private List<UsuarioDto> listaUsuarios;
    private UsuarioDto usuario;

    @PostConstruct
    public void init() {
        cargarDatos();
    }

    public void cargarDatos() {
        this.listaUsuarios = this.usuarioService.obtenerTodos();
    }

    public void agregarUsuario() {
        this.usuario = new UsuarioDto();
    }

    public void guardarUsuario() {
        if (this.usuario.getIdUsuario() == null) {
            this.usuarioService.guardarUsuario(this.usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario agregado con exito"));
        } else {
            this.usuarioService.guardarUsuario(this.usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario actualizado"));
        }
        PrimeFaces.current().executeScript("PF('ventanaModalUsuarios').hide()");
        PrimeFaces.current().ajax().update("formulario-usuarios:mensaje-emergente", "formulario-usuarios:tabla-usuarios");
        this.usuario = null;
    }

    public void eliminarUsuario() {
        this.usuarioService.eliminarUsuario(this.usuario.getIdUsuario());
        this.listaUsuarios.remove(this.usuario);
        this.usuario = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario eliminado con exito"));
        PrimeFaces.current().ajax().update("formulario-usuarios:mensaje-emergente", "formulario-usuarios:tabla-usuarios");
    }
}
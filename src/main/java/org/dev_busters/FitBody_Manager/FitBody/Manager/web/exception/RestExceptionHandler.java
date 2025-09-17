package org.dev_busters.FitBody_Manager.FitBody.Manager.web.exception;

import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception.Error;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception.RegistroNotFound;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.exception.RegistroYaExiste;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {

    //Excepcion para capturar cuando un registo ya existe en el sistema
    @ExceptionHandler(RegistroYaExiste.class)
    public ResponseEntity<Error> handlerException(RegistroYaExiste e) {
        Error error = new Error("Registro ya existente", e.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    //Excepcion para capturar cuando un registro no se encuentra en el sistema
    @ExceptionHandler(RegistroNotFound.class)
    public ResponseEntity<Error> handlerException(RegistroNotFound e) {
        Error error = new Error("Pelicula no encontrada", e.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    //Excepcion para capturar errores de validacion de argumentos en los controladores
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handlerException(MethodArgumentNotValidException e){
        List<Error> errores = new ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errores.add(new Error(fieldError.getField(), fieldError.getDefaultMessage()));
        });
        return ResponseEntity.badRequest().body(errores);
    }

    //Excepcion para capturar cualquier error
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handlerException(Exception e){
        Error error = new Error("Error desconocido", e.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}

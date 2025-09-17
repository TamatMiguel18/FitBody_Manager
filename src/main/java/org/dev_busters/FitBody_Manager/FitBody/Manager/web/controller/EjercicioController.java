package org.dev_busters.FitBody_Manager.FitBody.Manager.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.EjercicioDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModEjercicioDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.service.EjercicioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ejercicios")
@Tag(name = "Ejercicio", description = "Operaciones Crud Ejercicios")
public class EjercicioController {
    private final EjercicioService ejercicioService;

    public EjercicioController(EjercicioService ejercicioService){
        this.ejercicioService = ejercicioService;
    }

    @GetMapping
    public ResponseEntity<List<EjercicioDto>> obteneEjercicio(){
        return ResponseEntity.ok(this.ejercicioService.obtenerTodo());
    }

    @GetMapping("{idEjercicio}")

    @Operation(
            summary = "Obtener ejercicio por si id",
            description = "Retornar el ejercicio que coincida con el id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ejercicio Encontrado"),
                    @ApiResponse(responseCode = "404", description = "Ejercicio no Encontrado", content = @Content)
            }
    )
    public ResponseEntity<EjercicioDto> buscarPorId(@Parameter(description = "Id del ejercicio a recuperar", example = "7")@PathVariable Long idEjercicio){
        return ResponseEntity.ok(this.ejercicioService.buscarPorId(idEjercicio));
    }

    @PostMapping
    public ResponseEntity<EjercicioDto>guardarEjercicio(@RequestBody @Valid EjercicioDto ejercicioDto){
        //retornar una respuesta de creacion de entidad dentro del RepositoryEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(this.ejercicioService.guardarEjercicio(ejercicioDto));
    }

    @PutMapping("{idEjercicio}")
    public ResponseEntity<EjercicioDto> modificarEjercicio(@PathVariable Long idEjercicio, @RequestBody ModEjercicioDto modEjercicioDto){
        return ResponseEntity.ok(this.ejercicioService.modificarEjercicio(idEjercicio,modEjercicioDto));
    }

    @DeleteMapping("{idEjercicio}")
    public ResponseEntity<Void>eliminarEjercicio(@PathVariable Long idEjercicio){
        this.ejercicioService.eliminarEjercicio(idEjercicio);
        return ResponseEntity.ok().build();
    }

}

package org.dev_busters.FitBody_Manager.FitBody.Manager.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModPlanEntrenamientoDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.PlanEntrenamientoDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.service.PlanEntrenamientoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planes")
@Tag(name = "PlanEntrenamiento", description = "Operaciones Crud Planes de Entrenamiento")
public class PlanEntrenamientoController {
    private final PlanEntrenamientoService planEntrenamientoService;

    public PlanEntrenamientoController(PlanEntrenamientoService planEntrenamientoService){
        this.planEntrenamientoService = planEntrenamientoService;
    }

    @GetMapping
    public ResponseEntity<List<PlanEntrenamientoDto>> obtenerPlanes(){
        return ResponseEntity.ok(this.planEntrenamientoService.obtenerTodo());
    }

    @GetMapping("/{idPlan}")
    @Operation(
            summary = "Obtener plan de entrenamiento por su id",
            description = "Retorna el plan de entrenamiento que coincida con el id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Plan de Entrenamiento Encontrado"),
                    @ApiResponse(responseCode = "404", description = "Plan de Entrenamiento no Encontrado", content = @Content)
            }
    )
    public ResponseEntity<PlanEntrenamientoDto> buscarPorId(@Parameter(description = "Id del plan de entrenamiento a recuperar", example = "1") @PathVariable Long idPlan){
        return ResponseEntity.ok(this.planEntrenamientoService.buscarPorId(idPlan));
    }

    @PostMapping
    public ResponseEntity<PlanEntrenamientoDto> guardarPlanEntrenamiento(@RequestBody @Valid PlanEntrenamientoDto planEntrenamientoDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.planEntrenamientoService.guardarPlanEntrenamiento(planEntrenamientoDto));
    }

    @PutMapping("/{idPlan}")
    public ResponseEntity<PlanEntrenamientoDto> modificarPlanEntrenamiento(@PathVariable Long idPlan, @RequestBody ModPlanEntrenamientoDto modPlanEntrenamientoDto){
        return ResponseEntity.ok(this.planEntrenamientoService.modificarPlanEntrenamiento(idPlan, modPlanEntrenamientoDto));
    }

    @DeleteMapping("/{idPlan}")
    public ResponseEntity<Void> eliminarPlanEntrenamiento(@PathVariable Long idPlanEntrenamiento){
        this.planEntrenamientoService.eliminarPlanEntrenamiento(Math.toIntExact(idPlanEntrenamiento));
        return ResponseEntity.ok().build();
    }
}
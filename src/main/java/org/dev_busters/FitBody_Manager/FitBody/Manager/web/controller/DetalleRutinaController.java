package org.dev_busters.FitBody_Manager.FitBody.Manager.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.DetalleRutinaDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModDetalleRutinaDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.service.DetalleRutinaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/detalles-rutina")
@Tag(name = "Detalles de Rutina", description = "Operaciones CRUD para los detalles de las rutinas")
public class DetalleRutinaController {

    private final DetalleRutinaService detalleRutinaService;

    public DetalleRutinaController(DetalleRutinaService detalleRutinaService) {
        this.detalleRutinaService = detalleRutinaService;
    }

    @GetMapping
    public ResponseEntity<List<DetalleRutinaDto>> obtenerDetallesRutina() {
        return ResponseEntity.ok(this.detalleRutinaService.obtenerTodos());
    }

    @GetMapping("{Id}")
    @Operation(
            summary = "Obtener un detalle de rutina por su ID",
            description = "Retorna un detalle de rutina específico por su ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Detalle de rutina encontrado"),
                    @ApiResponse(responseCode = "404", description = "Detalle de rutina no encontrado", content = @Content)
            })
    public ResponseEntity<DetalleRutinaDto> buscarPorId
            (@Parameter(description = "Identificador del detalle de la rutina a recuperar", example = "1")
             @PathVariable Integer Id) {
        DetalleRutinaDto detalleRutina = this.detalleRutinaService.buscarPorId(Id);
        if (detalleRutina != null) {
            return ResponseEntity.ok(detalleRutina);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<DetalleRutinaDto> guardarDetalleRutina
            (@RequestBody @Valid DetalleRutinaDto detalleRutinaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).
                body(this.detalleRutinaService.guardarDetalleRutina(detalleRutinaDto));
    }

    @PutMapping("{Id}")
    public ResponseEntity<DetalleRutinaDto> modificarDetalleRutina
            (@PathVariable Integer Id, @RequestBody ModDetalleRutinaDto modDetalleRutinaDto) {
        DetalleRutinaDto detalleRutina = this.detalleRutinaService.modificarDetalleRutina(Id, modDetalleRutinaDto);
        if (detalleRutina != null) {
            return ResponseEntity.ok(detalleRutina);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{Id}")
    public ResponseEntity<Void> eliminarDetalleRutina(@PathVariable Integer Id) {
        this.detalleRutinaService.eliminarDetalleRutina(Id);
        return ResponseEntity.ok().build();
    }
}
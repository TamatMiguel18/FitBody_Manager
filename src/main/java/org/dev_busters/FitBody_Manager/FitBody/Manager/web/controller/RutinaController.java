package org.dev_busters.FitBody_Manager.FitBody.Manager.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModRegistroDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModRutinaDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.RutinaDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.service.RutinaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/Rutina")
@Tag(name = "Rutina", description = "Crud para manejar operaciones basicas como buscar, eliminar, editar o guardar rutinas")
public class RutinaController {
    private final RutinaService rutinaService;

    public RutinaController(RutinaService rutinaService) {
        this.rutinaService = rutinaService;
    }

    @GetMapping
    public ResponseEntity<List<RutinaDto>> listarRutinas(){
        return ResponseEntity.ok(this.rutinaService.obtenerTodo());
    }

    @GetMapping("{idRutina}")
    @Operation(
            summary = "Devulve una rutina por su id",
            description = "Se ingresa un id, y el programa retorna la rutina coincidente",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Rutina encontrado"),
                    @ApiResponse (responseCode = "404", description = "Rutina no encontrado", content = @Content)
            }
    )
    public ResponseEntity<RutinaDto> listarRutinaPorId(
            @Parameter(description = "Identificador para poder retornar la rutina correspondiente", example = "1")
            @PathVariable Long idRutina){
        return ResponseEntity.ok(this.rutinaService.buscarPorCodigo(idRutina));
    }

    @PostMapping
    public ResponseEntity<RutinaDto> agregarRutina(@RequestBody RutinaDto rutinaDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.rutinaService.guardarRutina(rutinaDto));
    }

    @PutMapping("{idRutina}")
    public ResponseEntity<RutinaDto> modificarRutina(@PathVariable Long idRutina, @RequestBody ModRutinaDto modRutinaDto){
        return ResponseEntity.ok().body(this.rutinaService.modificarRutina(idRutina, modRutinaDto));
    }

    @DeleteMapping("{idRutina}")
    public ResponseEntity<Void> eliminarRutina(@PathVariable Long idRutina){
        this.rutinaService.eliminarRutina(idRutina);
        return ResponseEntity.badRequest().build();
    }
}

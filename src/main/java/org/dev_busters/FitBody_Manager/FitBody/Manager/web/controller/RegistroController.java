package org.dev_busters.FitBody_Manager.FitBody.Manager.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.RegistroDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.service.RegistroService;
import org.dev_busters.FitBody_Manager.FitBody.Manager.repository.RegistroRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.Path;

import java.util.List;

@RestController
@RequestMapping("/v1/Registro")
@Tag(name = "Registro", description = "Crud para manejar operaciones basicas como buscar, eliminar, editar o guardar registros")
public class    RegistroController {
    private final RegistroService registroService;

    public RegistroController(RegistroService registroService) {
        this.registroService = registroService;
    }

    @GetMapping
    public ResponseEntity<List<RegistroDto>> listarRegistros(){
        return ResponseEntity.ok(this.registroService.listarRegistros());
    }

    @GetMapping("{idRegistro}")
    @Operation(
            summary = "Devulve un registro por su id",
            description = "Se ingresa un id, y el programa retorna el registro coincidente",
            responses = {
                    @ApiResponse (responseCode = "200", description = "Registro encontrado"),
                    @ApiResponse (responseCode = "404", description = "Registro no encontrado", content = @Content)
            }
    )
    public ResponseEntity<RegistroDto> buscarRegistroPorId(
            @Parameter(description = "Identificador para buscar el registro", example = "1")
            @PathVariable Long idRegistro){
        return ResponseEntity.ok(this.registroService.buscarRegistroPorId(idRegistro));
    }

    @PostMapping
    public ResponseEntity<RegistroDto> agregarRegistro(@RequestBody @Valid RegistroDto registroDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.registroService.guardarRegistro(registroDto));
    }

    @PutMapping("{idRegistro}")
    public ResponseEntity<RegistroDto> modificarRegistro(@PathVariable Long idRegistro, @RequestBody RegistroDto registroDto){
        return ResponseEntity.ok().body(this.registroService.modificarRegistro(idRegistro, registroDto));
    }

    @DeleteMapping("{idRegistro}")
    public ResponseEntity<Void> eliminarRegistro(Long codigo){
        this.registroService.eliminarRegistro(codigo);
        return ResponseEntity.ok().build();
    }
}

package org.dev_busters.FitBody_Manager.FitBody.Manager.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.UsuarioDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.dto.ModUsuarioDto;
import org.dev_busters.FitBody_Manager.FitBody.Manager.dominio.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/usuarios")
@Tag(name = "Usuarios", description = "Operaciones CRUD para usuarios en FitBody")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //ResponseEntity: manejar las respuestas HTTP
    @GetMapping
    public ResponseEntity<List<UsuarioDto>> obtenerPeliculas() {
        //HTTP: 404: no se encontro,
        //      405: Metodo no permitido
        //      500: Error de logica de trabajo o interno
        //      200: ok
        return ResponseEntity.ok(this.usuarioService.obtenerTodos());
    }

    // Buscar un usuario por Id
    @GetMapping("{Id}")
    @Operation(
            summary = "Obtener un usuario por su ID",
            description = "Retorna un usuario específico por su ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Usuario encontrado"),
                    @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = @Content)
            })

    public ResponseEntity<UsuarioDto> buscarPorId
         (@Parameter(description = "Identificador del usuario a recuperar", example = "1")
            @PathVariable Long Id) {
        return ResponseEntity.ok(this.usuarioService.buscarPorId(Id));
    }

    // Guardar un usuario
    @PostMapping
    public ResponseEntity<UsuarioDto> guardarUsuario
    (@RequestBody @Valid UsuarioDto usuarioDto) {
        //retornar una respuesta de creacion
        return ResponseEntity.status(HttpStatus.CREATED).
                body(this.usuarioService.guardarUsuario(usuarioDto));
    }

    // Modificar un usuario existente
    @PutMapping("{Id}")
    public ResponseEntity<UsuarioDto> modificarUsuario
    (@PathVariable Long Id, @RequestBody ModUsuarioDto modUsuarioDto) {
        return ResponseEntity.ok(this.usuarioService.modificarUsuario(Id, modUsuarioDto));
    }

    // Eliminar un usuario
    @DeleteMapping("{Id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long Id) {
        this.usuarioService.eliminarUsuario(Id);
        return ResponseEntity.ok().build();
    }
}


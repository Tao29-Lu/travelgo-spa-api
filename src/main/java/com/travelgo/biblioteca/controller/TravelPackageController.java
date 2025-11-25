package com.travelgo.biblioteca.controller;

import com.travelgo.biblioteca.model.TravelPackage;
import com.travelgo.biblioteca.service.TravelPackageService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/packages")
public class TravelPackageController {

    private final TravelPackageService service;

    public TravelPackageController(TravelPackageService service) {
        this.service = service;
    }

    @Operation(summary = "Listar paquetes", description = "Devuelve todos los paquetes turísticos")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = TravelPackage.class))))
    @GetMapping
    public List<TravelPackage> findAll() {
        return service.findAll();
    }

    @Operation(summary = "Obtener paquete por id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Encontrado",
                    content = @Content(schema = @Schema(implementation = TravelPackage.class))),
            @ApiResponse(responseCode = "404", description = "No encontrado")
    })
    @GetMapping("/{id}")
    public TravelPackage findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @Operation(summary = "Buscar paquetes por nombre")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/search")
    public List<TravelPackage> searchByName(@RequestParam String q) {
        return service.searchByName(q);
    }

    @Operation(summary = "Crear paquete")
    @ApiResponse(responseCode = "201", description = "Creado")
    @PostMapping
    public ResponseEntity<TravelPackage> create(@Valid @RequestBody TravelPackage travelPackage) {
        TravelPackage created = service.create(travelPackage);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Operation(summary = "Actualizar paquete")
    @ApiResponse(responseCode = "200", description = "Actualizado")
    @PutMapping("/{id}")
    public TravelPackage update(@PathVariable Long id, @Valid @RequestBody TravelPackage travelPackage) {
        return service.update(id, travelPackage);
    }

    @Operation(summary = "Eliminar paquete")
    @ApiResponse(responseCode = "204", description = "Eliminado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

package com.fmt.app.tutoring.controllers;

import com.fmt.app.tutoring.entities.GenericEntity;
import com.fmt.app.tutoring.interfaces.IGenericController;
import com.fmt.app.tutoring.interfaces.IGenericService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public abstract class GenericController<T extends GenericEntity> implements IGenericController<T> {

    protected final IGenericService<T> service;

    @Override
    @PostMapping
    @Operation(summary = "Criar")
    public ResponseEntity<T> create(@RequestBody T entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(entity));
    }

    @Override
    @GetMapping("list")
    @Operation(summary = "Listar")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) })
    })
    public ResponseEntity<List<T>> list() {
        return ResponseEntity.ok(service.findAll());
    }
    @Override
    @GetMapping("{id}")
    @Operation(summary = "Buscar")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) })
    })
    public ResponseEntity<T> listById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }


    @Override
    @Operation(summary = "Deletar")
    @DeleteMapping("delete/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Removed",content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) })
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


    @Override
    @PutMapping()
    @Operation(summary = "Atualizar")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) })
    })
    public ResponseEntity<T> update(T entity) {
        return ResponseEntity.ok(service.update(entity));
    }
}

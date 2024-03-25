package com.fmt.app.tutoring.controllers;

import com.fmt.app.tutoring.entities.Agenda;
import com.fmt.app.tutoring.services.AgendaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name="Agendas")
@RestController
@RequestMapping(value = "agenda")
public class AgendaController extends GenericController<Agenda> {
    protected final AgendaService service;
    public AgendaController(AgendaService service) {
        super(service);
        this.service = service;
    }


    @GetMapping("aluno-id/{alunoId}")
    @Operation(summary = "Buscar Por Aluno")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) })
    })
    public ResponseEntity<List<Agenda>> listByAlunoId(@PathVariable Long alunoId){
        return ResponseEntity.ok(service.findByAlunoId(alunoId));
    }

    @GetMapping("aluno-id/{alunoId}/futuros")
    @Operation(summary = "Buscar Próximos Por Aluno")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) })
    })
    public ResponseEntity<List<Agenda>> listNextByAlunoId(@PathVariable Long alunoId){
        return ResponseEntity.ok(service.findNextByAlunoId(alunoId));
    }

    @GetMapping("tutor-id/{tutorId}")
    @Operation(summary = "Buscar Por Tutor")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) })
    })
    public ResponseEntity<List<Agenda>> listByTutorId(@PathVariable Long tutorId){
        return ResponseEntity.ok(service.findByTutorId(tutorId));
    }

    @GetMapping("tutor-id/{tutorId}/futuros")
    @Operation(summary = "Buscar Próximos Por Tutor")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) })
    })
    public ResponseEntity<List<Agenda>> listNextByTutorId(@PathVariable Long tutorId){
        return ResponseEntity.ok(service.findNextByTutorId(tutorId));
    }


}

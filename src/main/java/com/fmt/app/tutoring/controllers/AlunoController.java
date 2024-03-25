package com.fmt.app.tutoring.controllers;

import com.fmt.app.tutoring.entities.Aluno;
import com.fmt.app.tutoring.interfaces.IGenericService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;


@Tag(name="Alunos")
@RestController
@RequestMapping(value = "aluno")
public class AlunoController extends GenericController<Aluno> {
    public AlunoController(IGenericService<Aluno> service) {
        super(service);
    }
}

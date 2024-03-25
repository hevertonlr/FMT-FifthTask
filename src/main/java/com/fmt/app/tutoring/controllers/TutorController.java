package com.fmt.app.tutoring.controllers;

import com.fmt.app.tutoring.entities.Tutor;
import com.fmt.app.tutoring.interfaces.IGenericService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Tutores")
@RestController
@RequestMapping(value = "tutor")
public class TutorController extends GenericController<Tutor> {
    public TutorController(IGenericService<Tutor> service) {
        super(service);
    }
}

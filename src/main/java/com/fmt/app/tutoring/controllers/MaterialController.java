package com.fmt.app.tutoring.controllers;

import com.fmt.app.tutoring.entities.Material;
import com.fmt.app.tutoring.interfaces.IGenericService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Materiais")
@RestController
@RequestMapping(value = "material")
public class MaterialController extends GenericController<Material> {
    public MaterialController(IGenericService<Material> service) {
        super(service);
    }
}

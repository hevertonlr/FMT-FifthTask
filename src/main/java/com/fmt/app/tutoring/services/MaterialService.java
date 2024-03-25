package com.fmt.app.tutoring.services;

import com.fmt.app.tutoring.entities.Material;
import com.fmt.app.tutoring.interfaces.IGenericRepository;
import org.springframework.stereotype.Service;

@Service
public class MaterialService extends GenericService<Material> {
    public MaterialService(IGenericRepository<Material> repository) {
        super(repository);
    }
}

package com.fmt.app.tutoring.repositories;

import com.fmt.app.tutoring.entities.Material;
import com.fmt.app.tutoring.interfaces.IGenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends IGenericRepository<Material> {
}

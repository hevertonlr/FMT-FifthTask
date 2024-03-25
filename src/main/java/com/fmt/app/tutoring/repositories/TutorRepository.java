package com.fmt.app.tutoring.repositories;

import com.fmt.app.tutoring.entities.Tutor;
import com.fmt.app.tutoring.interfaces.IGenericRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TutorRepository extends IGenericRepository<Tutor> {
}

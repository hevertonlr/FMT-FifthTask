package com.fmt.app.tutoring.services;

import com.fmt.app.tutoring.entities.Tutor;
import com.fmt.app.tutoring.interfaces.IGenericRepository;
import org.springframework.stereotype.Service;

@Service
public class TutorService extends GenericService<Tutor> {
    public TutorService(IGenericRepository<Tutor> repository) {
        super(repository);
    }
}

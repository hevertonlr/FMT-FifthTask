package com.fmt.app.tutoring.services;

import com.fmt.app.tutoring.entities.Aluno;
import com.fmt.app.tutoring.interfaces.IGenericRepository;
import org.springframework.stereotype.Service;

@Service
public class AlunoService extends GenericService<Aluno> {
    public AlunoService(IGenericRepository<Aluno> repository) {
        super(repository);
    }
}

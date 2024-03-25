package com.fmt.app.tutoring.repositories;

import com.fmt.app.tutoring.entities.Aluno;
import com.fmt.app.tutoring.interfaces.IGenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends IGenericRepository<Aluno> {
}

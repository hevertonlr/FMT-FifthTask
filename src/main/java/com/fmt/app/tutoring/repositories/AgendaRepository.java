package com.fmt.app.tutoring.repositories;

import com.fmt.app.tutoring.entities.Agenda;
import com.fmt.app.tutoring.interfaces.IGenericRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendaRepository extends IGenericRepository<Agenda> {
    List<Agenda> findByAlunoIdOrderByDataAgendamento(Long alunoId);
    List<Agenda> findByAlunoIdAndDataAgendamentoGreaterThanOrderByDataAgendamento(Long alunoId, LocalDateTime data);
    List<Agenda> findByTutorIdOrderByDataAgendamento(Long tutorId);
    List<Agenda> findByTutorIdAndDataAgendamentoGreaterThanOrderByDataAgendamento(Long tutorId, LocalDateTime data);
}

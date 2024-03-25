package com.fmt.app.tutoring.services;

import com.fmt.app.tutoring.entities.Agenda;
import com.fmt.app.tutoring.entities.Aluno;
import com.fmt.app.tutoring.entities.Tutor;
import com.fmt.app.tutoring.interfaces.IGenericRepository;
import com.fmt.app.tutoring.interfaces.IGenericService;
import com.fmt.app.tutoring.repositories.AgendaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendaService extends GenericService<Agenda> {
    protected final AgendaRepository repository;
    protected final TutorService tutorService;
    protected final AlunoService alunoService;
    public AgendaService(AgendaRepository repository,
                         TutorService tutorService,
                         AlunoService alunoService) {
        super(repository);
        this.repository = repository;
        this.tutorService = tutorService;
        this.alunoService = alunoService;
    }

    public Agenda insert(Agenda entity) {
        entity.setId(null);
        Aluno aluno = alunoService.findById(entity.getAluno().getId());
        entity.setAluno(aluno);

        Tutor tutor = tutorService.findById(entity.getTutor().getId());
        entity.setTutor(tutor);

        return repository.save(entity);
    }

    public Agenda update(Long id, Agenda entity) {
        findById(id);
        entity.setId(id);

        Aluno aluno = alunoService.findById(entity.getAluno().getId());
        entity.setAluno(aluno);

        Tutor tutor = tutorService.findById(entity.getTutor().getId());
        entity.setTutor(tutor);

        return repository.save(entity);
    }

    public List<Agenda> findByAlunoId(Long alunoId){
        alunoService.findById(alunoId);
        return repository.findByAlunoIdOrderByDataAgendamento(alunoId);
    }

    public List<Agenda> findNextByAlunoId(Long alunoId){
        alunoService.findById(alunoId);
        return repository.findByAlunoIdAndDataAgendamentoGreaterThanOrderByDataAgendamento(alunoId, LocalDateTime.now());
    }

    public List<Agenda> findByTutorId(Long tutorId){
        tutorService.findById(tutorId);
        return repository.findByTutorIdOrderByDataAgendamento(tutorId);
    }

    public List<Agenda> findNextByTutorId(Long tutorId){
        tutorService.findById(tutorId);
        return repository.findByTutorIdAndDataAgendamentoGreaterThanOrderByDataAgendamento(tutorId, LocalDateTime.now());
    }
}

package com.fmt.app.tutoring.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fmt.app.tutoring.enums.StatusAgendamento;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@DynamicUpdate
@Table(name = "agenda")
@EqualsAndHashCode(callSuper = true)
public class Agenda extends GenericEntity {

    @Column(name = "data_agendamento", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataAgendamento;
    @Enumerated(EnumType.ORDINAL)
    private StatusAgendamento statusAgendamento;
    private String tema;
    @Column(columnDefinition = "TEXT")
    private String descricao;


    @ManyToOne
    @JsonIgnoreProperties("agendas")
    @JoinColumn(name="id_aluno",nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JsonIgnoreProperties("agendas")
    @JoinColumn(name="id_tutor",nullable = false)
    private Tutor tutor;

    @JsonIgnoreProperties("agenda")
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "agenda", fetch = FetchType.EAGER)
    private List<Material> materiais;

}


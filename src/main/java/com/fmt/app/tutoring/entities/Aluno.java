package com.fmt.app.tutoring.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;


@Data
@Entity
@DynamicUpdate
@Table(name = "aluno")
@EqualsAndHashCode(callSuper = true)
public class Aluno extends GenericEntity {
    @NotBlank(message = "O nome é obrigatório")
    @Column(nullable = false)
    private String nome;

    @Setter(AccessLevel.NONE)
    @JsonIgnoreProperties("aluno")
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "aluno", fetch = FetchType.EAGER)
    private List<Agenda> agendas;
}

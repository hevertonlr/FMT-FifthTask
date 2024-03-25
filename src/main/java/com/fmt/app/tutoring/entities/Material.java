package com.fmt.app.tutoring.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;


@Data
@Entity
@DynamicUpdate
@Table(name = "material")
@EqualsAndHashCode(callSuper = true)
public class Material extends GenericEntity {

    @NotBlank(message = "O caminho do arquivo é obrigatório")
    @Column(nullable = false)
    private String caminhoArquivo;


    @ManyToOne
    @JoinColumn(name="id_agenda",nullable = false)
    private Agenda agenda;
}

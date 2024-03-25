package com.fmt.app.tutoring.entities;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@MappedSuperclass
public abstract class GenericEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Hidden
    @CreatedDate
    protected LocalDateTime createdAt;
    @Hidden
    @LastModifiedDate
    protected LocalDateTime modifyAt;
}

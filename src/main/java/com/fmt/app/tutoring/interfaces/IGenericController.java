package com.fmt.app.tutoring.interfaces;

import com.fmt.app.tutoring.entities.GenericEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IGenericController<T extends GenericEntity> {
    ResponseEntity<T> listById(Long id);
    ResponseEntity<List<T>> list();
    ResponseEntity<T> create(T entity);
    ResponseEntity<T> update(T entity);
    ResponseEntity<Void> delete(Long id);
}

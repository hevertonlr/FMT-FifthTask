package com.fmt.app.tutoring.interfaces;

import com.fmt.app.tutoring.entities.GenericEntity;

import java.util.List;

public interface IGenericService<T extends GenericEntity> {
    List<T> findAll();
    T findById(long id);
    T insert(T entity);
    T update(T entity);
    void delete(long id);
}

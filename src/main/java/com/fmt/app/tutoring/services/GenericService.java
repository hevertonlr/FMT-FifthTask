package com.fmt.app.tutoring.services;

import com.fmt.app.tutoring.entities.GenericEntity;
import com.fmt.app.tutoring.handlers.NotFoundException;
import com.fmt.app.tutoring.interfaces.IGenericRepository;
import com.fmt.app.tutoring.interfaces.IGenericService;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Service
public abstract class GenericService<T extends GenericEntity> implements IGenericService<T> {
    private final String entityName;
    protected final IGenericRepository<T> repository;

    public GenericService(IGenericRepository<T> repository) {
        this.repository = repository;
        ParameterizedType type =(ParameterizedType)getClass().getGenericSuperclass();
        this.entityName = ((Class) type.getActualTypeArguments()[0]).getSimpleName();
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T findById(long id) {
        return repository.findById(id).orElseThrow(() ->
                new NotFoundException(entityName+ " não encontrado com id: " + id));
    }

    @Override
    public T insert(T entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    @Override
    public T update(T entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(long id) {
        repository.findById(id)
                .ifPresentOrElse(
                        repository::delete,
                        ()-> { throw new NotFoundException(entityName + " não encontrado com id: " + id); });

    }


}

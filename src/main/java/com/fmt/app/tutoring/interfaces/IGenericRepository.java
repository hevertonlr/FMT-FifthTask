package com.fmt.app.tutoring.interfaces;

import com.fmt.app.tutoring.entities.GenericEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Qualifier("IGenericRepository")
@Repository
public interface IGenericRepository<T extends GenericEntity> extends JpaRepository<T, Long> {

}

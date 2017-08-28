package com.pritamprasad.spring_data_jpa.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

/**
 * To create a base repo which contains all common repository methods so that we
 * dont need to declare theses methods over and again in All DAO repositories
 * 
 * @author Pritam
 *
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {

	void delete(T deleted);

	List<T> findAll();

	Optional<T> findOne(ID id);

	T save(T persisted);
}

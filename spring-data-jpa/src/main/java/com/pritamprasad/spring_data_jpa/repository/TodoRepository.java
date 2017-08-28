package com.pritamprasad.spring_data_jpa.repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import com.pritamprasad.spring_data_jpa.dao.Todo;

public interface TodoRepository extends Repository<Todo, Long> {

	void delete(Todo deleted);

	List<Todo> findAll();

	Optional<Todo> findOne(Long id);

	Todo save(Todo persisted);


	@Query("SELECT t.title FROM Todo t where t.id = :id")
	String findTitleById(@Param("id") Long id);	
	
	/**
	 * Asynchronous query methods:
	 */ 
	@Async
	@Query("SELECT t.title FROM Todo t where t.id = :id")
	Future<String> findTitleById2(@Param("id") Long id);
	
	/**
	 * Named params
	 */
	@Query("SELECT t FROM Todo t where t.title = :title AND t.description = :description")
	public Optional<Todo> findByTitleAndDescription(@Param("title") String title,  @Param("description") String description);
	
	// nativeQuery : query method that uses SQL instead of JPQL.
	@Query(value = "SELECT * FROM todos t where t.title = :title AND t.description = :description", nativeQuery = true)
	public Optional<Todo> findByTitleAndDescription2(@Param("title") String title, @Param("description") String description);
	
	/**
	 * Position based params
	 */
	
	@Query("SELECT t FROM Todo t where t.title = ?1 AND t.description = ?2")
    public Optional<Todo> findByTitleAndDescription3(String title, String description);
	
	@Query(value = "SELECT * FROM todos t where t.title = ?0 AND t.description = ?1", nativeQuery = true)
	public Optional<Todo> findByTitleAndDescription4(String title, String description);
}

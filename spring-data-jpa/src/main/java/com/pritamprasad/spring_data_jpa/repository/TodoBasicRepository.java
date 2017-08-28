package com.pritamprasad.spring_data_jpa.repository;

import org.springframework.data.repository.CrudRepository;
import com.pritamprasad.spring_data_jpa.dao.Todo;

public interface TodoBasicRepository extends CrudRepository<Todo, Long>{
	

}

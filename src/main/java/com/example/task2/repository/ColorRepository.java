package com.example.task2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.task2.model.Color;  
@Repository
public interface ColorRepository extends CrudRepository<Color, Integer>{
	
	@Query(value="select c  from Color c")
	List<Color> findAllColors();
	
}

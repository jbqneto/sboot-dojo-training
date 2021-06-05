package com.jbqneto.dojo.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jbqneto.dojo.training.domain.model.Recipe;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepositoryImpl extends JpaRepository<Recipe, Integer> {
	
	List<Recipe> findByName(String name);
	List<Recipe> findByNameContaining(String name);
	
}

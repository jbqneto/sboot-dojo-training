package com.jbqneto.dojo.training.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jbqneto.dojo.training.domain.model.Recipe;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
	
	List<Recipe> findByName(String name);
	List<Recipe> findByNameContaining(String name);
	
}

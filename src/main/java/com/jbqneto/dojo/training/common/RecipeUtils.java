package com.jbqneto.dojo.training.common;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.jbqneto.dojo.training.domain.model.Recipe;
import com.jbqneto.dojo.training.repository.RecipeRepositoryImpl;

@Component
public class RecipeUtils {

	public Recipe findRecipeOrThrowNotFound(int id, RecipeRepositoryImpl repository) {
		return repository
				.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found"));
	}
	
}

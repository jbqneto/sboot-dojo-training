package com.jbqneto.dojo.training.commons;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.jbqneto.dojo.training.domain.Recipe;
import com.jbqneto.dojo.training.repository.RecipeRepository;

public class RecipeUtils {

	public Recipe findRecipeOrThrowNotFound(int id, RecipeRepository repository) {
		return repository
				.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found"));
	}
	
}

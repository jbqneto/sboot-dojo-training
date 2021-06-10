package com.jbqneto.dojo.training.domain.service;

import java.util.List;

import com.jbqneto.dojo.training.application.repository.RecipeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jbqneto.dojo.training.domain.model.Recipe;

import lombok.RequiredArgsConstructor;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class RecipeService {

	private final RecipeRepository recipeRepository;
	
	public List<Recipe> listAll() {
		return recipeRepository.findAll();
	}

	public Recipe findById(long id) {
		return recipeRepository
				.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found"));
	}
	
	public void update(Recipe recipe) {
		recipeRepository.save(recipe);
	}
	
	public List<Recipe> findByName(String name) {
		return recipeRepository.findByNameContaining(name);
	}
	
	public void delete(long id) {
		Recipe recipe = findById(id);
		recipeRepository.delete(recipe);
	}
	
	public Recipe save(Recipe recipe) {
		return recipeRepository.save(recipe);
	}

}

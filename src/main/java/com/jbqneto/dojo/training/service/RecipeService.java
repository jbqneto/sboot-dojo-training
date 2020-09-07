package com.jbqneto.dojo.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import com.jbqneto.dojo.training.commons.RecipeUtils;
import com.jbqneto.dojo.training.domain.Ingredient;
import com.jbqneto.dojo.training.domain.Recipe;
import com.jbqneto.dojo.training.repository.RecipeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RecipeService {
	
	private final RecipeUtils recipeUtils;
	private final RecipeRepository repository;
	
	public List<Recipe> listAll() {
		return repository.findAll();
	}

	public Recipe findById(int id) {
		return recipeUtils.findRecipeOrThrowNotFound(id, repository);
	}
	
	public Recipe update(Recipe recipe) {
		Recipe recipeFound = findById(recipe.getId());
		recipeFound.setName(recipe.getName());
		return recipe;
	}
	
	public void delete(int id) {
		Recipe recipe = recipeUtils.findRecipeOrThrowNotFound(id, repository);
		repository.delete(recipe);
	}
	
	public Recipe save(Recipe recipe) {
		return repository.save(recipe);
	}

}

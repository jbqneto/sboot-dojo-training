package com.jbqneto.dojo.training.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jbqneto.dojo.training.commons.RecipeUtils;
import com.jbqneto.dojo.training.domain.Recipe;
import com.jbqneto.dojo.training.repository.RecipeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RecipeService {
	
	private final RecipeUtils recipeUtils;
	private final RecipeRepository repository;
	
	public List<Recipe> listAll() {
		return repository.findAll();
	}

	public Recipe findById(int id) {
		return recipeUtils.findRecipeOrThrowNotFound(id, repository);
	}
	
	public void update(Recipe recipe) {
		repository.save(recipe);
	}
	
	public List<Recipe> findByName(String name) {
		return repository.findByNameContaining(name);
	}
	
	public void delete(int id) {
		Recipe recipe = recipeUtils.findRecipeOrThrowNotFound(id, repository);
		repository.delete(recipe);
	}
	
	public Recipe save(Recipe recipe) {
		return repository.save(recipe);
	}

}

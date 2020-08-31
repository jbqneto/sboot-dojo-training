package com.jbqneto.dojo.training.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import com.jbqneto.dojo.training.domain.Ingredient;
import com.jbqneto.dojo.training.domain.Recipe;

@Repository
public class RecipeRepository {
	
	private static List<Recipe> recipes = new ArrayList<Recipe>();
	
	public List<Recipe> listAll() {
		return recipes;
	}

	public Recipe findById(int id) {
		return recipes.stream()
				.filter(recipe -> recipe.getId() == id)
				.findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found"));
	}
	
	public Recipe update(Recipe recipe) {
		int pos = -1;
		for (int i=0; i < recipes.size(); i++) {
			if (recipes.get(i).getId() == recipe.getId())
				pos = i;
		}
		
		if (pos == -1)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found");
		
		recipes.set(pos, recipe);
		
		return recipe;
	}
	
	public void delete(int id) {
		Recipe recipe = recipes.stream()
			.filter(filteredRecipe -> filteredRecipe.getId() == id)
			.findFirst()
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe Not found"));
		
		recipes.remove(recipe);
	}
	
	public Recipe save(Recipe recipe) {
		Recipe latest = recipes.get(recipes.size() -1);
		recipe.setId(latest.getId() + 1);
		recipes.add(recipe);
		return recipe;
	}

}

package com.jbqneto.dojo.training.application.controller;

import com.jbqneto.dojo.training.application.mapper.RecipeMapper;
import com.jbqneto.dojo.training.application.representation.RecipeRepresentation;
import com.jbqneto.dojo.training.domain.model.Recipe;
import com.jbqneto.dojo.training.domain.service.IngredientService;
import com.jbqneto.dojo.training.domain.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.jbqneto.dojo.training.application.mapper.RecipeMapper.toDomain;
import static com.jbqneto.dojo.training.application.mapper.RecipeMapper.toRepresentation;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/recipes")
public class RecipeController {

	private final RecipeService recipeService;
	private final IngredientService ingredientService;

	@GetMapping
	public ResponseEntity<List<RecipeRepresentation>> list() {
		List<RecipeRepresentation> recipes = recipeService.listAll()
				.stream()
				.map(recipe -> toRepresentation(recipe)).collect(Collectors.toList());

		return ResponseEntity.ok(recipes);
	}
	
	@GetMapping("/{recipeId}")
	public ResponseEntity<RecipeRepresentation> findById(@PathVariable long recipeId) {
		Recipe recipe = recipeService.findById(recipeId);
		return ResponseEntity.ok(toRepresentation(recipe));
	} 
	
	@GetMapping("/find")
	public ResponseEntity<List<RecipeRepresentation>> findByName(@RequestParam String name) {
		List<Recipe> recipe = recipeService.findByName(name);

		return ResponseEntity.ok(
				recipe.stream().map(RecipeMapper::toRepresentation)
				.collect(Collectors.toList())
		);
	}
	
	@DeleteMapping("/{recipeId}")
	public ResponseEntity<Void> delete(@PathVariable int recipeId) {
		Recipe recipe = recipeService.findById(recipeId);

		ingredientService.deleteAll(recipe.getItems());

		recipeService.delete(recipeId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{recipeId}")
	public ResponseEntity<Void> update(@PathVariable long recipeId, @RequestBody RecipeRepresentation representation) {

		Recipe recipe = recipeService.findById(recipeId);
		Recipe updated = toDomain(representation);

		updated.setId(recipe.getId());

		recipeService.update(updated);

		ingredientService.update(recipe, updated.getItems());

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping
	public ResponseEntity<RecipeRepresentation> create(@RequestBody RecipeRepresentation representation) {
		var recipe = toDomain(representation);
		Recipe saved = recipeService.save(recipe);
		if (saved != null) {
			var savedIngredients = ingredientService.save(saved.getId(), saved.getItems());
			saved.setItems(savedIngredients);
		}
		return new ResponseEntity<RecipeRepresentation>(toRepresentation(saved), HttpStatus.CREATED);
	}
	
}

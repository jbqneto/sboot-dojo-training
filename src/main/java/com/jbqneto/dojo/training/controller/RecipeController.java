package com.jbqneto.dojo.training.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbqneto.dojo.training.domain.model.Recipe;
import com.jbqneto.dojo.training.domain.service.RecipeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/recipes")
public class RecipeController {

	private final RecipeService service;
	
	@GetMapping
	public ResponseEntity<List<Recipe>> list() {
		return ResponseEntity.ok(service.listAll());
	}
	
	@GetMapping("/{recipeId}")
	public ResponseEntity<Recipe> findById(@PathVariable int recipeId) {
		Recipe recipe = service.findById(recipeId);
		return ResponseEntity.ok(recipe);
	} 
	
	@GetMapping("/find")
	public ResponseEntity<List<Recipe>> findByName(@RequestParam String name) {
		return ResponseEntity.ok(service.findByName(name));
	}
	
	@DeleteMapping("/{recipeId}")
	public ResponseEntity<Void> delete(@PathVariable int recipeId) {
		service.delete(recipeId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping
	public ResponseEntity<Void> update(@RequestBody Recipe recipe) {
		service.update(recipe);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping
	public ResponseEntity<Recipe> save(@RequestBody Recipe recipe) {
		return new ResponseEntity<Recipe>(service.save(recipe), HttpStatus.CREATED);
	}
	
}

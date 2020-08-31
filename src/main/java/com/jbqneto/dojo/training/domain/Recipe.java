package com.jbqneto.dojo.training.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Recipe {
	
	private int id;
	private String name;
	private List<Ingredient> ingredients;

}

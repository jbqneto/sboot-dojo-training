package com.jbqneto.dojo.training.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = true)
	private String detail;

	@Column(nullable = false)
	private Double quantity;

	private String unity;

	@Column(name = "recipe_id", nullable = false)
	private long recipeId;

}

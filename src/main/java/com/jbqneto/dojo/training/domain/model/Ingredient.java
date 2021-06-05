package com.jbqneto.dojo.training.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@Data
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String name;


	private Long quantity;

}

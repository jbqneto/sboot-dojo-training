package com.jbqneto.dojo.training.domain.model;

import javax.persistence.*;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;

	private long time;

	@OneToMany(mappedBy = "recipe")
	private List<Ingredient> items;

}

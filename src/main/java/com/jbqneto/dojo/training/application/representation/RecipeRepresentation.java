package com.jbqneto.dojo.training.application.representation;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class RecipeRepresentation {
    private long id;
    private String name;
    private long preparationTime;
    private List<IngredientRepresentation> ingredients;
}

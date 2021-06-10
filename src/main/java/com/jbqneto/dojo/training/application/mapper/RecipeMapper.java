package com.jbqneto.dojo.training.application.mapper;

import com.jbqneto.dojo.training.application.representation.IngredientRepresentation;
import com.jbqneto.dojo.training.application.representation.RecipeRepresentation;
import com.jbqneto.dojo.training.domain.model.Ingredient;
import com.jbqneto.dojo.training.domain.model.Recipe;

import java.util.List;
import java.util.stream.Collectors;

public class RecipeMapper {
    public static Recipe toDomain(RecipeRepresentation representation) {
        return Recipe.builder()
                    .id(representation.getId())
                    .name(representation.getName())
                    .time(representation.getPreparationTime())
                    .items(ingredientsToDomain(representation))
                .build();
    }

    public static RecipeRepresentation toRepresentation(Recipe recipe) {
        return new RecipeRepresentation(
                recipe.getId(),
                recipe.getName(),
                recipe.getTime(),
                ingredientsToRepresentation(recipe.getItems())
        );
    }

    private static List<Ingredient> ingredientsToDomain(RecipeRepresentation recipe) {
        return recipe.getIngredients().stream().map(representation -> {
            return new Ingredient(
                    representation.getId(),
                    representation.getName(),
                    representation.getDetail(),
                    representation.getQuantity(),
                    representation.getUnity(),
                    recipe.getId()
            );
        }).collect(Collectors.toList());
    }

    private static List<IngredientRepresentation> ingredientsToRepresentation(List<Ingredient> items) {
        return items.stream().map(item -> {
            return new IngredientRepresentation(
                    item.getId(),
                    item.getName(),
                    item.getDetail(),
                    item.getQuantity(),
                    item.getUnity()
            );
        }).collect(Collectors.toList());
    }
}

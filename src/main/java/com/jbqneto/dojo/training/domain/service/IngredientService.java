package com.jbqneto.dojo.training.domain.service;

import com.jbqneto.dojo.training.application.repository.IngredientRepository;
import com.jbqneto.dojo.training.domain.model.Ingredient;
import com.jbqneto.dojo.training.domain.model.Recipe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository repository;

    public List<Ingredient> save(long recipeId, List<Ingredient> items) {
        List<Ingredient> ingredients = updateRecipeId(recipeId, items);

        var saved = repository.saveAll(ingredients);

        return saved;
    }

    public void update(Recipe recipe, List<Ingredient> items) {
        repository.deleteAll(recipe.getItems());

        this.save(recipe.getId(), items);
    }

    private List<Ingredient> updateRecipeId(long id, List<Ingredient> ingredients) {
        return ingredients.stream().map(ingredient -> {
            return new Ingredient(
                    ingredient.getId(),
                    ingredient.getName(),
                    ingredient.getDetail(),
                    ingredient.getQuantity(),
                    ingredient.getUnity(),
                    id
            );
        }).collect(Collectors.toList());
    }

    public void deleteAll(List<Ingredient> ingredients) {
        repository.deleteAll(ingredients);
    }
}

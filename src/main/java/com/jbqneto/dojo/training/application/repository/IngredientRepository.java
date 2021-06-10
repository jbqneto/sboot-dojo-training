package com.jbqneto.dojo.training.application.repository;

import com.jbqneto.dojo.training.domain.model.Ingredient;
import com.jbqneto.dojo.training.domain.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Long deleteByRecipe(Recipe recipe);
}

package net.recipies.RecipieGenerator.repository;

import net.recipies.RecipieGenerator.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}


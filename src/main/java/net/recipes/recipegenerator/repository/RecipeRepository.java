package net.recipes.recipegenerator.repository;

import net.recipes.recipegenerator.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}


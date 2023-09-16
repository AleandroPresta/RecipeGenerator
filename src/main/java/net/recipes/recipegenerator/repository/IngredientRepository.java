package net.recipes.recipegenerator.repository;

import net.recipes.recipegenerator.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}

package net.recipes.recipegenerator.service;

import net.recipes.recipegenerator.entity.Ingredient;

import java.util.List;

public interface IngredientService {

    Ingredient createIngredient(Ingredient ingredient);

    Ingredient getIngredientById(Long ingredientId);

    List<Ingredient> getAllIngredients();

    Ingredient updateIngredient(Long ingredientId, Ingredient updatedIngredient);

    void deleteIngredient(Long ingredientId);
}

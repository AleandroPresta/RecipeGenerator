package net.recipies.RecipieGenerator.service;

import net.recipies.RecipieGenerator.entity.Recipe;

import java.util.List;

public interface RecipeService {

    Recipe createRecipe(Recipe recipe);

    Recipe getRecipeById(Long recipeId);

    List<Recipe> getAllRecipes();

    Recipe updateRecipe(Long recipeId, Recipe updatedRecipe);

    void deleteRecipe(Long recipeId);
}

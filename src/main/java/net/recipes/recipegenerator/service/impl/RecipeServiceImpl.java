package net.recipes.recipegenerator.service.impl;

import lombok.AllArgsConstructor;
import net.recipes.recipegenerator.entity.Recipe;
import net.recipes.recipegenerator.exception.ResourceNotFoundException;
import net.recipes.recipegenerator.repository.RecipeRepository;
import net.recipes.recipegenerator.service.RecipeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository; // Assuming you have a RecipeRepository

    @Override
    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe getRecipeById(Long recipeId) {
        return recipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe doesn't exist with the given ID " + recipeId));
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe updateRecipe(Long recipeId, Recipe updatedRecipe) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe doesn't exist with the given ID " + recipeId));

        // Update the recipe properties as needed
        // For example: recipe.setName(updatedRecipe.getName());
        // You should update all relevant fields here

        return recipeRepository.save(recipe);
    }

    @Override
    public void deleteRecipe(Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe doesn't exist with the given ID " + recipeId));

        recipeRepository.delete(recipe);
    }
}


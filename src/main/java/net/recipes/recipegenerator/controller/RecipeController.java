package net.recipes.recipegenerator.controller;

import lombok.AllArgsConstructor;
import net.recipes.recipegenerator.entity.Ingredient;
import net.recipes.recipegenerator.entity.Recipe;
import net.recipes.recipegenerator.generator.RecipeGenerator;
import net.recipes.recipegenerator.service.IngredientService;
import net.recipes.recipegenerator.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utils.IngredientExtractor;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private RecipeService recipeService;
    private IngredientService ingredientService;

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {

        // Lowercase all the names of ingredients and the name of the recipie to avoid problems in quering
        String nameRecipeToLowercase = recipe.getName().toLowerCase();

        List<String> ingredientsToLowercase = recipe.getIngredients().stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        recipe.setName(nameRecipeToLowercase);
        recipe.setIngredients(ingredientsToLowercase);

        Recipe savedRecipe = recipeService.createRecipe(recipe);

        return new ResponseEntity<>(savedRecipe, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Recipe> updateRecipe(
            @PathVariable("id") Long recipeId,
            @RequestBody Recipe updatedRecipe) {
        // Convert ingredient names and recipe name to lowercase
        String nameRecipeToLowercase = updatedRecipe.getName().toLowerCase();
        List<String> ingredientsToLowercase = updatedRecipe.getIngredients().stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        updatedRecipe.setName(nameRecipeToLowercase);
        updatedRecipe.setIngredients(ingredientsToLowercase);

        Recipe recipe = recipeService.updateRecipe(recipeId, updatedRecipe);

        return ResponseEntity.ok(recipe);
    }

    @GetMapping("{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable("id") Long recipeId) {
        Recipe recipe = recipeService.getRecipeById(recipeId);

        return ResponseEntity.ok(recipe);
    }

    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> recipes = recipeService.getAllRecipes();

        return ResponseEntity.ok(recipes);
    }

    @GetMapping
    public ResponseEntity<List<Recipe>> getAllAvailableRecipes() {
        List<Recipe> recipes = recipeService.getAllRecipes();

        List<Ingredient> ingredients = ingredientService.getAllIngredients();
        List<String> ingredientsNames = IngredientExtractor.extract(ingredients);
        List<Recipe> availableRecipes = RecipeGenerator.findPossibleRecipes(recipes, ingredientsNames);

        return ResponseEntity.ok(availableRecipes);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRecipe(@PathVariable("id") Long recipeId) {
        recipeService.deleteRecipe(recipeId);

        return ResponseEntity.ok("Recipe deleted successfully!");
    }
}

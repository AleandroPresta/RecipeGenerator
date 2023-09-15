package net.recipes.recipegenerator.controller;

import lombok.AllArgsConstructor;
import net.recipes.recipegenerator.entity.Recipe;
import net.recipes.recipegenerator.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private RecipeService recipeService;

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        Recipe savedRecipe = recipeService.createRecipe(recipe);

        return new ResponseEntity<>(savedRecipe, HttpStatus.CREATED);
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

    @PutMapping("{id}")
    public ResponseEntity<Recipe> updateRecipe(
            @PathVariable("id") Long recipeId,
            @RequestBody Recipe updatedRecipe) {
        Recipe recipe = recipeService.updateRecipe(recipeId, updatedRecipe);

        return ResponseEntity.ok(recipe);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRecipe(@PathVariable("id") Long recipeId) {
        recipeService.deleteRecipe(recipeId);

        return ResponseEntity.ok("Recipe deleted successfully!");
    }
}


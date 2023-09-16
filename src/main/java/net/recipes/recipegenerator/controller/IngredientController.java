package net.recipes.recipegenerator.controller;

import lombok.AllArgsConstructor;
import net.recipes.recipegenerator.entity.Ingredient;
import net.recipes.recipegenerator.service.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    private IngredientService ingredientService;

    @PostMapping
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {

        String nameIngredientToLowercase = ingredient.getName().toLowerCase();
        ingredient.setName(nameIngredientToLowercase);
        Ingredient savedIngredient = ingredientService.createIngredient(ingredient);

        return new ResponseEntity<>(savedIngredient, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable("id") Long ingredientId) {
        Ingredient ingredient = ingredientService.getIngredientById(ingredientId);

        return ResponseEntity.ok(ingredient);
    }

    @GetMapping
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        List<Ingredient> ingredients = ingredientService.getAllIngredients();

        return ResponseEntity.ok(ingredients);
    }

    @PutMapping("{id}")
    public ResponseEntity<Ingredient> updateIngredient(
            @PathVariable("id") Long ingredientId,
            @RequestBody Ingredient updatedIngredient) {
        String nameIngredientToLowercase = updatedIngredient.getName().toLowerCase();
        updatedIngredient.setName(nameIngredientToLowercase);
        Ingredient ingredient = ingredientService.updateIngredient(ingredientId, updatedIngredient);

        return ResponseEntity.ok(ingredient);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteIngredient(@PathVariable("id") Long ingredientId) {
        ingredientService.deleteIngredient(ingredientId);

        return ResponseEntity.ok("Ingredient deleted successfully!");
    }
}

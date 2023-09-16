package net.recipes.recipegenerator.service.impl;

import lombok.AllArgsConstructor;
import net.recipes.recipegenerator.entity.Ingredient;
import net.recipes.recipegenerator.exception.ResourceNotFoundException;
import net.recipes.recipegenerator.repository.IngredientRepository; // Assuming you have an IngredientRepository
import net.recipes.recipegenerator.service.IngredientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private IngredientRepository ingredientRepository; // Assuming you have an IngredientRepository

    @Override
    public Ingredient createIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient getIngredientById(Long ingredientId) {
        return ingredientRepository.findById(ingredientId)
                .orElseThrow(() -> new ResourceNotFoundException("Ingredient doesn't exist with the given ID " + ingredientId));
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient updateIngredient(Long ingredientId, Ingredient updatedIngredient) {
        Ingredient ingredient = ingredientRepository.findById(ingredientId)
                .orElseThrow(() -> new ResourceNotFoundException("Ingredient doesn't exist with the given ID " + ingredientId));

        ingredient.setName(updatedIngredient.getName());

        return ingredientRepository.save(ingredient);
    }

    @Override
    public void deleteIngredient(Long ingredientId) {
        Ingredient ingredient = ingredientRepository.findById(ingredientId)
                .orElseThrow(() -> new ResourceNotFoundException("Ingredient doesn't exist with the given ID " + ingredientId));

        ingredientRepository.delete(ingredient);
    }
}

package net.recipes.recipegenerator.mapper;

import net.recipes.recipegenerator.dto.IngredientDto;
import net.recipes.recipegenerator.entity.Ingredient;

public class IngredientMapper {

    public static IngredientDto mapToIngredientDto(Ingredient ingredient) {
        return new IngredientDto(
                ingredient.getId(),
                ingredient.getName()
        );
    }

    public static Ingredient mapToIngredient(IngredientDto ingredientDto) {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ingredientDto.getId());
        ingredient.setName(ingredientDto.getName());
        return ingredient;
    }
}
